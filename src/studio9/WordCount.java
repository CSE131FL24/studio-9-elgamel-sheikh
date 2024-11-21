package studio9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;



public class WordCount {

    public static void main(String[] args) {
        // Create an instance of the WordCount class
        WordCount wordCount = new WordCount();

        // Example word list
        List<String> wordList = Arrays.asList("to", "be", "or", "not", "to", "be");

        // Call the non-static countWords method using the instance
        Map<String, Integer> words = wordCount.countWords(wordList);

        // Print the result
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println("Word: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }

    // Non-static method to count the occurrences of each word in the list
    public Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        return wordCountMap;
    }
}


	