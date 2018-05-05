package graph.impl;

import graph.DfsCallBack;
import graph.Node;

public class DefaultPostCallBack implements DfsCallBack {
    @Override
    public void visit(Node node) {
        System.out.println("Finish visit node:["+node.getName()+"]");
    }
}
