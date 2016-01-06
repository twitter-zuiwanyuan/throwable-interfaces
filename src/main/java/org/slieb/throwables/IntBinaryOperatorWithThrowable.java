package org.slieb.throwables;

/**
 * Generated from java.util.function.IntBinaryOperator
 * Extends java.util.function.IntBinaryOperator to allow for a checked exception.
 *
 * @param <E> The extension
 */
@FunctionalInterface
public interface IntBinaryOperatorWithThrowable<E extends Throwable> extends java.util.function.IntBinaryOperator {
    /**
     * Utility method to mark lambdas of type IntBinaryOperatorWithThrowable
     * @param intbinaryoperatorwiththrowable The interface instance
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <E extends Throwable> IntBinaryOperatorWithThrowable<E> castIntBinaryOperatorWithThrowable(IntBinaryOperatorWithThrowable<E> intbinaryoperatorwiththrowable) {
        return intbinaryoperatorwiththrowable;
    }

    /** 
     * Overridden method of IntBinaryOperatorWithThrowable that will call applyAsIntWithThrowable, but catching any exceptions.
     *
     * @param v1 parameter to overridden method
     * @param v2 parameter to overridden method
     * @return the value
     */
    @Override
    default int applyAsInt(int v1, int v2) {
        try {
            return applyAsIntWithThrowable(v1, v2);
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
     * @param v2 parameter to overridden method
     * @return the value
     * @throws E some exception
     */
    int applyAsIntWithThrowable(int v1, int v2) throws E;
}