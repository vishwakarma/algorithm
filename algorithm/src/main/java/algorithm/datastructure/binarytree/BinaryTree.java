package algorithm.datastructure.binarytree;

/**
 * User: gopi.vishwakarma
 * Date: 04/01/14
 */

/**
 * API
 */
public interface BinaryTree {
    /**
     * Insert into the tree.
     * @param element the item to insert.
     */
    void insert(Comparable element);

    /**
     * Remove from the tree, does nothing if x is not found.
     * @param element the item to remove.
     */
    void remove(Comparable element);

    /**
     * Find the smallest item in the tree.
     * @return the smallest item, or null if empty.
     */
    Comparable getMinimumElement();

    /**
     * Find the largest item in the tree.
     * @return the largest item, or null if empty.
     */
    Comparable getMaximumElement();

    /**
     * Find an item in the tree.
     *
     * @param elementToSearch the item to search for.
     * @return the matching item, or null if not found.
     */
    TreapNode findElement(Comparable elementToSearch);

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Print the tree contents in sorted order using standard Output.
     */
    void printTree();

}
