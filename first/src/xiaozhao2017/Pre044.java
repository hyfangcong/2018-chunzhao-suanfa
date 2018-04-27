package xiaozhao2017;

import java.util.Scanner;

public class Pre044 {
	
	/*
	 * 小B乘火车和朋友们一起在N市到M市之间旅行。她在路途中时睡时醒。当她醒来观看窗外的风景时，注意到每个
	 * 火车站都有一种特别颜色的旗帜，但是她看到的旗帜仅仅是经过的一小部分。小B在乘车过程中有两次清醒的时间
	 * ，她到达旅程终点时处于睡梦中。出站时，她和朋友们谈论着一路的见闻，朋友们觉得很有意思，他们把N到和M
	 * 之间经过车站的旗帜颜色依次列出来，然后告诉你小B记得的旗帜颜色序列，让你判断小B究竟是从N和M之间哪些
	 * 方向才能看到所说颜色的旗帜，还是根本就不可能看到？颜色用字母代表，相同的字母代表相同的颜色，不同的
	 * 字母则表示不同的颜色。
	 * 
	 * */
	
	/*
	 * 输入中有多组测试数据，每组测试数据包含三行，第一行为一个由小写拉丁字母构成的非空字符串，长度不超过
	 * 10^5，表示N到M之间车站的颜色。火车从M向N运行时，经过的车站相同，只是方向相反。第二行为小B在第一次
	 * 睡醒时看到的颜色序列，第三行为小B在第二次睡醒时看到的颜色序列。两个序列都是小写的拉丁字母构成的
	 * 字符串，长度不超过100个字母。每个序列的颜色顺序排列按小B看到的时间顺序排列。
	 * */
	
	/*
	 * 对每组测试数据，在单独的行中输出小B的旅行方向。
  
forward - 由N到M方向； 

backward -由M到N方向  

both - 两种方向都有可能；  

invalid - 不可能看到这样的颜色序列；
	 * 
	 * */
	
	
	
	/**
	 * 这是判断t是否是s的子序列
	 * */
	public static boolean isOk(String s,String t){
		for(int i=0;i<s.length();i++){
			int k = 0;
			for(int j=i;j<s.length();j++){
				if(k==t.length()-1){
					return true;
				}
				if(s.charAt(j)==t.charAt(k)){
					k++;
				}
			}
		}
		return false;
	}
	
	/*
	 *题目中是，只醒来2次，所以两次看到的车站都是连续的，因此我们要求小b看到的这两个字符串是否为
	 *车站的子串即可。
	 *因此可以用正则表达式
	 * */
	
	public static boolean regExp(String s,String t1,String t2){
		if(s.matches(".*"+t1+".*"+t2+".*")){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String s = in.next();
			String t1 = in.next();
			String t2 = in.next();
			String t = t1+t2;
			StringBuilder sb = new StringBuilder(s);
			boolean flag1 = isOk(s, t);
			boolean flag2 = isOk(sb.reverse().toString(), t);
			if(flag1 && flag2){
				System.out.println("both");
			}else if(flag1){
				System.out.println("forward");
			}else if(flag2){
				System.out.println("backward");
			}else{
				System.out.println("invalid");
			}
		}
	}
}
