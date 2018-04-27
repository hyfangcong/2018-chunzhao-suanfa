package xiaozhao2017;

import java.util.Scanner;

public class Pre048 {
	/*
	 * 战争游戏的至关重要环节就要到来了，这次的结果将决定王国的生死存亡，小B负责首都的防卫工作。首都位于
	 * 一个四面环山的盆地中，周围的n个小山构成一个环，作为预警措施，小B计划在每个小山上设置一个观察哨，
	 * 日夜不停的瞭望周围发生的情况。 一旦发生外地入侵事件，山顶上的岗哨将点燃烽烟，若两个岗哨所在的山峰
	 * 之间没有更高的山峰遮挡且两者之间有相连通路，则岗哨可以观察到另一个山峰上的烽烟是否点燃。由于小山
	 * 处于环上，任意两个小山之间存在两个不同的连接通路。满足上述不遮挡的条件下，一座山峰上岗哨点燃的烽烟
	 * 至少可以通过一条通路被另一端观察到。对于任意相邻的岗哨，一端的岗哨一定可以发现一端点燃的烽烟。 
	 * 小B设计的这种保卫方案的一个重要特性是能够观测到对方烽烟的岗哨对的数量，她希望你能够帮她解决这个问题。
	 * */
	
	/*
	 * 输入中有多组测试数据，每一组测试数据的第一行为一个整数n(3<=n<=10^6),为首都周围的小山数量，
	 * 第二行为n个整数，依次表示为小山的高度h（1<=h<=10^9）.
	 * */
	
	/*
	 * 对每组测试数据，在单独的一行中输出能相互观察到的岗哨的对数。
	 * */
	
	/*
	 * 直接暴力双向遍历，通过90%
	 * 
	 * 将满足情况的对数可以分为两类：
	 * 1.所有相邻的元素都满足。有n种
	 * 
	 * 2.两座山峰之间有间隔其他的山峰，则要求中间所有的山峰的高度要比首尾的两个山峰的高度都要小。
	 * 因为山峰处在一个环上，所以双向遍历，即正向从i-j，逆向从j-i.
	 * 正向和逆向中任何一个满足，对数就+1.
	 * 
	 * 注意：整个数组的首尾的山峰之间算了两次，所以最后的对数为count+n-1。
	 * 
	 * */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = in.nextInt();
		}
		
		int count = 0;
		for(int i=0;i<n-2;i++){
			for(int j=i+2;j<n;j++){
				int min = a[i]>a[j]?a[j]:a[i];
				boolean found_1 = true;
				boolean found_2 = true;
				for(int k=i+1;k<j;k++){
					if(a[k]>min){
						found_1 = false;
						break;
					}
				}
				
				int m = i+n;
				for(int k=j+1;k<m;k++){
					if(a[k%n]>min){
						found_2 = false;
						break;
					}
				}
				
				if(found_1 || found_2){
					count++;
				}
			}
		}
		System.out.println(count+n-1);
	}
	
	
	/*
	 * 单调栈法，可以全部ac
	 * 
	 * */

//		//AC代码：
//		#include<stdio.h>
//		#include<vector>
//		using namespace std;
//		struct node{
//		    long val,cnt;
//		    node(long val):val(val),cnt(1){}
//		};
//		int main(){
//		    int N,i,x,Maxi;
//		    //freopen("input.txt","r",stdin);
//		    while(scanf("%d",&N)!=EOF){
//		        vector<long> d(N);
//		        for(i=0;i<N;i++) scanf("%ld",&d[i]);
//		        vector<node> v;
//		        node tmp(d[0]);
//		        long Max=-1;
//		        for(i=1;i<N;i++)
//		            if(d[i]==d[i-1]) tmp.cnt++;
//		            else{
//		                v.push_back(tmp);
//		                if(Max<tmp.val){
//		                    Max=tmp.val;
//		                    Maxi=v.size()-1;
//		                }
//		                tmp.val=d[i];
//		                tmp.cnt=1;
//		            }
//		        v.push_back(tmp);
//		        if(Max<tmp.val){
//		            Max=tmp.val;
//		            Maxi=v.size()-1;
//		        }
//		        int n=0;
//		        long cnt=0;
//		        vector<node> stack;
//		        for(i=Maxi;n!=v.size();n++,i=(i+1)%v.size()){
//		            while(stack.size()&&v[i].val>stack[stack.size()-1].val){
//		                node &m=stack[stack.size()-1];
//		                cnt+=m.cnt+m.cnt*(m.cnt-1)/2;
//		                stack.pop_back();
//		                if(stack.size()) cnt+=m.cnt;
//		            }
//		            if(stack.size()){
//		                if(v[i].val==stack[stack.size()-1].val)
//		                    stack[stack.size()-1].cnt+=v[i].cnt;
//		                else
//		                    stack.push_back(v[i]);
//		            }else
//		                stack.push_back(v[i]);
//		        }
//		        while(stack.size()){
//		            node &m=stack[stack.size()-1];
//		            cnt+=m.cnt*(m.cnt-1)/2;
//		            stack.pop_back();
//		            if(stack.size()) cnt+=2*m.cnt;
//		            if(stack.size()==1&&stack[stack.size()-1].cnt==1) cnt-=m.cnt;
//		        }
//		        printf("%ld\n",cnt);
//		    }
//		}
	
}
