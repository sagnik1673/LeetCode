// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

// Example 2:
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3

// Constraints:
//    m == grid.length
//    n == grid[i].length
//    1 <= m, n <= 300
//    grid[i][j] is '0' or '1'.

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        // traverse the grid elements one by one
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //increment the count and do DFS for the adjacent cells
                if (grid[i][j] == '1') {
                    count++;
                    DFS(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void DFS(char[][] grid, int i, int j) {
        // the base cases where the DFS traversal should stop
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        //mark the element as 0 or visited so that it won't be taken into account, when visited again.
        grid[i][j] = '0'; // Mark as visited
        
       //DFS for up element
        DFS(grid,i-1,j);
        //DFS for down element
        DFS(grid,i+1,j);
        //DFS for left element
        DFS(grid,i,j-1);
        //DFS for right element
        DFS(grid,i,j+1);
    }
}
