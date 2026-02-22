import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int x = 0;

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num = 0;

            if(!op.equals("all") && !op.equals("empty")) {
                num = Integer.parseInt(st.nextToken());
            }

            switch(op) {
                case "add":
                    x |= (1 << num); // 숫자가 이미 있는 경우도 어차피 1이 되어 무시됨
                    break;
                case "remove":
                    x &= ~(1 << num);
                    break;
                case "check":
                    sb.append((x & (1 << num)) != 0 ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    x ^= (1 << num); // XOR 연산 (두 비트가 같으면 1 다르면 0)
                    break;
                case "all":
                    x = (1 << 21) - 1; // 1로 채워진 20bit 숫자를 반환
                    break;
                case "empty":
                    x = 0;
                    break;
            }
        }

        System.out.println(sb);
    }
}