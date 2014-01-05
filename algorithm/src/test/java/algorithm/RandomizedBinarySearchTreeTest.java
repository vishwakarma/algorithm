package algorithm;

import algorithm.binarytree.BinaryTree;
import algorithm.binarytree.RandomizedBinarySearchTree;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * User: gopi.vishwakarma
 * Date: 05/01/14
 */
public class RandomizedBinarySearchTreeTest extends TestCase {

    public void testInsertion() throws Exception {
        BinaryTree bst = new RandomizedBinarySearchTree();

        Random random = new Random();
        Collection<Integer> numbers = new LinkedList<Integer>();
        for(int i=0;i<100;i++){
            int x = random.nextInt(100); //insertion
            numbers.add(x);
            bst.insert(x);
        }

        for(Integer integer : numbers){
            Integer found = (Integer) bst.findElement(integer);
            Assert.assertEquals(integer, found);
        }
    }

    public void testDeletion() throws Exception {
        BinaryTree bst = new RandomizedBinarySearchTree();

        Random random = new Random();
        Collection<Integer> numbers = new LinkedList<Integer>();
        for(int i=0;i<100;i++){
            int x = random.nextInt(100); //insertion
            numbers.add(x);
            bst.insert(x);
        }

        for(Integer integer : numbers){
            bst.remove(integer);
            Integer found = (Integer) bst.findElement(integer);
            Assert.assertEquals(null, found);
        }
    }
    public void testFindMinimumAndMaximum() throws Exception{
        BinaryTree bst = new RandomizedBinarySearchTree();

        Random random = new Random();
        Collection<Integer> numbers = new LinkedList<Integer>();
        for(int i=0;i<100;i++){
            int x = random.nextInt(100); //insertion
            numbers.add(x);
            bst.insert(x);
        }
        Integer foundMin = (Integer) bst.getMinimumElement();
        Assert.assertEquals(Collections.min(numbers), foundMin);

        Integer foundMax = (Integer) bst.getMaximumElement();
        Assert.assertEquals(Collections.max(numbers), foundMax);

    }

}
