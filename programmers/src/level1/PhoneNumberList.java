package level1;

public class PhoneNumberList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
		System.out.println(solution(new String[] {"123","456","789"}));
		System.out.println(solution(new String[] {"12","123","1235","567","88"}));
	}

	  public static boolean solution(String[] phone_book) {
	      
	        for(int i=0;i<phone_book.length;i++) {
	        	for(int j=0;j<phone_book.length;j++) {
	        		//System.out.println(phone_book[i]+" "+phone_book[j]);
	        		if(i==j || phone_book[i].length()>phone_book[j].length()) continue;
	        		if(phone_book[j].substring(0, phone_book[i].length()).equals(phone_book[i])) {
	        			return false;
	        		}
	        	}
	        }
	        return true;
	    }
}
