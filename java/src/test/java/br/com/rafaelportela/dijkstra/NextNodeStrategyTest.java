package br.com.rafaelportela.dijkstra;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static br.com.rafaelportela.dijkstra.Link.link;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NextNodeStrategyTest {

    private Node node1 = new Node("1");
    private Node node2 = new Node("2");
    private Node node3 = new Node("3");

    private Set<Node> unvisitedNodes = new HashSet<Node>();
    private NextNodeStrategy nextNodeStrategy = new NextNodeStrategy();

    @Before
    public void setUp() throws Exception {
        node1.setTentativeDistanceValue(5);
        node2.setTentativeDistanceValue(Integer.MAX_VALUE);
        node3.setTentativeDistanceValue(Integer.MAX_VALUE);

        link().from(node1).to(node2).withDistance(2);
        link().from(node1).to(node3).withDistance(3);

        unvisitedNodes.add(node2);
        unvisitedNodes.add(node3);
    }

    @Test
    public void updatesDistancesFromCurrentAndSelectTheSmallestOne() throws Exception {
        Node next = nextNodeStrategy.next(node1, unvisitedNodes);
        assertThat(next, is(node2));
    }

    @Test
    public void updateLinkToPreviousNodesWhenNextIsSelected() throws Exception {
        Node next = nextNodeStrategy.next(node1, unvisitedNodes);
        assertThat(next.getPreviousNode(), is(node1));
    }

    @Test
    public void canSelectNodeOutOfCurrentPathIfItHasTheSmallestDistance() throws Exception {
        Node aVisitedNode = new Node("0");
        link().from(aVisitedNode).to(node1).withDistance(5);

        Node nodeWithSmallestDistance = new Node("4");
        link().from(aVisitedNode).to(nodeWithSmallestDistance).withDistance(1);
        nodeWithSmallestDistance.setTentativeDistanceValue(2);
        unvisitedNodes.add(nodeWithSmallestDistance);

        Node next = nextNodeStrategy.next(node1, unvisitedNodes);
        assertThat(next, is(nodeWithSmallestDistance));
    }
}