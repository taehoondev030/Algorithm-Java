import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] arr = new int[11]; // n은 최대 10

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(n));
        }
    }

    public static int dp(int n) {
        if(n == 1) {
            return 1; // 1
        } else if(n == 2) {
            return 2; // 1+1, 2
        } else if(n == 3) {
            return 4; // 1+1+2, 1+2, 2+1, 3
        }

        if (arr[n] != 0) { // 이미 계산된 값이 있다면
            return arr[n]; // 해당 값을 반환
        }

        // n-1, n-2, n-3을 만드는 방법의 개수를 구하여 저장
        // n을 만드는 방법의 개수와 같음
        arr[n] = dp(n - 1) + dp(n - 2) + dp(n - 3); 

        return arr[n];
    }
}