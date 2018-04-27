package suanfadaolun_22;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import suanfadaolun_22.Test_001_createLinkG.ENode;
import suanfadaolun_22.Test_001_createLinkG.VNode;

public class Test_003_BFS {
	
	public void BFStoLink(Test_001_createLinkG g,int index){
		Queue<VNode> queue = new LinkedList<VNode>();
		VNode u;
		ENode w;
		
		
		//访问初始节点
		VNode node = g.getmVexs()[index];
		System.out.print(node.getName()+" ");
		//设置结点已经被访问了，并且将节点入队
		node.setVisit(true);
		queue.add(node);
		
		while(!queue.isEmpty()){
			u = queue.poll();     //队头元素出队
			w = u.firstEdge;	  //元素u的第一个邻节点
			
			while(w!=null){
				VNode tmp = g.getmVexs()[w.getvIndex()];
				
				if(!tmp.isVisit()){
					System.out.print(tmp.getName()+" ");  //访问该节点
					
					//并将该节点入队，设置为已经访问了
					tmp.setVisit(true);
					queue.add(tmp);
				}
				//寻找下一个邻节点
				w = w.nextEdge;
			}
		}	
	}
	
	public void BFStoMatrix(Test_002_createMatrixG g,int index){
		Queue<suanfadaolun_22.Test_002_createMatrixG.VNode> queue = new LinkedList<suanfadaolun_22.Test_002_createMatrixG.VNode>();
		
		suanfadaolun_22.Test_002_createMatrixG.VNode u,w;
		int len = g.getVertexNum();
		int[][] matrixG = g.getMatrixG();
		//访问源节点，并将它入队，然后标记为已经访问了
		u = g.getmVertex()[index];
		System.out.print(u.getName()+" ");
		u.setVisit(true);
		queue.add(u);
		
		while(!queue.isEmpty()){
			u = queue.poll();
			int now = g.getPos(g.getmVertex(), u.getName());
			
			for(int j=0;j<len;j++){
				if(matrixG[now][j]!=0){
					suanfadaolun_22.Test_002_createMatrixG.VNode tmp = g.getmVertex()[j];
					
					//如果该节点没有被访问，则访问，并且入队，设置为已经访问了
					if(!tmp.isVisit()){
						System.out.print(tmp.getName()+" ");
						queue.add(tmp);
						tmp.setVisit(true);
					}
				}
			}
		}
	}
	
	
	
	public static void main(String[] args){
		String[] vexs = new String[]{"a","b","c","d","e"};
		String[][] edges = new String[][]{{"a","b","3"},{"a","c"},{"b","d"},{"b","e"},{"c","d"},{"d","e"}};
		
		String[] vexs2 = new String[]{"a","b","c","d","e"};
		int[][] edges2 = new int[][] {{0,1,1,0,0},{1,0,0,1,1},{1,0,0,1,0},{0,1,1,0,1},{0,1,0,1,0}};
		
		//第一个true是判断是否为有向图、第二个true是判断是否是有权重
		Test_001_createLinkG g1 = new Test_001_createLinkG(vexs, edges, false,true);
		
		Test_002_createMatrixG g2 = new Test_002_createMatrixG(vexs2, edges2, true);
		
		Test_003_BFS bfs = new Test_003_BFS();
		bfs.BFStoLink(g1, 2);
		System.out.println();
		bfs.BFStoMatrix(g2, 2);
		
	
	}
}
