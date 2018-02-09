import java.util.*;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] A, int k) {
        // TODO: your code here
        // For now, return a List that's correct size, but contains only 0s
        
        Stack <Integer> digitStack = new Stack<Integer>();
        digitStack.push(A[0]);
        int count = k;
        int rest = A.length - k;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] > digitStack.peek() && digitStack.peek() < rest) {
                digitStack.push(A[i]);
            }
            else {
                while (!digitStack.empty() && A[i] < digitStack.peek() && count > 0) {
                    digitStack.pop();
                    count--;
                }
                
                if (digitStack.size() < rest) {
                    digitStack.push(A[i]);
                }
            }
        }
        
        return digitStack;
    }

    public static boolean isPalindrome(Node n) {
        // TODO: your code here
        if (n == null || n.next == null) {
            return true;
        }

        // traverse list and count the number of nodes
        int count = 0;
        Node tempNode = n;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }

        tempNode = n;
        for (int i = 0; i < count/2; i++) {
            tempNode = tempNode.next;
        }
        Node rightNode = tempNode.next;
        
        if (count%2 == 0) {
            rightNode = tempNode;
        }

        // reverse second half
        Node prevNode = null;
        Node currNode = n;
        tempNode = null;
        for (int i = 0; i < count/2; i++) {
            tempNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = tempNode;
        }

        // compare if equals
        Node leftNode = prevNode;
        for (int i = 0; i < count/2; i++) {
            if (leftNode.val != rightNode.val) {
                return false;
            }
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        return true;
    }
    

    public static String infixToPostfix(String s) {
        Stack <String> operations = new Stack<>();
        
        String finalResult = "";
        
        for (int i = 0; i < s.length(); i++) {
            if (Character.toString(s.charAt(i)).equals(")")) {
                while(!operations.isEmpty()) {
                    finalResult = finalResult + Character.toString(operations.pop().charAt(0)) + " ";
                }
            }
     
            else if (Character.toString(s.charAt(i)).equals("+") || Character.toString(s.charAt(i)).equals("-") || Character.toString(s.charAt(i)).equals("*") || Character.toString(s.charAt(i)).equals("/")) {
                operations.push(Character.toString(s.charAt(i)));
            }
            
            else if (!Character.toString(s.charAt(i)).equals(" ") && !Character.toString(s.charAt(i)).equals("(")) {
                finalResult = finalResult + Character.toString(s.charAt(i)) + " ";
            }
            
        }
        
        while(!operations.isEmpty()) {
            finalResult = finalResult + Character.toString(operations.pop().charAt(0)) + " ";
        }
        
        return finalResult.trim();
    }
}