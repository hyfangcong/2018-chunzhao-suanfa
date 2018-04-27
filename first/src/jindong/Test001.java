package jindong;
import java.util.Scanner;

public class Test001 {
	
	public static void f2(String s){
		char[] ss = s.toCharArray();
		for(int i=0;i<s.length()-1;i++){
			char c = ss[i];
			for(int j=i+1;j<s.length();j++){
                StringBuilder sb = new StringBuilder();
				char tmp = ss[j];
				ss[i] = ss[j];
				ss[j] = c;
				sb.append(ss);
				if(isLegal(sb.toString())){
					System.out.println("Yes");
					return;
				}
				ss[i] = c;
				ss[j] = tmp;
			}
		}
		System.out.println("No");
	}
	
	public static boolean isLegal(String s){
		int count = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				count++;
			}
			if(s.charAt(i)==')'){
				count--;
			}
			
			if(count<0){
				return false;
			}
		}
		if(count==0){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		for(int i=0;i<n;i++){
			String s = in.nextLine();
			f2(s);
		}
		
	}
}
