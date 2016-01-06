package org.slieb.throwables;

/**
 * Generated from java.util.function.DoublePredicate
 * Extends java.util.function.DoublePredicate to allow for a checked exception.
 *
 * @param <E> The extension
 */
@FunctionalInterface
public interface DoublePredicateWithThrowable<E extends Throwable> extends java.util.function.DoublePredicate {
    /**
     * Utility method to mark lambdas of type DoublePredicateWithThrowable
     * @param doublepredicatewiththrowable The interface instance
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <E extends Throwable> DoublePredicateWithThrowable<E> castDoublePredicateWithThrowable(DoublePredicateWithThrowable<E> doublepredicatewiththrowable) {
        return doublepredicatewiththrowable;
    }

    /** 
     * Overridden method of DoublePredicateWithThrowable that will call testWithThrowable, but catching any exceptions.
     *
     * @param v1 parameter to overridden method
     * @return the value
     */
    @Override
    default boolean test(double v1) {
        try {
            return testWithThrowable(v1);
        } catch (final RuntimeException | Error exception) {
            throw exception;
        } catch (final Throwable throwable) {
            throw new org.slieb.throwables.SuppressedException(throwable);
        }
    }

    /** 
     * Functional method that will throw exceptions.
     *
     * @param v1 parameter to overridden method
     * @return the value
     * @throws E some exception
     */
    boolean testWithThrowable(double v1) throws E;
}