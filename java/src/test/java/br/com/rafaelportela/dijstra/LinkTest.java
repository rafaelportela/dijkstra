package br.com.rafaelportela.dijstra;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkTest {

    @Test
    public void shouldHaveOutgoingNode() {
        Link link = new Link();
        link.to(new Node());
    }

    @Test
    public void shouldHaveIncomingNode() {
        Link link = new Link();
        link.from(new Node());
    }

    @Test
    public void canBeInitializedWithItsCost() {
        Link link = new Link(10);
        assertEquals( new Integer(10), link.getCost());
    }

    @Test
    public void canHaveACost() {
        Link link = new Link();
        link.setCost(10);
        assertEquals( new Integer(10), link.getCost());
    }
}
