package com.rafaelportela;

import org.junit.Test;

public class GraphTest {

    @Test
    public void hasARootNode() {
        Node node = new Node();
        Graph graph = new Graph();
        graph.setRoot(node);
    }
}
