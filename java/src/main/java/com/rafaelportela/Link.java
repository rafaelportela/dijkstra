package com.rafaelportela;

public class Link {

    private Node to, from;
    private Integer cost;

    public Link() {
    }

    public Link(Integer cost) {
        this.cost = cost;
    }

    public Node to() {
        return to;
    }

    public void to(Node node) {
        to = node;
    }

    public Node from() {
        return from;
    }

    public void from(Node node) {
        from = node;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }
}
