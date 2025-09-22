import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            int count = 0;
            
            for(int j = 1; j <= num; j++) {
                if(num % j == 0) {
                    count++;
                }
                if(count >= 3) {
                    break;
                }
            }
            if(count==2) {
                result++;
            }
        }

        System.out.println(result);
    }
}