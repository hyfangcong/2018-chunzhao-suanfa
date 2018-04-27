package second;

import java.util.Scanner;

public class Test002 {
	
	/*在控制台读取数据的时候，不要读int型的数据
	 * 直接一行一行的读，然后在进行字符串的处理
	 * 
	 * 
	 * */
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		String string = scanner.nextLine();
		String[] ss = string.split(" ");
		
		int len1 = Integer.parseInt(ss[0]);
		int len2 = Integer.parseInt(ss[1]);
		
		int[] a = new int[len1];
		String[] b = new String[len2];
		for(int i=0;i<b.length;i++){
			b[i] = scanner.nextLine();
		}
		
		for(int i=0;i<a.length;i++){
			a[i] = scanner.nextInt();
		}
		
		for(int j=0;j<b.length;j++){
			System.out.print(b[j]+":");
		}
		System.out.println();
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+":");
		}
	}
}
