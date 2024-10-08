package org.hamcrest.collection;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @param <E> the collection element type
 * @deprecated As of release 2.1, replaced by {@link ArrayMatching}.
 */
@Deprecated
public class IsArrayContainingInAnyOrder<E> extends TypeSafeMatcher<E[]> {

    private final IsIterableContainingInAnyOrder<E> iterableMatcher;
    private final Collection<Matcher<? super E>> matchers;

    /**
     * Constructor, best called from {@link #arrayContainingInAnyOrder(Object[])},
     * {@link #arrayContainingInAnyOrder(Matcher[])}, or {@link #arrayContainingInAnyOrder(Collection)}.
     * @param matchers matchers for expected values
     */
    public IsArrayContainingInAnyOrder(Collection<Matcher<? super E>> matchers) {
        this.iterableMatcher = new IsIterableContainingInAnyOrder<>(matchers);
        this.matchers = matchers;
    }

    @Override
    public boolean matchesSafely(E[] item) {
        return iterableMatcher.matches(Arrays.asList(item));
    }

    @Override
    public void describeMismatchSafely(E[] item, Description mismatchDescription) {
      iterableMatcher.describeMismatch(Arrays.asList(item), mismatchDescription);
    };

    @Override
    public void describeTo(Description description) {
        description.appendList("[", ", ", "]", matchers)
            .appendText(" in any order");
    }

    /**
     * Creates an order agnostic matcher for arrays that matches when each item in the
     * examined array satisfies one matcher anywhere in the specified matchers.
     * For a positive match, the examined array must be of the same length as the number of
     * specified matchers.
     * <p>
     * N.B. each of the specified matchers will only be used once during a given examination, so be
     * careful when specifying matchers that may be satisfied by more than one entry in an examined
     * array.
     * <p>
     * For example:
     * <pre>assertThat(new String[]{"foo", "bar"}, arrayContainingInAnyOrder(equalTo("bar"), equalTo("foo")))</pre>
     *
     * @deprecated As of version 2.1, use {@link ArrayMatching#arrayContainingInAnyOrder(Matcher[])}.
     * @param <E>
     *     the matcher type.
     * @param itemMatchers
     *     a list of matchers, each of which must be satisfied by an entry in an examined array
     * @return The matcher.
     */
    public static <E> Matcher<E[]> arrayContainingInAnyOrder(Matcher<? super E>... itemMatchers) {
        return arrayContainingInAnyOrder((Collection) Arrays.asList(itemMatchers));
    }

    /**
     * Creates an order agnostic matcher for arrays that matches when each item in the
     * examined array satisfies one matcher anywhere in the specified collection of matchers.
     * For a positive match, the examined array must be of the same length as the specified collection
     * of matchers.
     * <p>
     * N.B. each matcher in the specified collection will only be used once during a given
     * examination, so be careful when specifying matchers that may be satisfied by more than
     * one entry in an examined array.
     * <p>
     * For example:
     * <pre>assertThat(new String[]{"foo", "bar"}, arrayContainingInAnyOrder(Arrays.asList(equalTo("bar"), equalTo("foo"))))</pre>
     *
     * @deprecated As of version 2.1, use {@link ArrayMatching#arrayContainingInAnyOrder(Collection)}.
     * @param <E>
     *     the matcher type.
     * @param itemMatchers
     *     a list of matchers, each of which must be satisfied by an item provided by an examined array
     * @return The matcher.
     */
    public static <E> Matcher<E[]> arrayContainingInAnyOrder(Collection<Matcher<? super E>> itemMatchers) {
        return new IsArrayContainingInAnyOrder<>(itemMatchers);
    }

    /**
     * Creates an order agnostic matcher for arrays that matches when each item in the
     * examined array is logically equal to one item anywhere in the specified items.
     * For a positive match, the examined array must be of the same length as the number of
     * specified items.
     * <p>
     * N.B. each of the specified items will only be used once during a given examination, so be
     * careful when specifying items that may be equal to more than one entry in an examined
     * array.
     * <p>
     * For example:
     * <pre>assertThat(new String[]{"foo", "bar"}, containsInAnyOrder("bar", "foo"))</pre>
     *
     * @deprecated As of version 2.1, use {@link ArrayMatching#arrayContainingInAnyOrder(Object[])}.
     * @param <E>
     *     the matcher type.
     * @param items
     *     the items that must equal the entries of an examined array, in any order
     * @return The matcher.
     */
    public static <E> Matcher<E[]> arrayContainingInAnyOrder(E... items) {
      List<Matcher<? super E>> matchers = new ArrayList<>();
      for (E item : items) {
          matchers.add(equalTo(item));
      }
      return new IsArrayContainingInAnyOrder<>(matchers);
    }

}
