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

    public static Builder link() {
        return new Builder();
    }

    public static class Builder {
        Node from, to;

        public Builder from(Node node) {
            from = node;
            return this;
        }

        public Builder to(Node node) {
            to = node;
            return this;
        }

        public Link withDistance(Integer distance) {
            Link link = new Link(distance);
            link.from(from);
            link.to(to);

            from.addLink(link);
            return link;
        }
    }
}
