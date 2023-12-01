package _21670310160_Azzam_Almekhlafi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListW {

	public static String frequencySort(String s) {
       
        Map <Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        List<Character> characters = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(characters, (a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        
        StringBuilder sortedString = new StringBuilder();
        for (char c : characters) {
            int frequency = frequencyMap.get(c);
            for (int i = 0; i < frequency; i++) {
                sortedString.append(c);
            }
        }
        
        return sortedString.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        String sorted = frequencySort(s);
        System.out.println(sorted);  // Output: eert

        s = "cccaaa";
        sorted = frequencySort(s);
        System.out.println(sorted);  // Output: aaaccc

        s = "Aabb";
        sorted = frequencySort(s);
        System.out.println(sorted);  // Output: bbAa
    }
}


