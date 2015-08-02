package br.com.rafaelportela.dijkstra;

import java.util.*;

public class Dijkstra {

    private Node root;
    private Set<Node> unvisitedNodes = new HashSet<Node>();
    private NextNodeStrategy nextNodeStrategy = new NextNodeStrategy();

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
        Node currentNode = root;
        unvisitedNodes.remove(root);

        while (!unvisitedNodes.isEmpty()) {
            currentNode = nextNodeStrategy.next(currentNode, unvisitedNodes);
            unvisitedNodes.remove(currentNode);

            if (currentNode.equals(target)) {
                return currentNode;
            }
        }

        throw new RuntimeException("Route not found");
    }
}
