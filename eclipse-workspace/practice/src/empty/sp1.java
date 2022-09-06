package empty;

public class sp1 {
	
    public static String makeFancyString(String s) {
		if(s.length()<3) return s;
		StringBuilder sb = new StringBuilder(s.length());
		sb.append(s.charAt(0));
		int cn=1;
		for (int i=1; i<s.length(); i++) {
			if(s.charAt(i)==s.charAt(i-1)) {
				if(cn<2) cn++;
				else continue;
			}
			else cn=1;
			sb.append(s.charAt(i)); 
		}
		return sb.toString();
	}
    
	public static void main(String[] args) {
		String s = "leeetttttcode";
		String res = makeFancyString(s);
		System.out.println(res);
	}
}
