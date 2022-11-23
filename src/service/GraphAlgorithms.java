package service;

import model.Edge;
import model.Graph;
import model.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphAlgorithms {
    public static double[][] floydWarshall(Graph graph) {
        List<Vertex> graphVertices = new ArrayList<>(graph.getVertices().keySet());
        double[][] minWeights = new double[graphVertices.size()][graphVertices.size()];

        for (int row = 0; row < graphVertices.size(); row++) {
            Arrays.fill(minWeights[row], Double.MAX_VALUE);
            minWeights[row][row] = 0;
        }

        for (Vertex vertex : graphVertices) {
            for (Edge edge : graph.getVertices().get(vertex)) {
                minWeights[graphVertices.indexOf(vertex)][graphVertices.indexOf(edge.getVertex())] = edge.getWeight();
            }
        }

        for (int i = 0; i < graphVertices.size(); i++) {
            for (int j = 0; j < graphVertices.size(); j++) {
                for (int k = 0; k < graphVertices.size(); k++) {
                    if (minWeights[j][k] > minWeights[j][i] + minWeights[i][k]) {
                        minWeights[j][k] = minWeights[j][i] + minWeights[i][k];
                    }
                }
            }
        }

        return minWeights;
    }
}