package br.com.rafaelportela.dijkstra;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static br.com.rafaelportela.dijkstra.Link.link;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DijkstraTest {

    private Graph graph;
    private Node root;
    private Node node1;
    private Node node2;
    private Node node3;

    @Before
    public void setUp() throws Exception {
        root = new Node("root");
        node1 = new Node("1");
        node2 = new Node("2");
        node3 = new Node("3");

        link().from(root).to(node1).withDistance(15);
        link().from(root).to(node2).withDistance(25);
        link().from(node1).to(node3).withDistance(32);
        link().from(node2).to(node3).withDistance(41);

        graph = new Graph();
        graph.addRootNode(root);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
    }

    @Test
    public void calculatesTheSmallestDistance() throws Exception {
        Dijkstra dijkstra = new Dijkstra(graph);
        Integer distance = dijkstra.smallestDistanceTo(node3);

        // root -> (15) node 1 -> (32) node 3
        assertThat(distance, is(47));
    }

    @Test
    public void returnsTheSmallestPathFromRootToTarget() throws Exception {
        Dijkstra dijkstra = new Dijkstra(graph);
        List<Node> path = dijkstra.shortestPathTo(node3);

        assertThat(path.get(0), is(root));
        assertThat(path.get(1), is(node1));
        assertThat(path.get(2), is(node3));
    }
}