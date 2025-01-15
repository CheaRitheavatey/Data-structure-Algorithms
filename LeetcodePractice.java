import java.util.Arrays;

public class LeetcodePractice {
    public static String reverseWords(String s) {
        // split string s into array
        StringBuilder result = new StringBuilder();
        String[] list = s.split(" ");
        for (int i = list.length - 1; i >= 0; i--) {
            if (!list[i].isEmpty()) {
                list[i] = list[i].trim();
                result.append(list[i]).append(" ");
            }
        }
        // remove the last space
        if (result.length() > 0 && result.charAt(result.length() - 1) == ' ') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();

        // time complexity O(n)

    }
    
        public static int hIndex(int[] citations) {
            // sort array
            Arrays.sort(citations); // time complexity O(nlogn)
            System.out.println(Arrays.toString(citations));

            int result = 0;
            for (int i=0; i<citations.length;i++) {
                if (citations[i] >= citations.length -i) {
                    result = citations.length - i;
                    break;
                }
            } // time complexity O(n)
            return result;

            // time complexity O(nlogn) + O(n) = O(nlogn)
        }
    
        
    
    public static String longestCommonPrefix(String[] strs) {
        String output = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j =1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return output;
                }
            }
            output +=c;
        }
      
        return output;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        // System.out.println(longestCommonPrefix(strs));
        int[] citations = {1,3,1};
        // System.out.println(hIndex(citations));

        String s = "  hello world  ";
        System.out.println(reverseWords(s));

    }
}