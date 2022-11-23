package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private boolean isDirected;
    private HashMap<Vertex, List<Edge>> vertices;

    private void setDirected(boolean directed) {
        this.isDirected = directed;
    }

    private void setVertices(HashMap<Vertex, List<Edge>> vertices) {
        this.vertices = vertices;
    }

    private boolean isDirected() {
        return this.isDirected;
    }

    public HashMap<Vertex, List<Edge>> getVertices() {
        return this.vertices;
    }

    public Graph(boolean isDirected) {
        setDirected(isDirected);
        setVertices(new HashMap<>());
    }


    public void addVertex(Vertex vertex) {
        vertices.put(vertex, new LinkedList<>());
    }

    public void addEdge(Vertex vertexFrom, Vertex vertexTo, double weight) {
        vertices.get(vertexFrom).add(new Edge(vertexTo, weight));

        if(!isDirected()) {
            vertices.get(vertexTo).add(new Edge(vertexFrom, weight));
        }
    }
}