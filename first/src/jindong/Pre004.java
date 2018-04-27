package jindong;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Pre004 {

	public static void main(String[] args){
		Set<Integer> set = new TreeSet<Integer>();
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int[] a = new int[n1];
		int[] b= new int[n2];
		
		for(int i=0;i<n1;i++){
			a[i] = in.nextInt();
			set.add(a[i]);
		}
		for(int i=0;i<n2;i++){
			b[i] = in.nextInt();
			set.add(b[i]);
		}
		
		Iterator<Integer> iterator = set.iterator();
		while(set.size()>1){
			System.out.print(iterator.next()+" ");
			iterator.remove();
		}
		System.out.print(iterator.next());
		
	}
}
