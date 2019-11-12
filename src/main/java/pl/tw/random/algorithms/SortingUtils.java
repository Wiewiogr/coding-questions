package pl.tw.random.algorithms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortingUtils {

    public static int[] createShuffledArray(int size) {
        List<Integer> collect = IntStream.range(1, size).boxed().collect(Collectors.toList());
        Collections.shuffle(collect);

        int[] array = new int[size];
        for (int i = 0; i < collect.size(); i++) {
            array[i] = collect.get(i);
        }
        return array;
    }
}
