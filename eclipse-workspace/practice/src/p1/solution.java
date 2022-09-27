package p1;

import java.util.HashMap;


public class solution {
	public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap();
        //students.forEach(System.out::println);
        for( String word:banned){
            map.put(word, -1);
        }
        map.put("", -1);
        paragraph = paragraph.toLowerCase();
        // System.out.println(paragraph);
        paragraph=paragraph.replace('!',' ').replace('?',' ').replace('\'',' ').replace(',',' ').replace(';',' ').replace('.',' ').trim();
        System.out.println(paragraph);
        String[] words = paragraph.split(" ");
        String resultWord = "";
        int max=0;
        for( String word:words){
            if(!map.containsKey(word)){
                map.put(word,1);
                if(max<1){
                    resultWord = word;
                    max = 1;
                }
            }else if(map.get(word)!=-1){
                int cur = map.get(word)+1;
                map.replace(word,cur);
                if(cur>max){
                    resultWord = word;
                    max = cur;
                }
            }
            
        }
         System.out.println(map);
        return resultWord;
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
