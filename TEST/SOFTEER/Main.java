import java.util.*;
import java.io.*;

/*
    1. 아이디어:

    2. 시간 복잡도:

    3. 자료구조:

 */

public class Main {
    private static String encrypt(String msg, String secret, int rot) {
        char[] arr = new char[msg.length()];

        for (int i = 0; i < msg.length(); i++) {
            int c = (msg.charAt(i)-'a' + secret.charAt(i)-'a') % 26 + 'a';
            int idx = (msg.length() + i - rot) % msg.length();
            arr[idx] = (char) c;
        }

        return new String(arr);
    }
    private static String decrypt(String msg, String secret, int rot) {
        char[] arr = new char[msg.length()];

        for (int i = 0; i < msg.length(); i++) {
            int c = (26 + msg.charAt((msg.length() + i - rot) % msg.length()) - secret.charAt(i)) % 26 + 'a';
            arr[i] = (char) c;
        }
        return new String(arr);
    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String type = st.nextToken();
        String secret = st.nextToken();
        int rot = Integer.parseInt(st.nextToken());
        String msg = st.nextToken();

        if (type.equals("encrypt")) {
            System.out.println(encrypt(msg, secret, rot));
        }
        if (type.equals("decrypt")) {
            System.out.println(decrypt(msg, secret, rot));
        }
    }
}




