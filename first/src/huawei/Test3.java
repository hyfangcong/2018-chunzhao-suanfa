package huawei;

import java.util.Scanner;

public class Test3 {
	
	//输入字符串的处理
	public static int[] f(){
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String s = in.nextLine();
		String[] ss = s.split(",| ");
		String tmps;
		
		int[] a = new int[n];
		for(int i=0,j=0;i<ss.length;i++){
			tmps="";
			if(!ss[i].equals("")){		//这里连续的两个分隔符会出现“”字符串
				char[] cs = ss[i].toCharArray();
				if(cs[0]=='-'){			//处理遇到负数的时候
					for(int k=1;k<cs.length;k++){
						tmps+=cs[k]-'0'; 
					}
					a[j++] = Integer.parseInt(tmps)*-1;
				}else{
					a[j++] = Integer.parseInt(ss[i]);
				}
			}
		}
		in.close();
		return a;
	}
	
	public static void findMax(int []a){
		int max = -1;
		int tmp = 0;
		for(int i=0;i<a.length;i++){
			tmp+=a[i];
			if(tmp>0){
				if(tmp>max){
					max = tmp;
				}
			}else{
				tmp = 0;
			}
		}
		System.out.println(max);
	}
	
	public static void main(String[] args){
		int[] a;
		a = f();
		findMax(a);
		
	}
}
