import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = 31;
        int M = 1234567891;
        int hash = 0;
        int pow = 0;


        // 문자열의 길이
        int L = Integer.parseInt(br.readLine());

        // 문자열
        char[] arr = br.readLine().toCharArray();
        for(int i = 0; i < L; i++) {
            int num = arr[i] - 96;

            for(int j = 0; j < pow; j++) {
                num *= r;
            }

            hash += num % M;
            pow++;
        }

        System.out.println(hash);
    }
}