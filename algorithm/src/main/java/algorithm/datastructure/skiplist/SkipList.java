package algorithm.datastructure.skiplist;

import java.util.Random;

/**
 * User: gopi.vishwakarma
 * Date: 06/01/14
 */
public class SkipList implements List{

    private static int height;
    private static int elements;

    public SkipList() {

    }

    /**
     * Insert into the list.
     *
     * @param element the item to insert.
     */
    public void insert(Comparable element) {
        SkipNode<Comparable> node = sentinel;
        int r = height;
        while(r >= 0){
            while(node.getNext()[r] != null && element.compareTo(node.getNext()[r].getElement()) < 0){
                node = node.getNext()[r];
            }
            stack[r--] = node;
        }
        SkipNode<Comparable> candidate = new SkipNode<Comparable>(element, getRandomHeight());

        while(height <=candidate.getHeight()){
            stack[++height] = sentinel;
        }

        for(int i=0;i<=candidate.getHeight();i++){
            candidate.getNext()[i] = stack[i].getNext()[i];
            stack[i].getNext()[i] = candidate;
        }
        elements++;
    }

    /**
     * Remove from the list, does nothing if x is not found.
     *
     * @param element the item to remove.
     */
    public void remove(Comparable element) {
        SkipNode<Comparable> node = sentinel;
        boolean removed = false;
        int r = height;
        while(r >= 0){
            while(node.getNext()[r] != null && element.compareTo(node.getNext()[r].getElement()) < 0){
                node = node.getNext()[r];
            }
            if(node.getNext()[r] != null && element.compareTo(node.getNext()[r].getElement()) == 0){
                removed = true;
                node.getNext()[r] = node.getNext()[r].getNext()[r];
                if(node == sentinel && node.getNext()[r] == null){
                    height--;
                }
            }
            r--;
        }
        if(removed) elements--;
    }


    /**
     * Find an item in the list.
     *
     * @param elementToSearch the item to search for.
     * @return the matching item, or null if not found.
     */
    public SkipNode findElement(Comparable elementToSearch) {
        SkipNode<Comparable> node = sentinel;
        int r = height;
        while(r >= 0){
            while(node.getNext()[r]!= null && elementToSearch.compareTo(node.getNext()[r].getElement()) < 0){
                node = node.getNext()[r];
            }
            if(node.getNext()[r] != null && elementToSearch.compareTo(node.getNext()[r].getElement()) == 0){
                return node.getNext()[r];
            }
            r--;
        }

        return null;
    }

    public void printList() {
        SkipNode<Comparable> node = sentinel;
        while(node.getNext()[0]!= null){
            node = node.getNext()[0];
            System.out.print(node.getElement() + " ");
        }
        System.out.println("--- List Over ---");
    }


    /**
     * number of trailing ones
     * @return
     */
    private int getRandomHeight(){
        Random random = new Random();
        int number = random.nextInt();
        int height = 0;
        while((number & 1) != 0){
            height++;
            number >>= 1;
        }
        return height;
    }

    private static SkipNode sentinel;
    private static SkipNode [] stack ;
    static {
        sentinel = new SkipNode(Integer.MIN_VALUE,34);
        height = 0;
        elements = 0;
        stack = new SkipNode[34];
    }
}
