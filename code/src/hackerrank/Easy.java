package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Easy {

   static boolean isAnagram(String a, String b) {
       // https://www.hackerrank.com/challenges/java-anagrams/problem?isFullScreen=true
//       if (a.length() != b.length()){
//           return false;
//       }
//       a = a.toLowerCase();
//       b = b.toLowerCase();
//       Map<Character, Integer> map = new HashMap<>();
//
//       for (int i = 0; i < a.length(); i++){
//           map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
//       }
//
//       for(int i = 0; i < b.length(); i++){
//           if (!map.containsKey(b.charAt(i)) || !(map.get(b.charAt(i)) > 0)){
//               return false;
//           } else {
//               map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
//           }
//       }
//
//       for (Character key: map.keySet()){
//           if (map.get(key) != 0){
//               return false;
//           }
//       }
//
//       return true;
       if (a.length() != b.length()){
           return false;
       }
       a = a.toLowerCase();
       b = b.toLowerCase();

       int[] count = new int[26];

       for (int i = 0; i < a.length(); i++){
           count[a.charAt(i) - 'a']++;
       }

       for(int i = 0; i < b.length(); i++){
           int index = b.charAt(i) - 'a';
           if (count[index] == 0){
               return false;
           }
               count[index]--;
       }

       return true;
   }

   public static void stringTokenizer(String str){
       // https://www.hackerrank.com/challenges/java-string-tokens/problem?isFullScreen=true
       StringTokenizer tokenizer = new StringTokenizer(str, "!,?._'@ ");

       while (tokenizer.hasMoreTokens()){
           System.out.println(tokenizer.nextToken());
       }
   }

    public static void main(String[] args) {
        System.out.println(isAnagram("Anagramm", "marganaa"));
        stringTokenizer("He is a very very good boy, isn't he?");
    }
}
