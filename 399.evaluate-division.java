class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Integer> map = new HashMap<>();
        int len = 0;
        for (int i = 0; i < equations.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (!map.containsKey(equations[i][j])) {
                    map.put(equations[i][j], len++);
                }
            }
        }
        double[][] graph = new double[len][len];
        for (int i = 0; i < len; i++) {
            graph[i][i] = 1.0;
        }
        for (int i = 0; i < values.length; i++) {
            int upIndex = map.get(equations[i][0]);
            int downIndex = map.get(equations[i][1]);
            graph[upIndex][downIndex] = values[i];
            graph[downIndex][upIndex] = 1.0 / values[i];
        }
        for (int k = 0; k < len; k++) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (graph[i][j] == 0.0 && graph[i][k] > 0.0 && graph[k][j] > 0.0) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                    }
                }
            }
        }
        double[] ret = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int upIndex = map.containsKey(queries[i][0]) ? map.get(queries[i][0]) : -1;
            int downIndex = map.containsKey(queries[i][1]) ? map.get(queries[i][1]) : -1;
            ret[i] = (upIndex == -1 || downIndex == -1 || graph[upIndex][downIndex] == 0.0) ? -1.0
                    : graph[upIndex][downIndex];
        }
        return ret;
    }
}