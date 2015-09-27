package com.michaldabski.stacks.hanoi;

/**
 * Created by Michal on 27/09/2015.
 */
public class HanoiTowerSolver {
    final HanoiTowers hanoiTowers;

    public HanoiTowerSolver(HanoiTowers hanoiTowers) {
        this.hanoiTowers = hanoiTowers;
    }

    public HanoiTowerSolver(int numDisks) {
        this(new HanoiTowers(numDisks));
    }

    /**
     * moves arbitrary number of disks from one tower to another
     * @param numDisks number of disks to move
     * @param from the origin tower
     * @param to destination tower
     * @param using auxiliary tower to aid moving disks
     */
    void move(int numDisks, int from, int to, int using) {
        if (numDisks == 1) {
            hanoiTowers.move(from, to);
        } else {
            move(numDisks - 1, from, using, to);
            hanoiTowers.move(from, to);
            move(numDisks - 1, using, to, from);
        }
    }

    /**
     * Solves Hanoi towers
     * @return number of moves
     */
    public int solve() {
        move(hanoiTowers.numDisks, 0, 2, 1);
        return hanoiTowers.getNumMoves();
    }

    public HanoiTowers getHanoiTowers() {
        return hanoiTowers;
    }
}
