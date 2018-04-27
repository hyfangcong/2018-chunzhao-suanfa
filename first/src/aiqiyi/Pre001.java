package aiqiyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.InlineView;

public class Pre001 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] ss = new String[n];
		
		for(int i=0;i<n;i++){
			ss[i] = in.next();
		}
		
		int max = change(ss[0]);
		for(int j=1;j<n;j++){
			if(change(ss[j])>max){
				max = change(ss[j]);
			}
		}
		System.out.println(max);
		
	}
	
	public static int change(String s){
		List<Character> list = new ArrayList<>();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)!='0'){
				list.add(s.charAt(i));
			}
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++){
			sb.append(list.get(i));
		}
		return Integer.parseInt(sb.toString());
	}
	
	
}
