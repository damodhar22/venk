package exp;

import java.util.*;

public class test {
    public static void main(String[] args) {
        int[] i = {17, 4, 5, 6, 10, 11, 4, -3, -5, 3, 15, 2, 7};
        System.out.println(ArrayChallenge(i));
    }

    public static String ArrayChallenge(int[] arr) {
        if (arr.length < 3) {
            return "-1";
        }

        int targetSum = arr[0];
        StringBuilder str = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < arr.length; i++) {
            int complement = targetSum - arr[i];
            if (map.containsKey(complement)) {
                if(str.isEmpty()){
                    str.append(complement).append(",").append(arr[i]);
                }else{
                    str.append(" ").append(complement).append(",").append(arr[i]);
                }
            }
            map.put(arr[i], i);
        }
        if(str.isEmpty()){
            return "-1";
        }
        return str.toString();
    }

    public static String SearchingChallenge(String[] strArr) {
        Map<String, Integer> keyValueMap = new HashMap<>();

        for (String pair : strArr) {
            String[] parts = pair.split(":");
            if (parts.length == 2) {
                String key = parts[0];
                int value = Integer.parseInt(parts[1]);
                keyValueMap.put(key, keyValueMap.getOrDefault(key, 0) + value);
            }
        }

        Map<String, Integer> sortedKeyValues = new TreeMap<>(keyValueMap);

        // Build the result string
        StringBuilder resultBuilder = new StringBuilder();
        boolean isFirst = true;
        for (Map.Entry<String, Integer> entry : sortedKeyValues.entrySet()) {
            if (!isFirst) {
                resultBuilder.append(",");
            }
            resultBuilder.append(entry.getKey()).append(":").append(entry.getValue());
            isFirst=false;
        }

        return resultBuilder.toString().trim();
    }

    public static int ArrayChallenge2(int[] args) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int p:args){
            max=Math.max(max,p-min);
            min=Math.min(min,p);
        }
        return max;
    }

    public static String findWordWithMostRepeatedLetters(String input) {
        String[] words = input.split("\\s+");
        String maxRepeatedWord = "-1";
        int maxRepeatedCount = 0;

        for (String word : words) {
            int[] letterCounts = new int[26];

            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    letterCounts[Character.toLowerCase(c) - 'a']++;
                }
            }

            int maxCount = 0;
            for (int count : letterCounts) {
                if (count > maxCount && count > 1) {
                    maxCount = count;
                }
            }

            if (maxCount > maxRepeatedCount) {
                maxRepeatedCount = maxCount;
                maxRepeatedWord = word;
            }
        }

        return maxRepeatedWord;
    }

   public static boolean is(String s){
       Deque<Character> q = new ArrayDeque<>();
        final Map<Character, Character> l = new HashMap<>(){{put('(',')'); put('{','}');put('[',']');}};
        for (int i=0;i<s.length();i++){
            if(l.get(s.charAt(i))!=null){
                q.addFirst(s.charAt(i));
            }else if(q.isEmpty() || l.get(q.removeFirst()) != s.charAt(i)){
                return false;
            }
        }
        return q.isEmpty();
   }

}
