package wangyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 一个合法的括号匹配序列被定义为:
 * 1. 空串""是合法的括号序列
 * 2. 如果"X"和"Y"是合法的序列,那么"XY"也是一个合法的括号序列
 * 3. 如果"X"是一个合法的序列,那么"(X)"也是一个合法的括号序列
 * 4. 每个合法的括号序列都可以由上面的规则生成
 * 例如"", "()", "()()()", "(()())", "(((()))"都是合法的。
 * 从一个字符串S中移除零个或者多个字符得到的序列称为S的子序列。
 * 例如"abcde"的子序列有"abe","","abcde"等。
 * 定义LCS(S,T)为字符串S和字符串T最长公共子序列的长度,即一个最长的序列W既是S的子序列也是T的子序列的长度。
 * 小易给出一个合法的括号匹配序列s,小易希望你能找出具有以下特征的括号序列t:
 * 1、t跟s不同,但是长度相同
 * 2、t也是一个合法的括号匹配序列
 * 3、LCS(s, t)是满足上述两个条件的t中最大的
 * 因为这样的t可能存在多个,小易需要你计算出满足条件的t有多少个。
 * 如样例所示: s = "(())()",跟字符串s长度相同的合法括号匹配序列有:
 * "()(())", "((()))", "()()()", "(()())",其中LCS( "(())()", "()(())" )为4,其他三个都为5,所以输出3.
 * 
 * 
 * 分析：
 * 根据题意，当且仅当修改距离为 1 时 LCS 最大。
 * 很容易证明对于两种基本序列 (()) 和 ()() 都有距离为 1 的合法修改。
 * 原本想的是对每个左括号，跟每个右括号替换，判断合法后累计。
 * 后来发现会漏掉一些情况，那就暴力得干脆一点，把每个符号插入到任意位置，
 * 判合法，去重，累计。
 * */


public class Pre008 {
	
	
	private static Set<String> set = new HashSet<String>();
	
	public static void f1(String s){
		for(int i=0;i<s.length();i++){
			StringBuilder sb = new StringBuilder(s);
			char c = sb.charAt(i);
			sb.deleteCharAt(i);
			for(int j=0;j<s.length()-1;j++){
				sb.insert(j, c);
				if(isLegal(sb.toString())){
					set.add(sb.toString());
				}
				 sb.deleteCharAt(j);
			}
		}
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
		String string = in.next();
		f1(string);
		System.out.println(set.size()-1);    //减1是为了去掉和和原字符串相同的那个字符串
		in.close();
	}
}
