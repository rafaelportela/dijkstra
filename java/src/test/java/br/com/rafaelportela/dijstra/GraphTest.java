package br.com.rafaelportela.dijstra;

import org.junit.Before;
import org.junit.Test;

import static br.com.rafaelportela.dijstra.Link.link;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GraphTest {

    private Node root;
    private Graph graph;
    private Node node3;

    @Before
    public void setUp() throws Exception {
        root = new Node("root");
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        node3 = new Node("3");

        link().from(root).to(node1).withDistance(15);
        link().from(root).to(node2).withDistance(25);
        link().from(node1).to(node3).withDistance(32);
        link().from(node2).to(node3).withDistance(41);

        graph = new Graph();
        graph.setRoot(root);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
    }

    @Test
    public void calculatesTheSmallestDistance() throws Exception {
        graph.setRoot(root);
        Integer distance = graph.smallestDistanceTo(node3);
        assertThat(distance, is(47));
    }
}