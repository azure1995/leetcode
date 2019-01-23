

/*
 * [475] Heaters
 *
 * https://leetcode.com/problems/heaters/description/
 *
 * algorithms
 * Easy (29.92%)
 * Total Accepted:    35K
 * Total Submissions: 117K
 * Testcase Example:  '[1,2,3]\n[2]'
 *
 * Winter is coming! Your first job during the contest is to design a standard
 * heater with fixed warm radius to warm all the houses.
 * 
 * Now, you are given positions of houses and heaters on a horizontal line,
 * find out minimum radius of heaters so that all houses could be covered by
 * those heaters.
 * 
 * So, your input will be the positions of houses and heaters seperately, and
 * your expected output will be the minimum radius standard of heaters.
 * 
 * Note:
 * 
 * Numbers of houses and heaters you are given are non-negative and will not
 * exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not
 * exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the
 * same.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the
 * radius 1 standard, then all the houses can be warmed.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to
 * use radius 1 standard, then all the houses can be warmed.
 * 
 * 
 */

class Solution {
    final int limit = 25001;
    public static int distance(int a, int b) {
        return Math.abs(a-b);
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int preHouse = -limit;
        int curHeaterIndex = 0;
        int r = 0;
        while (true) {
            int nextHouse;
            for (nextHouse = curHouse + 1; nextHouse < houses.length; nextHouse++) {
                if (distance(heaters[curHeater], houses[nextHouse]) > r) {
                    break;
                }
            }
            if (nextHouse == houses.length) {
                return r;
            } else {
                curHouse = nextHouse;
                curHeater ++;
            }
        }
    }
}
