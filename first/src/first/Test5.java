package first;

public class Test5 {
	
	public static boolean palindrome(String s){
		char[] cs = s.toCharArray();
		int left = 0;
		int right = cs.length-1;
		while(left<right){
			if(cs[left] == cs[right]){
				left++;
				right--;
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		String string = ")abcecba)";
		System.out.println(palindrome(string));
	}
}
