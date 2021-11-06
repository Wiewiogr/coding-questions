package pl.tw.random.algorithms;

import static pl.tw.random.algorithms.SortingUtils.createShuffledArray;

public class Heap {

    int size = 0;
    int[] data = new int[1000];

    public void add(int val) {
        data[size] = val;
        int ptr = size;
        size++;

        heapifyUp(ptr);
    }

    private void heapifyUp(int ptr) {
        if (ptr != 0) {
            int parent = parentIndex(ptr);
            if (data[parent] < data[ptr]) {
                swap(parent, ptr);
                heapifyUp(parent);
            }
        }
    }

    public int getMax() {
        return data[0];
    }

    public int poll() {
        int val = data[0];

        data[0] = data[size - 1];
        size--;

        heapifyDown(0);
        return val;
    }

    private void heapifyDown(int ptr) {
        if (ptr < size - 1) {
            int largest = ptr;
            int left = leftChildIndex(ptr);
            int right = rightChildIndex(ptr);

            if (left < size && data[left] > data[ptr]) largest = left;
            if (right < size && data[right] > data[largest]) largest = right;

            if (largest != ptr) {
                swap(ptr, largest);
                heapifyDown(largest);
            }
        }
    }

    private int parentIndex(int i) {
        return (int) Math.floor((i - 1) / 2.0);
    }

    private int leftChildIndex(int i) {
        return i * 2 + 1;
    }

    private int rightChildIndex(int i) {
        return i * 2 + 2;
    }

    private void swap(int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

//    public static void main(String[] args) {
////        var heap = new Heap();
////        int[] array = createShuffledArray(100);
////        for (int elem : array) {
////            heap.add(array[elem]);
////            System.out.println(heap.getMax());
////        }
////
////        for (int i = 0; i < 100; i++) {
////            System.out.print(heap.poll() + ", ");
////        }
////        System.out.println();
//        int x = 10;
//        int y = 20;
//        int[][] array = new int[x][y];
//        System.out.println(array[5,5]);
//    }
}
