
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int max = 0;
        int maxidx = 0;

        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < 9; i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxidx = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(maxidx);
    }
}