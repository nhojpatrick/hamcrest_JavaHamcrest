# Hamcrest Changes

## Version 3.1 (Unreleased)

### Breaking Changes

* As a result of the bugfix to allow matching against polymorphic collections
([PR #422](https://github.com/hamcrest/JavaHamcrest/pull/422)), the signature of the
`hasItem` and `hasItems` methods has changed. Code relying on the exact signature of
these methods will need to be updated. The following methods are affected:
  * `org.hamcrest.CoreMatchers.hasItem`
  * `org.hamcrest.CoreMatchers.hasItems`
  * `org.hamcrest.Matchers.hasItem`
  * `org.hamcrest.Matchers.hasItems`
  * `org.hamcrest.core.IsCollectionContaining.hasItem`
  * `org.hamcrest.core.IsCollectionContaining.hasItems`
  * `org.hamcrest.core.IsIterableContaining.hasItem`
  * `org.hamcrest.core.IsIterableContaining.hasItems`
  * TODO: decide if these breaking changes should trigger a major version upgrade (i.e v4.0)

### New Features

* Optional matchers ([PR #421](https://github.com/hamcrest/JavaHamcrest/pull/421))
* Matchers for thrown exceptions ([PR #423](https://github.com/hamcrest/JavaHamcrest/pull/423))

### Improvements

* Javadoc improvements and cleanup ([PR #420](https://github.com/hamcrest/JavaHamcrest/pull/420),
[#427](https://github.com/hamcrest/JavaHamcrest/issues/427),
[PR #428](https://github.com/hamcrest/JavaHamcrest/pull/428))
* Derive version from git tags ([PR #419](https://github.com/hamcrest/JavaHamcrest/pull/419))
* Migrate all tests to JUnit Jupiter ([PR #424](https://github.com/hamcrest/JavaHamcrest/pull/424))

### Bugfixes

* Allow matching against polymorphic collections ([#252](https://github.com/hamcrest/JavaHamcrest/issues/252),
  [PR #422](https://github.com/hamcrest/JavaHamcrest/pull/422))

## Version 3.0 (1st August 2024)

### Breaking Changes

* From version 3.0, the jar distributed to Maven Central is now compiled to Java 1.8 bytecode,
  and is not compatible with previous versions of Java. See
  [Issue #331](https://github.com/hamcrest/JavaHamcrest/issues/331) and
  [PR #411](https://github.com/hamcrest/JavaHamcrest/issues/411) for details. Developers who use Java 1.7 earlier can still
  depend upon `hamcrest-2.2.jar`.

### Improvements

* FileMatchersTest simplification ([PR #389](https://github.com/hamcrest/JavaHamcrest/issues/389))
* License cleanup ([PR #414](https://github.com/hamcrest/JavaHamcrest/issues/414),
  [PR #415](https://github.com/hamcrest/JavaHamcrest/issues/415), see also
  [#264](https://github.com/hamcrest/JavaHamcrest/issues/264),
  [#355](https://github.com/hamcrest/JavaHamcrest/issues/355),
  [#396](https://github.com/hamcrest/JavaHamcrest/issues/396),and
  [#399](https://github.com/hamcrest/JavaHamcrest/issues/399))


## Version 2.2 (17th October 2019)

### Improvements

* AllOf/AnyOf: Pass the matchers to constructor using varargs ([Issue #245](https://github.com/hamcrest/JavaHamcrest/pull/245))
* Matchers.anyOf: Fix generic bounds compatibility for JDK 11 ([Issue #256](https://github.com/hamcrest/JavaHamcrest/issues/256), [Issue #257](https://github.com/hamcrest/JavaHamcrest/issues/257))
* AssertionError message is unhelpful when match fails for byte type ([Issue #254](https://github.com/hamcrest/JavaHamcrest/issues/254), [Issue #255](https://github.com/hamcrest/JavaHamcrest/issues/255))
* Use platform specific line breaks ([PR #267](https://github.com/hamcrest/JavaHamcrest/pull/267))
* Build now checks for consistent use of spaces ([PR #217](https://github.com/hamcrest/JavaHamcrest/pull/217))

### Bugfixes
* Fix compatibility issue for development with Android D8 ([Issue #246](https://github.com/hamcrest/JavaHamcrest/issues/246))
* Fix typo in license name ([Issue #247](https://github.com/hamcrest/JavaHamcrest/pull/247))
* 1.3 compatible constructors for string matchers ([Issue #259](https://github.com/hamcrest/JavaHamcrest/issues/259), [Issue #260](https://github.com/hamcrest/JavaHamcrest/issues/260))
* Fix for split packages with Java 9 modules ([Issue #269](https://github.com/hamcrest/JavaHamcrest/issues/269), [PR #270](https://github.com/hamcrest/JavaHamcrest/pull/270))


## Version 2.1 (21st December 2018)

### Overview for 2.1

After a long hiatus without releases, this version simplifies the packaging of
Hamcrest into a single jar: `hamcrest-<version>.jar`. Other big changes include
Java 9 module compatibility, migrating the code repository from Google Code to
GitHub, along with numerous other new features, improvements and bug fixes.

### Breaking Changes for 2.1

* The way that the project is packaged has changed. This may cause problems with
  correctly upgrading transitive dependencies. Refer to the
  [Hamcrest Distributables](http://hamcrest.org/JavaHamcrest/distributables.html)
  documentation for more information, and in particular,
  [Upgrading from Hamcrest 1.x](http://hamcrest.org/JavaHamcrest/distributables.html#upgrading-from-hamcrest-1.x)
* `org.hamcrest.Factory` has been removed. This was only used in old implementations
  of the hamcrest build toolchain, and can safely be deleted from client code without
  any effect.

### Changes for 2.1

* Documentation updates
* Several JavaDoc improvements and corrections
* Fix JavaDoc examples
* Upgraded to Java 7
* Build with Gradle
* Publish a single jar `hamcrest-2.1.jar`
* Publish pom-only artifacts for `hamcrest-core` and `hamcrest-library`.
* Add implementation for CharSequence length matcher
* Fix for TypeSafeDiagnosingMatcher can't detect generic types for subclass
* Make Hamcrest an OSGI bundle
* Add StringRegularExpression matcher
* Fix StringContainsInOrder to detect if a repeated pattern is missing
* Add ArrayAsIterableMatcher
* Fix description for IsEqualIgnoringCase
* Removed deprecated methods from previous release
* Improve mismatch description of hasItem/hasItems
* General improvements to mismatch descriptions
* Deprecated several matcher factory methods of the for "isXyz"
* Fix [GH issue #75](https://github.com/hamcrest/JavaHamcrest/issues/75) - address doclint errors reported in JDK 1.8
* Fix [GH issue #69](https://github.com/hamcrest/JavaHamcrest/issues/69) - Iterable contains in order is null-safe
* Fix [GH issue #59](https://github.com/hamcrest/JavaHamcrest/issues/59) - added equalToObject() (i.e. unchecked) method
* Fix [GH issue #25](https://github.com/hamcrest/JavaHamcrest/issues/25) - arrayContaining(null, null) cause NullPointerException
* Fix [GH issue #36](https://github.com/hamcrest/JavaHamcrest/issues/36) - string matching on regular expressions
* Fix [GH issue #8](https://github.com/hamcrest/JavaHamcrest/issues/8) - isCloseTo() shows wrong delta in mismatch description
* Fix [GH issue #59](https://github.com/hamcrest/JavaHamcrest/issues/59) - add untyped version of equalTo, named equalToObject
* Fix [GC issue #131](https://code.google.com/archive/p/hamcrest/issues/131) - Implement IsEmptyMap, IsMapWithSize
* Fix [GC issue #187](https://code.google.com/archive/p/hamcrest/issues/187) - IsArray.describeMismatchSafely() should use Matcher.describeMismatch
* Fix [GC issue #155](https://code.google.com/archive/p/hamcrest/issues/155) - Add Matcher implementation for files
* Fix [GC issue #69](https://code.google.com/archive/p/hamcrest/issues/69) - fix NPE in IsIterableContainingInOrder

## Version 1.3 (9th July 2012)

* Introduce Condition class to ease the implementation of multi-step matches
* Upgrade qdox (included in the generator) to the latest stable version
* Correct inadvertent deprecation of the Is.isA factory method
* Fix [issue #179](https://code.google.com/archive/p/hamcrest/issues/179) - AllOf does not output mismatch description
* Fix [issue #177](https://code.google.com/archive/p/hamcrest/issues/177) - Introduced closeTo matcher for BigDecimals
* Fix [issue #152](https://code.google.com/archive/p/hamcrest/issues/152) - Factory classes missing from matchers.xml
* Fix [issue #144](https://code.google.com/archive/p/hamcrest/issues/144) - OrderingComparison doesn't describe mismatch of comparables that return values other than (-1,0,1)
* Fix [issue #134](https://code.google.com/archive/p/hamcrest/issues/134) - DescribedAs does not delegate describeMismatch
* Fix [issue #106](https://code.google.com/archive/p/hamcrest/issues/106) - deprecation warning when writing custom matchers
* Fix [issue #101](https://code.google.com/archive/p/hamcrest/issues/101) - Added theInstance alias for sameInstance factory method

## Version 1.3 RC2 (22nd October 2010)

* Added FeatureMatcher
* distinguish between instanceOf() and any()

## Version 1.2 (16th May 2009)

* Added mismatch reporting
* Added WithSamePropertyValuesAs matcher
* Moved any() from IsAnything to IsInstanceOf. It now checks the type of the matched object
* Moved MatcherAssert from integration to core
* Tightened up generics.
* Added IsMapContainingKey and IsMapContainingValue matchers to resolve a
  generics bug in hasKey and hasValue static factories previously declared
  in IsMapContaining (ngd)
* Added IsCollectionOnlyContaining and IsArrayOnlyContaining which matches
  collections (and arrays) where all match a given matcher. E.g onlyContains(3,4,5)
  or onlyContains(lessThan(9))
* text module moved to separate project, hamcrest-text-patterns
* added more colection matchers: xContainingInAnyOrder, xContainingInOrder, xWithSize
* new text Matcher: IsEmptyString
* hamcrest generator uses method return type

## Version 1.1 (30th June 2007)

* Hamcrest Generator now includes JavaDoc and parameter names in generated code
  by using QDox to parse the source code.
* Created hamcrest-core.jar (and removed hamcrest-api.jar).
  Moved core set of matchers (and, eq, not, etc)
  to this package to make it more practical for external libraries
  to embed Hamcrest.
* Created CoreMatchers (static import sugar) in hamcrest-core.jar.
* StringBuilder can use any Appendable (not just StringBuffer).
* Added sensible toString() method to BaseMatcher.
* Created StringDescription.asString() alias (because toString() caused issues
  with static imports).
* Relaxed isInstanceOf() matcher generic type so it can be used on any kind of
  object. e.g. assertThat(someUnknownObject, isInstanceOf(String.class));
* Added any(Class<T>), null(Class<T>) and notNull(Class<T>) matchers, which returns
  Matcher<T>. Helpful when the compiler struggles with type inference.
* Modified anyOf() and allOf() to accept mixed-types.
* TypeSafeMatcher.matchesSafely() is now public.
* Generator recognizes @Factory methods that return subclass of Matcher.
  (Fix by David Saff)

## Version 1.0 (15th December 2006)

Initial release.

* Support for namespaces in HasXPath
* Bug fix for matching empty elements with HasXPath
