/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to find a path to the goal
 */

import java.util.*;

public class Solver {

    public int minMoves = -1;
    private State solutionState;
    private boolean solved = false;
    //private State root;

    /**
     * State class to make the cost calculations simple
     * This class holds a board state and all of its attributes
     */
    private class State {
        // Each state needs to keep track of its cost and the previous state
        private Board board;
        private int moves; // equal to g-cost in A*
        public int cost; // equal to f-cost in A*
        private State prev;



        public State(Board board, int moves, State prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;

            // TODO
            cost = 0;
        }

        @Override
        public boolean equals(Object s) {
            if (s == this) return true;
            if (s == null) return false;
            if (!(s instanceof State)) return false;
            return ((State) s).board.equals(this.board);
        }

        public int compareTo(State s){
            return s.moves - moves; // SHOULD THIS BE MOVEs - S.MOVES?
        }

    }




    /*
     * Return the root state of a given state
     */
    private State root(State state) {
        return null;//this.root;
    }

    /*
     * A* Solver
     * Find a solution to the initial board using A* to generate the state tree
     * and a identify the shortest path to the the goal state
     */
    public Solver(Board initial) {
        State initialState = new State(initial, 0, null );
        if(isSolvable(initial)){
            ArrayList<State> open = new ArrayList<State>();
            ArrayList<State> closed = new ArrayList<State>();
            open.add(initialState);

            while(open.size()> 0){
                State curr = open.remove(0);
                for(Board neighbor : curr.board.neighbors()){
                    if(neighbor.isGoal()){
                        //  This is the solution
                        return;
                    }else{
                        int mDist = neighbor.manhattan();
                        boolean ignore = false;
                        for(int b = 0; b < open.size(); b++){
                            if(neighbor.equals(open.get(b)) && open.get(b).board.manhattan() < mDist){
                                //Ignore
                                ignore = true;
                            }
                        }
                        for(int b = 0; b < closed.size(); b++){
                            if(neighbor.equals(closed.get(b)) && closed.get(b).board.manhattan() < mDist){
                                //Ignore
                                ignore = true;
                            }
                        }
                        if(!ignore){
                            open.add(new State(neighbor,curr.moves+1, curr);
                        }

                    }
                }

            }

        }
    }

    /*
     * Is the input board a solvable state
     * Research how to check this without exploring all states
     */
    public boolean isSolvable(Board initial) {
        if(initial.solvable()){
            return true;
        }else{
            return false;
        }

    }

    /*
     * Return the sequence of boards in a shortest solution, null if unsolvable
     */
    public Iterable<Board> solution() {
        // TODO: Your code here

        return null;
    }

    public State find(Iterable<State> iter, Board b) {
        for (State s : iter) {
            if (s.board.equals(b)) {
                return s;
            }
        }
        return null;
    }

    /*
     * Debugging space
     */
    public static void main(String[] args) {
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board initial = new Board(initState);

        Solver solver = new Solver(initial);

    }


}
