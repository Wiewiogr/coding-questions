package pl.tw.mediumarticle.pre.lru;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
    }

    public void addNum(int num) {
        leftHeap.add(num);

        if (!rightHeap.isEmpty() && leftHeap.peek() > rightHeap.peek()) {
            int elem = leftHeap.poll();
            rightHeap.add(elem);
        }


        if (Math.abs(leftHeap.size() - rightHeap.size()) > 1) {
            if (leftHeap.size() > rightHeap.size()) {
                int elem = leftHeap.poll();
                rightHeap.add(elem);
            } else {
                int elem = rightHeap.poll();
                leftHeap.add(elem);
            }
        }
    }

    public double findMedian() {
        if (leftHeap.size() == rightHeap.size()) {
            return (leftHeap.peek() + rightHeap.peek()) / 2.0;
        }

        if (leftHeap.size() > rightHeap.size()) {
            return leftHeap.peek();
        } else {
            return rightHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */