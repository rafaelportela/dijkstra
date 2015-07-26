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
        node.setTentativeDistanceValue(9999);
        unvisitedNodes.add(node);
    }

    public Set<Node> unvisitedNodes() {
        return unvisitedNodes;
    }

    public Node nextNodeFrom(Node node) {
        Node next = null;
        Integer smallestTentativeDistance = 9999;
        for (Link link: node.getLinks()) {
            Integer distance = node.getTentativeDistanceValue() + link.getCost();
            link.to().setTentativeDistanceValue(distance);
            if (distance < smallestTentativeDistance) {
                smallestTentativeDistance = distance;
                next = link.to();
            }
        }
        return next;
    }
}
