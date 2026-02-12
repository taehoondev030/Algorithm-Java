import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 1; // 거쳐가는 방 수
        int increase = 0; // 증가하는 범위
        int end = 2; // 경계값

        if(N == 1) {
            count = 1;
        }
        else {
            while(true) {
                if(N < end) {
                    break;
                }
                increase += 6;
                end += increase;
                count++;
            }
        }

        System.out.println(count);
    }
}