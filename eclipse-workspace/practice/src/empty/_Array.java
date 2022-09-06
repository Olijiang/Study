package empty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class _Array {
	public static void main(String[] args) {
		//1. Arraylist
		ArrayList<String> names = new ArrayList<String>();
		names.add("月月");
		names.add("千影");
		names.add("清漪");
		names.add("月婵");
		System.out.println("names"+names);
		
//		for(String name:names) {
//			System.out.println(name);
//		}	
//		names.forEach((name)->System.out.println(name));
		
		//2. Linklisty
		LinkedList<String> names2 = new LinkedList<String>();
		names2.add("月月");
		names2.add("千影");
		names2.add("清漪");
		names2.add("月婵");
		System.out.println("names2"+names2);
		
		//3. HashSet
		// 集合
		HashSet<String> names3 = new HashSet<String>();
		names3.add("月月");
		names3.add("千影");
		names3.add("清漪");
		names3.add("月婵");
		System.out.println("names3"+names3);
		
		//4.HashMap
		HashMap<Integer, String> names4 = new HashMap<>();
		names4.put(1,"月月");
		names4.put(2,"千影");
		names4.put(3,"清漪");
		names4.put(4,"月婵");

		System.out.println("names4"+names4);
		//遍历
		for (Integer i : names4.keySet()) {
			System.out.println(i + names4.get(i) + " ");
		}
		for (String name : names4.values()) {
			System.out.println(name);
		}
		
	}
	
	
	
	
	
	
}
