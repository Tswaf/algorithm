package graph;

import java.util.Set;

public interface Graph {
    /**
     *
     * @return number of nodes
     */
    int size();

    /**
     * Get all nodes
     * @return List of graph node
     */
    Set<Node> getNodes();

    /**
     * @param node
     * @return
     */
    boolean contains(Node node);

    /**
     * Add a node to the graph
     * @param node
     * @return true if success,false otherwise
     */
    boolean addNode(Node node);

    /**
     * Add an edge to the graph
     * @param start start node of the edge
     * @param end end node of the edge
     * @return true if success,false otherwise
     * if node not in the graph,the node will be added
     */
    boolean addEdge(Node start,Node end);

    /**
     * Depth firth visit of graph with node callback function
     * @param pre callback function before node visit
     * @param post callback function after node visit
     */
    void dfs(DfsCallBack pre,DfsCallBack post);
}
