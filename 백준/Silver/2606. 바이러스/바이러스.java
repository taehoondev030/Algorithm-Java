import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int node;
    static int[][] graph;
    static boolean[] visited;
    static int count = 0;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(br.readLine()); // 노드 개수
        int n = Integer.parseInt(br.readLine()); // 간선 개수

        graph = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        DFS(1);

        System.out.println(count);
    }

    public static void DFS(int x) {
        queue.add(x);
        visited[x] = true;

        while(!queue.isEmpty()) {
            int nextNode = queue.poll();
            
            for(int i = 1; i <= node; i++) {
                if(graph[nextNode][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }
}