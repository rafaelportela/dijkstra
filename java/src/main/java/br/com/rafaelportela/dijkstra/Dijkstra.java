package br.com.rafaelportela.dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Dijkstra {

    private Node root;
    private Node currentNode;
    private Set<Node> unvisitedNodes = new HashSet<Node>();

    public Dijkstra(Graph graph) {
        for (Node node: graph.nodes()) {
            node.setTentativeDistanceValue(Integer.MAX_VALUE);
            unvisitedNodes.add(node);
        }

        root = graph.getRoot();
        root.setTentativeDistanceValue(0);
    }

    public Integer smallestDistanceTo(Node target) {
        currentNode = root;
        unvisitedNodes.remove(root);

        while (!unvisitedNodes.isEmpty()) {

            updateDistancesFromCurrent();
            Node next = smallestTentativeDistance();
            unvisitedNodes.remove(next);

            if (next.equals(target)) {
                return next.getTentativeDistanceValue();
            }

            currentNode = next;
        }

        throw new RuntimeException("Route not found");
    }

    private void updateDistancesFromCurrent() {
        for (Link link : currentNode.getLinks()) {
            Node dest = link.to();
            int newDistance = currentNode.getTentativeDistanceValue() + link.getCost();
            if (newDistance < dest.getTentativeDistanceValue()) {
                dest.setTentativeDistanceValue(newDistance);
                dest.setPreviousNode(currentNode);
            }
        }
    }

    private Node smallestTentativeDistance() {
        Node selected = null;
        Integer smallestValue = Integer.MAX_VALUE;
        for (Node node : unvisitedNodes) {
            if (node.getTentativeDistanceValue() < smallestValue) {
                selected = node;
                smallestValue = node.getTentativeDistanceValue();
            }
        }

        if (selected == null)
            throw new RuntimeException("Failed to select node with smallest distance.");

        return selected;
    }
}
