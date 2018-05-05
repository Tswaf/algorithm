package graph.impl;

import graph.NamedNode;

public class NodeImpl implements NamedNode {
    private String name;

    public NodeImpl(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(!(other instanceof NodeImpl)){
            return false;
        }
        NodeImpl otherNode = (NodeImpl)other;
        return this.name.equals(otherNode.name);
    }

    @Override
    public int hashCode(){
      return name.hashCode();
    }

    @Override
    public String toString(){
        return name;
    }
}
