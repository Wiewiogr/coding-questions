package pl.tw.dailycodingquestion;

import java.util.Arrays;

/**
 * You run an e-commerce website and want to record the last N order ids in a log.
 * Implement a data structure to accomplish this, with the following API:
 * <p>
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 * <p>
 * You should be as efficient with time and space as possible.
 */
public class CodingQuestion16 {

    public static void main(String[] args) {
        RingBuffer ringBuffer = new RingBuffer(10);

        for (int i = 0; i < 10; i++) {
            ringBuffer.record(i);
        }
        System.out.println(ringBuffer.get(0));
        System.out.println(Arrays.toString(ringBuffer.buffer));
        System.out.println(ringBuffer.start);
    }

    public static class RingBuffer {

        int start = 0, end = 0;
        int size;
        int[] buffer;
        int capacity;

        RingBuffer(int size) {
            this.size = size;
            this.capacity = size;
            this.buffer = new int[size];
        }

        public void record(int value) {
            buffer[end] = value;
            end = (end + 1) % size;
            if (--capacity < 0) {
                start++;
            }
        }

        public int get(int i) {
            return buffer[(start + i) % size];
        }
    }
}
