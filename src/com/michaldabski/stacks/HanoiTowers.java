package com.michaldabski.stacks;

/**
 * Created by Michal on 27/09/2015.
 *
 * Represents state of Hanoi Tower problem
 */
public class HanoiTowers {
    public final HanoiStack[] towers;
    public final int numDisks;
    int numMoves = 0;

    public HanoiTowers(int numDisks) {
        if (numDisks <= 0)
            throw new IllegalArgumentException("Invalid number of disks: " + numDisks);
        this.towers = new HanoiStack[3];
        for (int i = 0; i < towers.length; i++) {
            towers[i] = new HanoiStack();
        }
        this.numDisks = numDisks;
        initFirstTower();
    }

    /**
     * Place numDisks on the first tower
     */
    void initFirstTower() {
        for (int i = 0; i < numDisks; i++) {
            towers[0].push(numDisks - i + 1);
        }
    }

    /**
     * Move disk from one tower to another
     *
     * @param from tower id 0 to 2
     * @param to   tower id 0 to 2
     */
    public void move(int from, int to) {
        // Peek the top element without popping it, to remain in
        // consistent state if push throws an exception
        towers[to].push(towers[from].peek());
        towers[from].pop();
        numMoves++;
    }

    public boolean isSolved() {
        // problem is considered solved if all but the last tower is empty
        return towers[0].empty() && towers[1].empty() && towers[2].size() == numDisks;
    }

    public int getNumMoves() {
        return numMoves;
    }
}
