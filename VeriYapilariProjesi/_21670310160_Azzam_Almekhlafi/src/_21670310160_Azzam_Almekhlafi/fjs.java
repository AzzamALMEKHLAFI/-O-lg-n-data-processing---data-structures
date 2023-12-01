package _21670310160_Azzam_Almekhlafi;

import java.util.Arrays;

public class fjs {

	public static void main(String[] args) {
			
			String sentence = "is2 sentence4 This1 a3";
			String sortedSentence = sortSentences(sentence);
			System.out.println(sortedSentence);
		}	
		public static String sortSentences(String sentence) {
		    String[] words = sentence.split(" ");
		    Arrays.sort(words, (a, b) -> a.charAt(a.length() - 1) - b.charAt(b.length() - 1));
		    StringBuilder sb = new StringBuilder();
		    for (String word : words) {
		        sb.append(word.substring(0, word.length() - 1)).append(" ");
		    }
		    return sb.toString().trim();
		}
	}


