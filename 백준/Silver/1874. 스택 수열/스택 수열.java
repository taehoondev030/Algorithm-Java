//  스택 수열

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        int start = 0;

        while(N-- > 0) {
            int value = sc.nextInt();

            if(value > start) {
                // start + 1부터 value까지 차례대로 push
                for(int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = value; // 다음 push할때 value + 1부터 시작 (오름차순 유지)
            } else if (stack.peek() != value) { // 스택의 맨 위 원소가 value와 같지 않다면 수열 만족X
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }
}