package graph.utils;

import graph.DirectedGraph;

public class Main {
    public static void main(String[] args){
        DirectedGraph graph = Builder.directedGraphFromFile("graph_1");
        System.out.println(graph.scc());
        //graph.dfs(node -> System.out.println("start "+ node.getName()),
         //         node -> System.out.println("end " + node.getName()));
    }
}
