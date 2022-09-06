package p1;

import java.util.ArrayList;
import java.util.HashMap;


public class solution {
    public void duplicateZeros(int[] arr) {

    }

    
    public int findPairs(int[] nums, int k) {
    	HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.putIfAbsent(nums[i], 0);
			map.put(nums[i], map.get(nums[i])+1);
		}
		int count=0;
		for(int i:map.keySet()) {
			if(k==0) {
				if(map.get(i)>1) count++;
			}
			else if(map.containsKey(i-k)) count++;
		}
		return count;
    }
    
    //508
    
    public int[] findFrequentTreeSum(TreeNode root) {
    	HashMap<Integer, Integer> map = new HashMap<>();
    	

        return null;
    }
   
    
}
