import java.text.*;
import java.util.*;
import org.junit.jupiter.api.Assertions;
import leetcode.*;

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
    void L00007Test() {
        L00007 test = new L00007();
        Assertions.assertEquals(321, test.reverse(123));
        Assertions.assertEquals(-321, test.reverse(-123));
        Assertions.assertEquals(21, test.reverse(120));
    }

    void L00011Test() {
        L00011 test = new L00011();
        Assertions.assertEquals(49, test.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        Assertions.assertEquals(1, test.maxArea(new int[] { 1, 1 }));
    }

    void L00012Test() {
        L00012 test = new L00012();
        Assertions.assertEquals("III", test.intToRoman(3));
        Assertions.assertEquals("LVIII", test.intToRoman(58));
        Assertions.assertEquals("MCMXCIV", test.intToRoman(1994));
    }

    void L00013Test() {
        L00013 test = new L00013();
        Assertions.assertEquals(3, test.romanToInt("III"));
        Assertions.assertEquals(58, test.romanToInt("LVIII"));
        Assertions.assertEquals(1994, test.romanToInt("MCMXCIV"));
    }

    void L00020Test() {
        L00020 test = new L00020();
        Assertions.assertTrue(test.isValid("()"));
        Assertions.assertTrue(test.isValid("()[]{}"));
        Assertions.assertFalse(test.isValid("(]"));
    }

    void L00026Test() {
        L00026 test = new L00026();
        Assertions.assertEquals(2, test.removeDuplicates(new int[] { 1, 1, 2 }));
        Assertions.assertEquals(5, test.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
    }

    void L00042Test() {
        L00042 test = new L00042();
        Assertions.assertEquals(6, test.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
        Assertions.assertEquals(9, test.trap(new int[] { 4, 2, 0, 3, 2, 5 }));
    }

    void L00054Test() {
        L00054 test = new L00054();
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), test.spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), test.spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
    }
    
    void L00073Test() {
        L00073 test = new L00073();
        int[][] matrix = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int[][] expected = new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
        test.setZeroes(matrix);
        Assertions.assertArrayEquals(expected, matrix);
        matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        expected = new int[][] { { 0, 0, 0, 0 }, { 0, 4, 5, 0 }, { 0, 3, 1, 0 } };
        test.setZeroes(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    void L00079Test() {
        L00079 test = new L00079();
        Assertions.assertTrue(test.exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCCED"));
        Assertions.assertTrue(test.exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE"));
        Assertions.assertFalse(test.exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB"));
    }

    void L00096Test() {
        L00096 test = new L00096();
        Assertions.assertEquals(5, test.numTrees(3));
        Assertions.assertEquals(1, test.numTrees(1));
    }

    void L00118Test() {
        L00118 test = new L00118();
        Assertions.assertEquals(Arrays.asList(
                List.of(1),
            Arrays.asList(1, 1), 
            Arrays.asList(1, 2, 1), 
            Arrays.asList(1, 3, 3, 1), 
            Arrays.asList(1, 4, 6, 4, 1)), test.generate(5));
        Assertions.assertEquals(List.of(List.of(1)), test.generate(1));
    }

    void L00130Test() {
        L00130 test = new L00130();
        char[][] board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
        char[][] expected = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'X', 'X' } };
        test.solve(board);
        Assertions.assertArrayEquals(expected, board);

        board = new char[][] { { 'X' }};
        expected = new char[][] { { 'X' }};
        test.solve(board);
        Assertions.assertArrayEquals(expected, board);
    }

    void L00135Test() {
        L00135 test = new L00135();
        Assertions.assertEquals(5, test.candy(new int[] { 1, 0, 2 }));
        Assertions.assertEquals(4, test.candy(new int[] { 1, 2, 2 }));
    }

    void L00202Test() {
        L00202 test = new L00202();
        Assertions.assertTrue(test.isHappy(19));
        Assertions.assertFalse(test.isHappy(2));
    }

    void L00442Test() {
        L00442 test = new L00442();
        Assertions.assertTrue(
            Arrays.asList(2, 3).size() == test.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }).size()
            && Arrays.asList(2, 3).containsAll(test.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }))
            && test.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }).containsAll(Arrays.asList(2, 3))
        );
        Assertions.assertEquals(List.of(1), test.findDuplicates(new int[] { 1, 1, 2 }));
        Assertions.assertEquals(List.of(), test.findDuplicates(new int[] { 1 }));
    }

    void L00463Test() {
        L00463 test = new L00463();
        Assertions.assertEquals(16, test.islandPerimeter(new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } }));
        Assertions.assertEquals(4, test.islandPerimeter(new int[][] { { 1 } }));
        Assertions.assertEquals(4, test.islandPerimeter(new int[][] { { 1, 0 } }));
    }

    void L00567Test() {
        L00567 test = new L00567();
        Assertions.assertTrue(test.checkInclusion("ab", "eidbaooo"));
        Assertions.assertFalse(test.checkInclusion("ab", "eidboaoo"));
    }

    void L00640Test() {
        L00640 test = new L00640();
        Assertions.assertEquals("x=2", test.solveEquation("x+5-3+x=6+x-2"));
        Assertions.assertEquals("Infinite solutions", test.solveEquation("x=x"));
        Assertions.assertEquals("x=0", test.solveEquation("2x=x"));
    }

    void L00658Test() {
        L00658 test = new L00658();
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4), test.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4), test.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1));
    }

    void L00721Test() {
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
    }

    void L00752Test() {
        L00752 test = new L00752();
        Assertions.assertEquals(6, test.openLock(new String[] { "0201", "0101", "0102", "1212", "2002" }, "0202"));
        Assertions.assertEquals(1, test.openLock(new String[] { "8888" }, "0009"));
        Assertions.assertEquals(-1, test.openLock(new String[] { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" }, "8888"));
    }

    void L01053Test() {
        L01053 test = new L01053();
        Assertions.assertArrayEquals(new int[] { 3, 1, 2 }, test.prevPermOpt1(new int[] { 3, 2, 1 }));
        Assertions.assertArrayEquals(new int[] { 1, 1, 5 }, test.prevPermOpt1(new int[] { 1, 1, 5 }));
        Assertions.assertArrayEquals(new int[] { 1, 7, 4, 6, 9 }, test.prevPermOpt1(new int[] { 1, 9, 4, 6, 7 }));
    }

    void L01654Test() {
        L01654 test = new L01654();
        Assertions.assertEquals(3, test.minimumJumps(new int[] { 14, 4, 18, 1, 15 }, 3, 15, 9));
        Assertions.assertEquals(-1, test.minimumJumps(new int[] { 8, 3, 16, 6, 12, 20 }, 15, 13, -11));
        Assertions.assertEquals(2, test.minimumJumps(new int[] { 1, 6, 2, 14, 5, 17, 4 }, 16, 9, 7));
    }

    void L01922Test() {
        L01922 test = new L01922();
        Assertions.assertEquals(5, test.countGoodNumbers(1L));
        Assertions.assertEquals(400, test.countGoodNumbers(4L));
        Assertions.assertEquals(564908303, test.countGoodNumbers(50L));
    }

    public static void main(String[] args) {
        TestRunner leetcode = new TestRunner();
        leetcode.L00007Test();
        leetcode.L00011Test();
        leetcode.L00012Test();
        leetcode.L00013Test();
        leetcode.L00020Test();
        leetcode.L00026Test();
        leetcode.L00042Test();
        leetcode.L00054Test();
        leetcode.L00073Test();
        leetcode.L00079Test();
        leetcode.L00096Test();
        leetcode.L00118Test();
        leetcode.L00130Test();
        leetcode.L00135Test();
        leetcode.L00202Test();
        leetcode.L00442Test();
        leetcode.L00463Test();
        leetcode.L00567Test();
        leetcode.L00640Test();
        leetcode.L00658Test();
        leetcode.L00721Test();
        leetcode.L00752Test();
        leetcode.L01053Test();
        leetcode.L01654Test();
        leetcode.L01922Test();
    }
}
