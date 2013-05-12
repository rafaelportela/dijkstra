package com.rafaelportela;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Link> links = new ArrayList<Link>();
    private Integer tentativeDistanceValue = 0;

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
}
