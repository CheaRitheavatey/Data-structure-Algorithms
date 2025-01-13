public class LeetcodePractice {
    public static String longestCommonPrefix(String[] strs) {
        String output = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j =1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return output;
                }
            }
            output +=c;
        }
      
        return output;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));

    }
}