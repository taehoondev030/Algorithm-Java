import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if(str.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean balance = true;

            for(char c : str.toCharArray()) {
                if(c == '(' || c == '[') {
                    stack.push(c);
                }

                if(c == ')') {
                    if(stack.isEmpty() || stack.pop() != '(') {
                        balance = false;
                        break;
                    }
                }
                else if( c == ']') {
                    if(stack.isEmpty() || stack.pop() != '[') {
                        balance = false;
                        break;
                    }
                }
            }

            if(balance && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}