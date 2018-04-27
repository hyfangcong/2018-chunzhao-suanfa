package first;

public class Test3 {
	public static void main(String[] args){
		String s = "123456";
		int num = Integer.valueOf(s);
		int num2 = Integer.parseInt(s);
		int tt = 1111;
		String ssssss=tt+"";
		System.out.println(ssssss);
		System.out.println(num+num2);
		char[] ss = s.toCharArray();
		
		int[] a = new int[ss.length];
		for(int j=0;j<ss.length;j++){
			a[j] = ss[j] - '0';
		}
		System.out.println("");
		
		for(int i=0;i<ss.length;i++){
			System.out.println(ss[i]);
		}
	}
}
