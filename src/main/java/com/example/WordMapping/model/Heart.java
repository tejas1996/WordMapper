package com.example.WordMapping.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Heart {

    @Autowired
    IndexMap indexMap;

    @Autowired
    Wordmap wordmap;

    static final int V = 3;
    int numberOfWords = 3;
    double[][] A = {{10, 1, 10},
            {1, 10, 1},
            {10, 1, 10}
    };

    public void addNode() {

        numberOfWords++;
    }

    public void makeConnection(String a, String b) throws Exception {
        Integer c = indexMap.getIndex(a);
        Integer d = indexMap.getIndex(b);

        if (c == -1) {
            WordNode wordNode = new WordNode(a);
            wordmap.addNode(wordNode);
            int indexOfA = indexMap.addEntry(a);
            numberOfWords++;
            c = indexOfA;
        }
        if (d == -1) {
            WordNode wordNode = new WordNode(b);
            wordmap.addNode(wordNode);
            int indexOfB = indexMap.addEntry(b);
            numberOfWords++;
            d = indexOfB;
        }

        array[c][d]++;

        System.out.println(array[0][1] + "and" + array[c][d]);

    }

    double[][] array = new double[1000][1000];

    public String getDistance(String word1, String word2) {
        Integer c = indexMap.getIndex(word1);
        Integer d = indexMap.getIndex(word2);
        if (c == -1) {
            return "-1";
        }
        if (d == -1) {
            return "-1";
        }

        double distance = array[c][d];
        String s = Double.toString(distance);
        return s;

    }

    public void print() {

        A = reShuffle(A);
        A = reShuffle(A);

        System.out.println("hey");
    }

    public double[][] reShuffle(double[][] graph) {

        double distance[] = new double[100];
        for (int i = 0; i < numberOfWords; i++) {
            distance = dijkstra(graph, i);
            for (int j = 0; j < numberOfWords; j++) {
                graph[i][j] = distance[j];
                graph[j][i] = distance[j];
            }

        }
        return graph;


    }


    public double[] dijkstra(double[][] graph, int src) {
        double dist[] = new double[V]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = 100;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != 100 &&
                        dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // print the constructed distance array
        printSolution(dist, V);
        return dist;
    }

    int minDistance(double dist[], Boolean sptSet[]) {
        // Initialize min value
        double min = 100;
        int min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(double dist[], int n) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " tt " + dist[i]);
    }




}
