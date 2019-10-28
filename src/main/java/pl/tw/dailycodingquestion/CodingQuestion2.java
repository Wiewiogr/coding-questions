package pl.tw.dailycodingquestion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * return a new sorted merged list from K sorted lists, each with size N
 */

public class CodingQuestion2 {

    public static void main(String[] args) {
        List<List<Integer>> lists = List.of(List.of(10, 15, 30), List.of(12, 15, 20), List.of(17, 20, 32));
        System.out.println(merge(lists, 3));
    }

    // nk + klog(k) = nklog(k)
    public static List<Integer> merge(List<List<Integer>> lists, int n) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Record> heap = new PriorityQueue<>(Comparator.comparingInt(record -> record.val));

        for (int i = 0; i < lists.size(); i++) {
            heap.add(new Record(lists.get(i).get(0), i, 0));
        }

        while (!heap.isEmpty()) {
            Record record = heap.poll();

            result.add(record.val);
            if (record.index + 1 == n) {
                continue;
            }

            Record newRecord = new Record(lists.get(record.list).get(record.index + 1), record.list, record.index + 1);
            heap.offer(newRecord);
        }
        return result;
    }

    public static class Record {

        public int val;
        public int list;
        public int index;

        public Record(int val, int list, int index) {
            this.val = val;
            this.list = list;
            this.index = index;
        }
    }
}
