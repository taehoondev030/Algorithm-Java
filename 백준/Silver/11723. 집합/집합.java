import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static HashSet<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i ++) {
			st = new StringTokenizer(br.readLine());
			String operator = st.nextToken(); // 연산자 추출
			
			if(operator.equals("all")) {
				set.clear();
				for(int j = 1; j <= 20; j++) {
					set.add(j);
				}
				continue;
			} else if (operator.equals("empty")) {
				set.clear();
				continue;
			}
			
			int num = Integer.parseInt(st.nextToken()); // 피연산자 추출
			
			switch(operator) {
			case "add":
				set.add(num); break;
				
			case "check": 
				if(set.contains(num)) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				};
				break;
				
			case "remove":
				set.remove(num); break;
				
			case "toggle":
				if(set.contains(num)) {
					set.remove(num);
				} else {
					set.add(num);
				};
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}