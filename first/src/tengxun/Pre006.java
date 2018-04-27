package tengxun;

public class Pre006 {
	
	public static void main(String[] args){
		int i=1;
		int j=1;
		int res = j|(i<<7);
		int k=1<<6;
		System.out.println((res&k)!=0);
	}
}
