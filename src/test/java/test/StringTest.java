package test;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str = "hello world";
		char ch;
		String m = "";
		
		for(int i =0; i<str.length(); i++) {
			ch = str.charAt(i);
			m = ch + m;
			
		}
		
		System.out.println("reverse string: " +m);

	}

}
