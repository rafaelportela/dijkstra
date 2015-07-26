package br.com.rafaelportela.dijstra;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private List<Link> links = new ArrayList<Link>();
    private Integer tentativeDistanceValue;
    private Boolean visited = false;

    public Node() {
    }

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

    public Boolean isVisited() {
        return visited;
    }

    public void setVisited() {
        visited = true;
    }
}
