package br.com.rafaelportela.dijstra;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GraphTest {

    private Node root;
    private Node node1;
    private Node node2;
    private Node node3;
    private Graph graph;

    @Before
    public void setUp() throws Exception {
        root = new Node("root");
        node1 = new Node("1");
        node2 = new Node("2");
        node3 = new Node("3");

        Link linkRootTo1 = new Link(10);
        root.addLink(linkRootTo1);
        linkRootTo1.from(root);
        linkRootTo1.to(node1);

        Link linkRootTo2 = new Link(20);
        root.addLink(linkRootTo2);
        linkRootTo2.from(root);
        linkRootTo2.to(node2);

        Link link1To3 = new Link(30);
        node1.addLink(link1To3);
        link1To3.from(node1);
        link1To3.to(node3);

        Link link2To3 = new Link(40);
        node2.addLink(linkRootTo2);
        link2To3.from(node2);
        link2To3.to(node3);

        graph = new Graph();
        graph.setRoot(root);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
    }

    @Test
    public void calculatesTheSmallestDistance() throws Exception {
        graph.setRoot(root);
        assertThat(graph.smallestDistanceTo(node3), is(40));
    }

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
        setupGraph();
        assertEquals(node1, graph.nextNodeFrom(root));
    }
}