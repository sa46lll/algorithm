package leetcode.array;

import java.util.Arrays;

public class LongestCommonPrefix {
    static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);
        String result = "";
        for (int i = 0; i < strs[0].length(); i++) {
            String prefix = strs[0].substring(0, i + 1);
            if (!strs[strs.length - 1].startsWith(prefix)) {
                break;
            }
            result = prefix;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[] {"a"}));
        System.out.println(longestCommonPrefix(new String[] {"aaa","aa","aaa"}));
    }
}
