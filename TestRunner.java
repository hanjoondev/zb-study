import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import acmicpc.*;
import kickstart.*;
import leetcode.*;
import programmers.*;

class Benchmark {
    void L00007Benchmark() {
        L00007 test = new L00007();
        int ITERATIONS = 100_000;
        ArrayList<List<Integer>> testCases = new ArrayList<>() {{
            add(Arrays.asList(123, 321));
            add(Arrays.asList(-123, -321));
            add(Arrays.asList(120, 21));
        }};
        for (List<Integer> testCase : testCases) {
            int num = testCase.get(0), expected = testCase.get(1);
            long start, end, total = 0;
            for (int i = 0; i < ITERATIONS; i++) {
                start = System.nanoTime();
                test.reverse(num);
                end = System.nanoTime();
                total += end - start;
            }
            System.out.printf("reverse(%d) returned %d in %sms (%s iteration%s)%s\n",
                    num, test.reverse(num),
                    new DecimalFormat("#,###.00").format((double) total / 1000000),
                    new DecimalFormat("#,###").format(ITERATIONS), ITERATIONS > 1 ? "s" : "",
                    test.reverse(num) == expected ? " (correct)" : " (FAIL)");
        }
    }

    public void run() {
        L00007Benchmark();
    }
}

public class TestRunner {
    @org.junit.jupiter.api.Test
    void L00007Test(Boolean verbose) {
        L00007 test = new L00007();
        Assertions.assertEquals(321, test.reverse(123));
        Assertions.assertEquals(-321, test.reverse(-123));
        Assertions.assertEquals(21, test.reverse(120));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00011Test(Boolean verbose) {
        L00011 test = new L00011();
        Assertions.assertEquals(49, test.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        Assertions.assertEquals(1, test.maxArea(new int[] { 1, 1 }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00012Test(Boolean verbose) {
        L00012 test = new L00012();
        Assertions.assertEquals("III", test.intToRoman(3));
        Assertions.assertEquals("LVIII", test.intToRoman(58));
        Assertions.assertEquals("MCMXCIV", test.intToRoman(1994));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00013Test(Boolean verbose) {
        L00013 test = new L00013();
        Assertions.assertEquals(3, test.romanToInt("III"));
        Assertions.assertEquals(58, test.romanToInt("LVIII"));
        Assertions.assertEquals(1994, test.romanToInt("MCMXCIV"));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00020Test(Boolean verbose) {
        L00020 test = new L00020();
        Assertions.assertTrue(test.isValid("()"));
        Assertions.assertTrue(test.isValid("()[]{}"));
        Assertions.assertFalse(test.isValid("(]"));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00026Test(Boolean verbose) {
        L00026 test = new L00026();
        Assertions.assertEquals(2, test.removeDuplicates(new int[] { 1, 1, 2 }));
        Assertions.assertEquals(5, test.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00042Test(Boolean verbose) {
        L00042 test = new L00042();
        Assertions.assertEquals(6, test.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
        Assertions.assertEquals(9, test.trap(new int[] { 4, 2, 0, 3, 2, 5 }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00049Test(Boolean verbose) {
        L00049 test = new L00049();
        List<List<String>> expected = new ArrayList<>() {{
            add(Arrays.asList("bat"));
            add(Arrays.asList("nat", "tan"));
            add(Arrays.asList("ate", "eat", "tea"));
        }};
        List<List<String>> actual = test.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
        Assertions.assertTrue(expected.size() == actual.size());
        Collections.sort(actual, (a, b) -> a.size() - b.size());
        Collections.sort(actual, (a, b) -> a.size() - b.size());
        for (int i = 0; i < expected.size(); i++)
            Assertions.assertTrue(expected.get(i).size() == actual.get(i).size()
                                  && expected.get(i).containsAll(actual.get(i))
                                  && actual.get(i).containsAll(expected.get(i)));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00054Test(Boolean verbose) {
        L00054 test = new L00054();
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), test.spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), test.spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00056Test(Boolean verbose) {
        L00056 test = new L00056();
        Assertions.assertArrayEquals(new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } }, test.merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, {15, 18} }));
        Assertions.assertArrayEquals(new int[][] { { 1, 5 } }, test.merge(new int[][] { { 1, 4 }, { 4, 5 } }));
        Assertions.assertArrayEquals(new int[][] { { 0, 0 }, { 1, 4 } }, test.merge(new int[][] { { 1, 4 }, { 0, 0 } }));
        Assertions.assertArrayEquals(new int[][] { { 1, 10 } }, test.merge(new int[][] { {2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10} }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00073Test(Boolean verbose) {
        L00073 test = new L00073();
        int[][] matrix = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int[][] expected = new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
        test.setZeroes(matrix);
        Assertions.assertArrayEquals(expected, matrix);
        matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        expected = new int[][] { { 0, 0, 0, 0 }, { 0, 4, 5, 0 }, { 0, 3, 1, 0 } };
        test.setZeroes(matrix);
        Assertions.assertArrayEquals(expected, matrix);
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00075Test(Boolean verbose) {
        L00075 test = new L00075();
        int[] before = new int[] { 2, 0, 2, 1, 1, 0 };
        test.sortColors(before);
        Assertions.assertArrayEquals(new int[] { 0, 0, 1, 1, 2, 2 }, before);
        before = new int[] { 2, 0, 1 };
        test.sortColors(before);
        Assertions.assertArrayEquals(new int[] { 0, 1, 2 }, before);
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00079Test(Boolean verbose) {
        L00079 test = new L00079();
        Assertions.assertTrue(test.exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCCED"));
        Assertions.assertTrue(test.exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE"));
        Assertions.assertFalse(test.exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB"));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00096Test(Boolean verbose) {
        L00096 test = new L00096();
        Assertions.assertEquals(5, test.numTrees(3));
        Assertions.assertEquals(1, test.numTrees(1));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00118Test(Boolean verbose) {
        L00118 test = new L00118();
        Assertions.assertEquals(Arrays.asList(
                List.of(1),
            Arrays.asList(1, 1), 
            Arrays.asList(1, 2, 1), 
            Arrays.asList(1, 3, 3, 1), 
            Arrays.asList(1, 4, 6, 4, 1)), test.generate(5));
        Assertions.assertEquals(List.of(List.of(1)), test.generate(1));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00130Test(Boolean verbose) {
        L00130 test = new L00130();
        char[][] board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
        char[][] expected = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'X', 'X' } };
        test.solve(board);
        Assertions.assertArrayEquals(expected, board);

        board = new char[][] { { 'X' } };
        expected = new char[][] { { 'X' } };
        test.solve(board);
        Assertions.assertArrayEquals(expected, board);
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00135Test(Boolean verbose) {
        L00135 test = new L00135();
        Assertions.assertEquals(5, test.candy(new int[] { 1, 0, 2 }));
        Assertions.assertEquals(4, test.candy(new int[] { 1, 2, 2 }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00202Test(Boolean verbose) {
        L00202 test = new L00202();
        Assertions.assertTrue(test.isHappy(19));
        Assertions.assertFalse(test.isHappy(2));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00442Test(Boolean verbose) {
        L00442 test = new L00442();
        Assertions.assertTrue(
            Arrays.asList(2, 3).size() == test.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }).size()
            && Arrays.asList(2, 3).containsAll(test.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }))
            && test.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }).containsAll(Arrays.asList(2, 3))
        );
        Assertions.assertEquals(List.of(1), test.findDuplicates(new int[] { 1, 1, 2 }));
        Assertions.assertEquals(List.of(), test.findDuplicates(new int[] { 1 }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00463Test(Boolean verbose) {
        L00463 test = new L00463();
        Assertions.assertEquals(16, test.islandPerimeter(new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } }));
        Assertions.assertEquals(4, test.islandPerimeter(new int[][] { { 1 } }));
        Assertions.assertEquals(4, test.islandPerimeter(new int[][] { { 1, 0 } }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00567Test(Boolean verbose) {
        L00567 test = new L00567();
        Assertions.assertTrue(test.checkInclusion("ab", "eidbaooo"));
        Assertions.assertFalse(test.checkInclusion("ab", "eidboaoo"));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00640Test(Boolean verbose) {
        L00640 test = new L00640();
        Assertions.assertEquals("x=2", test.solveEquation("x+5-3+x=6+x-2"));
        Assertions.assertEquals("Infinite solutions", test.solveEquation("x=x"));
        Assertions.assertEquals("x=0", test.solveEquation("2x=x"));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00658Test(Boolean verbose) {
        L00658 test = new L00658();
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4), test.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4), test.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00721Test(Boolean verbose) {
        L00721 test = new L00721();
        List<List<String>> expected = new ArrayList<>() {{
            add(Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"));
            add(Arrays.asList("Mary", "mary@mail.com"));
            add(Arrays.asList("John", "johnnybravo@mail.com"));
        }};
        List<List<String>> actual = test.accountsMerge(Arrays.asList(
            Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"), 
            Arrays.asList("Mary", "mary@mail.com"), 
            Arrays.asList("John", "johnnybravo@mail.com"))
        );
        Assertions.assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
        expected = new ArrayList<>() {{
            add(Arrays.asList("Ethan", "Ethan0@m.co", "Ethan4@m.co", "Ethan5@m.co"));
            add(Arrays.asList("Gabe", "Gabe0@m.co", "Gabe1@m.co", "Gabe3@m.co"));
            add(Arrays.asList("Hanzo", "Hanzo0@m.co", "Hanzo1@m.co", "Hanzo3@m.co"));
            add(Arrays.asList("Kevin", "Kevin0@m.co", "Kevin3@m.co", "Kevin5@m.co"));
            add(Arrays.asList("Fern", "Fern0@m.co", "Fern1@m.co", "Fern5@m.co"));
        }};
        actual = test.accountsMerge(Arrays.asList(
            Arrays.asList("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"),
            Arrays.asList("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"),
            Arrays.asList("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"),
            Arrays.asList("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"),
            Arrays.asList("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co"))
        );
        Assertions.assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L00752Test(Boolean verbose) {
        L00752 test = new L00752();
        Assertions.assertEquals(6, test.openLock(new String[] { "0201", "0101", "0102", "1212", "2002" }, "0202"));
        Assertions.assertEquals(1, test.openLock(new String[] { "8888" }, "0009"));
        Assertions.assertEquals(-1, test.openLock(new String[] { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" }, "8888"));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L01023Test(Boolean verbose) {
        L01023 test = new L01023();
        Assertions.assertEquals(Arrays.asList(true, false, true, true, false), 
            test.camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, "FB"));
        Assertions.assertEquals(Arrays.asList(true, false, true, false, false), 
            test.camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, "FoBa"));
        Assertions.assertEquals(Arrays.asList(false, true, false, false, false), 
            test.camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, "FoBaT"));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L01053Test(Boolean verbose) {
        L01053 test = new L01053();
        Assertions.assertArrayEquals(new int[] { 3, 1, 2 }, test.prevPermOpt1(new int[] { 3, 2, 1 }));
        Assertions.assertArrayEquals(new int[] { 1, 1, 5 }, test.prevPermOpt1(new int[] { 1, 1, 5 }));
        Assertions.assertArrayEquals(new int[] { 1, 7, 4, 6, 9 }, test.prevPermOpt1(new int[] { 1, 9, 4, 6, 7 }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L01354Test(Boolean verbose) {
        L01354 test = new L01354();
        Assertions.assertEquals(true, test.isPossible(new int[] { 9, 3, 5 }));
        Assertions.assertEquals(false, test.isPossible(new int[] { 1, 1, 1, 2 }));
        Assertions.assertEquals(true, test.isPossible(new int[] { 8, 5 }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L01383Test(Boolean verbose) {
        L01383 test = new L01383();
        Assertions.assertEquals(60, test.maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 2));
        Assertions.assertEquals(68, test.maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 3));
        Assertions.assertEquals(72, test.maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 4));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L01654Test(Boolean verbose) {
        L01654 test = new L01654();
        Assertions.assertEquals(3, test.minimumJumps(new int[] { 14, 4, 18, 1, 15 }, 3, 15, 9));
        Assertions.assertEquals(-1, test.minimumJumps(new int[] { 8, 3, 16, 6, 12, 20 }, 15, 13, -11));
        Assertions.assertEquals(2, test.minimumJumps(new int[] { 1, 6, 2, 14, 5, 17, 4 }, 16, 9, 7));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L01851Test(Boolean verbose) {
        L01851 test = new L01851();
        Assertions.assertArrayEquals(new int[] { 3, 3, 1, 4 },
                test.minInterval(new int[][] { { 1, 4 }, { 2, 4 }, { 3, 6 }, { 4,4 } },
                                 new int[] { 2, 3, 4, 5 }));
        Assertions.assertArrayEquals(new int[] { 2, -1, 4, 6 },
                    test.minInterval(new int[][] { { 2, 3 }, { 2, 5 }, { 1, 8 }, { 20,25 } },
                        new int[] { 2, 9, 5, 22 }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L01922Test(Boolean verbose) {
        L01922 test = new L01922();
        Assertions.assertEquals(5, test.countGoodNumbers(1L));
        Assertions.assertEquals(400, test.countGoodNumbers(4L));
        Assertions.assertEquals(564908303, test.countGoodNumbers(50L));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void L01942Test(Boolean verbose) {
        L01942 test = new L01942();
        Assertions.assertEquals(1, test.smallestChair(
                new int[][] { { 1, 4 }, { 2, 3 }, { 4, 6 } }, 1));
        Assertions.assertEquals(2, test.smallestChair(
                new int[][] { { 3, 10 }, { 1, 5 }, { 2, 6 } }, 0));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void P01878Test(Boolean verbose) {
        P01878 test = new P01878();
        Assertions.assertArrayEquals(new int[] { 1, 10 }, 
            test.solution(new int[][] { { 1, 4 }, { 3, 4 }, { 3, 10 } }));
        Assertions.assertArrayEquals(new int[] { 2, 1 }, 
            test.solution(new int[][] { { 1, 1 }, { 2, 2 }, { 1, 2 } }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void P42576Test(Boolean verbose) {
        P42576 test = new P42576();
        Assertions.assertEquals("leo",
            test.solution(new String[] { "leo", "kiki", "eden" }, 
                          new String[] { "eden", "kiki"}));
        Assertions.assertEquals("vinko",
            test.solution(new String[] { "marina", "josipa", "nikola", "vinko", "filipa" }, 
                          new String[] { "josipa", "filipa", "marina", "nikola" }));
        Assertions.assertEquals("mislav",
            test.solution(new String[] { "mislav", "stanko", "mislav", "ana" },
                          new String[] { "stanko", "ana", "mislav" }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void P42577Test(Boolean verbose) {
        P42577 test = new P42577();
        Assertions.assertEquals(false,
            test.solution(new String[] { "119", "97674223", "1195524421" }));
        Assertions.assertEquals(true,
            test.solution(new String[] { "123", "456", "789" }));
        Assertions.assertEquals(false,
            test.solution(new String[] { "12", "123", "1235", "567", "88" }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void P42579Test(Boolean verbose) {
        P42579 test = new P42579();
        Assertions.assertArrayEquals(new int[] { 4, 1, 3, 0 }, 
            test.solution(new String[] { "classic", "pop", "classic", "classic", "pop" },
                          new int[] { 500, 600, 150, 800, 2500 }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void P42892Test(Boolean verbose) {
        P42892 test = new P42892();
        Assertions.assertArrayEquals(new int[][] { { 7, 4, 6, 9, 1, 8, 5, 2, 3 },
                                                   { 9, 6, 5, 8, 1, 4, 3, 2, 7 } },
            test.solution(new int[][] { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, 
                                        { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void P42587Test(Boolean verbose) {
        P42587 test = new P42587();
        Assertions.assertEquals(1, test.solution(new int[] { 2, 1, 3, 2 }, 2));
        Assertions.assertEquals(5, test.solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }
    
    void P43236Test(Boolean verbose) {
        P43236 test = new P43236();
        Assertions.assertEquals(4, test.solution(25, new int[] { 2, 4, 11, 21, 17 }, 2));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void P60057Test(Boolean verbose) {
        P60057 test = new P60057();
        Assertions.assertEquals(7, test.solution("aabbaccc"));
        Assertions.assertEquals(9, test.solution("ababcdcdababcdcd"));
        Assertions.assertEquals(8, test.solution("abcabcdede"));
        Assertions.assertEquals(14, test.solution("abcabcabcabcdededededede"));
        Assertions.assertEquals(17, test.solution("xababcdcdababcdcd"));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void P64061Test(Boolean verbose) {
        P64061 test = new P64061();
        Assertions.assertEquals(4,
            test.solution(new int[][]
            { {0, 0, 0, 0, 0},
              {0, 0, 1, 0, 3},
              {0, 2, 5, 0, 1},
              {4, 2, 4, 4, 2},
              {3, 5, 1, 3, 1} }, new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void P67257Test(Boolean verbose) {
        P67257 test = new P67257();
        Assertions.assertEquals(60420, test.solution("100-200*300-500+20"));
        Assertions.assertEquals(300, test.solution("50*6-3*2"));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void P67258Test(Boolean verbose) {
        P67258 test = new P67258();
        Assertions.assertArrayEquals(new int[] { 3, 7 }, 
            test.solution(new String[] { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" }));
        Assertions.assertArrayEquals(new int[] { 1, 3 }, 
            test.solution(new String[] { "AA", "AB", "AC", "AA", "AC" }));
        Assertions.assertArrayEquals(new int[] { 1, 1 }, 
            test.solution(new String[] { "XYZ", "XYZ", "XYZ" }));
        Assertions.assertArrayEquals(new int[] { 1, 5 }, 
            test.solution(new String[] { "ZZZ", "YYY", "NNNN", "YYY", "BBB" }));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    void P84512Test(Boolean verbose) {
        P84512 test = new P84512();
        Assertions.assertEquals(6, test.solution("AAAAE"));
        Assertions.assertEquals(10, test.solution("AAAE"));
        Assertions.assertEquals(1563, test.solution("I"));
        Assertions.assertEquals(1189, test.solution("EIO"));
        if (verbose) System.out.println(new Object() {}.getClass().getEnclosingMethod().getName() + "(): SUCCESS");
    }

    @Test
    void K22A1Test(Boolean verbose) throws IOException {
        K22A1 test = new K22A1();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName,
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void K22A2Test(Boolean verbose) throws IOException {
        K22A2 test = new K22A2();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A01158Test(Boolean verbose) throws IOException {
        A01158 test = new A01158();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A01300Test(Boolean verbose) throws IOException {
        A01300 test = new A01300();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A01406Test(Boolean verbose) throws IOException {
        A01406 test = new A01406();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A01654Test(Boolean verbose) throws IOException {
        A01654 test = new A01654();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A01874Test(Boolean verbose) throws IOException {
        A01874 test = new A01874();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A01914Test(Boolean verbose) throws IOException {
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            A01914 test = new A01914();
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A01920Test(Boolean verbose) throws IOException {
        A01920 test = new A01920();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A02110Test(Boolean verbose) throws IOException {
        A02110 test = new A02110();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A02346Test(Boolean verbose) throws IOException {
        A02346 test = new A02346();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A02805Test(Boolean verbose) throws IOException {
        A02805 test = new A02805();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A03190Test(Boolean verbose) throws IOException {
        A03190 test = new A03190();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A05670Test(Boolean verbose) throws IOException {
        A05670 test = new A05670();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A09012Test(Boolean verbose) throws IOException {
        A09012 test = new A09012();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A10026Test(Boolean verbose) throws IOException {
        A10026 test = new A10026();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A12015Test(Boolean verbose) throws IOException {
        A12015 test = new A12015();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A16934Test(Boolean verbose) throws IOException {
        A16934 test = new A16934();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A17609Test(Boolean verbose) throws IOException {
        A17609 test = new A17609();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    @Test
    void A17612Test(Boolean verbose) throws IOException {
        A17612 test = new A17612();
        String fileName = new Object() {}.getClass().getEnclosingMethod().getName().replace("Test", "");
        ArrayList<String[]> files = mockInOutTestHelper(fileName);
        final PrintStream sysOut = System.out;
        long start = System.nanoTime();
        for (int i = 0; i < files.size() / 2; i++) {
            String mockData = files.get(0)[i], expected = files.get(1)[i];
            InputStream sysIn = System.in;
            ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(mockData.getBytes()));
            System.setOut(new PrintStream(actualOutput));
            test.reader();
            Assertions.assertEquals(expected, actualOutput.toString().trim());
            System.setIn(sysIn);
        }
        long end = System.nanoTime();
        System.setOut(sysOut);
        if (verbose)
            System.out.printf("%sTest(): SUCCESS%s\n", fileName, 
                String.format(" in %.2fms", (end - start) / 1e6));
    }

    private ArrayList<String[]> mockInOutTestHelper(String filename) throws IOException {
        String path = "zb-study/data";
        List<String> files = Stream.of(new File(path).listFiles())
                                   .filter(file -> !file.isDirectory() 
                                                   && file.toString().contains(filename))
                                   .map(File::getName).collect(Collectors.toList());
        List<String> inFileNames = files.stream().filter(file -> file.contains("in")).collect(Collectors.toList());
        List<String> outFileNames = files.stream().filter(file -> file.contains("out")).collect(Collectors.toList());
        Collections.sort(inFileNames);
        Collections.sort(outFileNames);
        path += "/";
        String[] mockInput = new String[inFileNames.size()], expected = new String[outFileNames.size()];
        for (int i = 0; i < inFileNames.size(); i++) {
            ByteArrayInputStream iC = new ByteArrayInputStream(
                Files.readString(Paths.get(path + inFileNames.get(i))).getBytes(StandardCharsets.UTF_8));
            ByteArrayInputStream oC = new ByteArrayInputStream(
                Files.readString(Paths.get(path + outFileNames.get(i))).getBytes(StandardCharsets.UTF_8));
            mockInput[i] = new BufferedReader(new InputStreamReader(iC)).lines().collect(Collectors.joining("\n"));
            expected[i] = new BufferedReader(new InputStreamReader(oC)).lines().collect(Collectors.joining("\n"));
        }
        return new ArrayList<>() {{
            add(mockInput);
            add(expected);
        }};
    }

    void leetcodeRunner(Boolean verbose, TestRunner testRunner) {
        testRunner.L00007Test(verbose);
        testRunner.L00011Test(verbose);
        testRunner.L00012Test(verbose);
        testRunner.L00013Test(verbose);
        testRunner.L00020Test(verbose);
        testRunner.L00026Test(verbose);
        testRunner.L00042Test(verbose);
        testRunner.L00049Test(verbose);
        testRunner.L00054Test(verbose);
        testRunner.L00056Test(verbose);
        testRunner.L00073Test(verbose);
        testRunner.L00075Test(verbose);
        testRunner.L00079Test(verbose);
        testRunner.L00096Test(verbose);
        testRunner.L00118Test(verbose);
        testRunner.L00130Test(verbose);
        testRunner.L00135Test(verbose);
        testRunner.L00202Test(verbose);
        testRunner.L00442Test(verbose);
        testRunner.L00463Test(verbose);
        testRunner.L00567Test(verbose);
        testRunner.L00640Test(verbose);
        testRunner.L00658Test(verbose);
        testRunner.L00721Test(verbose);
        testRunner.L00752Test(verbose);
        testRunner.L01023Test(verbose);
        testRunner.L01053Test(verbose);
        testRunner.L01354Test(verbose);
        testRunner.L01383Test(verbose);
        testRunner.L01654Test(verbose);
        testRunner.L01851Test(verbose);
        testRunner.L01922Test(verbose);
        testRunner.L01942Test(verbose);
        System.out.println("All leetcode tests have been completed successfully.");
    }

    void programmersRunner(Boolean verbose, TestRunner testRunner) {
        testRunner.P01878Test(verbose);
        testRunner.P42576Test(verbose);
        testRunner.P42577Test(verbose);
        testRunner.P42579Test(verbose);
        testRunner.P42587Test(verbose);
        testRunner.P42892Test(verbose);
        testRunner.P43236Test(verbose);
        testRunner.P60057Test(verbose);
        testRunner.P64061Test(verbose);
        testRunner.P67257Test(verbose);
        testRunner.P67258Test(verbose);
        testRunner.P84512Test(verbose);
        System.out.println("All programmers tests have been completed successfully.");
    }

    void kickstartRunner(Boolean verbose, TestRunner testRunner) throws IOException {
        testRunner.K22A1Test(verbose);
        testRunner.K22A2Test(verbose);
        System.out.println("All kickstart tests have been completed successfully.");
    }

    void acmicpcRunner(Boolean verbose, TestRunner testRunner) throws IOException {
        testRunner.A01158Test(verbose);
        testRunner.A01300Test(verbose);
        testRunner.A01406Test(verbose);
        testRunner.A01654Test(verbose);
        testRunner.A01874Test(verbose);
        testRunner.A01914Test(verbose);
        testRunner.A01920Test(verbose);
        testRunner.A02110Test(verbose);
        testRunner.A02346Test(verbose);
        testRunner.A02805Test(verbose);
        testRunner.A03190Test(verbose);
        testRunner.A05670Test(verbose);
        testRunner.A09012Test(verbose);
        testRunner.A10026Test(verbose);
        testRunner.A12015Test(verbose);
        testRunner.A16934Test(verbose);
        testRunner.A17609Test(verbose);
        testRunner.A17612Test(verbose);
        System.out.println("All acmicpc tests have been completed successfully.");
    }

    public static void main(String[] args) throws IOException {
        TestRunner testRunner = new TestRunner();
        testRunner.leetcodeRunner(true, testRunner);
        testRunner.programmersRunner(true, testRunner);
        testRunner.kickstartRunner(true, testRunner);
        testRunner.acmicpcRunner(true, testRunner);
    }
}
