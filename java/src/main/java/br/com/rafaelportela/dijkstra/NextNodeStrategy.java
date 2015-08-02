package br.com.rafaelportela.dijkstra;

import java.util.Set;

public class NextNodeStrategy {

    public Node next(Node current, Set<Node> unvisitedNodes) {
        updateDistancesFrom(current);
        return nextSmallestTentativeDistance(unvisitedNodes);
    }

    private void updateDistancesFrom(Node currentNode) {
        for (Link link : currentNode.getLinks()) {
            Node dest = link.to();
            int newDistance = currentNode.getTentativeDistanceValue() + link.getCost();
            if (newDistance < dest.getTentativeDistanceValue()) {
                dest.setTentativeDistanceValue(newDistance);
                dest.setPreviousNode(currentNode);
            }
        }
    }

    private Node nextSmallestTentativeDistance(Set<Node> unvisitedNodes) {
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
