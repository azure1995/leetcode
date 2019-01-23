import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * [744] Network Delay Time
 *
 * https://leetcode.com/problems/network-delay-time/description/
 *
 * algorithms
 * Easy (37.48%)
 * Total Accepted:    13.4K
 * Total Submissions: 35.6K
 * Testcase Example:  '[[2,1,1],[2,3,1],[3,4,1]]\n4\n2'
 *
 * 
 * There are N network nodes, labelled 1 to N.
 * 
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 * 
 * Now, we starget a signal from a certain node K.  How long will it take for all
 * nodes to receive the signal?  If it is impossible, return -1.
 * 
 * 
 * Note:
 * 
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1  and 1 .
 * 
 * 
 */
class Solution {
    class route {
        int target;
        int dist;
        route (int target, int dist) {
            this.target = target;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dists = new int[N];
        Arrays.fill(dists, -1);
        int[][] edges = new int[N][N];
        for (int i = 0; i< N; i++) {
            Arrays.fill(edges[i], -1);
        }
        for (int i = 0; i < times.length; i++) {
            edges[times[i][0] - 1][times[i][1] - 1] = times[i][2];
        }
        PriorityQueue<route> priority_queue = new PriorityQueue<>(new Comparator<route>() {
            public int compare (route a, route b) {
                return a.dist > b.dist ? 1 : -1;
            }
        });
        priority_queue.add(new route(K-1, 0));
        while (!priority_queue.isEmpty()) {
            route head = priority_queue.remove();
            if (dists[head.target] == -1) {
                dists[head.target] = head.dist;
            } else {
                continue;
            }
            for (int i = 0; i < N; i++) {
                if (edges[head.target][i] >= 0 && dists[i] == -1) {
                    priority_queue.add(new route(i, head.dist + edges[head.target][i]));
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (dists[i] == -1) {
                return -1;
            } 
            max = Math.max(max, dists[i]);
        } 
        return max;
    }
}
