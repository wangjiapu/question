package com.pupu.project.solutions;

public class ModifiedArray {
    /**
     * 370、区间加法
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference difference = new Difference(nums);
        for (int[] update : updates) {
            difference.increment(update[0], update[1], update[2]);
        }
        return difference.result();
    }

    /**
     * 1109、航班预订统计[差分数组]
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n){
        int[] nums = new int[n];
        Difference difference = new Difference(nums);
        for (int[] update : bookings) {
            difference.increment(update[0]-1, update[1]-1, update[2]);
        }
        return difference.result();
    }

    /**
     * 差分数组实现
     */
    class Difference {
        final int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int start, int end, int value) {
            diff[start] = diff[start] + value;
            if (end + 1 < diff.length) {
                diff[end + 1] = diff[end + 1] - value;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
