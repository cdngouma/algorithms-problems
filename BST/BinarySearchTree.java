import java.util.*;

public class BinaryTree {
    private Node root;

    public BinaryTree(ArrayList<Integer> values) {
        this.push(values);
    }

    public BinaryTree() {
        this.root = null;
    }

    public void push(ArrayList<Integer> values) {
        if (values.size() <= 0)
            return;
        for (int key : values) {
            this.push(key);
        }
    }

    public void push(int key) {
        
        if (this.root == null)  this.root = new Node(key);

        else {
            Node parent = this.root;
            Node current = parent;
            while (current != null) {
                parent = current;
                if (key < current.key) {
                    current = parent.left;
                }
                else{
                    current = parent.right; 
                }
            }
            
            Node node = new Node(key);
            if(key < parent.key) parent.left = node;
            else parent.right = node;
        }
    }
    
    public void printInOrder() {
        Stack<Node> stack = new Stack<>();
        Node current = this.root;
        
        while(current != null || !stack.empty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.key + " ");
            current = current.right;
        }
        System.out.println();
    }
    
    public void printPostOrder() {
        Stack<Node> stack = new Stack<>();
        Node current = this.root;
        
        while(current != null || !stack.empty()) {
            while(current != null) {
                System.out.print(current.key + " ");
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        System.out.println();
    }
    
    public void printPreOrder() {
        Stack<Node> stack = new Stack<>();
        Node current = this.root;
        
        while(current != null || !stack.empty()) {
            while(current != null) {
                System.out.print(current.key + " ");
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        System.out.println();
    }
    
    public boolean find(int key) {
        Node current = this.root;
        while(current != null) {
            if(key == current.key) return true;
            else if(key < current.key) current = current.left;
            else current = current.right;
        }
        return false;
    }
    
    private class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }
}