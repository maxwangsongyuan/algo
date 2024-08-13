package ds.Graph;

import java.util.List;

public class KeysAndRooms {
    /*
    There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
    When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
    Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
     */

    // 思路：
    /*
    1. 用DFS解决
    2. 用一个visited数组记录访问过的房间
    3. 遍历每一个房间，如果没有访问过，就dfs遍历这个房间的所有连接房间
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, boolean[] visited, int i) {
        visited[i] = true;
        for (int j : rooms.get(i)) {
            if (!visited[j]) {
                dfs(rooms, visited, j);
            }
        }
    }
}
