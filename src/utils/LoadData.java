package utils;

import model.Graph;
import model.Vertex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LoadData {
    public static Graph loadFile(String filePath) {
        Graph graph = null;
        List<String> fileLines = getListFromFile(filePath);

        if(fileLines != null) {
            graph = makeGraphFromList(fileLines);
        }

        return graph;
    }

    private static Graph makeGraphFromList(List<String> fileLines) {
        Graph graph = new Graph(fileLines.get(0).contains("S"));

        int lastVertex = Integer.parseInt(fileLines.get(1)) + 2;

        for(int i = 2; i < lastVertex; i++) {
            graph.addVertex(new Vertex(fileLines.get(i)));
        }

        List<String[]> edges = generateEdges(fileLines.subList(lastVertex, fileLines.size()));
        for(String[] edge : edges) {
            graph.addEdge(new Vertex(edge[0]), new Vertex(edge[1]), Double.parseDouble(edge[2]));
        }

        return graph;
    }

    private static List<String[]> generateEdges(List<String> edgesAndWeights) {
        List<String[]> edgeList = new ArrayList<>();

        for (String edgesAndWeight : edgesAndWeights) {
            String[] edge = edgesAndWeight.split(",");
            edgeList.add(edge);
        }

        return edgeList;
    }

    private static List<String> getListFromFile(String filePath) {
        List<String> mList;

        try {
            BufferedReader mBuffer = new BufferedReader(new FileReader(filePath));
            mList = mBuffer.lines().toList();
            mBuffer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            mList = null;
        }

        return mList;
    }
}