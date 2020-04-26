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
    void v() {
    }

    @Test
    void e() {
    }

    @Test
    void addEdge() {
    }

    @Test
    void isAdjacent() {
    }

    @Test
    void isConnected() {
    }

    @Test
    void adj() {
    }

    @Test
    void adjString() {
    }

    @Test
    void BFS() {
        assertEquals("BFS for Vert #1: 1 2 3 4 5 6 7 8 9 10 11 ", g.BFS(1));
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
    }
}