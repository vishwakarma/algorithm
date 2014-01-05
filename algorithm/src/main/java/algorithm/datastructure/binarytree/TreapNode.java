package algorithm.datastructure.binarytree;

/**
 * User: gopi.vishwakarma
 * Date: 04/01/14
 */

import java.util.Random;

/**
 * Domain class of Treap Node
 * @param <T>
 */
public class TreapNode<T extends Comparable> {

    private T key;
    private Long priority;

    private TreapNode left;
    private TreapNode right;

    public TreapNode(T key) {
        this.key = key;
        priority = Long.MAX_VALUE;
    }

    public TreapNode(T key, TreapNode left, TreapNode right) {
        Random random = new Random();

        this.key = key;
        this.priority = random.nextLong();
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public Long getPriority() {
        return priority;
    }

    public TreapNode getLeft() {
        return left;
    }

    public TreapNode getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreapNode)) return false;

        TreapNode node = (TreapNode) o;

        if (key != null ? !key.equals(node.key) : node.key != null) return false;
        if (left != null ? !left.equals(node.left) : node.left != null) return false;
        if (priority != null ? !priority.equals(node.priority) : node.priority != null) return false;
        if (right != null ? !right.equals(node.right) : node.right != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    public void setLeft(TreapNode left) {
        this.left = left;
    }

    public void setRight(TreapNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", priority=" + priority +
                '}';
    }
}
