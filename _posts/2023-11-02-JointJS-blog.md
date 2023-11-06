---
layout: post
title: Joint.JS blog
description: Blog about Joint.JS used in our project
categories: ['C4.0']
type: tangibles
courses: {'csa': {'week': 11}}
---

[Layout of code with Joint.JS found here](https://github.com/CSA-Tri-1/DADDiJkstra-frontend/blob/main/assets/scripts/graph.js)

Initialization and Configuration:
A JointJS Graph object is created to represent the graph's data model.
A JointJS Paper object is created to display the graph on an HTML element with the id "interactive-graph."

Controllers:
The code defines two custom controllers (ViewController and EditController) that handle interactions and events related to the graph and its elements.

Event Handling:
Event listeners are set up to respond to various user interactions with the graph, such as pointer clicks, mouse enters, mouse leaves, double clicks, etc. The handlers call various functions that modify the graph's state.
Node and Link Creation:

Functions like createNode and createLink are used to create nodes (representing circles) and links (representing connections) within the graph.

Graph Manipulation:
The code allows users to interact with the graph, such as adding and removing nodes, creating and modifying links, and displaying tools for these interactions.

Path Highlighting:
The code handles path highlighting within the graph. Users can select a start node and an end node, and the code highlights the shortest path between them, taking into account directed or undirected connections.

Zooming:
Users can zoom in and out on the graph using the "zoom-in" and "zoom-out" buttons.

Styling:
The code sets up styling for nodes, links, and other elements within the graph.

Keyframes and Animations:
The code defines keyframe animations for elements, such as path highlighting and link animations.

Data Structures:
The code appears to use various data structures like arrays and matrices to manage the graph's data.

Other Features:
The code has several other features and functions for managing elements within the graph, as well as for managing tools, tools' visibility, and more.

Import JointJS: The code imports the JointJS library at the beginning with other libraries.

```
const graph = new joint.dia.Graph;
const paperElement = document.getElementById('interactive-graph');
const paper = new joint.dia.Paper({
    el: paperElement,
    // ...
});
```

Creating a Graph: The joint.dia.Graph is used to create a graph object that stores elements and their relationships in the diagram.

Creating a Paper: The joint.dia.Paper object is used to render and interact with the graph. It specifies the canvas element on which the graph is drawn, as well as various properties like width, height, and interactivity settings.

Creating Elements: The code uses JointJS to create and manage elements (nodes) in the graph. For example, the createNode function creates a new node, and the createLink function creates links between nodes.

```
function createNode(id) {
    var node = new joint.shapes.standard.Circle({
        id,
        size: { width: 40, height: 40 },
        attrs: {
            body: {
                fill: 'black'
            },
            label: {
                fill: 'white'
            }
        }
    }).addTo(graph);
    // ...
    return node;
}

function createLink(s, t) {
    // ...
    var link = new joint.shapes.standard.Link({
        id: [s, t].sort().join(),
        source: { id: s },
        target: { id: t },
        z: 1,
        // ...
    });
    // ...
    link.addTo(graph);
}
```

Event Handling: JointJS allows you to handle events such as mouse interactions with elements on the graph. The code includes event handlers for various events like pointer clicks, element removal, and element addition.

Styling and Highlighting: JointJS provides facilities for styling and highlighting elements. The code uses highlighters to add and remove classes and styles from elements, making them visually interactive.

Pathfinding: The code also uses JointJS to find and display paths between elements in the graph.

In summary, JointJS is used in this code to create, display, and manage a graph, as well as to enable interactivity and pathfinding features for the graph.
