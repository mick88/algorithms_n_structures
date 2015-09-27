package com.michaldabski.stacks.tests;

import com.michaldabski.stacks.HanoiTowers;
import junit.framework.TestCase;

/**
 * Created by Michal on 27/09/2015.
 */
public class HanoiTowersTest extends TestCase {

    HanoiTowers hanoiTowers;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        hanoiTowers = new HanoiTowers(3);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        hanoiTowers = null;
    }

    public void testInitFirstTower() throws Exception {
        // should be initialized by constructor
        assertEquals(3, hanoiTowers.numDisks);
        assertEquals(3, hanoiTowers.towers[0].size());
        assertEquals(0, hanoiTowers.towers[1].size());
        assertEquals(0, hanoiTowers.towers[2].size());
        assertFalse(hanoiTowers.isSolved());
    }

    public void testMove() throws Exception {
        assertEquals(3, hanoiTowers.towers[0].size());
        assertEquals(0, hanoiTowers.towers[1].size());
        assertEquals(0, hanoiTowers.towers[2].size());
        assertEquals(0, hanoiTowers.getNumMoves());

        hanoiTowers.move(0, 1);

        assertEquals(2, hanoiTowers.towers[0].size());
        assertEquals(1, hanoiTowers.towers[1].size());
        assertEquals(0, hanoiTowers.towers[2].size());
        assertEquals(1, hanoiTowers.getNumMoves());
    }

    public void testIsSolved() throws Exception {
        hanoiTowers.towers[0].clear();
        for (int i = 0; i < 3; i++) {
            hanoiTowers.towers[2].push(4 - i);
        }
        assertTrue(hanoiTowers.isSolved());
    }
}