import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;


// Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

 
public class LeetcodePractice {
    public static int maxDepth(TreeNode root) {
        int left = maxDepth(root.left);
        System.out.println(left);
        int right = maxDepth(root.right);
        System.out.println(right);
        return Math.max(left, right)+1;
        
    }
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int left = 0;
        int maxlength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            System.out.println("current: "+s.charAt(right));
            
            while (chars.contains(current)) {
                System.out.println("before remove: "+ chars);
                chars.remove(s.charAt(left));
                System.out.println("after remove: "+chars);
                left++;
            }
            chars.add(current);
            System.out.println("chars.add(current): "+chars);
            maxlength = Math.max(maxlength, right - left +1);
            System.out.println("max length: " + maxlength);
        }
        System.out.println(chars);

        return maxlength;
        


        // String result = "";
        // // result += s.charAt(0);

        // // hash
        // Set<Character> chars = new HashSet<Character>();

        
        // // take in one char first in the string
        // for (int i = 0; i<s.length();i++) {
        //     char current = s.charAt(i);
        //     if (!chars.contains(current)) {
        //         result += s.charAt(i);
        //         chars.add(current);
        //     }
            
        // }
        // System.out.println(result);
        // return result.length();
        
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // new link list
        ListNode result = new ListNode(0);
        ListNode current = result;

        ListNode x = head;
        ListNode behindy = x;
        

        while (x.val != left) {
            current.next = x;
            current = current.next;
            x = x.next;
        }

        ListNode y = x;
        while (behindy.val != right) {
            behindy = behindy.next;
            y= y.next;

        }
        // current.next = behindy;
        return result.next;


        
        
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // create a pointer for list1 and list2 and pointer for new list
        ListNode x = list1;
        ListNode y = list2;

        ListNode z = new ListNode(0);
        ListNode current = z;


        // traverse list1 and list2 and compare
        while (x != null && y != null) {
            if (x.val < y.val) {
                current.next = x;
                x = x.next;
            } else {
                current.next = y;
                y = y.next;
            }
            // move current to the next node
            current = current.next;
        }

        // if theres any leftover just add them 
        if (x != null) {
            current.next = x;
        }

        if (y != null) {
            current.next = y;
        }
        return z.next;

        // time complexity is O(n+m) or O(n) because we have to traverse both linkedlist

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode x = new ListNode(0);
        ListNode current = x;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int total = val1 + val2 + carry;
            carry = total/10;

            current.next = new ListNode(total % 10);

            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            
        }
        return x.next;
        
        }
    
    public static String simplifyPath(String s) {
        String[] list = s.split("/");
        System.out.println(Arrays.toString(list));
        Stack<String> stack = new Stack<>();

       
        StringBuilder result = new StringBuilder();
        

        for (String sub: list) {
            if (sub.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }

            }

            else if (sub.equals("") || sub.equals(".")) {
                continue;
            } else {
                stack.push(sub);
            }
           
        }

        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }

        if (result.length() == 0) {
            return "/"; }
        
        return result.toString();

        // time complexity O(n)
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ']' || s.charAt(i) == ')' || s.charAt(i) == '}') {
                
                if (stack.isEmpty()) {
                    return false;
                }
            

            char top  = stack.peek();
            if (s.charAt(i) == ']' && top == '[' || s.charAt(i) == ')' && top == '(' || s.charAt(i) == '}' && top == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
    }
           
        return stack.isEmpty();

        // time complexity: O(n) where n is the length of the input string s

        
    }
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
        // System.out.println(threeSum(nums));
        
        // minSubArrayLen(11, nums);

        String a = "(])";
        // System.out.println(isValid(a));
        String simplify = "/home/user/Documents/../Pictures";
        // System.out.println(simplifyPath(simplify));

        String x = "pwwkew";
        // System.out.println(lengthOfLongestSubstring(x));
        // int[] test = {3,9,20,null,null,15,7};
        // System.out.println(maxDepth(test));
        

    }
}