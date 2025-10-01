package String_Ques;

import java.util.ArrayList;
import java.util.Arrays;

public class Str {
    public static void main(String[] args) {
        
    }




    // For get the words from string
    static String[] GetWords(String s){
        if (s == null || s.length() == 0) {
            throw new NullPointerException();
            // return new String[]{};
        }
        // int ind = 0;
        String[] wordsArray = s.trim().split("[ \\t]+"); // For split the array

        return wordsArray;
    }





    // Question - 1
    static String reverseString(String s){
        if (s == null || s.length() == 0) {
            throw new NullPointerException();
        }
        StringBuilder s1 = new StringBuilder(s);
        s1.reverse();
        // char[] c = s.toCharArray();
        // int n = c.length-1;
        // for(int i = 0;i<=n/2;i++){
        //     char temp = c[i];
        //     c[i] = c[n];
        //     c[n] = temp;
        //     n--;
        // }

        return s1.toString();
    }





    // Question - 2
    static boolean palindrome(String s){
        if (s == null || s.length() == 0) {
            throw new NullPointerException();
        }
        String s1 = reverseString(s);
        return s1.equals(s);
    }





    // Question - 3
    static String uppercase(String s){
        if (s == null || s.length() == 0) {
            throw new NullPointerException();
        }
        return s.toUpperCase();
    }





    // Question - 4
    static int[] countVowel(String s){
        int n = s.length();
        if (s == null || n == 0) {
            throw new NullPointerException();
        }

        int vowel = 0;
        int cons = 0;
        String k = "AEIOU";
        s = s.toUpperCase();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if (k.indexOf(c) >= 0) {
                vowel++;
            }
            else if ('A' <= c && c <= 'Z') {
                cons++;
            }
        }

        return new int[]{vowel, cons};
    }





    // Question - 5
    static boolean anagram(String s,String s1){

        int n = s.length();
        int n1 = s1.length();

        if (s == null || n == 0) {
            throw new NullPointerException();
        }
        if (s1 == null || n1 == 0) {
            throw new NullPointerException();
        }

        // simply early check
        if(n != n1){
            return false;
        }

        int[] freq = new int[256];

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            freq[ch]++;
        }

        for(int i = 0; i < n1; i++){
            char ch = s1.charAt(i);
            freq[ch]--;
        }

        for(int i = 0; i < 256; i++){
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }





    // Question 6
    static char nonRepeated(String s){
        int n = s.length();
        if (s == null || n == 0) {
            throw new NullPointerException();
        }

        int[] freq = new int[256];

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            freq[ch]++;
        }

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    } 





    // Question - 7
    static boolean isNumeric(String s){
        int n = s.length();
        if (s == null || n == 0) {
            throw new NullPointerException();
        }

        for(int i = 0; i < n;i++){
            if(48 > s.charAt(i) || s.charAt(i) > 57){
                return false;
            }
        }
        return true;
    }





    // Question - 8
    static String ReplaceAll(String s,char old, char New){
        int n = s.length();
        if (s == null || n == 0) {
            throw new NullPointerException();
        }

        char[] c = s.toCharArray();
        for(int i = 0; i < n; i++){
            if(c[i] == old){
                c[i] = New;
            }
        }

        StringBuilder s1 = new StringBuilder();
        for(char a :c){
            s1.append(a);
        }
        return s1.toString();

        // return s.replace(old,New); second method (simple)
    }

    



    // Question - 9
    static int countOccur(String s,char c){
        int n = s.length();
        if (s == null || n == 0) {
            throw new NullPointerException();
        }

        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == c){
                count++;
            }
        }

        return count;
    }





    // Question - 10
    static ArrayList<String> freqChar(String s){
        
        int n = s.length();
        if (s == null || n == 0) {
            throw new NullPointerException();
        }

        int[] freq = new int[256];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch]++;
        }
        
        ArrayList<String> l = new ArrayList<>();
    
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (freq[ch] > 0) {
                l.add(ch + " -> " + freq[ch]);
                freq[ch] = 0;
            }
        }

        return l;
    }





    // Question - 11
    static String toggle(String s){
        int n = s.length();
        if (s == null || n == 0) {
            throw new NullPointerException();
        }

        StringBuilder s1 = new StringBuilder();

        for(int i = 0; i < n ;i++){
            char c = s.charAt(i);
            if('a' <= c && c <= 'z'){
                c -= 32;
                s1.append(c);
            }
            else if('A' <= c && c <= 'Z'){
                c += 32;
                s1.append(c);
            }
            else{
                s1.append(c);
            }
        }

        return s1.toString();
    }





    // Question - 12
    static boolean checkRotation(String s, String s1){
       
        int n = s.length();
        int n1 = s1.length();
        if (s == null || n == 0) {
            throw new NullPointerException();
        }

        if (s1 == null || n1 == 0) {
            throw new NullPointerException();
        }

        if (n == n1 && (s+s).contains(s1)) {
            return true;
        }

        return false;
    }





    // Question - 13
    static ArrayList<String> PrintSubString(String s){

        int n = s.length();
        if (s == null || n == 0) {
            throw new NullPointerException();
        }
        
        ArrayList<String> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int k = i+1;
            while (k <= n) {
                l.add(s.substring(i, k) + "");
                k++;
            }
        }

        return l;
    }
    




    // Question - 14
    static String reverseWord(String s){
        String[] arr = GetWords(s);
        int n = arr.length;

        StringBuilder s1 = new StringBuilder();

        for(int i = 0; i < n; i++){
            s1.append(reverseString(arr[i]));
            s1.append(" ");
        }

        return s1.toString().trim();
    }





    // Question - 15
    static boolean isSubSequence(String s,String s1){
        int n = s.length();
        int n1 = s1.length();

        if (s == null || n == 0) {
            throw new NullPointerException();
        }
        if (s1 == null || n1 == 0) {
            throw new NullPointerException();
        }

        int i = 0;
        int j = 0;
        while (i < n && j < n1) {
            if(s.charAt(i) == s1.charAt(j)){
                i++;
            }
            j++;
        }
        return i == n;
    }






    // Question - 16
    static String removeDup(String s){
        int n = s.length();

        if (s == null || n == 0) {
            throw new NullPointerException();
        }

        StringBuilder s1 = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(s1.indexOf(s.charAt(i) + "") == -1){
                s1.append(s.charAt(i));
            }
        }
        return s1.toString();
    }






    // Question - 17
    static String LongestWord(String s){
        // int ind = 0;
        
        if (s == null || s.length() == 0) {
            throw new NullPointerException();
        }

        String[] arr = GetWords(s);
        int n = arr.length;
        int longWord = 0;
        int index = 0;
        for(int i = 0;i< n;i++){
            if(arr[i].length() > longWord){
                longWord = arr[i].length();
                index = i;
            }
        }

        return arr[index];
    }





    // Question - 18
    static String Capitalize(String s){
        String[] arr = GetWords(s);
        int n = arr.length;
        StringBuilder s2 = new StringBuilder();

        for(int i = 0; i < n; i++){
           String s1 = arr[i];
           char c =  Character.toUpperCase(s1.charAt(0));

           s2.append(c + s1.substring(1).toLowerCase());
           s2.append(" ");
        }

        return s2.toString().trim();
    }






    // Question - 19
    static int countWords(String s){
        return GetWords(s).length;
    }






    // Question - 20
    static int convertToInt(String s){
        int n = s.length();
        if (s == null || n == 0) {
            throw new NullPointerException();
        }
        
        long num = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        int sign = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
        }

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(c < '0' || c > '9'){ // check if there is another character in String
                continue;
            }


            int k = (c - '0');
            num = (num*10) + k;

            if (num > max) {
                return max;
            }
            if (sign == -1 && num > (long)max + 1) {
                return min;
            }
            
        }

        return (int)(num*sign);
    }






    // Question - 21
    static String RLE(String s){

        int n = s.length();
        if (s == null || n == 0) {
            throw new NullPointerException();
        }

        StringBuilder s1 = new StringBuilder();

        for(int i = 0; i < n; i++){
            int count = 1;

            while (i+1 < n && s.charAt(i+1) == s.charAt(i)) {
                count++;
                i++;
            }

            s1.append(s.charAt(i));
            s1.append(count + "");
        }

        return s1.toString();
    }

   


    
    // Question - 22
    static String LongestPre(String[] s){

        if (s == null || s.length == 0) {
            throw new NullPointerException();
        }

        int n = Integer.MAX_VALUE;

        for(String a: s){
            int k = a.length();
            if(k < n){
                n = k;
            }
        }

        StringBuilder s1 = new StringBuilder();
        for(int i = 0; i < n; i++){
            int count = 0;
            char c = s[0].charAt(i);

            for(String b:s){
                if(c == b.charAt(i)){
                    count++;
                }
                if(b.charAt(i) != c){
                    return s1.toString();
                }
            }

            if(count == s.length){
                s1.append(c + "");
            }
        }
        return s1.toString();
    }






    // Question - 23
    static String[] AllPalindrome(String s){

        ArrayList<String> l = PrintSubString(s);
        ArrayList<String> ans = new ArrayList<>();
        for(String check : l){
            if (check.equals(reverseString(check))) {
                ans.add(check);
            }
        }

        int size = ans.size();
        String[] k = new String[size];
        int index = 0;
        for(String a : ans){
            k[index++] = a;
        }

        return k;
    }






    // Question - 24
    static int PalindromePermutation(String s){ // check if it's palindrome gives 0 else gives how many incorrect words;

        if (s == null || s.length() == 0) {
            throw new NullPointerException();
        }
        ArrayList<Integer> l = new ArrayList<>();
        char[] c = s.toCharArray();
        Arrays.sort(c);
        
        int count = 1;
        int n = c.length-1;

        for(int i = 0; i < n; i++){

            if(c[i] == c[i+1]){
                count++;
            }
            else{
                l.add(count);
                count = 1;
            }
        }
       l.add(count);

        
        count = 0;
        n = l.size();

        for(int i = 0; i < n; i++){
            int k = l.get(i);
            if (k %2 != 0) {
                count++;
            }
        }

        return count;
    }
}