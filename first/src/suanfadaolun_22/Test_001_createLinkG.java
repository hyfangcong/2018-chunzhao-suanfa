package suanfadaolun_22;


public class Test_001_createLinkG {
	
	/*图的顶点节点，*/
	class VNode {
		private String name;			//顶点的名字
		private boolean isVisit;		//顶点是否被访问过
		ENode firstEdge;				//指向顶点的第一个邻接点
		
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
	
	/*图的邻接表对应的链表中的结点*/
	class ENode{
		private int vIndex;      	//指向顶点的位置
		private int wight;			//权重
		ENode nextEdge;				//指向邻接表中的下一个结点
		
		public ENode(){
			this.nextEdge = null;
	
		}
		
		public int getvIndex() {
			return vIndex;
		}
		
		public int getWight() {
			return wight;
		}
		
		
	}
	
	private VNode[] mVexs;             //图的顶点数组
	
	public VNode[] getmVexs() {
		return mVexs;
	}


	/*初始化
	 * vexs为顶点数组
	 * edges边数组*/
	public Test_001_createLinkG(String[] vexs,String[][] edges,boolean isDection,boolean isWight){
		//初始化顶点数边数
		int vlen = vexs.length;
		int elen = edges.length;
		
		//初始化顶点
		mVexs = new VNode[vlen];
		for(int i=0;i<vlen;i++){
			mVexs[i] = new VNode();
			mVexs[i].name = vexs[i];
			mVexs[i].setVisit(false);
			mVexs[i].firstEdge = null;
		}
		
		//初始化边
		for(int i=0;i<elen;i++){
			//读取起始点和结束点
			String startV = edges[i][0];
			String endV = edges[i][1];
			int wight=0;						//权重默认为0
			
			//如果是有权图就加上权重，如果是无权图就忽略权重
			if(edges[i].length>2){
				wight = Integer.parseInt(edges[i][2]);
			}
			
			//获取起始点和结束点的位置
			int startPos = getPosition(startV, mVexs);
			int endPos = getPosition(endV, mVexs);
			if(!isDection){
				ENode eNode1 = new ENode();
				ENode eNode2 = new ENode();
				
				//如果有权重就加上权重，如果没有就忽略
				if(isWight){
					eNode1.wight = wight;
					eNode2.wight = wight;
				}
				eNode1.vIndex = endPos;
				eNode2.vIndex = startPos;
				insertEdge(startPos, eNode1);
				insertEdge(endPos, eNode2);
			}else{
				ENode eNode = new ENode();
				//如果有权重就加上权重，如果没有就忽略
				if(isWight){
					eNode.wight = wight;
				}
				eNode.wight = wight;
				eNode.vIndex = endPos;
				insertEdge(startPos, eNode);
			}
			
		}
	}
	
	//获取顶点在数组中的位置
	private static int getPosition(String vexName,VNode[] mVexs){
		for(int i=0;i<mVexs.length;i++){
			if(mVexs[i].getName().equals(vexName)){
				return i;
			}
		}
		return -1;
	}
	
	//向邻接表中插入边
	private  void insertEdge(int index,ENode eNode){
		if(mVexs[index].firstEdge==null){
			mVexs[index].firstEdge=eNode;
		}else{
			ENode p = mVexs[index].firstEdge;
			while(p.nextEdge!=null){
				p = p.nextEdge;
			}
			p.nextEdge = eNode;
		}
	}
	
	
	
	public static void main(String[] args){
		String[] vexs = new String[]{"a","b","c","d","e"};
		String[][] edges = new String[][]{{"a","b","3"},{"a","c"},{"b","d"},{"b","e"},{"c","d"},{"d","e"}};
		Test_001_createLinkG g = new Test_001_createLinkG(vexs, edges, false,false);
		
		
	}
}
