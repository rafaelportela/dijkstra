package br.com.rafaelportela.dijkstra;

import org.junit.Before;
import org.junit.Test;

import static br.com.rafaelportela.dijkstra.Link.link;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DijkstraTest {

    private Node root;
    private Dijkstra dijkstra;
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

        dijkstra = new Dijkstra();
        dijkstra.setRoot(root);
        dijkstra.addNode(node1);
        dijkstra.addNode(node2);
        dijkstra.addNode(node3);
    }

    @Test
    public void calculatesTheSmallestDistance() throws Exception {
        dijkstra.setRoot(root);
        Integer distance = dijkstra.smallestDistanceTo(node3);
        assertThat(distance, is(47));
    }
}