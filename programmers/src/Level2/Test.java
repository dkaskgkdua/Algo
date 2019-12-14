package Level2;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr=new ArrayList<String>();
		ArrayList<String> arr2=new ArrayList<String>();
		
		arr.add("1234");
		arr.add("123");
		arr.add("3456");
		arr.add("1");
		arr.add("2");
		arr.add("34");
		
		Collections.sort(arr);
		System.out.println(arr);
	}

}
