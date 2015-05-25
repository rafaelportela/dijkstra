package com.rafaelportela;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    private Node root;
    private Node node1;
    private Node node2;
    private Graph graph;

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

    private void setupGraph() {
        root = new Node("root");
        node1 = new Node("1");
        node2 = new Node("2");

        Link link1 = new Link(10);
        root.addLink(link1);
        link1.from(root);
        link1.to(node1);

        Link link2 = new Link(20);
        root.addLink(link2);
        link2.from(root);
        link2.to(node2);

        graph = new Graph();
        graph.setRoot(root);
        graph.addNode(node1);
        graph.addNode(node2);

    }

    @Test
    public void nextNodeShouldBeTheOneWithSmallestTentativeDistance() {
        assertEquals(node1, graph.nextNodeFrom(root));
    }

    @Test
    public void shouldSetTheVisitedNodeAsVisited() {
        assertTrue(root.isVisited());
    }
}
