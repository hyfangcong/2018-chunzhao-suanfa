package second;


import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Test001 {
	
	//给出一个段落s1，然后给出一个段落s2，要求找出在s1的句子中匹配s2句子中单词个数最多的句子，并且将他们输出。
	/*1.重复的单词只计算一次，且不区分大小写
	 *2.输入数据将保证结果存在且唯一
	 *3.单词之间由空格()分隔，并且不会出现连续的空格。
	 * */
	public static void paragraph(String[] s1,String[] s2){
		int max=0,index=-1,tmp=-1;
		
		for(int i=0;i<s2.length;i++){
			max = 0;
			index = -1;
			tmp = -1;
			String subS = s2[i];
			for(int j=0;j<s1.length;j++){
				String parS = s1[j];
				tmp = calulate(parS, subS);
				if(tmp>max){
					max = tmp;
					index = j;
				}
			}
			System.out.println(s1[index]);
		}
	}
	
	//比较两个字符串中相同的单词的个数，不区分大小写，不重复计算
	public static int calulate(String parS,String subS){
		int count = 0;
		String[] ps = parS.split(" |\\(|\\)");
		String[] ss = subS.split(" |\\(|\\)");
		
		Set<String> pSet = new LinkedHashSet<String>();
		Set<String> sSet = new LinkedHashSet<String>();
		
		for(int i=0;i<ps.length;i++){
			pSet.add(ps[i]);
		}
		for(int j=0;j<ss.length;j++){
			sSet.add(ss[j]);
		}
		
		Iterator<String> itPs = pSet.iterator();
		while(itPs.hasNext()){
			String s = itPs.next();
			Iterator<String> itSs = sSet.iterator();
			while(itSs.hasNext()){
				if(itSs.next().equalsIgnoreCase(s)){
					count++;
					break;
				}
			}
		}
		return count;
	}
	
	//处理从控制台输入的数据
	public static void splitData(){
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		String[] ss = string.split(" ");
		
		int len1 = Integer.parseInt(ss[0]);
		int len2 = Integer.parseInt(ss[1]);
		
		String[] parS = new String[len1];
		String[] subS = new String[len2];
		
		for(int i=0;i<len1;i++){
			parS[i] = sc.nextLine();
		}
		for(int j=0;j<len2;j++){
			subS[j] = sc.nextLine();
		}
		
		sc.close();
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		String[] ss = string.split(" ");
		
		int len1 = Integer.parseInt(ss[0]);
		int len2 = Integer.parseInt(ss[1]);
		
		String[] parS = new String[len1];
		String[] subS = new String[len2];
		
		for(int i=0;i<len1;i++){
			parS[i] = sc.nextLine();
		}
		for(int j=0;j<len2;j++){
			subS[j] = sc.nextLine();
		}
		
		sc.close();
		
		paragraph(parS, subS);
	}
}
