package Level2;

import java.util.HashMap;
import java.util.Map;

public class EngShiritori {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EngShiritori e=new EngShiritori();
		for(int i:e.solution(3	, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})) System.out.print(i);
		System.out.println();
		for(int i:e.solution(5	, new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})) System.out.print(i);
		System.out.println();
		for(int i:e.solution(2	, new String[] {"hello", "one", "even", "never", "now", "world", "draw"})) System.out.print(i);
	}
    public int[] solution(int n, String[] words) {
 
       Map<Integer, String> turnNword=new HashMap<Integer, String>();
        for(int i=0;i<words.length;i++) {
			  if(turnNword.containsValue(words[i])==true
			  ||(turnNword.get(i)!=null&&turnNword.get(i).charAt(turnNword.get(i).
			 length()-1)!=words[i].charAt(0))||words[i].length()<=1) break;
			  turnNword.put(i+1, words[i]);
        	
        }

        if(turnNword.size()==words.length) return new int[]{0,0};
        else {
        	 return new int[] {turnNword.size()%n+1,turnNword.size()/n+1};
        }
       
    }
    
}
/*
 * class Shiritori{ int turn=0; String word=""; public Shiritori(int turn,String
 * word) { this.turn=turn; this.word=word; } }
 */