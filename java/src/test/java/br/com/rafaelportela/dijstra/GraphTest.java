package br.com.rafaelportela.dijstra;

import org.junit.Before;
import org.junit.Test;

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
}