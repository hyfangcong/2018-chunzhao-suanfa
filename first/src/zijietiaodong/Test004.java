package zijietiaodong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test004 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++){
			String string = in.nextLine();
			String[] ss = string.split(" ");
			int k = Integer.parseInt(ss[0]);
			int[] a = new int[ss.length-1];
			for(int j=0;j<a.length;j++){
				a[j] = Integer.parseInt(ss[j+1]);
			}
			
			
		}
	}
}
