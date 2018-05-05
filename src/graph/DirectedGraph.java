package graph;

import graph.metas.SccMeta;

public interface DirectedGraph extends Graph {

    //强连通分量
    SccMeta scc();
}
