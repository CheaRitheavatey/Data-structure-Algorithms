import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class LeetcodePractice {
    public boolean hasCycle(ListNode head) {
        // this method is called Floyd's Tortoise and Hare where the fast and slow node will eventually meet at a certain point
        // time complexity O(n)
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
        
    }
    public static void minSubArrayLen(int target, int[] nums) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 2; i<nums.length; i++) {
            int maxSum = 0;
            for (int j = 0; j < i; j++) {
                maxSum += nums[i];

                if (maxSum >= target) {
                    array.add(nums[i]);
                }
            }

            int windowSum = maxSum;
            // Slide the window over the array
            for (int k = i; k < nums.length; k++) {
                windowSum += nums[k] - nums[k - i];
                if (windowSum >= target) {
                    array.add(nums[k]);
                }
                
            }
            
        }
        System.out.println(array);
        HashSet<Integer> set = new HashSet<>(array);
        System.out.println(set);
        System.out.println(set.size());
        
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 1; i < nums.length-1; i++) {
            int y = i + 1;
            int z = nums.length - 1;
            int x = nums[i];
            while (y < z) {
                int sum = x + nums[y] + nums[z];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[y], nums[z]));
                    y++;
                    z++;
                    break; 
                }
                else if (sum > 0) {
                    z--;
                } else {
                    y++;
                }        
            }

            
        }
        // check for when duplicate in element
        
        // check for when duplicate
        Set<List<Integer>> uniqueResults = new HashSet<>(result);
        result = new ArrayList<>(uniqueResults);

        return result;

       
    }
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left+1;
                result[1] = right+1;

                left++;
                right++;
                break;

            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return result;
        // time complexity O(n) because while loop take O(n) time, space complexity O(1) because of fixed array
        
   }

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
        // System.out.println(reverseWords(s));

        int[] numbers = {2,7,11,15};
        // System.out.println(twoSum(numbers, 9));

        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
        
        // minSubArrayLen(11, nums);
    }
}