package tengxun;

import java.util.Scanner;

public class Pre002 {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String s1 = in.next();
			String s2 = new StringBuilder(s1).reverse().toString();
			int[][] dp = new int[s1.length()+1][s2.length()+1];
			
			for(int i=1;i<dp.length;i++){
				for(int j=1;j<dp[0].length;j++){
					dp[i][j] = (s1.charAt(i-1)==s2.charAt(j-1))?dp[i-1][j-1]+1:Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			System.out.println(s1.length()-dp[s1.length()][s2.length()]);
		}

	}
}
