package schrader.collection.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

class CollectionTest {

    @Nested
    @DisplayName("Java 9: static factory methods for collections")
    class Java9AddOns {

        @Test
        void listOf() {
            var l = List.of(1, 2, 3);
        }

        @Test
        void setOf() {
            var s = Set.of(1, 2, 3);
        }

        @Test
        void mapOf() {
            var m = Map.of(
                    1, "one",
                    2, "two",
                    3, "three"
            );
        }

        @Test
        void mapOfEntries() {
            var m = Map.ofEntries(
                    Map.entry("1", "one"),
                    Map.entry("2", "two"),
                    Map.entry("3", "three")
            );
        }
    }
}
