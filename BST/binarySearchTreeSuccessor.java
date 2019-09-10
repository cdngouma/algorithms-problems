/**
 * Problem:
 * Given the root node of a binary search tree and a value
 * write a function to find the inorder successor to that value
 */


/**
 *  Node {
 *      int key;
 *      Node left, Node right;
 *      Node(int key){
 *          this.key = key;
 *      }
 *  }
 */

public int successor(Node root, int target) {
    Stack < Node > stack = new Stack < > ();
    Node current = root;

    while (true) {
        // if the current node key is equal to the target
        // but has no right child, or the target was not found
        // the first node which has the current node has a 
        // left descendant must be the node with the smallest 
        // key greather than the target
        if (current == null || (target == current.key && current.right == null)) {
            while (!stack.empty()) {
                current = stack.pop();
                if (current.key > target) {
                    return current.key;
                }
            }
            // if stack is empty therefore the target was
            // found but does not have a successor
            // return the target
            return target;
        }
        // if current node key is equal to the target
        // look for the smallest value to the right
        // of the current node
        else if (target == current.key && current != null) {
            current = current.right;
            while (current.left != null) {
                current = current.left;
            }
            return current.key;
        }
        // keep looking for the target
        else if (target < current.key) {
            stack.push(current);
            current = current.left;
        } else {
            stack.push(current);
            current = current.right;
        }
    }
    // return -1 if the target was not found
    //return -1;
}