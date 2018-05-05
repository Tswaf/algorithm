package graph.impl;

import graph.DfsCallBack;
import graph.DirectedGraph;
import graph.Node;
import graph.metas.SccMeta;
import graph.metas.Status;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DirectedGraphImpl extends AbstractGraph implements DirectedGraph {


    @Override
    public boolean addEdge(Node start, Node end) {
        if(!contains(start)){
            addNode(start);
        }
        if(!contains(end)){
            addNode(end);
        }
        int indexStart = index(start);
        int indexEnd = index(end);
        return adjacencyList.get(indexStart).add(indexEnd);
    }


    //data structure used for dfs related methods
    private int timer;
    private int d[]; //node detection time
    private int f[]; //node finish time
    private Status status[];
    private int low[]; //used for tarjan scc
    private Deque<Integer> stack;

    @Override
    public void dfs(DfsCallBack pre,DfsCallBack post) {
        initDfs();
        for(int i=0;i<size();i++){
            if(status[i] == Status.NOT_VISIT){
                dfs(i,pre,post);
            }
        }
    }

    @Override
    public SccMeta scc() {
        initScc();
        SccMeta sccMeta = new SccMeta();
        int nodeNum = size();
        for(int i=0; i<nodeNum;i++){
            if(status[i] == Status.NOT_VISIT){
                tarjan(i, sccMeta);
            }
        }
        return sccMeta;
    }

    private void tarjan(int i,SccMeta sccMeta){
        low[i] = d[i] = timer++;
        stack.push(i);
        status[i] = Status.VISITING;
        List<Integer> neighbors = adjacencyList.get(i);
        for(int j : neighbors){
            if(status[j] == Status.NOT_VISIT){ // 节点j未访问，边<i,j>是树边
                tarjan(j, sccMeta);
                low[i] = Math.min(low[i],low[j]);
            }else if(d[i] > d[j]){ // 节点j节点j已经被访问过，<i,j>是反向边或交叉边
                if(stack.contains(j)){
                    low[i] = Math.min(low[i],d[j]);
                }
            }else{
                //节点j已经被访问过，而且<i,j>是前向边,忽略
            }
        }
        status[i] = Status.VISITED;

        if(d[i] == low[i]){ // node i is a ssc root
            List<Node> scc = new LinkedList<>();
            int k;
            do{
                k = stack.pop();
                scc.add(getNode(k));
            }while(k != i);
            sccMeta.addScc(scc);
        }

    }

    private void initDfs(){
        timer = 0;
        int nodeNum = size();
        if(d==null){
            d = new int[nodeNum];
        }
        if(f==null){
            f = new int[nodeNum];
        }
        if(status == null){
            status = new Status[nodeNum];
        }

        for(int i=0;i<nodeNum;i++){
            d[i] = -1;
            f[i] = -1;
        }
        for(int i=0;i<nodeNum;i++) {
            status[i] = Status.NOT_VISIT;
        }
    }

    private void initScc(){
        initDfs();
        int nodeNum = size();
        if(null == low){
            low = new int[nodeNum];
        }
        for(int i=0;i<nodeNum;i++){
            low[i] = -1;

        }
        if(stack == null){
            stack = new ArrayDeque<>();
        }
    }

    private void dfs(int i,DfsCallBack pre,DfsCallBack post){
        //visit node start
        Node node = getNode(i);
        if(pre != null){
            pre.visit(node);
        }

        status[i] = Status.VISITING;
        d[i] = timer++;

        List<Integer> ajList = adjacencyList.get(i);
        if(ajList != null && ajList.size()>0){
            for(Integer j : ajList){
                if(status[j] == Status.NOT_VISIT){
                    dfs(j,pre,post);
                }
            }
        }

        //visit node i finish
        f[i] = timer++;
        status[i] = Status.VISITED;
        if(post != null){
            post.visit(node);
        }
    }
}
