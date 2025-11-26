import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while(queue.size() != 1) {
            queue.poll();
            int card = queue.poll();
            queue.add(card);
        }

        System.out.println(queue.poll());
    }
}