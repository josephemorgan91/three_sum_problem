package Test;

import Main.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    Graph g = new Graph(20);

    public GraphTest() {
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
        g.addEdge(6, 9);
        g.addEdge(7, 10);
        g.addEdge(9, 11);
        g.addEdge(10, 11);
    }

    @Test
    void BFS() {
        assertEquals("BFS for Vert #1: 1 2 3 4 5 6 7 8 9 10 11 ", g.BFS(1));
        Graph t = new Graph(9);
    }

    @Test
    void DFS() {
        assertEquals("DFS for Vert #1: 1 2 5 4 6 8 9 11 10 7 3 ", g.DFS(1));
    }

    @Test
    void addWeightedEdge() {
    }

    @Test
    void shortestPath() {
        g.addWeightedEdge(1,4,32);
        g.addWeightedEdge(1, 2, 3);
        g.addWeightedEdge(1, 3, 4);
        g.addWeightedEdge(2, 5, 7);
        g.addWeightedEdge(4, 5, 9);
        g.addWeightedEdge(5, 6, 45);
        g.addWeightedEdge(5, 7, 3);
        g.addWeightedEdge(6, 8, 12);
        g.addWeightedEdge(6, 9, 15);
        g.addWeightedEdge(7, 10, 2);
        g.addWeightedEdge(10, 11, 2);
        g.addWeightedEdge(9, 11, 1);
        assertEquals(g.shortestPath(1, 11), "[1,2,5,7,10,11]");
    }
}