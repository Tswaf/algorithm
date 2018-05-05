package graph.metas;

import graph.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * SCC(Strongly Connected Component) data structure
 */
public class SccMeta {
    private int sccCount;
    private List<List<Node>> sccList;

    public SccMeta(){
        this.sccCount = 0;
        this.sccList = new ArrayList<>();
    }

    public int getSccCount(){
        return sccCount;
    }

    public List<List<Node>> getSccList(){
        return sccList;
    }

    public void addScc(List<Node> scc){
        this.sccList.add(scc);
        this.sccCount++;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Strongly Connected Componnet:").append("\n");
        for(int i=0; i< sccCount; i++){
            s.append("scc " + i+":");
            s.append(sccList.get(i).toString());
            s.append("\n");
        }
        return s.toString();
    }
}
