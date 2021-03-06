package com.leetcode;

/*
1 1 2 2 3 4 2 ...
            -
e.g.
min = 2
 */
class Solution {
    public int findUnsortedSubarray(int[] a) {
        int n = a.length;
        if (n == 1) return 0;

        int reversedIdx = 0;
        int i;

        // find the first 'reversed' num
        for (i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                reversedIdx = i;
                break;
            }
        }
        if (i >= n) return 0;
        // find the min num from [reversedIdx, n)
        int min = Integer.MAX_VALUE;
        for (i = reversedIdx; i < n; i++) {
            min = Math.min(min, a[i]);
        }
        // find the left-most
        int leftMostIdx = 0;
        for (i = reversedIdx - 1; i > 0; i--) {
            if (min < a[i] && min >= a[i - 1]) {
                leftMostIdx = i;
                break;
            }
        }

        for (i = n - 2; i >= 0; i--) {
            if (a[i] > a[i + 1]) {
                reversedIdx = i;
                break;
            }
        }
        if (i < 0) return 0;

        int max = Integer.MIN_VALUE;
        for (i = reversedIdx; i >= 0; i--) {
            max = Math.max(max, a[i]);
        }

        int rightMostIdx = n - 1;
        for (i = reversedIdx + 1; i < n - 1; i++) {
            if (max > a[i] && max <= a[i + 1]) {
                rightMostIdx = i;
                break;
            }
        }

        return rightMostIdx - leftMostIdx + 1;
    }
}
