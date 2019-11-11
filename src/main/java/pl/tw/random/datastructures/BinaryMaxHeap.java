package pl.tw.random.datastructures;

public class BinaryMaxHeap {

    int size = 0;
    int[] data;

    public BinaryMaxHeap(int size) {
        this.data = new int[size];
    }

    public int getMax() {
        return data[0];
    }

    public void insert(int val) {
        data[size] = val;

        int currentIndex = size;
        int parentIndex = getParent(currentIndex);

        while (parentIndex >= 0 && data[parentIndex] < data[currentIndex]) {
            swap(parentIndex, currentIndex);
            parentIndex = getParent(currentIndex);
            currentIndex = parentIndex;
        }

        size++;
    }

    // removeFirst
    public int extract() {
        int toReturn = data[0];
        data[0] = data[size - 1];
        size--;

        int cur = 0;
        int left = 1;
        int right = 2;

        while ((left < size && data[cur] < data[left]) ||
                (right < size && data[cur] < data[right])) {
            if (right < size) { // if right exists
                if (data[left] > data[right]) {
                    swap(left, cur);
                    cur = left;
                } else {
                    swap(right, cur);
                    cur = right;
                }
            } else {
                swap(left, cur);
                cur = left;
            }
            left = cur * 2 + 1;
            right = cur * 2 + 2;
        }

        return toReturn;
    }

    private void swap(int parentIndex, int currentIndex) {
        int tmp = data[parentIndex];
        data[parentIndex] = data[currentIndex];
        data[currentIndex] = tmp;
    }

    private int getParent(int index) {
        return (int) Math.floor((index - 1) / 2.0);
    }

    public static void main(String[] args) {
        BinaryMaxHeap heap = new BinaryMaxHeap(100);

        heap.insert(2);
        System.out.println(heap.getMax());

        heap.insert(3);
        System.out.println(heap.getMax());

        heap.insert(1);
        heap.insert(1);
        heap.insert(1);
        heap.insert(1);
        heap.insert(2);
        System.out.println(heap.getMax());

        System.out.println(heap.extract());
        System.out.println(heap.extract());
        System.out.println(heap.extract());
        System.out.println(heap.extract());
    }
}
