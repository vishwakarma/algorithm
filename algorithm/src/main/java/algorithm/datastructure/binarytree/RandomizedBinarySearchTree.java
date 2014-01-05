package algorithm.datastructure.binarytree;

/**
 * User: gopi.vishwakarma
 * Date: 04/01/14
 */
public class RandomizedBinarySearchTree implements BinaryTree {

    private TreapNode root;
    private static TreapNode dummyNode;

    public RandomizedBinarySearchTree() {
        root = getDummyNode();
    }

    /**
     * Insert into the tree.
     *
     * @param element the item to insert.
     */
    public void insert(Comparable element) {
        root = insert(element, root);
    }

    /**
     * Internal method to insert into a subtree.
     * @param element
     * @param root
     * @return the new root
     */
    private TreapNode insert(Comparable element, TreapNode root) {
        if(root == getDummyNode()){
            root =  new TreapNode(element, getDummyNode(), getDummyNode());
        }
        else{
            if(element.compareTo(root.getKey()) < 0){
                root.setLeft(insert(element, root.getLeft()));

                if(root.getLeft().getPriority() < root.getPriority()){
                    root = rotateWithLeftChild(root);
                }
            }
            else{
                if(element.compareTo(root.getKey()) > 0){
                    root.setRight(insert(element, root.getRight()));

                    if(root.getRight().getPriority() < root.getPriority()){
                        root = rotateWithRightChild(root);
                    }
                }
            }

        }
        return root;
    }

    private TreapNode rotateWithRightChild(TreapNode root) {

        TreapNode right = root.getRight();
        root.setRight(right.getLeft());
        right.setLeft(root);

        return right;
    }

    private TreapNode rotateWithLeftChild(TreapNode root) {
        TreapNode left = root.getLeft();
        root.setLeft(left.getRight());
        left.setRight(root);

        return left;
    }

    /**
     * Remove from the tree, does nothing if x is not found.
     *
     * @param element the item to remove.
     * @return the new root.
     */
    public void remove(Comparable element) {
        root = remove(element, root);
    }

    /**
     * Internal method to remove from a subtree.
     */
    private TreapNode remove(Comparable element, TreapNode root) {
        if(root != getDummyNode()){
            if(element.compareTo(root.getKey()) < 0){
                root.setLeft(remove(element, root.getLeft()));
            }
            else{
                if(element.compareTo(root.getKey()) > 0){
                    root.setRight(remove(element, root.getRight()));
                }
                else{
                    // Match found
                    if(root.getLeft().getPriority() < root.getRight().getPriority())
                        root = rotateWithLeftChild( root );
                    else
                        root = rotateWithRightChild( root );

                    if( root != getDummyNode() )
                        root = remove( element, root );
                    else
                        root.setLeft(getDummyNode()); // At a leaf , now delete
                }
            }
        }
        return root;
    }

    /**
     * Find the smallest item in the tree.
     *
     * @return the smallest item, or null if empty.
     */
    public Comparable getMinimumElement() {
        if(isEmpty()){
            System.out.println("Tree is empty");
            return null;
        }

        TreapNode node = root;

        while( node.getLeft() != getDummyNode() )
            node = node.getLeft();

        return node.getKey();
    }

    /**
     * Find the largest item in the tree.
     *
     * @return the largest item, or null if empty.
     */
    public Comparable getMaximumElement() {
        if(isEmpty())
            return null;

        TreapNode node = root;

        while( node.getRight() != getDummyNode() )
            node = node.getRight();

        return node.getKey();
    }

    /**
     * Find an item in the tree.
     *
     *
     * @param elementToSearch the item to search for.
     * @return the matching item, or null if not found.
     */
    public TreapNode findElement(Comparable elementToSearch) {
        return findElement(elementToSearch, root);
    }

    private TreapNode findElement(Comparable elementToSearch, TreapNode root) {

        if(elementToSearch != null){
            if(root != dummyNode){
                if(elementToSearch.compareTo(root.getKey()) < 0){
                    return findElement(elementToSearch, root.getLeft());
                }
                else{
                    if(elementToSearch.compareTo(root.getKey()) > 0){
                        return findElement(elementToSearch, root.getRight());
                    }
                    return root;
                }
            }
        }
        return null;
    }

    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == getDummyNode();
    }

    /**
     * Print the tree contents in sorted order using standard Output.
     */
    public void printTree() {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param root the node that roots the tree.
     */
    private void printTree( TreapNode root )
    {
        if(root != dummyNode ){
            printTree( root.getLeft() );
            System.out.println(root.getKey());
            printTree( root.getRight() );
        }
    }
    private TreapNode getDummyNode() {
        return dummyNode;
    }

    static {
        dummyNode = new TreapNode(null);
        dummyNode.setLeft(dummyNode);
        dummyNode.setRight(dummyNode);
    }
}
