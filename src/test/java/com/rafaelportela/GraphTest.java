package com.rafaelportela;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void hasARootNode() {
        Node node = new Node();
        Graph graph = new Graph();
        graph.setRoot(node);
    }

    @Test
    public void rootNodeInitializedWithTentativeDistanceValueAsZero() {
        Node root = new Node();
        Graph graph = new Graph();
        graph.setRoot(root);

        assertEquals(new Integer(0), root.getTentativeDistanceValue());
    }

    @Test
    public void otherNodesInitializedWithTentativeDistanceValueAsInfinite() {
        Node node = new Node();
        Graph graph = new Graph();
        graph.addNode(node);

        assertEquals(new Integer(9999), node.getTentativeDistanceValue());
    }

    @Test
    public void allNodesInitializedAsUnvisited() {
        Node node = new Node();
        Graph graph = new Graph();
        graph.addNode(node);

        assertFalse(node.isVisited());
    }

    @Test
    public void allNodesInitializedInTheUnvisitedSet() {
        Node node = new Node();
        Graph graph = new Graph();
        graph.addNode(node);

        assertEquals(1, graph.unvisitedNodes().size());
    }

}
