package org.hamcrest.collection;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import static org.hamcrest.core.DescribedAs.describedAs;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Matches if array size satisfies a size matcher.
 *
 * @param <E> the array element type
 */
public class IsArrayWithSize<E> extends FeatureMatcher<E[], Integer> {

    /**
     * Constructor, best called from {@link #emptyArray()},
     * {@link #arrayWithSize(int)} or {@link #arrayWithSize(Matcher)}.
     * @param sizeMatcher the expected size
     */
    public IsArrayWithSize(Matcher<? super Integer> sizeMatcher) {
        super(sizeMatcher, "an array with size","array size");
    }

    @Override
    protected Integer featureValueOf(E[] actual) {
      return actual.length;
    }

    /**
     * Creates a matcher for arrays that matches when the <code>length</code> of the array
     * satisfies the specified matcher.
     * For example:
     * <pre>assertThat(new String[]{"foo", "bar"}, arrayWithSize(equalTo(2)))</pre>
     * @param <E>
     *     the matcher type.
     * @param sizeMatcher
     *     a matcher for the length of an examined array
     * @return The matcher.
     */
    public static <E> Matcher<E[]> arrayWithSize(Matcher<? super Integer> sizeMatcher) {
        return new IsArrayWithSize<>(sizeMatcher);
    }

    /**
     * Creates a matcher for arrays that matches when the <code>length</code> of the array
     * equals the specified <code>size</code>.
     * For example:
     * <pre>assertThat(new String[]{"foo", "bar"}, arrayWithSize(2))</pre>
     *
     * @param <E>
     *     the matcher type.
     * @param size
     *     the length that an examined array must have for a positive match
     * @return The matcher.
     */
    public static <E> Matcher<E[]> arrayWithSize(int size) {
        return arrayWithSize(equalTo(size));
    }

    /**
     * Creates a matcher for arrays that matches when the <code>length</code> of the array
     * is zero.
     * For example:
     * <pre>assertThat(new String[0], emptyArray())</pre>
     *
     * @param <E>
     *     the matcher type.
     * @return The matcher.
     */
    public static <E> Matcher<E[]> emptyArray() {
        return describedAs("an empty array", IsArrayWithSize.<E>arrayWithSize(0));
    }

}
