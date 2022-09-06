package p1;

public class test {
	public static void main(String[] args) {
		solution so = new solution();
		
		int[] nums = {1,3,5,4,1,3,2};
		System.out.println(so.findPairs(nums, 0));
		System.out.println("--------------------------");
		int[] arr = {1,3,2,0,0,0,0,1};
		so.duplicateZeros(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
}