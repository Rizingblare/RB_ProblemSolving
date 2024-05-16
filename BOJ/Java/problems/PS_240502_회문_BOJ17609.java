package PS_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PS_240502_회문_BOJ17609 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    // 1. 아이디어 :
    // (1) 주어진 문자열 길이가 홀수인지 짝수인지 판별
    // (2) 짝수일 때는 유사회문이 발생할 수 없음
    // (3) 중간값을 기준으로 양옆으로 같은 값인지 확인한다
    // 2. 시간 복잡도 : O(N) 100000
    // 3. 자료구조 : 정수 int

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int code = checkPalindrome(str);
            sb.append(code).append("\n");
        }
    }

    private static int checkPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        boolean isEven = str.length() % 2 == 0;
        if (isEven) {
            int lptr = str.length() / 2 - 1;
            int rptr = str.length() / 2;

            for (int i = 0; i < str.length(); i++) {

            }
        }

        else {
            int lptr = str.length() / 2 - 1;
            int cptr = str.length() / 2;
            int rptr = str.length() / 2 + 1;

            if (str.charAt(cptr) == str.charAt(lptr)) {
                lptr--;
            }
            else if (str.charAt(cptr) == str.charAt(rptr)) {
                rptr++;
            }
            else {
                return 2;
            }


            boolean flag = false;

            for (int i = 0; i < cptr; i++) {
                if (str.charAt(lptr) != str.charAt(rptr)) {

                }
            }
        }
        return 0;
    }
}
