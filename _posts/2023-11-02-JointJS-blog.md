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
