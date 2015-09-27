package com.michaldabski.stacks;

import junit.framework.TestCase;

/**
 * Created by Michal on 27/09/2015.
 */
public class HanoiTowerSolverTest extends TestCase {

    private static HanoiTowers testSolverForNTowers(int numDisks) {
        final HanoiTowerSolver solver = new HanoiTowerSolver(numDisks);

        final int moves = solver.solve();

        assertTrue("Towers are not solved for " + numDisks + " Disks", solver.getHanoiTowers().isSolved());
        System.out.println(String.format("Solved Hanoi Towers with %d disks in %d moves", numDisks, moves));
        return solver.getHanoiTowers();
    }

    public void testSolve3() throws Exception {
        testSolverForNTowers(3);
    }

    public void testSolve7() throws Exception {
        testSolverForNTowers(7);
    }

    public void testSolve1() throws Exception {
        HanoiTowers towers = testSolverForNTowers(1);
        // 1 disk should be solved in 1 move
        assertEquals(1, towers.getNumMoves());
    }

    public void testSolve10() throws Exception {
        testSolverForNTowers(10);
    }

    public void testSolve15() throws Exception {
        testSolverForNTowers(15);
    }

    public void testSolve20() throws Exception {
        testSolverForNTowers(20);
    }

}