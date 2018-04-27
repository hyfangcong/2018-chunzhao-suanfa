package suanfadaolun_22;

import java.util.Stack;

import suanfadaolun_22.Test_001_createLinkG.ENode;
import suanfadaolun_22.Test_001_createLinkG.VNode;

public class Test_004_DFS {
	
	public void DFStoLink(Test_001_createLinkG g1,int index){
		Stack<VNode> stack = new Stack<VNode>();
		VNode u;
		ENode w;
		//访问源节点，并将源节点入栈，然后标记已被访问
		u = g1.getmVexs()[index];
		System.out.print(u.getName()+" ");
		stack.push(u);
		u.setVisit(true);
		
		while(!stack.isEmpty()){
			boolean isPop = true;
			u = stack.peek();
			w = u.firstEdge;
			
			while(w!=null){
				VNode tmp = g1.getmVexs()[w.getvIndex()];
				if(!tmp.isVisit()){
					System.out.print(tmp.getName()+" ");
					stack.add(tmp);
					tmp.setVisit(true);
					isPop = false;
					break;
				}
				w = w.nextEdge;
			}
			
			if(isPop){
				stack.pop();
			}
			
		}
	}
	
	public static void main(String[] args){
		String[] vexs = new String[]{"a","b","c","d","e"};
		String[][] edges = new String[][]{{"a","b","3"},{"a","c"},{"b","d"},{"b","e"},{"c","d"},{"d","e"}};
		
		//第一个true是判断是否为有向图、第二个true是判断是否是有权重
		Test_001_createLinkG g1 = new Test_001_createLinkG(vexs, edges, false,true);
		
		Test_004_DFS dfs = new Test_004_DFS();
		dfs.DFStoLink(g1, 1);
	}
}
