import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 0;
        int i = 666;

        while(true) {
            String str = Integer.toString(i); //현재 값을 문자열로
            if(str.contains("666")) { // 666이 포함되었는지 확인
                count++;
            }
            
            if(count == N) {
                System.out.println(i);
                break;
            }
            
            i++;
        }
    }
}