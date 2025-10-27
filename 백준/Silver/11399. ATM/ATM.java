import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] atm = new int[n]; // 인출 시간 저장 리스트

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            atm[i] = Integer.parseInt(st.nextToken());
        }

        // 인출 시간 오름차순으로 정렬
        Arrays.sort(atm);

        int result = 0; // 인출에 필요한 시간의 합
        int sum = 0; // 현재 사람까지 인출에 걸린 시간
        for(int i = 0; i < n; i++) {
            sum += atm[i];
            result += sum;
        }

        System.out.println(result);
    }
}