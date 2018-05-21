package sample.javacode;

public class ReversString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverse("n"));
	}

	
	public static String reverse(String str )
	{
		//check condition  : null, single digit string
		if(null==str)
		{
			System.out.println( "Null value . Please enter valid string");
			return str;
		}
		
		String revStr="";
		
		for(int x=(str.length()-1);x>=0; x-- )
		{
			revStr+=str.charAt(x);
		}
		return revStr;
		
	}
}
