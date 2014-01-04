package main.java.variousbinarysearchtree.randomizedBST;

import main.java.variousbinarysearchtree.BinarySearchTree;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * User: gopi.vishwakarma
 * Date: 05/01/14
 */
public class Main {
    public static void main(String [] args){
        BinarySearchTree bst = new RandomizedBinarySearchTree();

        Random random = new Random();
        Collection<Integer> numbers = new LinkedList<Integer>();
        for(int i=0;i<10;i++){
            int x = random.nextInt(100); //insertion
            numbers.add(x);
            bst.insert(x);
        }

        // findElement
        for(Integer integer : numbers){
            Integer found = (Integer) bst.findElement(integer);
            if(found != integer){
                System.out.println("Failed for :"+integer);
            }
        }
//
//        //Delete and search
//        for(Integer integer : numbers){
//            bst.remove(integer);
//            Integer found = (Integer) bst.findElement(integer);
//            if(found == integer){
//                System.out.println("Deletion Failed for :"+integer);
//            }
//        }

        Integer min = Collections.min(numbers);
        Integer max = Collections.max(numbers);

        Integer foundMin = (Integer) bst.getMinimumElement();
        Integer foundMax = (Integer) bst.getMaximumElement();

        if(foundMin != min){
            System.out.println("Expected "+min + " .. actual "+foundMin);
        }
        if(foundMax != max){
            System.out.println("Expected "+max + " .. actual "+foundMax);
        }



    }
}
