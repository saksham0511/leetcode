package binarysearch;

public class FindTargetInMatrix {
    // Intuition for binary search :
    // Use start > end as breaking condition
    // To understand what to return in the breaking condition
    // Assume both start and end are equal. Now which will point at your desired element in such case, return that
    // In our case, let's assume start == end at the element which is just lower than our target (condition : element <= target)
    // end will continue to point at this element, as start would become mid+1 (end+1). We want this just smaller element than our target
    // So we return the "end" as answer.
    // Also, think about the case where there are only 2 elements in the array. Will your "mid" make it to the second element of the array, or will you break s > e condition first?
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int row = searchrow(matrix, target, 0, m-1);
            return searchcol(matrix, target, 0, n-1, row);
        }

        private int searchrow(int[][] matrix, int target, int start, int end) {
            if (start > end) {
                return end;
            }
            int mid = start + (end - start)/2;
            if (matrix[mid][0] <= target) {
                return searchrow(matrix, target, mid+1, end);
            } else {
                return searchrow(matrix, target, start, mid-1);
            }
        }

        private boolean searchcol(int[][] matrix, int target, int start, int end, int row) {
            if (start > end || row<0) {
                return false;
            }
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                return searchcol(matrix, target, mid+1, end, row);
            } else {
                return searchcol(matrix, target, start, mid-1, row);
            }
        }
    }
}
