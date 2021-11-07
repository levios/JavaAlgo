package util;

import java.util.Objects;

public class TupleUtil {
    static class T2<X, Y> {
        public final X _1;
        public final Y _2;
        T2(X _1, Y _2) {
            this._1 = _1;
            this._2 = _2;
        }
        @Override
        public String toString() {
            return _1 + " " + _2;
        }
    }

    static class T3<X, Y, Z> {
        public final X _1;
        public final Y _2;
        public final Z _3;
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            T3<?, ?, ?> t3 = (T3<?, ?, ?>) o;
            return Objects.equals(_1, t3._1) &&
                    Objects.equals(_2, t3._2) &&
                    Objects.equals(_3, t3._3);
        }
        @Override
        public int hashCode() { return Objects.hash(_1, _2, _3); }
        T3(X _1, Y _2, Z _3) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
        }
        @Override
        public String toString() {
            return _1 + " " + _2 + " " + _3;
        }
    }
}
