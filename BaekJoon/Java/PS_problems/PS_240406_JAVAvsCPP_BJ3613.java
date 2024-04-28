package PS_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS_240406_JAVAvsCPP_BJ3613 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private enum LType {JAVA, CPP, ERROR};

    public static void main(String[] args) throws IOException {
        String vName = br.readLine();

        LType type = styleCheck(vName);

        switch (type) {
            case CPP:
                System.out.println(Cpp2Java(vName));
                break;

            case JAVA:
                System.out.println(Java2Cpp(vName));
                break;

            case ERROR:
                System.out.println("Error!");
                break;
        }


    }

    private static LType styleCheck(String vName) {
        if (!Character.isLowerCase(vName.charAt(0))) {
            return LType.ERROR;
        }
        if (vName.contains("__")) {
            return LType.ERROR;
        }

        if (vName.contains("_")) {
            if (vName.charAt(vName.length()-1) == '_') {
                return LType.ERROR;
            }
            for (int i = 0; i < vName.length(); i++) {
                char curr = vName.charAt(i);
                if (Character.isUpperCase(curr)) {
                    return LType.ERROR;
                }
            }
            return LType.CPP;
        }

        return LType.JAVA;
    }

    private static String Cpp2Java(String vName) {
        String result = "";

        boolean flag = false;
        for (int i = 0; i < vName.length(); i++) {
            char curr = vName.charAt(i);

            if (curr == '_') {
                flag = true;
                continue;
            }

            if (flag) {
                result += Character.toUpperCase(curr);
                flag = false;
            }

            else {
                result += curr;
            }

        }
        return result;
    }

    private static String Java2Cpp(String vName) {
        String result = "";
        for (int i = 0; i < vName.length(); i++) {
            char curr = vName.charAt(i);

            if (Character.isUpperCase(curr)) {
                result += "_";
                result += Character.toLowerCase(curr);
            }
            else {
                result += curr;
            }
        }
        return result;
    }

}