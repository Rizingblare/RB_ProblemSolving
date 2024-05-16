package PS_problems;

import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        String result = step1(new_id);
        result = step2(result);
        result = step3(result);
        result = step4(result);
        result = step5(result);
        result = step6(result);
        result = step7(result);
        System.out.println(result);
        
        return result;
    }
    
    private String step1(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (Character.isUpperCase(curr)) {
                sb.append(Character.toLowerCase(curr));
            }
            else {
                sb.append(curr);
            }
        }
        return sb.toString();
    }
    
    private String step2(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if ('a' <= c && c <= 'z') {
                sb.append(c);
            }
            else if ('0' <= c && c <= '9') {
                sb.append(c);
            }
            else if (c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private String step3(String str){
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.') {
                if (flag) continue;
                else {
                    flag = true;
                    sb.append(c);
                }
            }
            else {
                flag = false;
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    private String step4(String str) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 || i == str.length()-1) {
                if (c == '.') continue;
                else sb.append(c);
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    private String step5(String str){
        if (str.isEmpty()) return new String("a");
        else return str;
    }
    
    private String step6(String str){
        if (str.length() >= 16) {
            str = new String(str.substring(0,15));
            
            if (str.charAt(str.length()-1) == '.') {
                str = new String(str.substring(0,14));
            }
        }
        
        return str;
    }
    
    private String step7(String str){
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < 3) {
            sb.append(str.charAt(str.length()-1));
        }
        return sb.toString();
    }
}