package algorithm.datastructure.skiplist;

/**
 * User: gopi.vishwakarma
 * Date: 06/01/14
 */
public interface List {
    /**
     * Insert into the list.
     * @param element the item to insert.
     */
    void insert(Comparable element);

    /**
     * Remove from the list, does nothing if x is not found.
     * @param element the item to remove.
     */
    void remove(Comparable element);

    /**
     * Find an item in the list.
     * @param elementToSearch the item to search for.
     * @return the matching item, or null if not found.
     */
    SkipNode findElement(Comparable elementToSearch);

    /**
     * Print the tree contents in sorted order using standard Output.
     */
    void printList();

}
