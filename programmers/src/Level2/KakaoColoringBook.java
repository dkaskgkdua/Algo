package Level2;

import java.util.ArrayList;

public class KakaoColoringBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KakaoColoringBook k=new KakaoColoringBook();
		//System.out.println(k.solution(6,4,new int [][]{{ 1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}}));
		//6, 4, [[1, 1, 1, 0], [1, 1, 1, 0], [0, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 1]]
		//System.out.println(k.solution(6,4,new int [][]{{ 1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}}));
		System.out.println(k.solution(13,16,new int [][]{{ 0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0}, {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0}, {0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0}, {0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0}, {0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
			{0,1,1,1,1,2,1,1,1,1,2,1,1,1,1,0},{0,1,1,1,2,1,2,1,1,2,1,2,1,1,1,0},{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{0,1,3,3,3,1,1,1,1,1,1,3,3,3,1,0},{0,1,1,1,1,1,2,1,1,2,1,1,1,1,1,0},{0,1,1,1,1,1,1,2,2,1,1,1,1,1,1,0},{0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0}
			,{0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0}}));
	}
	public static int c,r,cnt=0;;
	public static int currentColor=0, numberOfArea = 0, maxSizeOfOneArea = 0, currentNumberOfArea = 0, currentMaxSizeOfOneArea = 0;
	
	  public int[] solution(int m, int n, int[][] picture) {
	      
		  
	      c=m;r=n;
	      for(int column=0;column<m;column++) {
	    	  for(int row=0;row<n;row++) {
	    		  if(picture[column][row]!=0) {
	    			 currentColor=picture[column][row];
	    			 currentMaxSizeOfOneArea=0;
	    			  dfs(column,row,picture);
	    			 
	    			 numberOfArea++;
	    			
	    		  }
	    	  }
	    	 
	      }


	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      System.out.println("num : "+numberOfArea);
	      System.out.println("max : "+maxSizeOfOneArea);
	     
	      return answer;
	  }
	  
	  public static void dfs(int column,int row,int[][]picture) {
		 // System.out.println("dd");
			if(picture[column][row]==currentColor) {
				//System.out.println("ifmax");
				currentMaxSizeOfOneArea++;
			}
			else {
				return;

			}
		 
		 
			System.out.println(picture[column][row]);
				System.out.println(column+" : "+row);
		  
		
		 picture[column][row]=0;
		  int[] dx = { 0, 0, 1, -1 };
			int[] dy = { 1, -1, 0, 0 };
			int ax, ay;
		
			
		  for(int i=0;i<4;i++) {
			 
			  ax = dx[i] + column;
				ay = dy[i] +row;
				
				if ((check(ax, ay) && (picture[ax][ay] != 0)&&picture[ax][ay]==currentColor)) {
					//currentColor=picture[column][row];
					dfs(ax,ay,picture);
				}
			
		  }
		 //System.out.println("¾ðÁ¦ "+column +" "+row);
		   maxSizeOfOneArea=Math.max(maxSizeOfOneArea, currentMaxSizeOfOneArea);
		   
		  
		
	  }
	  public static boolean check(int x, int y) {
			return (x >= 0 && x < c && y >= 0 && y < r);
		}
	 

}
