package br.com.rafaelportela.dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<Node> nodes = new HashSet<Node>();
    private Node root;

    public Graph addNode(Node node) {
        nodes.add(node);
        return this;
    }

    public Graph addRootNode(Node root) {
        this.root = root;
        nodes.add(root);
        return this;
    }

    public Set<Node> nodes() {
        return nodes;
    }

    public Node getRoot() {
        return root;
    }
}
