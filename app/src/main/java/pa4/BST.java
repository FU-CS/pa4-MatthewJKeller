
package pa4;

public class BST {
    
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public BST() {
        this.root = null;
    }

    /** 
     * Insert a node with a given value into the BST.
     * @param value the value of the node to insert
     */
    public void insert(int value) {
        if (this.root == null) {
            this.root =new Node(value);
        } else {
            this.insertHelper(this.root, value);
        }
    }
    
    private void insertHelper(Node curr, int value) {
        if (curr.value == value) {
            return;
        } else if (curr.value < value) {
            if (curr.right ==null) {
                curr.right = new Node(value);
            } else {
                this.insertHelper(curr.right,value);
            }
        } else {
            if (curr.left == null) {
                curr.left = new Node(value);
            } else {
                this.insertHelper(curr.left, value);
            }
        }
    }



    /** 
     * Delete a node with a given value from the BST.
     * @param value the value of the node to delete
     */
    public void delete(int value) {
       
        this.root = deleteHelper(this.root, value);
    }
    
    private Node deleteHelper(Node curr, int value) {
        if (curr == null) {
            return null;
        }
    
        if (curr.value > value) {
            curr.left = deleteHelper(curr.left, value);
        } else if (curr.value < value) {
            curr.right = deleteHelper(curr.right, value);
        } else {
            if (curr.left == null) {
                return curr.right;
            } else if (curr.right== null) {
                return curr.left;
            } else {
                Node successor = findMin(curr.right);
                curr.value = successor.value;
                curr.right = deleteHelper(curr.right, successor.value);
            }
        }
        return curr;
    }
    
    private Node findMin(Node curr) {
        while (curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    /** 
     * Search for a node with a given value in the BST and return true if found.
     * @param value the value to search for
     */
    public boolean search(int value) {
        if (this.root == null) {
            return false;
        }
        else{
            return this.searchHelper(this.root,value);
        }
    }
    private boolean searchHelper(Node curr, int value){
        if(curr == null){
            return false;
        }
        else if(curr.value>value){
            return this.searchHelper(curr.left,value);
        }
        else if(curr.value<value){
            return this.searchHelper(curr.right,value);
        }
        else{
            return true;
        }
        
    }

    /** 
     * Update a node with a given old value to a new value in the BST.
     * @param oldValue the old value of the node to update
     * @param newValue the new value of the node to update
     */
    public void update(int oldValue, int newValue) {
        if (this.root != null) {
            delete(oldValue);
            insert(newValue);   
        }  
    }

    /** 
     * Traverse the BST in inorder and return the values as a string. 
     * @return the inorder traversal of the BST
     */
    public String inOrder() {
       return this.inOrderTraversalHelper(this.root);
    }

    private String inOrderTraversalHelper(Node curr){
        if(curr == null){
            return "";
        }
        String left = this.inOrderTraversalHelper(curr.left);
        String right = this.inOrderTraversalHelper(curr.right);
        return left +curr.value + " " + right;
    }
        
    
    public static Node sortedArrayToBST(int[] arr) {
        return sortedArrayToBSTHelper(arr, 0, arr.length - 1);
    }
    
    private static Node sortedArrayToBSTHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
    
        int mid = start + (end - start) / 2;
        Node curr = new Node(arr[mid]);
    
        curr.left = sortedArrayToBSTHelper(arr, start, mid- 1);
        curr.right = sortedArrayToBSTHelper(arr, mid + 1, end);
    
        return curr;
    }
    

    /** 
     * Find the lowest common ancestor of two nodes with given values in the BST.
     */
    public Node lowestCommonAncestor(int value1, int value2) {
        if (this.root == null) {
            return null;
        }
        else{
        return this.lowestCommonAncestorHelper(value1, value2, root);
        }
    }

    private Node lowestCommonAncestorHelper(int value1, int value2, Node curr){
        if (((curr.value>=value1) && (curr.value<=value2)) || ((curr.value<=value1) && (curr.value>=value2))){
            return curr;
        }
        else if((curr.value == value1) || (curr.value == value2)){
            return curr;
        }
        else if((curr.value > value1)&&(curr.value> value2)){
            return this.lowestCommonAncestorHelper(value1, value2, curr.left);
        }
        else if((curr.value < value1)&&(curr.value < value2)){
            return this.lowestCommonAncestorHelper(value1, value2, curr.right);
        }
        else{

        return null;
        }
    }

    public static void main(String[] args) {

        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println(bst.inOrder());
        bst.delete(3);
        System.out.println(bst.inOrder());
        System.out.println(bst.search(3));
        System.out.println(bst.search(4));
        bst.update(4, 9);
        System.out.println(bst.inOrder());

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node root = BST.sortedArrayToBST(arr);
        System.out.println(root.value);

        System.out.println(bst.lowestCommonAncestor(2, 4).value);
        System.out.println(bst.lowestCommonAncestor(2, 6).value);

    }
}