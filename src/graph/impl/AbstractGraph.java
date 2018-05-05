package graph.impl;

import graph.DfsCallBack;
import graph.Graph;
import graph.Node;

import java.util.*;

public abstract class AbstractGraph implements Graph {
    protected Set<Node> nodes;
    protected List<List<Integer>> adjacencyList; //邻接表存储

    //节点和节点序号对应关系
    protected Map<Node,Integer> nodeIndexMap;
    protected Map<Integer,Node> indexNodeMap;

    public AbstractGraph(){
        nodes = new HashSet<>();
        adjacencyList = new ArrayList<>();
        nodeIndexMap = new HashMap<>();
        indexNodeMap = new HashMap<>();
    }

    protected int index(Node node){
        return nodeIndexMap.get(node);
    }

    protected Node getNode(int index){
        return indexNodeMap.get(index);
    }

    @Override
    public int size(){
        return nodes.size();
    }

    @Override
    public Set<Node> getNodes() {
        return nodes;
    }

    @Override
    public boolean addNode(Node node) {
        if(nodes.contains(node)){
            return false;
        }
        int index = nodes.size();
        nodes.add(node);
        adjacencyList.add(new LinkedList<Integer>());
        nodeIndexMap.put(node,index);
        indexNodeMap.put(index,node);
        return true;
    }

    @Override
    public boolean contains(Node node){
        return nodes.contains(node);
    }

    abstract public boolean addEdge(Node start, Node end);

    abstract public void dfs(DfsCallBack pre,DfsCallBack post);


}
