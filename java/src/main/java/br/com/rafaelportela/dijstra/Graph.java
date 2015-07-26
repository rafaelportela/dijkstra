package br.com.rafaelportela.dijstra;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Node root;
    private Node currentNode;
    private Set<Node> unvisitedNodes = new HashSet<Node>();

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        root.setTentativeDistanceValue(0);
        this.root = currentNode = root;
    }

    public void addNode(Node node) {
        node.setTentativeDistanceValue(Integer.MAX_VALUE);
        unvisitedNodes.add(node);
    }

    public Set<Node> unvisitedNodes() {
        return unvisitedNodes;
    }

    public Node nextNodeFrom(Node node) {
        Node next = null;
        Integer smallestTentativeDistance = Integer.MAX_VALUE;
        for (Link link : node.getLinks()) {
            Integer distance = node.getTentativeDistanceValue() + link.getCost();
            link.to().setTentativeDistanceValue(distance);
            if (distance < smallestTentativeDistance) {
                smallestTentativeDistance = distance;
                next = link.to();
            }
        }
        return next;
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
            dest.setTentativeDistanceValue(
                    currentNode.getTentativeDistanceValue() +
                            link.getCost());
            dest.setPreviousNode(currentNode);
        }
    }

    private Node smallestTentativeDistance() {
        Node selected = null;
        Integer smallestValue = Integer.MAX_VALUE;
        for (Node node : unvisitedNodes) {
            if (node.getTentativeDistanceValue() < smallestValue) {
                selected = node;
            }
        }

        if (selected == null)
            throw new RuntimeException("Failed to select node with smallest distance.");

        return selected;
    }
}
