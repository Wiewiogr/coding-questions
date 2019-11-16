package pl.tw.dailycodingquestion.num11to20;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Given a stream of elements too large to store in memory,
 * pick a random element from the stream with uniform probability.
 * <p>
 * Note:
 * This algorithm is a Reservoir Sampling for k=1
 */
public class CodingQuestion15 {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(reservoirSampling(IntStream.range(1, 1000).boxed().collect(toList())));
        }
    }

    public static int reservoirSampling(List<Integer> stream) {
        int choosen = 0;
        int i = 1;

        for (int elem : stream) {
            double roll = Math.random();
            if (roll < 1.0 / i) {
                choosen = elem;
            }
            i++;
        }

        return choosen;
    }
}
