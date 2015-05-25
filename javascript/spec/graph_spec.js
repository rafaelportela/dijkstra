var Graph = require('../graph.js');

describe('Graph', function() {
  it('does not have duplicated nodes', function() {

    var graph = new Graph();
    expect(graph.nodes).toEqual([]);

    graph.add('a', 'b', 2);
    graph.add('b', 'c', 3);
    graph.add('a', 'c', 4);
    graph.add('c', 'd', 4);
    expect(graph.nodes.length).toEqual(4);
  });

  it('finds the distance between to nodes', function() {
    var graph = new Graph();

    graph.add('a', 'b', 5);
    expect(graph.distanceBetween('a', 'b')).toEqual(5);
  });
});
