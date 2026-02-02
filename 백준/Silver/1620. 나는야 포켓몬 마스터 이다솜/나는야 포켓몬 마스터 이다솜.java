import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameToNum = new HashMap<String, Integer>();
        Map<Integer, String> numToName = new HashMap<Integer, String>();

        for(int i = 0; i < N; i++) {
            String name = br.readLine();
            nameToNum.put(name, i + 1);
            numToName.put(i + 1, name);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            String query = br.readLine();

            if(isNumber(query)) {
                int index = Integer.parseInt(query);
                sb.append(numToName.get(index)).append("\n");
            }
            else  {
                sb.append(nameToNum.get(query)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}