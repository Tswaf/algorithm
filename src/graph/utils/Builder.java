package graph.utils;

import graph.DirectedGraph;
import graph.Node;
import graph.impl.DirectedGraphImpl;
import graph.impl.NodeImpl;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Builder {

    public static DirectedGraph directedGraphFromFile(String fileName){

        fileName = "./src/graph/data/"+fileName;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){

            DirectedGraph graph = new DirectedGraphImpl();
            String line = null;
            String nodes[] = null;
            while((line=reader.readLine()) != null){
                if(line.startsWith("#")){ //ignore comment
                    continue;
                }
                nodes = line.split(">");
                Node start = new NodeImpl(nodes[0]);
                Node end = new NodeImpl(nodes[1]);
                graph.addEdge(start,end);
            }
            return graph;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
