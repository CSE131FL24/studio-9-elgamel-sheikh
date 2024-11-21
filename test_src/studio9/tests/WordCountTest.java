package studio9.tests;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

import studio9.WordCount;

public class WordCountTest {

    @Test
    public void testCountWords() {
        // List of words to test
        List<String> words = Arrays.asList("to", "be", "or", "not", "to", "be");
        
        // Create an instance of WordCount
        WordCount wordCountInstance = new WordCount();
        
        // Call the non-static countWords method on the instance
        Map<String, Integer> map = wordCountInstance.countWords(words);
        
        // Assert the expected result
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("to", 2);
        expectedMap.put("be", 2);
        expectedMap.put("or", 1);
        expectedMap.put("not", 1);
        
        assertEquals(expectedMap, map);
    }
}
