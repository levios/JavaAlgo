package combi;

import java.util.*;

public class Permute<T> extends AbstractCollection<List<T>> {
    private final List<T> items;
    public Permute(List<T> s) {
        items = s;
    }
    public Permute(T[] s) {
        items = Arrays.asList(s.clone());
    }
    @Override
    public Iterator<List<T>> iterator() {
        if (items.size() == 1) {
            return Collections.singleton(items).iterator();
        } else {
            return new PermutingIterator<>(items);
        }
    }
    @Override
    public int size() {
        return factorial(items.size());
    }

    private static class PermutingIterator<T> implements Iterator<List<T>> {
        private final T last;
        private final Iterator<List<T>> inner;
        private List<T> current;
        private int position;
        PermutingIterator(List<T> s) {
            int lastIndex = s.size() - 1;
            this.inner = new Permute<T>(s.subList(0, lastIndex)).iterator();
            this.last = s.get(lastIndex);
        }
        @Override
        public boolean hasNext() {
            return inner.hasNext() || (current != null && position <= current.size());
        }
        @Override
        public List<T> next() {
            while(true) {
                if (current != null && position <= current.size()) {
                    List<T> n = new ArrayList<>(current);
                    n.add(position++, last);
                    return n;
                } else if (inner.hasNext()) {
                    position = 0;
                    current = inner.next();
                } else {
                    throw new IllegalStateException("no more permutations available");
                }
            }
        }
        @Override
        public void remove() { throw new UnsupportedOperationException(); }
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}