package main.java;

/**
 * User: gopi.vishwakarma
 * Date: 01/01/14
 */

/**
 * The problem is to count all the possible paths from top left to bottom right of a mXn matrix
 * with the constraints that from each cell you can either move only to right or down
 */
public class PossiblePathInMatrix {

    public static void main(String args[]){

        int numberOfPathsUsingRecursion = solveUsingRecursion(3,3);
        int numberOfPathsUsingDP = solveUsingDP(3,3);

        System.out.println(numberOfPathsUsingRecursion);
        System.out.println(numberOfPathsUsingDP);

    }

    /**
     * Complexity exponential using recursion
     */
    private static int solveUsingRecursion(int row, int col) {
        if(row == 1 || col == 1){
            return 1;
        }
        return solveUsingRecursion(row-1, col) + solveUsingRecursion(row, col-1);
    }

    /**
     * O(row*col) using dynamic programming
     * @param row
     * @param col
     * @return
     */
    private static int solveUsingDP(int row, int col){
        int dp[][] = new int[row][col];

        for(int i=0;i<row;i++){
            dp[0][i] = 1;
        }

        for(int j=0;j<row;j++){
            dp[j][0] = 1;
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[row-1][col-1];
    }
}
