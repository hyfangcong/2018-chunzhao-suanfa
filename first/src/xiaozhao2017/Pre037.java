package xiaozhao2017;

import java.util.Arrays;
import java.util.Scanner;

public class Pre037 {
	
	/*
	 * 输入n个整数，输出出现次数大于等于数组长度一半的数。
	 * */
	
	/*
	 * 每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
	 * */
	
	/*
	 * 输出出现次数大于等于n/2的数。
	 * */
	
//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		String string = in.nextLine();
//		String[] ss = string.split(" ");
//		Arrays.sort(ss);
//		System.out.println(ss[(ss.length-1)/2]);
//	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }
            int num = arr[0];
            int count = 0;
            
            /*
             * 此处的时间复杂度为n
             * 
             * 这里要满足的条件为：
             * 数组中存在>=n/2的数字
             * 
             * 当不确定数组中是否满足有>=n/2的数字的时候，
             * 这个算法不成立
             * 
             * 
             * */
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == num) {
                    count++;
                } else if (count > 0) {
                    count--;
                } else {
                    num = arr[j];
                }
            }
            System.out.println(num);
            System.out.println(count);
        }
    }
}
