package jindong;

public class Pre006 {
	
	public static void main(String[] args){
		
	}
	
	public static int calcDistance(int A, int B, int C, int D) {
        // write code here
		int count=A+B+C+D;
		int a=A/2;
		int b=B/2;
		int c=C/2;
		int d =D/2;
		while(a!=0){
			count=count+a*2;
			a/=2;
		}
		while(b!=0){
			count=count+b*2;
			b/=2;
		}
		while(c!=0){
			count=count+2*c;
			c/=2;
		}
		while(d!=0){
			count=count+2*d;
			d/=2;
		}
		return count;
    }
}
