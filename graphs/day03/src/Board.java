
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.*;


/**
 * Board definition for the 8 Puzzle challenge
 */
public class Board {

    private int n;
    public int[][] tiles;
    int[] target = {0,0};

    //TODO: DONE?
    // Create a 2D array representing the solved board state
    private int[][] goal = {{}};


    /*
     * Set the global board size and tile state
     */
    public Board(int[][] b) {

        tiles = b;
        n = tiles.length^2;
        setTarget();
    }

    public void setTarget() {
        for (int i = 0; i < size(); i++) {
            for (int p = 0; p < size(); p++) {
                // checks all the rows: i
                // with each colm: p

                if (tiles[i][p] == 0) {
                    this.target[0] = i;
                    this.target[1] = p;
                }
            }
        }
    }

    /*
         * Size of the board
         (equal to 3 for 8 puzzle, 4 for 15 puzzle, 5 for 24 puzzle, etc)
         */
    private int size() {
        return tiles.length;
    }



    /*
     * Sum of the manhattan distances between the tiles and the goal
     */
    public int manhattan(){
        // TODO: DONE?
        int sumDist = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                int num = tiles[i][j];
                if (num != 0) {
                    int expX = (num - 1)/tiles.length;
                    int expY = (num - 1)%tiles.length;
                    sumDist += Math.abs(i - expX) + Math.abs(j - expY);
                }
            }
        }
        return sumDist;
    }

    /*
     * Compare the current state to the goal state
     */
    public boolean isGoal() {
        // for every value in tiles, check that the one to the right is in order
        int[][] d = tiles;
        int count = 1;
        int leng = d.length;
        for(int i = 0; i<leng; i++){
            for(int p = 0; p <leng; p++){
                // checks all the rows: i
                // with each colm: p
                if(i== leng-1 && p == leng-1){
                    if(d[i][p] == 0){
                        return true;
                    }
                }
                if(d[i][p] != count){
                    return false;
                }
                count++;
            }
        }
        return true;
    }

    public int numInversions(int[] arr) {
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i] != 0 && arr[j] != 0 && arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // remove parameters
    public int[] twoDtooneD (int[][] arr) {
        int [] oneDarr = new int [(arr.length * arr.length)];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int u = oneDarr.length;
                oneDarr[(i * arr.length) + j] = arr[i][j];
            }
        }

        return oneDarr;
    }

    /*
     * Returns true if the board is solvable
     * Research how to check this without exploring all states
     */
    public boolean solvable() {
        int [] newTiles = twoDtooneD(tiles);
        int numInv = numInversions(newTiles);

        if (numInv%2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void visualize(int[][] b){
        int s = b.length;
        for(int i = 0; i<b.length; i++){
            for(int p = 0; p <b.length; p++){
                if(p == b.length-1){
                    System.out.println(b[i][p]);
                }else{
                    System.out.print(b[i][p]);
                }
            }
        }
    }


    /*
     * Return all neighboring boards in the state tree
     */
    public Iterable<Board> neighbors() {
            // Need a way to get the target node

            // make a list of boards
            ArrayList<Board> boardsNeigh = new ArrayList<Board>();
            int numNeighbors = 0;//
            int[] movements = {1, -1, 1, -1};
            for (int i = 0; i < 4; i++) {
                int x = target[0];
                int y = target[1];
                if (i < 2) {
                    if (x + movements[i] < size() && x + movements[i] >= 0) {
                        // This is inbounds
                        //FIND NEGHBOR
                        int[][] tempBoard = copyOf(tiles);
                        tempBoard[x][y] = tempBoard[x + movements[i]][y];
                        tempBoard[x + movements[i]][y] = 0;
                        Board Tboard = new Board(tempBoard);
                        boardsNeigh.add(Tboard);
                    }
                } else {
                    if (y + movements[i] < size() && y + movements[i] >= 0) {
                        // This is inbounds
                        int[][] tempBoard = copyOf(tiles);
                        tempBoard[x][y] = tempBoard[x][y + movements[i]];
                        tempBoard[x][y + movements[i]] = 0;
                        Board Tboard = new Board(tempBoard);
                        boardsNeigh.add(Tboard);
                    }
                }

            }
//        // For each board, make a copy, change the one piece, move on
//        Iterable<Board> OtherBoards =  boardsNeigh.iterator();
//

            return boardsNeigh;
        }

    /*
     * Check if this board equals a given board state
     */


    private static int[][] copyOf(int[][] A) {
        int[][] B = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }


    @Override
    public boolean equals(Object x) {
        // Check if the board equals an input Board object            if(x){
//
//            }
        if (x == this) return true;
        if (x == null) return false;
        if (!(x instanceof Board)) return false;
        // Check if the same size
        Board y = (Board) x;
        if (y.tiles.length != n || y.tiles[0].length != n) {
            return false;
        }
        // Check if the same tile configuration
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] != y.tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // DEBUG - Your solution can include whatever output you find useful
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 0, 5}};
        int[][] initState2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        visualize(initState2);
        Board board = new Board(initState);

        System.out.println("Size: " + board.size());
        System.out.println("Solvable: " + board.solvable());
        System.out.println("Manhattan: " + board.manhattan());
        System.out.println("Is goal: " + board.isGoal());
        System.out.println("Neighbors:");
        Iterable<Board> it = board.neighbors();
    }
}
