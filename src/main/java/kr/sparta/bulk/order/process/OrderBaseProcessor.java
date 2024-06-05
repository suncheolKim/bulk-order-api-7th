package kr.sparta.bulk.order.process;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public abstract class OrderBaseProcessor <T> implements OrderRandomProcessable {
    private static final RandomGenerator gen = RandomGenerator.of("L128X256MixRandom");
    protected List<T> list;

    protected OrderBaseProcessor(List<T> list) {
        this.list = list;
    }

    protected abstract long getMin();
    protected abstract long getMax();

    protected List<Integer> getRandomTargets() {
        // 랜덤으로 수정할 대상의 개수 선정
        final int limit = gen.nextInt(list.size());

        final int min = Math.toIntExact(getMin());
        final int max = Math.toIntExact(getMax());

        final IntStream randoms = gen.ints(min, max)
                .limit(limit);

        return randoms.boxed().toList();
    }
}
