import model.Graph;
import service.GraphAlgorithms;
import utils.LoadData;

public class Main {
    public static void main(String[] args) {
        Graph graph = LoadData.loadFile("src/data/data.txt");
        GraphAlgorithms.floydWarshall(graph);
    }
}