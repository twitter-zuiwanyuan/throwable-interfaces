package org.slieb.throwables;

/**
 * Generated from java.util.function.LongUnaryOperator
 * Extends java.util.function.LongUnaryOperator to allow for a checked exception.
 *
 * @param <E> The extension
 */
@FunctionalInterface
public interface LongUnaryOperatorWithThrowable<E extends Throwable> extends java.util.function.LongUnaryOperator {


    /**
     * Utility method to mark lambdas of type LongUnaryOperatorWithThrowable
     *
     * @param longunaryoperatorwiththrowable The interface instance
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <E extends Throwable> LongUnaryOperatorWithThrowable<E> castLongUnaryOperatorWithThrowable(LongUnaryOperatorWithThrowable<E> longunaryoperatorwiththrowable) {
        return longunaryoperatorwiththrowable;
    }
    /**
     * Utility method to convert LongUnaryOperatorWithThrowable
     * @param longunaryoperator The interface instance
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <E extends Throwable> LongUnaryOperatorWithThrowable<E> asLongUnaryOperatorWithThrowable(java.util.function.LongUnaryOperator longunaryoperator) {
        return longunaryoperator::applyAsLong;
    }

    /** 
     * Overridden method of LongUnaryOperatorWithThrowable that will call applyAsLongWithThrowable, but catching any exceptions.
     *
     * @param v1 parameter to overridden method
     * @return the value
     */
    @Override
    default long applyAsLong(long v1) {
        try {
            return applyAsLongWithThrowable(v1);
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
    long applyAsLongWithThrowable(long v1) throws E;


    /**
     * @param logger The logger to log exceptions on
     * @param message A message to use for logging exceptions
     * @return An interface that will log all exceptions to given logger
     */
    @SuppressWarnings("Duplicates")
    default LongUnaryOperatorWithThrowable<E> withLogging(org.slf4j.Logger logger, String message) {
        return (v1) -> {
            try {
                return applyAsLongWithThrowable(v1);
            } catch (final Throwable throwable) {
                logger.error(message, throwable);
                throw throwable;
            }
        };
    }


    /**
     * Will log WARNING level exceptions on logger if they occur within the interface
     * @param logger The logger instance to log exceptions on
     * @return An interface that will log exceptions on given logger
     */
    default LongUnaryOperatorWithThrowable<E> withLogging(org.slf4j.Logger logger) {
        return withLogging(logger, "Exception in LongUnaryOperatorWithThrowable");
    }


    /**
     * Will log WARNING level exceptions on logger if they occur within the interface
     * @return An interface that will log exceptions on global logger
     */
    default LongUnaryOperatorWithThrowable<E> withLogging() {
        return withLogging(org.slf4j.LoggerFactory.getLogger(getClass()));
    }

}
