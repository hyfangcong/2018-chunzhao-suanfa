package first;

import java.util.LinkedList;
import java.util.List;

public class Test2 {
	static class Node{
		int value;
		Node next;
		public Node(int value) {
			this.value=value;
			this.next=null;
		}
		
		public Node(){
			this.next=null;
		}
	}
	
	public static boolean insert(Node head,int value,int index){
		Node pNode = head.next;
		while(index>0&&pNode!=null){
			pNode = pNode.next;
			index--;
		}
		if(pNode!=null){
			Node node = new Node(value);
			node.next = pNode.next;
			pNode.next = node;
			return true;
		}else{
			return false;
		}
	}
	
	//有头结点的头插法建立链表
	public static Node createHaveHead(int[] a){
		Node head = new Node();
		for(int i=0;i<a.length;i++){
			Node node = new Node(a[i]);
			node.next = head.next;
			head.next = node;
		}
		return head;
	}
	
	//有头结点的尾插法建立链表
	public static Node createTail(int[] a){
		Node head = new Node();
		Node curNode = head;;
		for(int i=0;i<a.length;i++){
			Node node = new Node(a[i]);
			curNode.next = node;
			curNode = node;
		}
		return head;
	}
	
	//没有头结点的头插法创建链表
	public static Node createNoHead(int[] a){
		Node head = null;
		Node pNode = head;
		for(int i=0;i<a.length;i++){
			Node node = new Node(a[i]);
			if(pNode==null){
				head = node;
				pNode = head;
			}else{
				node.next = pNode;
				pNode = node;
			
			}
		}
		return pNode;
	}
	
	//没有头结点的尾插法创建链表
	public static Node createNoHeadTail(int[] a){
		Node newHead = null;
		Node tmp=null;
		for(int i=0;i<a.length;i++){
			Node node = new Node(a[i]);
			if(i==0){
				newHead = node;
				tmp = newHead;
			} else{
				tmp.next = node;
				tmp = node;
			}
		}
		return newHead;
	}
	
	//带头结点的链表的反转
	public static Node reverseHaveHead(Node head){
		Node tmp;
		if(head.next==null){
			return head;
		}
		if(head.next.next==null){
			return head;
		}
		Node curNode = head.next.next;
		head.next.next = null;
		while(curNode!=null){
			tmp = curNode;
			curNode = curNode.next;
			tmp.next = head.next;
			head.next = tmp;
		}
		return head;
	}
	
	//不带头结点的反转
	public static Node reverseNoHead(Node head){
		Node newHead = null;
		Node curNode = head;
		Node tmp;
		while(curNode!=null){
			tmp = curNode;
			curNode = curNode.next;
			tmp.next = newHead;
			newHead = tmp;
		}
		return newHead;
	}
	
	//不带头结点的部分反转链表
	public static Node partReverseNoHead(Node head,int k){
		if(k<=1 || head==null){
			return head;
		}
		
		
		Node newHead = null;
		Node curNode = head;
		Node sectionHead = null;
		Node sectionTail = null;
		Node preTail = null;
		Node tmp = null;
		int sectionNum = 0;
		while(curNode!=null){
			
			int count = k;
			preTail = sectionTail;
			sectionTail = curNode;
			
			while(count-->0 && curNode!=null){
				tmp = curNode;
				curNode = curNode.next;
				tmp.next = sectionHead;
				sectionHead = tmp;
			}
			//统计逆置了几个部分
			++sectionNum;
			//如果是第一个部分，就因该确定逆置后的链表的头结点
			if(sectionNum==1){
				newHead = sectionHead;
			}else{
				preTail.next = sectionHead;
			}	
		}
		sectionTail.next = null;
		return newHead;
	}
	
	//使用单向链表完成两位正整数加法
	public static Node addTwoPositive(Node list1,Node list2){
		int carry=0;
		int remain = 0;
		Node head1 = reverseNoHead(list1);
		Node head2 = reverseNoHead(list2);
		Node p=head1; Node q=head2;Node newHead=null;
		while(p!=null && q!=null){
			int s = p.value+q.value+carry;
			remain = s%10;
			Node node = new Node(remain);
			node.next = newHead;
			newHead = node;
			carry = s/10;
			p = p.next;
			q = q.next;
		}
		while(p!=null){
			int s = p.value+carry;
			remain = s%10;
			Node node = new Node(remain);
			node.next = newHead;
			newHead = node;
			carry=s/10;
			p = p.next;
		}
		while(q!=null){
			int s = q.value+carry;
			remain = s%10;
			Node node = new Node(remain);
			node.next = newHead;
			newHead = node;
			carry=s/10;
			q = q.next;
		}
		
		if(carry==1){
			Node node = new Node(1);
			node.next = newHead;
			newHead = node;
		}
		
		return newHead;
		
	}
	public static void main(String[] args){         
		int[] a = new int[] {1,2,3,4,5};
		int[] b = new int[] {9,2,3,4,3};
		
		Node list1 = createNoHeadTail(a);
		Node list2 = createNoHeadTail(b);
		
		Node newHead = addTwoPositive(list1, list2);
		
		
		while(newHead!=null){
			System.out.print(newHead.value+":");
			newHead = newHead.next;
		}
		
		System.out.println();
		
		
	}
}

