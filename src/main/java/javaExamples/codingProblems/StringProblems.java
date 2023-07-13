package javaExamples.codingProblems;

import java.util.HashMap;
import java.util.Map;

public class StringProblems {
    public static void main(String[] args) {
        duplicateCharacters("Where ? is this going to land ?");
        duplicateCharacters("!! ## Helluva ride happening here !!@@");
    }
    public static void duplicateCharacters(String target) {
        Map<Character, Integer> countOfChars = new HashMap<>();

        for(int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            countOfChars.compute(ch, (k,v) -> (v==null)? 1 : ++v);

        }
        for ( Character chr: countOfChars.keySet()) {
            if(countOfChars.get(chr) > 1) {
                System.out.println("Number of times for :" +chr + "is " + countOfChars.get(chr));
            }
        }
    }
}
