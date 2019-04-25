package schrader.collection.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SuppressWarnings("unused")
class CollectionTest {

    @Nested
    @DisplayName("Java 9: static factory methods for collections")
    class Java9AddOns {

        @Test
        void immutableListOf() {
            var l = List.of(1, 2, 3);
        }

        @Test
        void immutableSetOf() {
            var s = Set.of(1, 2, 3);
        }

        @Test
        void immutableMapOf() {
            var m = Map.of(
                    1, "one",
                    2, "two",
                    3, "three"
            );
        }

        @Test
        void immutableMapOfEntries() {
            var m = Map.ofEntries(
                    Map.entry("1", "one"),
                    Map.entry("2", "two"),
                    Map.entry("3", "three")
            );
            m.put("4", "four");
        }

        @Test
        void immutableListOfThrowsUnsupportedOperationException() {
            var l = List.of(1, 2, 3);
            assertThatExceptionOfType(UnsupportedOperationException.class)
                    .isThrownBy(() -> {
                        l.add(4);
                    });
        }
    }

    @Nested
    @DisplayName("Durchschnitt, Vereinigung und Differenz")
    class SetOperations {

        @Test
        void intersection() {
            var s = new HashSet<>(Arrays.asList(1, 2, 3)); // mutable
            var s2 = Set.of(2, 3, 4); // immutable
            s.retainAll(s2);
            assertThat(s).containsExactly(2, 3);
        }

        @Test
        void union() {
            var s = new HashSet<>(Arrays.asList(1, 2, 3)); // mutable
            var s2 = Set.of(2, 3, 4); // immutable
            s.addAll(s2);
            assertThat(s).containsExactly(1, 2, 3, 4);
        }

        @Test
        void difference() {
            var s = new HashSet<>(Arrays.asList(1, 2, 3)); // mutable
            var s2 = Set.of(2, 3, 4); // immutable
            s.removeAll(s2);
            assertThat(s).containsExactly(1);
        }

        @Test
        void intersectionWithStream() {
            var s1 = Set.of(1, 2, 3);
            var s2 = Set.of(2, 3, 4);
            var s = s1.stream()
                    .filter(s2::contains)
                    .collect(Collectors.toSet());
            assertThat(s).containsExactly(2, 3);
        }

        @Test
        void unionWithStream() {
            var s1 = Set.of(1, 2, 3);
            var s2 = Set.of(2, 3, 4);
            var s = Stream.concat(s1.stream(), s2.stream())
                    .collect(Collectors.toSet());
            assertThat(s).containsExactly(1, 2, 3, 4);
        }

        @Test
        void differenceWithStream() {
            var s1 = Set.of(1, 2, 3);
            var s2 = Set.of(2, 3, 4);
            var s = s1.stream()
                    .filter(val -> !s2.contains(val))
                    .collect(Collectors.toSet());
            assertThat(s).containsExactly(1);
        }
    }
}
