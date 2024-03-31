package PS_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PS_240319_좋은단어_BJ3986_CollectionStack {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int cnt = N;

        for (int i = 0; i < N; i++) {
            Stack<Character> myStack = new Stack<>();
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                if (!myStack.isEmpty() && myStack.peek() == line.charAt(j)) {
                    myStack.pop();
                }
                else {
                    myStack.push(line.charAt(j));
                }
            }

            if (!myStack.empty()) {
                cnt--;
            }
        }

        System.out.println(cnt);
    }
}
