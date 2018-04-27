package jindong;

import java.util.Scanner;

public class Test003 {
	
	public static boolean isLegal(String s){
		int left = 0;
		int right = s.length()-1;
		while(left<=right){
			if(s.charAt(left)!=s.charAt(right)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String s = in.next();
			
		}
	}
}
