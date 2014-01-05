package algorithm;

import algorithm.datastructure.skiplist.List;
import algorithm.datastructure.skiplist.SkipList;
import algorithm.datastructure.skiplist.SkipNode;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

/**
 * User: gopi.vishwakarma
 * Date: 06/01/14
 */
public class SkipListTest extends TestCase{
    public void testInsertion() throws Exception {
        List skipList = new SkipList();

        Random random = new Random();
        Collection<Integer> numbers = new LinkedList<Integer>();
        for(int i=0;i<5;i++){
            int x = random.nextInt(100); //insertion
            numbers.add(x);
            skipList.insert(x);
        }
        for(Integer integer : numbers){
            SkipNode skipNode = skipList.findElement(integer);
            Assert.assertNotNull("Failed for " + integer, skipNode);
            Integer found = (Integer) skipNode.getElement();
            Assert.assertEquals(integer, found);
        }
    }
    public void testDeletion() throws Exception {
        List skipList = new SkipList();

        Random random = new Random();
        Collection<Integer> numbers = new LinkedList<Integer>();
        for(int i=0;i<5;i++){
            int x = random.nextInt(100); //insertion
            numbers.add(x);
            skipList.insert(x);
        }
        for(Integer integer : numbers){
            SkipNode skipNode = skipList.findElement(integer);
            Assert.assertNotNull("Failed for " + integer, skipNode);

            skipList.remove(integer);
            skipNode = skipList.findElement(integer);
            Assert.assertNull("Failed for " + integer, skipNode);

        }
    }

}
