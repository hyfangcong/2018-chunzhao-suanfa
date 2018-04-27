package first;
/*如果我们从左至右遍历列表，每个下标水的量最多是到现在为止最大的数。这表示如果我们已知右边有相等或更大的，
 * 我们可以知道存下的水有多少。 反向遍历的时候也一样：如果我们知道左边有比右边最大的数更大的，
 * 我们装水是毫无问题的。
 * 
 * 
 * 基于这个想法，一个解决方法是：先找到最大值，从左遍历到最大值，然后从右遍历到最大值。这个方法需要两次遍历：
 * 一次找到最大值，另一次分成了两个子遍历。
 * 
 * 
 * 一次遍历的方法通过两端的指针相向移动避免了寻找最大值。如果（左指针找到的左指针以左的最大值）小于（右指针找到右指针以右的最大值），
 * 将左指针向右移动一位。否则右指针向左移动一位。重复过程直到两个指针相遇。*/


public class Test4 {
	public static void main(String[] args) {
        int [] testcase_1 = {2,5,1,2,3,4,7,7,6};
        int [] testcase_2 = {2,5,1,3,1,2,1,7,7,6};
        int [] testcase_3 = {6,1,4,6,7,5,1,6,4};
      

        System.out.println("Case testcase_1, total volume :" + calculate(testcase_1));
        System.out.println("Case testcase_2, total volume :" + calculate(testcase_2));
        System.out.println("Case testcase_3, total volume :" + calculate(testcase_3));
        
        System.out.println("Case testcase_1, total volume :" + volunm(testcase_1));
        System.out.println("Case testcase_2, total volume :" + volunm(testcase_2));
        System.out.println("Case testcase_3, total volume :" + volunm(testcase_3));
    }

    private static int calculate(int [] testcase){
        int p_l = 0;
        int p_r = testcase.length - 1;
        int max_l = testcase[p_l];
        int max_r = testcase[p_r];

        int volume = 0;
        while (p_r > p_l) {
            if (max_l < max_r){
                p_l++;
                if (testcase[p_l] >= max_l){
                    max_l = testcase[p_l];
                }else{
                    volume += max_l - testcase[p_l];
                }
            }else{
                p_r--;
                if (testcase[p_r] >= max_r){
                    max_r = testcase[p_r];
                }else{
                    volume += max_r - testcase[p_r];
                }
            }
        }

        return volume;
    }
    
    public static int volunm(int[] testcase){
    	int left = 0;
    	int right = testcase.length-1;
    	int maxLeft = testcase[left];
    	int maxRight = testcase[right];
    	int volunm = 0;
    	
    	while(left<right){
    		if(maxLeft<maxRight){
    			++left;
    			if(testcase[left]>=maxLeft){
    				maxLeft = testcase[left];
    			}else{
    				volunm+=maxLeft - testcase[left];
    			}
    		}else{
    			--right;
    			if(testcase[right]>=maxRight){
    				maxRight = testcase[right];
    			}else{
    				volunm+=maxRight - testcase[right];
    			}
    		}
    	}
    	return volunm;
    }
}
