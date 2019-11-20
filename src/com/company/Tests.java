package com.company;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    Main main = new Main();

    @org.junit.jupiter.api.Test
    void removeDuplicates() {
        int[] x = new int[]{0,1,0,2,3,4,0,0,0,5,6,7,0,8,0};
        main.removeDuplicates(x,3);
    }

    @org.junit.jupiter.api.Test
    void containsDuplicate() {
    }

    @org.junit.jupiter.api.Test
    void testContainsDuplicate() {
    }

    @org.junit.jupiter.api.Test
    void testContainsDuplicate1() {
    }

    @org.junit.jupiter.api.Test
    void intersect() {
    }

    @org.junit.jupiter.api.Test
    void plusOne() {
    }

    @org.junit.jupiter.api.Test
    void moveZeroes() {
    }

    @org.junit.jupiter.api.Test
    void prime() {
    }

    @org.junit.jupiter.api.Test
    void twoSum() {
    }

    @org.junit.jupiter.api.Test
    void isValidSudoku() {
    }

    @org.junit.jupiter.api.Test
    void rotate() {
    }

    @org.junit.jupiter.api.Test
    void productExceptSelf() {
    }

    @org.junit.jupiter.api.Test
    void productExceptSelf2() {
    }

    @org.junit.jupiter.api.Test
    void productExceptSelfRek() {
    }

    @org.junit.jupiter.api.Test
    void productExceptSelf3() {
    }

    @org.junit.jupiter.api.Test
    void spiralOrder() {
    }

    @org.junit.jupiter.api.Test
    void spiralOrder2() {
    }

    @org.junit.jupiter.api.Test
    void generateMatrix() {
    }

    @org.junit.jupiter.api.Test
    void duplicateZeros() {
    }

    @org.junit.jupiter.api.Test
    void maxAreaOfIsland() {
    }

    @org.junit.jupiter.api.Test
    void summeArray() {
    }

    @org.junit.jupiter.api.Test
    void maxPoints2() {
    }

    @org.junit.jupiter.api.Test
    void maxPoints() {
        Assertions.assertEquals(main.maxPoints(new int[][]{{-5, 1}, {-1, 10}, {0, 2},{1,20},{5, 3}}), 3);
        Assertions.assertEquals(main.maxPoints(new int[][]{{0,-1},{0,3},{0,-4},{0,-2},{0,-4},{0,0},{0,0},{0,1},{0,-2},{0,4}}), 10);
        Assertions.assertEquals(main.maxPoints(new int[][]{{-54,-297},{-36,-222},{30,53},{-36,-222},{6,-47},{48,128},{24,28},{48,128},{-12,-122}}), 9);
        Assertions.assertEquals(main.maxPoints(new int[][]{{0, 0}, {1, 1}, {2, 2}}), 3);
        Assertions.assertEquals(main.maxPoints(new int[][]{{0, 1}, {0, -14}, {0, 1}, {0, 1}, {0, 2}, {0, 56}, {1, 3}, {2, 5}, {-1, -1}, {-2, -3}}), 7);
        Assertions.assertEquals(main.maxPoints(new int[][]{{3, 1}, {12, 3}, {3, 1}, {-6, -1}}), 4);
        Assertions.assertEquals(main.maxPoints(new int[][]{{0, 0}, {1, 1}, {1, -1}}), 2);
        Assertions.assertEquals(main.maxPoints(new int[][]{{0,0},{94911151,94911150},{94911152,94911151}}), 2);
        Assertions.assertEquals(main.maxPoints(new int[][]{{4, 0}, {4, -1}, {4, 5}}), 3);
        Assertions.assertEquals(main.maxPoints(new int[][]{{0, 0}, {1, 65536}, {65536, 0}}), 2);
        Assertions.assertEquals(main.maxPoints(new int[][]{{0, 0}, {0, 0}, {1, 1}, {1, 1}}), 4);
        Assertions.assertEquals(main.maxPoints(new int[][]{{0, 1}, {0, 1}, {0, 1}, {0, 1}, {0, 2}}), 5);
        Assertions.assertEquals(main.maxPoints(new int[][]{{4, 30}, {5, 25}, {6, 20}, {7, 15}}), 4);
        Assertions.assertEquals(main.maxPoints(new int[][]{{0, 0}, {1, 1}, {2, 2}, {-2, 2}, {-1, 1}, {5, 5}, {6, 6}, {0, 2}, {1, 4}, {2, 6}, {3, 8}, {4, 10}, {5, 12}, {6, 14}}), 7);
        Assertions.assertEquals(main.maxPoints(new int[][]{{-54, -297}, {-36, -222}, {3, -2}, {30, 53}, {-5, 1}, {-36, -222}, {0, 2}, {1, 3}, {6, -47}, {0, 4}}), 5);
        Assertions.assertEquals(main.maxPoints(new int[][]{{-54, -297}, {-36, -222}, {3, -2}, {30, 53}, {-5, 1}, {-36, -222}, {0, 2}, {1, 3}, {6, -47}, {0, 4}, {2, 3}, {5, 0}, {48, 128}}), 6);
        Assertions.assertEquals(main.maxPoints(new int[][]{{-54, -297}, {-36, -222}, {3, -2}, {30, 53}, {-5, 1}, {-36, -222}, {0, 2}, {1, 3}, {6, -47}, {0, 4}, {2, 3}, {5, 0}, {48, 128}, {24, 28}}), 7);
        Assertions.assertEquals(main.maxPoints(new int[][]{{-54, -297}, {-36, -222}, {3, -2}, {30, 53}, {-5, 1}, {-36, -222}, {0, 2}, {1, 3}, {6, -47}, {0, 4}, {2, 3}, {5, 0}, {48, 128}, {24, 28}, {0, -5}, {48, 128}}), 8);
        Assertions.assertEquals(main.maxPoints(new int[][]{{-54, -297}, {-36, -222}, {3, -2}, {30, 53}, {-5, 1}, {-36, -222}, {0, 2}, {1, 3}, {6, -47}, {0, 4}, {2, 3}, {5, 0}, {48, 128}, {24, 28}, {0, -5}, {48, 128}, {-12, -122}}), 9);
        Assertions.assertEquals(main.maxPoints(new int[][]{{-54, -297}, {-36, -222}, {3, -2}, {30, 53}, {-5, 1}, {-36, -222}, {0, 2}, {1, 3}, {6, -47}, {0, 4}, {2, 3}, {5, 0}, {48, 128}, {24, 28}, {0, -5}, {48, 128}, {-12, -122}, {-54, -297}, {-42, -247}, {-5, 0}, {2, 4}, {0, 0}}), 11);
        Assertions.assertEquals(main.maxPoints(new int[][]{{-54,-297},{-36,-222},{3,-2},{30,53},{-5,1},{-36,-222},{0,2},{1,3},{6,-47},{0,4},{2,3},{5,0},{48,128},{24,28},{0,-5},{48,128},{-12,-122},{-54,-297},{-42,-247},{-5,0},{2,4},{0,0},{54,153},{-30,-197},{4,5},{4,3},{-42,-247},{6,-47},{-60,-322},{-4,-2},{-18,-147},{6,-47},{60,178},{30,53},{-5,3},{-42,-247},{2,-2},{12,-22},{24,28},{0,-72},{3,-4},{-60,-322},{48,128},{0,-72},{-5,3},{5,5},{-24,-172},{-48,-272},{36,78},{-3,3}}),30);
    }
}