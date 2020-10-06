package edu.gatech.cs1331.wordcount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount {

    // is an inner class, NOT static inner classes because not in main method
    /*private class RankComparator implements Comparator<String> {
        public int compare(String w1, String w2) {
            int diff = wordCounts.get(w1) - wordCounts.get(w2);
            return (diff == 0) ? w1.compareTo(w2): diff;
        }
    }*/

    Map<String, Integer> wordCounts;

    public WordCount(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        wordCounts = new HashMap<>();
        while (scanner.hasNext()) {
            String curWord = scanner.next();
            System.out.println("curWord = " + curWord);
            if(wordCounts.keySet().contains(curWord)) {
                int count = wordCounts.get(curWord);
                wordCounts.put(curWord, count + 1);
            } else {
                wordCounts.put(curWord, 1);
            }
        }
    }

    public Collection<String> getWords() {
        TreeSet<String> sortedWords = new TreeSet<>(
            (String w1, String w2) -> {
                int diff = wordCounts.get(w1) - wordCounts.get(w2);
                return (diff == 0) ? w1.compareTo(w2): diff;
        });
        sortedWords.addAll(wordCounts.keySet());
        return sortedWords;
    }

    public int getCount(String word) {
        return wordCounts.get(word);
    }

    public static void main(String[] args) throws FileNotFoundException {
        WordCount wc = new WordCount(args[0]);
        System.out.println("wc = " + wc);
        for(String word: wc.getWords()) {
            System.out.println(word + ": " + wc.getCount(word));
        }
    }
}
