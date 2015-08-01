package br.com.rafaelportela.dijkstra;

import org.junit.Test;

import static br.com.rafaelportela.dijkstra.Link.link;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LinkTest {

    @Test
    public void linksTwoNodes() throws Exception {
        Node origin = new Node("origin");
        Node dest = new Node("dest");
        assertThat(origin.getLinks().isEmpty(), is(true));

        link().from(origin).to(dest).withDistance(10);

        assertThat(origin.getLinks().isEmpty(), is(false));
        assertThat(origin.getLinks().get(0).to(), is(dest));
    }
}
