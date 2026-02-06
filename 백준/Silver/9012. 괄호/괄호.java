import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            boolean vps = true;
            String str = br.readLine();

            for(int j = 0; j < str.length(); j++) {
                char in = str.charAt(j);

                if(in == '(') {
                    stack.push(in);
                }
                else if(in == ')') {
                    // 스택에 문자가 남아있으면
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                    // 스택에 문자가 없으면 VPS가 아님
                    else {
                        vps = false;
                        break;
                    }
                }
            }

            if(vps == false || !(stack.isEmpty())) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}