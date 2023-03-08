package assignment.strings;

import java.util.Scanner;

public class StringMethods {
	
	// Hackerrank
	public static void main(String[] args) {
		
		StringMethods problem = new StringMethods();
		
		problem.stringIntroduction();
//		problem.substring();
//		problem.substringComparison();
//		problem.stringReverse();

	}
	
	
	// Problem 1: Java Strings Introduction
	public void stringIntroduction() {
		Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        
        int ALength = A.length();
        int BLength = B.length();
        
        int sumLength = ALength + BLength;
        System.out.println(sumLength);
        
        boolean lexi = (A.charAt(0) > B.charAt(0));
        if (lexi) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        String AUpper = A.substring(0, 1).toUpperCase() + A.substring(1);
        String BUpper = B.substring(0, 1).toUpperCase() + B.substring(1);
        System.out.println(AUpper + " " + BUpper);
	}
	
	
	// Problem 2: Java Substring
	public void substring() {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		int start = in.nextInt();
		int end = in.nextInt();

		String ss = S.substring(start, end);
		System.out.println(ss);
	}
	
	
	// Problem 3: Java Substring Comparison
	public void substringComparison() {
		String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        String s = "ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs";
        int k = 30;
        
        smallest = s.substring(0, k);
        largest = s.substring(0, k);
        
        for (int i = 1; i <= s.length() - k; i++) {
            String sSub = s.substring(i, i + k);
            
            for (int j = 0; j < k; j++) {
                if (sSub.charAt(j) < smallest.charAt(j)) {
                    smallest = sSub;
                    break;
                } else if (sSub.charAt(j) == smallest.charAt(j)) {
                    continue;
                } else {
                    break;
                } 
            }
            
            for (int j = 0; j < k; j++) {
                if (sSub.charAt(j) > largest.charAt(j)) {
                	largest = sSub;
                    break;
                } else if (sSub.charAt(j) == largest.charAt(j)) {
                    continue;
                } else {
                    break;
                } 
            }
        }
        
        System.out.println(smallest);
        System.out.println(largest);
	}
	
	// Problem 4: Java String Reverse
	public void stringReverse() {
//		// Approach 1
//        Scanner sc=new Scanner(System.in);
//        String A=sc.next();
//        /* Enter your code here. Print output to STDOUT. */
//        StringBuffer ss = new StringBuffer(A);
//        ss.reverse();
//        if (A.equals(ss.toString())) {
//            System.out.println("Yes");
//        } else {
//            System.out.println("No");
//        }
        
        // Approach 2
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String ss = "";
        for (int i = A.length() - 1; i >= 0; i--) {
            ss = ss + A.charAt(i);
        }
        
        if (A.equals(ss)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
	}

}
