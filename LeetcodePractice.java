import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
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
    public static int candy(int[] ratings) {
        int[] deftL = new int[ratings.length];
        int[] deftR = new int[ratings.length];

        int r = 0;

        Arrays.fill(deftL, 1);
        Arrays.fill(deftR, 1);

       
        for (int i =1 ; i< ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                deftL[i] = deftL[i-1] + 1;
            }
        }

        for (int i = ratings.length-2; i >=0; i-- ) {
            if (ratings[i] > ratings[i+1]) {
                deftR[i] = deftR[i+1]+1;
            }
        }

        for (int i =0; i<ratings.length; i++) {
            r += Math.max(deftL[i], deftR[i]);

        }
        return r;

        
    }
    public static void rotate(int[] nums, int k) {
        // circular array
        int l = nums.length;
        int[] x = new int[l];
        
        for (int i = 0; i<l; i++) {
            x[(i + k) % l] = nums[i];
        }

        System.out.println(Arrays.toString(x));
       
    }
    public static boolean isIsomorphic(String s, String t) {
        // store string in hashmap
        // check length
        if (s.length() != t.length())
            return false;
        
        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();

        // for char i in s if s contain key t put it in else retur false
        for (int i =0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);

            if (s2t.containsKey(chs)) {
                if (s2t.get(chs) != cht) {
                    return false;
                }
            }
            else {
                s2t.put(chs, cht);
            }
            
            if (t2s.containsKey(cht)) {
                if (t2s.get(cht) != chs) {
                    return false;
                }
            }
            else {
                t2s.put(cht, chs);
            }
            

            
        }
        System.out.println(s2t);
        System.out.println(t2s);
        return true;
        }
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        // if the value contain the key then return true
       for (char c: magazine.toCharArray()) {
        map.put(c, map.getOrDefault(c,0)+1);
       }

       for (char c: ransomNote.toCharArray()) {
        if (!map.containsKey(c) || map.get(c) <= 0) {
            return false;
        }
        map.put(c, map.get(c)-1);
       }
       return true;
       
    }
    public static int romanToInt(String s) {
        int result = 0;

        Dictionary<Character, Integer> dict = new Hashtable<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);

        for (int i =0; i < s.length(); i++) {
            int x = dict.get(s.charAt(i));
            result += x;
        }

        return result;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        // traverse to the end
        ListNode end = head;
        ListNode current = head;

        
        while (end != null) {
            count += 1;
            end = end.next;
        }
        if (n == count)
            return head.next;

        for (int i=1; i < count - n; i++) {
            current = current.next;
        }

        current.next = current.next.next;

        return head;
        
    }
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) +1;
        
    }
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) 
            return true;
        
        return check(root.left,root.right);
        
    }

    public static boolean check(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null)
            return true;
        
        if (tree1 == null || tree2 == null)
            return false;
        
        
        return tree1.val == tree2.val && check(tree1.left,tree2.right) && check(tree1.right, tree2.left);
    }
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        
        invertTree(root.left);
        invertTree(root.right);

        return root;


        
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        current.next = head;

        k = k % length;
        int tail = length - k;
        
        
        ListNode end = head;
        ListNode newhead = head;
        for (int i = 1; i < tail; i++) {
            end = end.next;
        }
        newhead = end.next;
        end.next = null;

        
        return newhead;

        // time complexity O(n)
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;
    }
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

        int[] nums = {1,0,2};
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
        
        // romanToInt("LVIII");
        // System.out.println(isIsomorphic("badc", "baba"));
        // rotate(nums, 3);
        System.out.println(candy(nums));

    }
}