public class Solution {
    public boolean isPalindrome(int x){
        String s =String.valueOf(x);
        for (int i=0; i<s.length(); i++){
            //if (s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
            if (s.charAt(i)==s.charAt(s.length()-i-1)) return true;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 1;
        Solution test = new Solution();
        System.out.println(test.isPalindrome(x));
    }
}
