package br.com.rafaelportela.dijstra;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeTest {

    @Test
    public void hasLinks() {
        Node node = new Node();
        node.addLink(new Link());
        assertEquals(1, node.getLinks().size());
    }
}
