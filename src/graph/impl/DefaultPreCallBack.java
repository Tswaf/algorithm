package graph.impl;

import graph.DfsCallBack;
import graph.Node;

public class DefaultPreCallBack implements DfsCallBack {
    @Override
    public void visit(Node node) {
        System.out.println("Start visit node:["+ node.getName() + "]");
    }
}
