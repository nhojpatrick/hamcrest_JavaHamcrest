package org.hamcrest.collection;

import org.hamcrest.test.AbstractMatcherTest;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.test.MatcherAssertions.*;
import static org.hamcrest.collection.IsMapContaining.hasKey;

public class IsMapContainingKeyTest extends AbstractMatcherTest {

    @Override
    protected Matcher<?> createMatcher() {
        return hasKey("foo");
    }

    @Test
    public void testMatchesSingletonMapContainingKey() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);

        assertMatches("Matches single key", hasKey("a"), map);
    }

    @Test
    public void testMatchesMapContainingKey() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        assertMatches("Matches a", hasKey("a"), map);
        assertMatches("Matches c", hasKey("c"), map);
    }

//    No longer compiles
//    public void testMatchesMapContainingKeyWithNoGenerics() {
//        Map map = new HashMap();
//        map.put("a", 1);
//        map.put("b", 2);
//        map.put("c", 3);
//
//        assertMatches("Matches a", hasKey("a"), map);
//        assertMatches("Matches c", hasKey("c"), map);
//    }

    @Test
    public void testMatchesMapContainingKeyWithIntegerKeys() throws Exception {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");

        assertThat(map, hasKey(1));
    }

    @Test
    public void testMatchesMapContainingKeyWithNumberKeys() throws Exception {
        Map<Number, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");

        assertThat(map, hasKey((Number)1));

        // TODO: work out the correct sprinkling of wildcards to get this to work!
//        assertThat(map, hasKey(1));
    }

    @Test
    public void testHasReadableDescription() {
        assertDescription("map containing [\"a\"->ANYTHING]", hasKey("a"));
    }

    @Test
    public void testDoesNotMatchEmptyMap() {
        assertMismatchDescription("map was []", hasKey("Foo"), new HashMap<String, Integer>());
    }

    @Test
    public void testDoesNotMatchMapMissingKey() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        assertMismatchDescription("map was [<a=1>, <b=2>, <c=3>]", hasKey("d"), map);
    }

}
