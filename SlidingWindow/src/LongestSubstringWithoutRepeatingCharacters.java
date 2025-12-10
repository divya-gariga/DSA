import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
        public int lengthOfLongestSubstring(String s) {
            int i = 0, cnt = 0, res = 0;
            HashMap<Character, Integer> hm = new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                char ele = s.charAt(j);
                if (hm.containsKey(ele) && hm.get(ele)>=i) {
                    i = hm.get(ele)+1;
                    hm.remove(ele);
                }
                hm.put(ele, j);
                res = Math.max(res, j-i+1);
            }
            return res;
        }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj=new LongestSubstringWithoutRepeatingCharacters();
        System.out.println("should be = 3 result is = "+obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("should be = 1 result is = "+obj.lengthOfLongestSubstring("bbbbb"));
        System.out.println("should be = 3 result is = "+obj.lengthOfLongestSubstring("dvdf"));
    }
}
