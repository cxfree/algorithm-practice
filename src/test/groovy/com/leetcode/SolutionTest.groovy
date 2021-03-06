package com.leetcode


import spock.lang.Ignore
import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/6/9
 */
class SolutionTest extends Specification {

    def "test"() {
        expect:
        len == new Solution().findUnsortedSubarray(nums as int[])
        where:
        nums                                             | len
        [1, 2, 3]                                        | 0
        [2, 6, 4, 8, 10, 9, 15]                          | 5
        [2, 6, 999, 4, 10, 11, 99, 22, 1, 19, 20, 88]    | 12
        [0, 2, 6, 999, 4, 10, 11, 99, 22, 1, 19, 20, 88] | 12
        [2, 2, 3, 2, 4] | 2
    }

    @Ignore
    def "5438"(int[] a, int m, int k, int r) {
        expect:
        println a
        int actual = new Solution_5438().minDays(a, m, k)
        r == actual
        where:
        a                               | m | k | r
        null                            | 3 | 2 | -1
        []                              | 3 | 2 | -1

        [1, 10, 3, 10, 2]               | 3 | 1 | 3
        [1, 10, 3, 10, 2]               | 3 | 2 | -1
        [7, 7, 7, 7, 12, 7, 7]          | 2 | 3 | 12
        [1000000000, 1000000000]        | 1 | 1 | 1000000000
        [1, 10, 2, 9, 3, 8, 4, 7, 5, 6] | 4 | 2 | 9
    }

    /*
    def "1473 3D-dp | MinCost"(int[] houses, int[][] cost, int m, int n, int target, int r) {
        expect:
        println "houses: ${houses}, cost: ${cost}"
        int actual = new Solution().minCost(houses, cost, m, n, target)
        r == actual
        println '> ===== <'
        where:
        houses          | cost                                          | m | n | target || r
        [0, 0, 0, 0, 0] | [[1, 10], [10, 1], [10, 1], [1, 10], [5, 1]]  | 5 | 2 | 3      || 9
        [0, 2, 1, 2, 0] | [[1, 10], [10, 1], [10, 1], [1, 10], [5, 1]]  | 5 | 2 | 3      || 11
        [0, 0, 0, 0, 0] | [[1, 10], [10, 1], [1, 10], [10, 1], [1, 10]] | 5 | 2 | 5      || 5
        [3, 1, 2, 3]    | [[1, 1, 1], [1, 1, 1], [1, 1, 1], [1, 1, 1]]  | 4 | 3 | 3      || -1
        [2, 3, 0]       | [[5, 2, 3], [3, 4, 1], [1, 2, 1]]             | 3 | 3 | 3      || 1
        [2, 2, 1]       | [[1, 1], [3, 4], [4, 2]]                      | 3 | 2 | 2      || 0
        [0, 0, 0, 1]    | [[1, 5], [4, 1], [1, 3], [4, 4]]              | 4 | 2 | 4       | 12
    }
    */
}
