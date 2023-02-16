package classExamples.stringbuffer;

public class StringBufferExample {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("abcdefghijklmnopq");
		
		System.out.println(sb);  // output: abcdefghi
		
		sb.replace(0, 20, "1234567890");
		
		System.out.println(sb);  // output: 1234567890fghi
		
		sb.insert(2, "ABCDE");
		
		System.out.println(sb);  // output: 12ABCDE34567890fghi

	}

}
