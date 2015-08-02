package br.com.rafaelportela.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private List<Link> links = new ArrayList<Link>();
    private Integer tentativeDistanceValue;
    private Boolean visited = false;
    private Node previousNode;

    public Node(String name) {
        this.name = name;
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public List<Link> getLinks() {
        return links;
    }

    public Integer getTentativeDistanceValue() {
        return tentativeDistanceValue;
    }

    public void setTentativeDistanceValue(Integer tentativeDistanceValue) {
        this.tentativeDistanceValue = tentativeDistanceValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node))
            return false;

        Node other = (Node) obj;
        return name.equals(other.name);
    }

    @Override
    public String toString() {
        return "[node " + name + "]";
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }
}
