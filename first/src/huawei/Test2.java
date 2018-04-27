package huawei;

import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(System.in);
		//String s = in.nextLine();
		//f(s);
	
		while(!in.hasNextLine()){
			sb.append(in.nextLine());
			sb.append("\n");
		}
	}
	
	public static void f(String s){
		StringBuilder sb = new StringBuilder();
		String[] ss = s.split(" ");
		for(int i=0;i<ss.length;i++){
			char[] cs = ss[i].toCharArray();
			for(int j=0;j<cs.length;j++){
				sb.append(change(cs[j]));
			}
			sb.append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static char change(char c){
		switch (c) {
		case 'a':
			return 'q';
		case 'A':
			return 'Q';
		case 'b':
			return 'w';
		case 'B':
			return 'W';
		case 'c':
			return 'e';
		case 'C':
			return 'E';
		case 'd':
			return 'r';
		case 'D':
			return 'R';
		case 'e':
			return 't';
		case 'E':
			return 'T';
		case 'f':
			return 'y';
		case 'F':
			return 'Y';
		case 'g':
			return 'u';
		case 'G':
			return 'U';
		case 'h':
			return 'i';
		case 'H':
			return 'I';
		case 'i':
			return 'o';
		case 'I':
			return 'O';
		case 'j':
			return 'p';
		case 'J':
			return 'P';
		case 'k':
			return 'a';
		case 'K':
			return 'A';
		case 'l':
			return 's';
		case 'L':
			return 'S';
		case 'm':
			return 'd';
		case 'M':
			return 'D';
		case 'n':
			return 'f';
		case 'N':
			return 'F';
		case 'o':
			return 'g';
		case 'O':
			return 'G';
		case 'p':
			return 'h';
		case 'P':
			return 'H';
		case 'q':
			return 'j';
		case 'Q':
			return 'J';
		case 'r':
			return 'k';
		case 'R':
			return 'K';
		case 's':
			return 'l';
		case 'S':
			return 'L';
		case 't':
			return 'z';
		case 'T':
			return 'z';
		case 'u':
			return 'x';
		case 'U':
			return 'X';
		case 'v':
			return 'c';
		case 'V':
			return 'C';
		case 'w':
			return 'v';
		case 'W':
			return 'V';
		case 'x':
			return 'b';
		case 'X':
			return 'B';
		case 'y':
			return 'n';
		case 'Y':
			return 'N';
		case 'z':
			return 'm';
		case 'Z':
			return 'M';
			
			

		default:
			return c;
		}
	}
}
