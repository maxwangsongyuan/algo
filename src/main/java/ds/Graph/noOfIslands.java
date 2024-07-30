package ds.Graph;

public class noOfIslands {
    // leetcode 200
    /*
    解题：
    1. 用DFS解决
    2. 遍历每一个点，如果是1，就把周围的1都变成0
    3. 用一个变量记录岛屿的数量
    4. 时间复杂度O(m*n)
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);

    }


    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        noOfIslands noOfIslands = new noOfIslands();
        System.out.println(noOfIslands.numIslands(grid));
    }
}
