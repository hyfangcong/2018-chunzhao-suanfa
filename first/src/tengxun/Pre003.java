package tengxun;

import java.util.Scanner;

public class Pre003 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String string = in.nextLine();
			char[] cs = string.toCharArray();
			System.out.println(cs.length);
			
			for(int i=0;i<cs.length;i++){
				for(int j=0;j<cs.length-1;j++){
					if((cs[j]>='A'&&cs[j]<='Z') && (cs[j+1]>'Z')){
						char tmp = cs[j];
						cs[j] = cs[j+1];
						cs[j+1] = tmp;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<cs.length;i++){
				sb.append(cs[i]);
			}
			System.out.println(sb.toString());
			//string.replaceAll(regex, replacement)
			
			
			
		}
		
		
	}
}
