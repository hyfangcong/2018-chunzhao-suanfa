package aiqiyi;
import java.util.*;
  
public class Pre007{
	
	
	/*
	 * 有一种有趣的字符串价值计算方式:统计字符串中每种字符出现的次数,然后求所有字符次数的平方和作为字符串的
	 * 价值
例如: 字符串"abacaba",里面包括4个'a',2个'b',1个'c',于是这个字符串的价值为4 * 4 + 2 * 2 + 1 * 1 = 21
牛牛有一个字符串s,并且允许你从s中移除最多k个字符,你的目标是让得到的字符串的价值最小。
	 * */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        int count[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        while (k>0) {
            int max = getMax(count);
            count[max]--;
            k--;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i]*count[i];
        }
        System.out.println(sum);
    }
    private static int getMax(int[] count) {
        int max_index = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > count[max_index]) {
                max_index = i;
            }
        }
    return max_index;
    }
}