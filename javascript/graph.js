var Node = require('./node.js');

module.exports = function() {

  var indexOf = function(nodes, name) {
    for (var i=0; i<nodes.length; i++) {
      if(nodes[i].name === name) {
        return i;
      }
    }
    return -1;
  };

  var remove = function(nodes, node) {
    var indexToBeRemoved = indexOf(nodes, node.name);
    nodes.splice(indexToBeRemoved , 1);
  };

  var find = function(nodes, name) {
    for (var i=0; i<nodes.length; i++) {
      if (nodes[i].name === name) {
        return nodes[i];
      }
    }
  };

  var findOrAdd = function(nodes, name) {
    var node = find(nodes, name);
    if (!node) {
      node = new Node(name);
      nodes.push(node);
    }
    return node;
  };

  var findNodeWithSmallestDistance = function(nodes) {
    var smallestDistance = 1000000;
    var selected;
    for (var i=0; i<nodes.length; i++) {
      if (nodes[i].distanceToRoot < smallestDistance) {
        selected = nodes[i];
      }
    }
    return selected;
  };

  var findDistanceBetween = function(root, targetName, unvisited) {

    var current = root;

    while (unvisited.length > 0) {
      
      var smallestNeighbourDistance = 10000;
      var nextNode;

      for (var i=0; i<current.vertexes.length; i++) {
        var pathToNeighbour = current.vertexes[i];
        if (current.distanceFromRoot + pathToNeighbour.cost < smallestNeighbourDistance) {
          smallestNeighbourDistance = current.distanceFromRoot + pathToNeighbour;
          nextNode = pathToNeighbour.dest;
        }
      }

      current.visited = true;
      remove(unvisited, current);
      if (current.name === targetName) {
        return current.distanceFromRoot;
      }

      if (nextNode) {
        nextNode.distanceFromRoot = current.distanceFromRoot + pathToNeighbour.cost;
        current = nextNode;
      }
      else {
        current = findNodeWithSmallestDistance(unvisited);
      }

    }
  };

  return {
    nodes: [],

    add: function(origin, dest, cost) {
      var originNode = findOrAdd(this.nodes, origin);
      var destNode = findOrAdd(this.nodes, dest);

      originNode.vertexes.push({
        cost: cost,
        dest: destNode
      });
    },

    distanceBetween: function(rootName, targetName) {
      var root = find(this.nodes, rootName);
      root.distanceFromRoot = 0;
      var unvisited = [];

      for (var i=0; i<this.nodes.length; i++) {
        unvisited.push(this.nodes[i]);
      }

      return findDistanceBetween(root, targetName, unvisited);
    }
  };
}
