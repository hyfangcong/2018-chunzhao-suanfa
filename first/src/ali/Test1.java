package ali;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class Test1 {
	 static double calculate(int a, double i, int n) {
		 double tmp=1;
		 double sum=0;
		 double res=0;
		 		for(int j=0;j<n;j++){
		 			tmp*=(1+i/100);
		 		}
		 		 
		 sum = a*tmp;
		 BigDecimal bigDecimal = new BigDecimal(sum/(12*n));
		 res = bigDecimal.setScale(2, BigDecimal.ROUND_CEILING).doubleValue();
		
		return res;

	    }
	 
	 public static void main(String[] args){
		 double a = 1.25467;
		//BigDecimal bigDecimal = new BigDecimal(sum/(12*n));
	//	double f1 = bigDecimal.setScale(2, BigDecimal.ROUND_CEILING).doubleValue();
		// System.out.println(f1);
		 String.valueOf(a);
		 System.out.println("hhah");
		 Map<Integer, Integer> map = new TreeMap<Integer,Integer>();
		 map.keySet();
	 }

}
