package toutiao;

import java.util.Stack;
import java.util.TreeMap;

/*
 * 第一行为一个整数n 
接下来n行，每一行为一个表达式 
对于30%的数据，表达式仅包含'6', '+', '-'三种字符 
对于100%的数据，表达式仅包含'6', '+', '-', '*'四种字符。1≤n≤100，表达式长度不超过100，
其中'+', '-', '*'均为二元运算符，计算中间结果在[−2^63,2^63−1]之内，最终结果在[0,2^63−1]之内
*/
public class Test4 {

	//已知中缀表达式，求后缀表达式。运算符只有*，-，+三个二元运算符，运算数只有6
			public static void postExpresion(char[] cs,Stack<Character>operand){
				Stack<Character> operator = new Stack<Character>();   //操作符栈
				operator.push('#');				//初始化栈
				for(int i=0;i<cs.length;i++){
					if(cs[i]>='0' && cs[i]<='9'){
						operand.push(cs[i]);
					}else{
						while(getLevel(cs[i])<=getLevel(operator.peek()) && operator.peek()!='#'){
							char tmp = operator.pop();
							operand.push(tmp);
						}
						operator.push(cs[i]);
					}
				}
				
				//如果操作符栈中还有没有出栈的元素，则全部出栈
				while(operator.peek()!='#'){
					char tmp = operator.pop();
					operand.push(tmp);
				}
			}
			
			//运算符的优先级
			public static int getLevel(char ch){
				switch (ch) {
				case '+':
				case '-':
					return 1;
				case '*':
					return 2;
				case '#':
					return -1;
				default:
					return 0;
				}
			}
			
			//根据后缀表达式，求出算数表达式的值
			public static long calulate(Stack<Character> stack){
				long result=0;
				long tmp,firstOprand,secondOprand;
				Stack<Long> oprand = new Stack<Long>();
				while(!stack.isEmpty()){        					//如果是操作数则直接入栈
					char top = stack.peek();
					if(top>='0' && top<='9'){
						tmp = (long) (stack.pop()-'0');
						oprand.add(tmp);
					}else if(top=='*'){    				//如果是操作符就，就从操作数栈中弹出栈顶两个元素，进行计算
						stack.pop();
						secondOprand = oprand.pop();
						firstOprand = oprand.pop();
						tmp = firstOprand*secondOprand;
						oprand.push(tmp);
					}else if(top=='+'){
						stack.pop();
						secondOprand = oprand.pop();
						firstOprand = oprand.pop();
						tmp = firstOprand+secondOprand;
						oprand.push(tmp);
					}else if(top=='-'){
						stack.pop();
						secondOprand = oprand.pop();
						firstOprand = oprand.pop();
						tmp = firstOprand-secondOprand;
						oprand.push(tmp);
					}
				}
				result = oprand.pop();
				return result;
			}
			
			public static void printResult(long result){
				String[][] G = {{"66666","....6","66666","66666","6...6","66666","66666","66666","66666","66666"},
								 {"6...6","....6","....6","....6","6...6","6....","6....","....6","6...6","6...6"},
								 {"6...6","....6","66666","66666","66666","66666","66666","....6","66666","66666"},
								 {"6...6","....6","6....","....6","....6","....6","6...6","....6","6...6","....6"},
								 {"66666","....6","66666","66666","....6","66666","66666","....6","66666","66666"}
								};
				String s = result + "";
				char[] cs = s.toCharArray();
				for(int i=0;i<5;i++){
					for(int j=0;j<cs.length;j++){
						switch (cs[j]) {
						case '0':
							System.out.print(G[i][0]+"..");
							break;
						case '1':
							System.out.print(G[i][1]+"..");
							break;
						case '2':
							System.out.print(G[i][2]+"..");
							break;
						case '3':
							System.out.print(G[i][3]+"..");
							break;
						case '4':
							System.out.print(G[i][4]+"..");
							break;
						case '5':
							System.out.print(G[i][5]+"..");
							break;
						case '6':
							System.out.print(G[i][6]+"..");
							break;
						case '7':
							System.out.print(G[i][7]+"..");
							break;
						case '8':
							System.out.print(G[i][8]+"..");
							break;
						case '9':
							System.out.print(G[i][9]+"..");
							break;
							
						default:
							break;
						}
					}
					System.out.println();
				}
			}
			
			public static void main(String[] args){
				Stack<Character>operand = new Stack<Character>();  //中缀转后缀（这里返回的结果后缀表达式的顺序是反的）
				Stack<Character>stack = new Stack<Character>();	//将得到的后缀结果逆序输出
				String testcase_1 = "6*6-6+6+6*6+6+6*6*6*6*6*6*6*6*6";
				char[] cs = testcase_1.toCharArray();
				long time = System.currentTimeMillis();
				//将中缀表达式转化为后缀表达式
				postExpresion(cs, operand);
				while(!operand.isEmpty()){			//逆序输出才是后缀表达式
					stack.push(operand.pop());
				}
				
				//将结果打印出来
				printResult(calulate(stack));
				System.out.println("程序执行时间："+(System.currentTimeMillis()-time)/1000+"秒");
				
			}
	
}
