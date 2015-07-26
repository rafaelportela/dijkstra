package br.com.rafaelportela.dijstra;

public class Link {

    private Node to, from;
    private Integer cost;

    public Link(Integer cost) {
        this.cost = cost;
    }

    public Node to() {
        return to;
    }

    public void to(Node node) {
        to = node;
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

    @Override
    public String toString() {
        return "[Link from " + from + " to " + to + "]";
    }
}
