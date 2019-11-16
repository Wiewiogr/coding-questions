package pl.tw.dailycodingquestion.num21to30;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
 * find the minimum number of rooms required.
 * <p>
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */
public class CodingQuestion21 {

    public static void main(String[] args) {

        System.out.println(minNumberOfRooms(
//                new Interval[]{
//                        new Interval(30, 75),
//                        new Interval(0, 50),
//                        new Interval(60, 150),
//                }
//                new Interval[]{
//                        new Interval(60, 100),
//                        new Interval(0, 50),
//                        new Interval(110, 150),
//                }
                new Interval[]{
                        new Interval(40, 100),
                        new Interval(20, 50),
                        new Interval(30, 150),
                }
        ));
    }

    public static int minNumberOfRooms(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int maxRooms = 0;

        for (Interval interval : intervals) {
            while (!heap.isEmpty() && heap.peek() < interval.start) {
                heap.poll();
            }

            heap.offer(interval.end);

            maxRooms = Math.max(heap.size(), maxRooms);
        }

        return maxRooms;
    }

    static class Interval {

        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}
