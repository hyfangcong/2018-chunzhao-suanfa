package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test4 {
	
	public static void f1(){
		Scanner in = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		while (in.hasNext()) {
			String s = in.nextLine();

			String[] str = s.split(" ");
			int[] a = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				a[i] = Integer.parseInt(str[i]);
			}
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	
	public static void f2(){
		Scanner in = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		int i=20;
		while(i>=0){
			list.add(in.next());
			i--;
		}
		
		for(int j=0;i<list.size();i++){
			System.out.println(list.get(j));
		}
	}
	
	public static void f3(){
		Scanner in = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		while(in.hasNext()){
			String s = in.next();
			
			if(s.equals("#")){
				break;
			}
			list.add(s);
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		System.out.println(list.size());
	}
	
	public static void f4(){
		Scanner in = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		while(!in.hasNext("quit")){
			list.add(in.next());
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		System.out.println(list.size());
	}
	
	public static void f5(){
		String string = "a\nb";
		System.out.println(string);
		System.out.println(string.length());
		char[] cs = string.toCharArray();
		for(int i=0;i<cs.length;i++){
			System.err.println(cs[i]);
		}
		System.out.println(cs.length);
		System.out.println(cs[1]);
		System.out.println("hh");
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//byte b = in.nextByte();
		byte c = 127;
		System.out.println(c);
	}
}
