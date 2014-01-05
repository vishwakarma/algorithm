package algorithm.datastructure.skiplist;

/**
 * User: gopi.vishwakarma
 * Date: 06/01/14
 */
public class SkipNode <T extends Comparable>{
    private T element;
    private SkipNode<T>[] next; //contains current node successor

    public SkipNode(T element, int height) {
        this.element = element;
        this.next = new SkipNode[height+1];
    }

    public T getElement() {
        return element;
    }

    public SkipNode<T>[] getNext() {
        return next;
    }
    public int getHeight(){
        return next.length-1;
    }
}
