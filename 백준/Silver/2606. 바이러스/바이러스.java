//  바이러스

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 정점 개수
        M = Integer.parseInt(br.readLine()); // 간선 개수

        // 그래프 생성
        graph = new int[N + 1][N + 1];

        // 그래프에 간선 반영
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = graph[v][u] = 1; // 양방향 간선
        }

        // 방문 여부 배열
        visited = new boolean[N + 1];

        bfs(1);
        System.out.println(count);
    }

    public static void bfs(int node) {
        queue.add(node); // 큐에 탐색 시작 노드 추가
        visited[node] = true; // 방문 처리

        // 큐가 공백이 될때까지 실행
        while(!queue.isEmpty()) {
            int temp = queue.poll(); // 큐에서 다음 정점을 꺼냄

            // 모든 정점 탐색
            for(int next = 1; next <= N; next++) {
                // 큐에서 꺼낸 정점과 연결되어있고, 아직 방문되지 않은 정점인 경우
                if(graph[temp][next] == 1 && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    count++; // 바이러스에 걸린 컴퓨터 수 증가
                }
            }
        }
    }
}