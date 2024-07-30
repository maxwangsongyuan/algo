package ds.Graph;

public class noOfProvinces {
    /*
    leetcode 547

    解题：
    1. 用DFS解决
    2. 用visited数组记录访问过的城市
    3. 遍历每一个城市，如果没有访问过，就dfs遍历这个城市的所有连接城市


     */
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        int n = isConnected.length; // n*n matrix
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                dfs(isConnected, visited, i);
            }
        }
        return res;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) { //如果i和j是连接的，并且j没有访问过
                dfs(isConnected, visited, j);
            }
        }
    }
}
