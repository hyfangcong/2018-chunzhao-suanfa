package aiqiyi;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Pre003 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int aMax = 0;
		int cMax = 0;
		int gMax = 0;
		int tMax = 0;
		
		for(int i=0;i<s.length()-1;i++){
			Character c = s.charAt(i);
			int tmp = 1;
			for(int j=i+1;j<s.length();j++){
				if(s.charAt(j)==s.charAt(i)){
					tmp++;
					}
				else{
					i = j-1;
					break;
				}
				}
			switch (c) {
			case 'A':
				if(tmp>aMax){
					aMax=tmp;
				}
				break;
			case 'C':
				if(tmp>cMax){
					cMax=tmp;
				}
				break;
			case 'G':
				if(tmp>gMax){
					gMax=tmp;
				}
				break;
			case 'T':
				if(tmp>tMax){
					tMax=tmp;
				}
				break;

			default:
				break;
			}
			}
		Character c = s.charAt(s.length()-1);
		switch (c) {
		case 'A':
			if(1>aMax){
				aMax=1;
			}
			break;
		case 'C':
			if(1>cMax){
				cMax=1;
			}
			break;
		case 'G':
			if(1>gMax){
				gMax=1;
			}
			break;
		case 'T':
			if(1>tMax){
				tMax=1;
			}
			break;

		default:
			break;
		}
		
		if(aMax==cMax && aMax==gMax && aMax==tMax){
			System.out.println(aMax);
			return;
		}
		System.out.println(aMax+" "+cMax+" "+gMax+" "+tMax);
		int min = Math.min(aMax, cMax);
		min = Math.min(min, gMax);
		min = Math.min(min, tMax);
		System.out.println(min+1);
			
			
	}
}
