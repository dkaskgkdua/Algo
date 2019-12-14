package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidateKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			CandidateKey c=new CandidateKey();
			System.out.println(c.solution(new String[][] {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
	}
	public static List<Integer> index=new ArrayList<Integer>();
	public static int answer=0;
	public static List<String> lap=new ArrayList<String>();
	  public int solution(String[][] relation) {
	        //int answer = 0;
	      
	        int [] att=new int[relation[0].length];
	        //부분집합 할 속성 생성 (0123....)
	        for(int i=0;i<att.length;i++) att[i]=i;
	        boolean []vis=new boolean[att.length];
	        PowerSet(att, relation, 0, vis, att.length);
	        for(int i=0;i<lap.size();i++) {
	        	int cnt=0;
	        	  for(int j=0;j<lap.size();j++) {
	  	        	if(i!=j &&lap.get(i).contains(lap.get(j))) {
	  	        		cnt++;
	  	        		continue;
	  	        	}
				
				  else if(i!=j) { int cnt2=0; String[]str=lap.get(j).split(""); for(String s:str) {
				  if(lap.get(i).contains(s)) cnt2++; } if(cnt2==lap.get(j).length()) cnt++; }
				 
	  	        }
	        	  if(cnt==0) answer++;
	        }
	        System.out.println(lap);
	        return answer;
	    }
	  //부분집합
	  public void PowerSet(int []att,String[][]relation,int idx, boolean[] vis,int length) {
		  if(idx==length) {
			  index=new ArrayList<Integer>();
			  String ol="";
			  for(int i=0;i<length;i++) {
				  if(vis[i]==true) {
					 // System.out.print(att[i]+" ");
					 ol+=att[i];
					  index.add(att[i]);
				  }
				  
			  }
			  lap.addAll(CandidateSelection(index, relation,ol));
			
			 // System.out.println();
			  return;
		  }
		  vis[idx]=false;
		  PowerSet(att, relation, idx+1, vis, length);
		  
		  vis[idx]=true;
		  PowerSet(att, relation, idx+1, vis, length);
	  }
	  //후보키 선별
	  public ArrayList<String> CandidateSelection(List<Integer> index,String[][]relation,String ol) {
		  Map<String, Integer> cKey=new HashMap<String, Integer>();
		  ArrayList<String> overlap=new ArrayList<String>();
		  //int value=0;
		  for(int i=0;i<relation.length;i++) {
			  String k = "";
			 
			  for(int j=0;j<index.size();j++) {

				 k+=relation[i][index.get(j)];

			  }
			 //System.out.println("key : "+k );
			  cKey.put(k, i);
		  }
		  if(cKey.size()==relation.length) {
			overlap.add(ol);

		  }
		  return overlap;

	  }
}
