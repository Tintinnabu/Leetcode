package top.tinn.Top200.Problem_030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0){
            return res;
        }
        int wordLen = words[0].length();
        Map<String, Integer> allWords = new HashMap<>();
        for (String word : words){
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);
        }
        for (int j = 0; j < wordLen; j++){
            Map<String, Integer> hasWords = new HashMap<>();
            int num = 0;
            for (int i = j; i < s.length() - wordLen * wordNum + 1; i += wordLen){
                boolean hasRemoved = false;
                while (num < wordNum){
                    String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (allWords.containsKey(word)){
                        int value = hasWords.getOrDefault(word, 0);
                        hasWords.put(word, value + 1);
                        if (hasWords.get(word) > allWords.get(word)){
                            hasRemoved = true;
                            int removeNum = 0;
                            while (hasWords.get(word) > allWords.get(word)){
                                String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                int v = hasWords.get(firstWord);
                                hasWords.put(firstWord, v - 1);
                                removeNum++;
                            }
                            num = num - removeNum + 1;
                            i = i + (removeNum - 1) * wordLen;
                            break;
                        }
                    }else {
                        hasWords.clear();
                        i = i + num * wordLen;
                        num = 0;
                        break;
                    }
                    num++;
                }
                if (num == wordNum){
                    res.add(i);
                }
                if (num > 0 && !hasRemoved){
                    String firstWord = s.substring(i, i + wordLen);
                    int v = hasWords.get(firstWord);
                    hasWords.put(firstWord, v - 1);
                    num--;
                }
            }
        }
        return res;
    }
}
