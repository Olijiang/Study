package empty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class _Array {
	public static void main(String[] args) {
		//1. Arraylist
		ArrayList<String> names = new ArrayList<String>();
		names.add("����");
		names.add("ǧӰ");
		names.add("����");
		names.add("���");
		System.out.println("names"+names);
		
//		for(String name:names) {
//			System.out.println(name);
//		}	
//		names.forEach((name)->System.out.println(name));
		
		//2. Linklisty
		LinkedList<String> names2 = new LinkedList<String>();
		names2.add("����");
		names2.add("ǧӰ");
		names2.add("����");
		names2.add("���");
		System.out.println("names2"+names2);
		
		//3. HashSet
		// ����
		HashSet<String> names3 = new HashSet<String>();
		names3.add("����");
		names3.add("ǧӰ");
		names3.add("����");
		names3.add("���");
		System.out.println("names3"+names3);
		
		//4.HashMap
		HashMap<Integer, String> names4 = new HashMap<>();
		names4.put(1,"����");
		names4.put(2,"ǧӰ");
		names4.put(3,"����");
		names4.put(4,"���");

		System.out.println("names4"+names4);
		//����
		for (Integer i : names4.keySet()) {
			System.out.println(i + names4.get(i) + " ");
		}
		for (String name : names4.values()) {
			System.out.println(name);
		}
		
	}
	
	
	
	
	
	
}
