package graph.impl;

import graph.DfsCallBack;
import graph.Node;

public class DefaultCallBack implements DfsCallBack {
    @Override
    public void visit(Node node) {
        System.out.println("visit node:["+node.getName()+";");
    }
}
