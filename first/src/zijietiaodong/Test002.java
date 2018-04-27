package zijietiaodong;

import java.util.Scanner;

public class Test002 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			int N = in.nextInt();
			int M = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			
			int step = 0;
			for(int j=0;j<s.length();j++){
				char c = s.charAt(j);
				
				if(x>=1 && x<=N && y>=1 && y<=M){
					switch (c) {
					case 'u':
						x-=1;
						break;
					case 'd':
						x+=1;
						break;
					case 'l':
						y-=1;
						break;
					case 'r':
						y+=1;
						break;

					default:
						break;
					}
					step++;
				}else{
					break;
				}
			}
			System.out.println(step);
		}
	}
	
}
