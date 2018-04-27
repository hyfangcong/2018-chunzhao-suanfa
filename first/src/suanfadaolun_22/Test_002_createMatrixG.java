package suanfadaolun_22;

import suanfadaolun_22.Test_001_createLinkG.ENode;

public class Test_002_createMatrixG {
	
	/*图的顶点节点，*/
	class VNode {
		private String name;			//顶点的名字
		private boolean isVisit;		//顶点是否被访问过
		ENode firstEdge;				//指向顶点的第一个邻接点
		
		public VNode(){
			this.isVisit = false;
			this.firstEdge = null;
		}
		
		public String getName() {
			return name;
		}
		
		public boolean isVisit() {
			return isVisit;
		}
		public void setVisit(boolean isVisit) {
			this.isVisit = isVisit;
		}
		
	}
	
	private VNode[] mVertex;			//存放顶点信息的数组
	private int[][] matrixG;			//存放顶点之间边的关系  默认：0代表无边相连，1代表有边相连，大于等于1的为权重
	private int edgeNum;				//图中边的数目
	private int vertexNum;				//图中顶点的数目
	private boolean isDection;			//是否是有有向图
	
	
	
	public VNode[] getmVertex() {
		return mVertex;
	}
	public int[][] getMatrixG() {
		return matrixG;
	}
	public int getEdgeNum() {
		return edgeNum;
	}
	public int getVertexNum() {
		return vertexNum;
	}
	
	public Test_002_createMatrixG(String[] vexs,int[][] edges,boolean isDection){
		/*初始化
		 * vertexNum为顶点的数目*/
		this.vertexNum = vexs.length;
		this.isDection = isDection;
		
		
		//初始化顶点数组
		mVertex = new VNode[vertexNum];
		for(int i=0;i<vertexNum;i++){
			mVertex[i] = new VNode();
			mVertex[i].name = vexs[i];
		}
		
		//初始化矩阵
		matrixG = new int[edges.length][edges.length];
		
		for(int i=0;i<matrixG.length;i++){
			for(int j=0;j<matrixG.length;j++){
				matrixG[i][j] = edges[i][j];
			}
		}
		
		//初始化图的边的数目
		this.edgeNum = edgeNum(matrixG);
	}
	
	//计算出图中的边的数量
	private int edgeNum(int[][] matrixG){
		int count = 0;
		if(!isDection){
			for(int i=0;i<matrixG.length;i++){
				for(int j=0;j<matrixG[0].length;j++){
					if(matrixG[i][j] > 0){
						count++;
					}
				}
			}
			return count/2;
		}else{
			for(int i=0;i<matrixG.length;i++){
				for(int j=0;j<matrixG[0].length;j++){
					if(matrixG[i][j] > 0){
						count++;
					}
				}
			}
			return count;
		}
	}

	//找出顶点在数组中的位置
	public int getPos(VNode[] mVexs,String name){
		for(int i=0;i<mVexs.length;i++){
			if(mVexs[i].getName().equals(name)){
				return i;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args){
		String[] vexs = new String[]{"a","b","c"};
		int[][] edges = new int[][] {{0,1,1},{1,0,1},{1,1,0}};
		
		Test_002_createMatrixG g = new Test_002_createMatrixG(vexs, edges, false);
		
		System.out.println(g.edgeNum);
	}
}
