import java.util.*;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island 
 * is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * https://leetcode.com/problems/number-of-islands/
 */

public class Main {
    public static void main(String[] args) {
        final int[][] map1 = { {1,1,1,1,0}, {1,1,0,1,0}, {1,1,0,0,0}, {0,0,0,0,0} };
        final int[][] map2 = { {1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,1} };
        final int[][] map3 = { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,0,0} };
        final int[][] map4 = { {0,0,0,0,0} };
        final int[][] map5 = {{}};
        Main solution = new Main();
        
        System.out.println(solution.numberOfIslands(map1));
        System.out.println(solution.numberOfIslands(map2));
        System.out.println(solution.numberOfIslands(map3));
        System.out.println(solution.numberOfIslands(map4));
        System.out.println(solution.numberOfIslands(map5));
    }
    
    public int numberOfIslands(final int[][] map) {
        int numIslands = 0;
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    numIslands++;
                }
                exploreMap(map, explored, i, j);
            }
        }
        
        return numIslands;
    }
    
    void exploreMap(int[][] map, int i, int j) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] == 0) return;
        
        map[i][j] = 0;
        
        exploreMap(map, explored, i, j-1);
        exploreMap(map, explored, i, j+1);
        exploreMap(map, explored, i-1, j);
        exploreMap(map, explored, i+1, j);
        
        return;
    }
}