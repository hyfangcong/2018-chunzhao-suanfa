package first;

import java.util.Scanner;

public class Test8 {
	
	//从控制台输入数据
	public static void scanfTest(){
		Scanner scanner = new Scanner(System.in);
//		while(scanner.hasNext()){
//			System.out.println(scanner.next());
//		}
		
		while(!scanner.hasNext("#")){
			System.out.println(scanner.next());
		}
		
		//System.out.println(a);
		scanner.close();
	
	}
	
	public static void main(String[] args){
		scanfTest();
	}
}
