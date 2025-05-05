import java.io.*;

class Solution
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static String s;
    private static char[] arr;
    private static int maxLength;

    private static void func(int depth, int st) {
        String curr = String.valueOf(arr).substring(0,depth);

        if (curr.contains("aa")
                || curr.contains("ab")
                || curr.contains("ba")
                || curr.contains("bb")) return;
        maxLength = Math.max(maxLength, depth);
        if (depth == N) return;

        for (int i = st ; i < N; i++) {
            arr[depth] = s.charAt(i);
            func(depth+1, i+1);
        }
    }

    public static void main(String args[]) throws Exception
    {

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            s = br.readLine();
            maxLength = 0;
            arr = new char[N];
            func(0,0);
            int score = s.length() - maxLength;
            System.out.println("#" + test_case + " " + score);
        }

    }
}
