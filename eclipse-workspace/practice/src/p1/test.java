package p1;

public class test {
	public static void main(String[] args) {
		solution so = new solution();
		
		String paragraph = "Bob. hIt, baLl";
		String[] banned = {"bob", "hit"};
		String result = so.mostCommonWord(paragraph, banned);
		System.out.println(result);
		
	}
}