package xiaozhao2017;

import java.util.Scanner;

public class Pre047 {
	
	/*
	 * 时间复杂度太大，超时不通过。
	 * 对于20%的数据, 1 <= m <= n <= 5 ; 
	 * 对于80%的数据, 1 <= m <= n <= 10^7 ; 
	 * 对于100%的数据, 1 <= m <= n <= 10^18.
	 * */

//	private static class TrieTree {
//		TrieTree[] next = new TrieTree[10];
//		boolean isEnd = false;
//		long val; // 用于存放从根到该末节点的数字的值
//	}
//
//	public static TrieTree buildTree(long n) {
//		TrieTree trieTree = new TrieTree();
//		for (long i = 1; i <= n; i++) {
//			TrieTree current = trieTree;
//			String s = i + "";
//			for (int j = 0; j < s.length(); j++) {
//				int digit = s.charAt(j) - '0';
//				if (current.next[digit] == null) {
//					current.next[digit] = new TrieTree();
//				}
//				current = current.next[digit];
//			}
//			current.isEnd = true;
//			current.val = i;
//		}
//		return trieTree;
//	}
//
//	static long res = 0;
//	static long count = 0;
//	public static void queryTree(TrieTree trieTree,long m) {
//		TrieTree current = trieTree;
//		if(count==m){
//			res=current.val;
//			return;
//		}
//		
//		if (current != null) {
//			for (TrieTree tree : current.next) {
//				if(tree!=null){
//					if (tree.isEnd == true) {
//							count++;
//							queryTree(tree,m);
//					}
//				}
//			}
//
//		}
//	}
//	
//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		long n = in.nextLong();
//		long m = in.nextLong();
//		TrieTree trieTree = buildTree(n);
//		queryTree(trieTree, m);
//		System.out.println(res);
//	}
	
	/*
	 * 给定整数n和m, 将1到n的这n个整数按字典序排列之后, 求其中的第m个数。对于n=11, m=4, 按字典序排列依次
	 * 为1, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 因此第4个数是2. 对于n=200, m=25, 按字典序排列依次为1 10 100 
	 * 101 102 103 104 105 106 107 108 109 11 110 111 112 113 114 115 116 117 118 119 12 120 121 122 123
	 *  124 125 126 127 128 129 13 130 131 132 133 134 135 136 137 138 139 14 140 141 142 143 144 145 
	 *  146 147 148 149 15 150 151 152 153 154 155 156 157 158 159 16 160 161 162 163 164 165 166 167 
	 *  168 169 17 170 171 172 173 174 175 176 177 178 179 18 180 181 182 183 184 185 186 187 188 189 
	 *  19 190 191 192 193 194 195 196 197 198 199 2 20 200 21 22 23 24 25 26 27 28 29 3 30 31 32 33 34 
	 *  35 36 37 38 39 4 40 41 42 43 44 45 46 47 48 49 5 50 51 52 53 54 55 56 57 58 59 6 60 61 62 63 64 
	 *  65 66 67 68 69 7 70 71 72 73 74 75 76 77 78 79 8 80 81 82 83 84 85 86 87 88 89 9 90 91 92 93 94 
	 *  95 96 97 98 99 因此第25个数是120…
	 * 
	 * */
	
	/*
	 * 输入仅包含两个整数n和m。数据范围: 

对于20%的数据, 1 <= m <= n <= 5 ; 

对于80%的数据, 1 <= m <= n <= 10^7 ; 

对于100%的数据, 1 <= m <= n <= 10^18.
	 * */
	
	/*
	 * 输出仅包括一行, 即所求排列中的第m个数字.
	 * */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long m = in.nextLong();
		long i = 1;
		
		m--;
		while(m!=0){
			long count = 0;
			long start = i;
			long end = i+1;
			while(start<=n){
				count+=Math.min(n+1, end)-start;
				start*=10;
				end*=10;
			}
			if(count>m){
				m--;
				i*=10;
			   }else{
				m-=count;
				i++;
			}
		}
		System.out.println(i);
	}
}
