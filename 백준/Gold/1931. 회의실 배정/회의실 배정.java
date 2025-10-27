import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2]; // 시작, 종료시간을 저장하는 배열

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }

        // 종료시간 기준 오름차순으로 정렬
        // Comparator 인터페이스의 compare() 메서드를 람다식으로 표현
        // Comparator: 비교값이 음수면 a, 양수면 b가 먼저 오도록 리턴
        Arrays.sort(meetings, (a, b) -> {
            if(a[1] == b[1]) return a[0]-b[0]; // 종료시간이 같다면 시작시간을 비교
            return a[1]-b[1];
        });

        int meetingCount = 0; // 가능한 회의 개수
        int lastend = 0; // 이전 작업의 종료시간

        for(int i = 0; i < n; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            // 다음 작업의 시작시간이 이전 작업의 종료시간보다 크거나(늦거나) 같은 경우
            if(start >= lastend) { 
                meetingCount++;
                lastend = end;
            }
        }

        System.out.println(meetingCount);
    }
}