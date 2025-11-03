import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int sum = 0;
        int weight = 0;
        for(int i = 0; i < 13; i++) {
            char ch = str.charAt(i);
            if (ch == '*') {
                if ((i + 1) % 2 == 1) {
                    weight = 1;
                } else {
                    weight = 3;
                }
                continue;
            }
            if((i + 1) % 2 == 1) {
                sum += ch - '0';
            } else {
                sum += 3 * (ch - '0');
            }
        }

        for(int i = 0; i < 10; i++) {
           if((sum + weight * i) % 10 == 0) {
               System.out.println(i);
           }
        }
    }
}