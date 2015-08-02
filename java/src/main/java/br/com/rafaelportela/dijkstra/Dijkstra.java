package br.com.rafaelportela.dijkstra;

import java.util.*;

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
        return executePathFinderTo(target).getTentativeDistanceValue();
    }

    public List<Node> shortestPathTo(Node target) {
        Node lastNode = executePathFinderTo(target);
        List<Node> path = buildPathBackFrom(lastNode);

        Collections.reverse(path);
        return path;
    }

    private List<Node> buildPathBackFrom(Node lastNode) {
        List<Node> path = new ArrayList<Node>();
        Node current = lastNode;

        while (current.getPreviousNode() != null) {
            path.add(current);
            current = current.getPreviousNode();
        }

        path.add(root);
        return path;
    }

    private Node executePathFinderTo(Node target) {
        currentNode = root;
        unvisitedNodes.remove(root);

        while (!unvisitedNodes.isEmpty()) {

            updateDistancesFromCurrent();
            Node next = smallestTentativeDistance();
            unvisitedNodes.remove(next);

            if (next.equals(target)) {
                return next;
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
