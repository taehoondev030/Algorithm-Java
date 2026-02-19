import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(i == str.length()-1) {
                count++;
                break;
            }
            if(str.charAt(i) == 'c') {
                if(str.charAt(i + 1) == '=') {
                    count++;
                    i++;
                    continue;
                } else if(str.charAt(i + 1) == '-') {
                    count++;
                    i++;
                    continue;
                }
            }
            else if(str.charAt(i) == 'd') {
                if(str.charAt(i + 1) == 'z') {
                    if(i + 1 == str.length() - 1) {
                        count += 2;
                        break;
                    }
                    if(str.charAt(i + 2) == '=') {
                        count ++;
                        i += 2;
                        continue;
                    }
                } else if(str.charAt(i + 1) == '-') {
                    count++;
                    i++;
                    continue;
                }
            }
            else if(str.charAt(i) == 'l') {
                if(str.charAt(i + 1) == 'j') {
                    count++;
                    i++;
                    continue;
                }
            }
            else if(str.charAt(i) == 'n') {
                if(str.charAt(i + 1) == 'j') {
                    count++;
                    i++;
                    continue;
                }
            }
            else if(str.charAt(i) == 's') {
                if(str.charAt(i + 1) == '=') {
                    count++;
                    i++;
                    continue;
                }
            }
            else if(str.charAt(i) == 'z') {
                if(str.charAt(i + 1) == '=') {
                    count++;
                    i++;
                    continue;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}