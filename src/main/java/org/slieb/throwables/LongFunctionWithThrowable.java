package org.slieb.throwables;

/**
 * Generated from java.util.function.LongFunction
 * Extends java.util.function.LongFunction to allow for a checked exception.
 *
 * @param <R> some generic flag
 * @param <E> The extension
 */
@FunctionalInterface
public interface LongFunctionWithThrowable<R, E extends Throwable> extends java.util.function.LongFunction<R> {
    /**
     * Utility method to mark lambdas of type LongFunctionWithThrowable
     * @param longfunctionwiththrowable The interface instance
     * @param <R> Generic that corresponds to the same generic on LongFunction  
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <R, E extends Throwable> LongFunctionWithThrowable<R, E> castLongFunctionWithThrowable(LongFunctionWithThrowable<R, E> longfunctionwiththrowable) {
        return longfunctionwiththrowable;
    }

    /** 
     * Overridden method of LongFunctionWithThrowable that will call applyWithThrowable, but catching any exceptions.
     *
     * @param v1 parameter to overridden method
     * @return the value
     */
    @Override
    default R apply(long v1) {
        try {
            return applyWithThrowable(v1);
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
    R applyWithThrowable(long v1) throws E;
}