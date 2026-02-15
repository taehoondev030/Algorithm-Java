import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, V;
    static boolean[] visited;
    static boolean[][] graph;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st1.nextToken()); // 정점 개수
        M = Integer.parseInt(st1.nextToken()); // 간선 개수
        V = Integer.parseInt(st1.nextToken()); // 탐색 시작 정점

        graph = new boolean[N+1][N+1];
        // 간선 연결
        for(int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st2.nextToken());
            int n2 = Integer.parseInt(st2.nextToken());
            graph[n1][n2] = true;
            graph[n2][n1] = true;
        }

        visited = new boolean[N+1];
        DFS(V);

        System.out.println();

        visited = new boolean[N+1];
        BFS(V);
    }

    public static void DFS(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        // 정점 순회
        for(int i = 1; i <= N; i++) {
            // 정점이 연결되어 있고 아직 방문하지 않은 정점이라면
            if(graph[node][i] == true && visited[i] == false) {
                DFS(i);
            }
        }
    }

    public static void BFS(int node) {
        queue.add(node);
        visited[node] = true;
        System.out.print(node + " ");

        // 큐가 공백이 될 때 까지
        while(!queue.isEmpty()) {
            // 다음 정점
            int next = queue.poll();

            // 정점 순회
            for(int i = 1; i <= N; i++) {
                // 정점에 연결되어 있고 아직 방문하지 않은 정점이라면
                if(graph[next][i] == true && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}