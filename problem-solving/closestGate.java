/**
 * Given a NxN grid with cells containing either an empty space '_', a wall 'W' or a gate 'G',
 * Replace each empty space by the distance to the nearest gate.
 * Constraint: we cannot go through a wall
 */ 

import java.util.*;

public class ClosestGate {
    public static void main (String[] args) {
        String[][] grid = {
            {"G","W","_","G","W"},
            {"_","_","_","W","_"},
            {"W","W","_","G","W"},
            {"G","_","_","W","W"},
            {"_","W","W","W","W"}
        };
        
        printGrid(grid);
        
        System.out.println();
        
        printGrid(calcDistance(grid));
    }
    
    static String[][] calcDistance(String[][] grid) {
        Set<Integer> visited = new HashSet<>();
        final int N = grid.length;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited.contains(i * grid.length + j) && grid[i][j].compareTo("_") == 0) {
                    int distance = traverse(grid, visited, i, j);
                    grid[i][j] = String.valueOf(distance);
                }
            }
        }
        
        return grid;
    }
    
    static int traverse(String[][] grid, Set<Integer> visited, int i, int j) {
        // check if out of bound
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length) {
            return Integer.MAX_VALUE;
        }
        
        // return distance if cell already visited
        if (visited.contains(i * grid.length + j)) {
            try {
                return Integer.parseInt(grid[i][j]);
            } catch (NumberFormatException ex) {
                if (grid[i][j].compareTo("G") == 0) {
                    return 0;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        
        visited.add(i * grid.length + j);
        
        // get neighbor distances
        if (grid[i][j].compareTo("_") == 0) {
            int top = traverse(grid, visited, i-1, j);
            int right = traverse(grid, visited, i, j+1);
            int bottom = traverse(grid, visited, i+1, j);
            int left = traverse(grid, visited, i, j-1);
            int distance = Math.min(Math.min(top, bottom), Math.min(left, right)) + 1;
            grid[i][j] = String.valueOf(distance);
            return distance;
        } else if (grid[i][j].compareTo("W") == 0) {
            return Integer.MAX_VALUE;
        } else {
            return 0;
        }
    }
    
    static void printGrid(String[][] grid) {
        for (int i = 0; i < grid.length * grid.length; i++) {
            if ((i+1) % grid.length == 0) {
                System.out.println(grid[i / grid.length][i % grid.length]);
            } else {
                System.out.print(grid[i / grid.length][i % grid.length] + " ");
            }
        }
    }
}