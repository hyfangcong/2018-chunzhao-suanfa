package second;

import java.util.Stack;

public class Test003_表达式的计算 {
	
	
	//已知中缀表达式，求后缀表达式。运算符只有*，-，+三个二元运算符
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
		
		
		/**********************************************************************************/
		/*在求后缀表达式的时候一起把表达式的值求出来
		 * 这里的运算符包括(,),+,-,*,/这四种运算符
		 * 操作数都是正整数并且都是0-9之间的正整数
		 * 
		 * 
		 * 在浮点数的计算和两位以上的数字的表达式求值的时候不能简单的用中缀转后缀来计算*/
		
		
		
		
		public static void main(String[] args){
			Stack<Character>operand = new Stack<Character>();
			Stack<Character>stack = new Stack<Character>();
			String testcase_1 = "9+8*6";
			char[] cs = testcase_1.toCharArray();
			long time = System.currentTimeMillis();
			//将中缀表达式转化为后缀表达式
			postExpresion(cs, operand);
			while(!operand.isEmpty()){			//逆序输出才是后缀表达式
				stack.push(operand.pop());
			}
			//根据后缀表达式计算表达式的值
			System.out.println(calulate(stack));
			System.out.println("程序执行时间："+(System.currentTimeMillis()-time)/1000+"秒");
			
			
			
		}
}
