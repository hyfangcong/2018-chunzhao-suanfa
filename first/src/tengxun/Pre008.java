package tengxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Pre008 {
	
	
	/*
	 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，
	 * 请编写一个函数，使用递归的方法生成N位的格雷码。给定一个整数n，请返回n位的格雷码，顺序为从0开始。
	 * 测试样例：
	 * 
	 * 1
	 * 返回：["0","1"]
	 * 
	 * 
	 * 根据递归来求出格雷码
	 * 求N位的格雷码只需要在N-1的格雷码前面加上一个0或者1
	 * 
	 * 有格雷码的性质我们可以知道在加0是顺着加的时候，
	 * 加1的时候就要反向，这样就很容易就可以根据地推就出格雷码
	 * */
	
	public String[] getGray(int n) {
        // write code here
		int len = 1<<n;
		String[] gray = new String[len];
		
		if(n==1){
			gray[0] = "0";
			gray[1] = "1";
			return gray;
		}
		String[] last_gray = getGray(n-1);
		int j=0,i=0;
		for(i=0;i<last_gray.length;i++){
			gray[i] = "0"+last_gray[j++];
		}
		for(;i<2*last_gray.length;i++){
			gray[i] = "1" + last_gray[--j];
		}
		return gray;
		
    }
}
