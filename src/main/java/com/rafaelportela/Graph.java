package com.rafaelportela;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {

    private Node root;
    private Set<Node> unvisitedNodes = new HashSet<Node>();

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        root.setTentativeDistanceValue(0);
        this.root = root;
    }

    public void addNode(Node node) {
        node.setTentativeDistanceValue(9999);
        unvisitedNodes.add(node);
    }

    public Set<Node> unvisitedNodes() {
        return unvisitedNodes;
    }
}
