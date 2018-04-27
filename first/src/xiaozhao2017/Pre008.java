package xiaozhao2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Pre008 {

	/*
	 * 牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，其中有一些位置
	 * （不超过 10 个）看不清了，但是牛牛记得这个数列顺序对的数量是 k，顺序对是指满足 i < j 且 A[i] < A[j]
	 *  的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。
	 *  
	 *  
	 * 输入描述：
	 * 每个输入包含一个测试用例。每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 
	 * 0 <= k <= 1000000000），接下来的 1 行，包含 n 个数字表示排列 A，其中等于0的项表示看不清的位置
	 * （不超过 10 
	 * 
	 * 输出描述：
	 * 输出一行表示合法的排列数目。
	 * */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int k = in.nextInt();
			int[] arr = new int[n];
			boolean[] flag = new boolean[n + 1];

			// 标记哪些数据已经存在
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
				if (arr[i] != 0) {
					flag[arr[i]] = true;
				}
			}

			// 统计排列中不存在的数字
			List<Integer> list = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				if (!flag[i]) {
					list.add(i);
				}
			}

			// 求出模糊数字的全排列
			List<ArrayList<Integer>> perm = new ArrayList<ArrayList<Integer>>();
			calperm(perm, list, 0, list.size());

			// 求出清晰数字的顺序对
			int val = 0;
			for (int i = 0; i < n - 1; i++) {
				if (arr[i] != 0) {
					for (int j = i + 1; j < n; j++) {
						if (flag[arr[i]] && arr[i] < arr[j]) {
							val++;
						}
					}
				}
			}

			// 计算每个模糊数字的顺序对，如果等于k，result++；
			int result = 0;
			for (ArrayList<Integer> tmp : perm) {
				int sum = val;
				int[] tmpa = Arrays.copyOf(arr, n);
				sum += calculate(tmp, arr);
				if (sum == k) {
					result++;
				}
			}
			System.out.println(result);
		}

	}

	// 计算全排序
	public static void calperm(List<ArrayList<Integer>> perm, List<Integer> list, int m, int n) {
		if (m == n) {
			perm.add(new ArrayList<Integer>(list));
		} else {
			for (int i = m; i < n; i++) {
				Collections.swap(list, i, m);
				calperm(perm, list, m + 1, n);
				Collections.swap(list, i, m);
			}
		}
	}

	// 计算排列的顺序对
	public static int calculate(List<Integer> list, int[] arr) {
		int val = 0;
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = list.get(j++);
				for (int k = 0; k < i; k++) {
					if (arr[k] < arr[i]) {
						val++;
					}
				}
				for (int k = i + 1; k < arr.length; k++) {
					if (arr[i] < arr[k]) {
						val++;
					}
				}
			}
		}
		return val;
	}

}
