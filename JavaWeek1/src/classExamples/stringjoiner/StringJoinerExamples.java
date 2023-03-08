package classExamples.stringjoiner;

import java.util.StringJoiner;

public class StringJoinerExamples {

	public static void main(String[] args) {
		
		StringJoiner sj = new StringJoiner(":", "{", "}");
		
		sj.add("a");
		sj.add("b");
		sj.add("c");
		sj.add("d");
		
		System.out.println(sj.toString());
		
		
		StringJoiner sj1 = new StringJoiner(",", "[", "]");
		
		sj1.add("i");
		sj1.add("j");
		sj1.add("k");
		sj1.add("l");
		
		System.out.println(sj1.toString());
		
//		System.out.println(sj.merge(sj1).toString());
		System.out.println(sj1.merge(sj).toString());
		

	}

}
