import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] original = new int[N]; // 원본 배열
        int[] sorted = new int[N]; // 정렬할 배열
        // 원본 값과 순위를 저장하는 HashMap
        HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            sorted[i] = original[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted); // 오름차순 정렬

        int rank = 0;
        for(int v : sorted) {
            // 원소가 중복되지 않는 경우만 추가
            if (!rankingMap.containsKey(v)) {
                rankingMap.put(v, rank);
                rank++; // 다음 순위로 넘어가도록 1 더하기
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int key : original) {
		        //원본 배열의 원소(key)에 대한 value(순위)값 가져오기
            int ranking = rankingMap.get(key); 
            sb.append(ranking).append(' ');
        }

        System.out.println(sb);
    }
}