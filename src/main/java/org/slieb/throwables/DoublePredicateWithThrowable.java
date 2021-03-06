package org.slieb.throwables;

import java.lang.FunctionalInterface;
import java.lang.SuppressWarnings;
import java.lang.Throwable;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Generated from DoublePredicate
 * Extends java.util.function.DoublePredicate to allow for a checked exception.
 *
 * @param <E> The extension
 */
@FunctionalInterface
@SuppressWarnings({"WeakerAccess"})
public interface DoublePredicateWithThrowable<E extends Throwable> extends DoublePredicate {

    /**
     * Utility method to mark lambdas of type DoublePredicateWithThrowable
     *
     * @param doublepredicatewiththrowable The interface instance
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <E extends Throwable> DoublePredicateWithThrowable<E> castDoublePredicateWithThrowable(final DoublePredicateWithThrowable<E> doublepredicatewiththrowable) {
        return doublepredicatewiththrowable;
    }

    /**
     * Utility method to unwrap lambdas of type DoublePredicate and withUncheckedThrowable any Exception
     *
     * @param doublepredicatewiththrowable The interface instance
     * @param <E> The type this interface is allowed to throw
     * @throws E the original Exception from doublepredicatewiththrowable
     * @return the cast interface
     */
    static <E extends Throwable> DoublePredicate aDoublePredicateThatUnsafelyThrowsUnchecked(final DoublePredicateWithThrowable<E> doublepredicatewiththrowable) throws E {
        return doublepredicatewiththrowable.thatUnsafelyThrowsUnchecked();
    }

    /**
     * Utility method to convert DoublePredicateWithThrowable
     * @param doublepredicate The interface instance
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <E extends Throwable> DoublePredicateWithThrowable<E> asDoublePredicateWithThrowable(final DoublePredicate doublepredicate) {
        return doublepredicate::test;
    }

    /**
     * Overridden method of DoublePredicateWithThrowable that will call testWithThrowable, but catching any exceptions.
     *
     * @param v1 parameter to overridden method
     * @return the value
     */
    @Override
    default boolean test(final double v1) {
        try {
            return testWithThrowable(v1);
        } catch (final RuntimeException | Error exception) {
            throw exception;
        } catch (final Throwable throwable) {
            throw new SuppressedException(throwable);
        }
    }

    /**
     * Functional method that will throw exceptions.
     *
     * @param v1 parameter to overridden method
     * @return the value
     * @throws E some exception
     */
    boolean testWithThrowable(final double v1) throws E;


    /**
     * @param defaultReturnValue A value to return if any throwable is caught.
     * @return An interface that returns a default value if any exception occurs.
     */
    default DoublePredicate thatReturnsOnCatch(final boolean defaultReturnValue) {
      return (final double v1) -> {
        try {
          return testWithThrowable(v1);
        } catch(final Throwable throwable) {
          return defaultReturnValue;
        }
      };
    }


    /**
     * @throws E if an exception E has been thrown, it is rethrown by this method
     * @return An interface that is only returned if no exception has been thrown.
     */
    default DoublePredicate thatUnsafelyThrowsUnchecked() throws E {
      return (final double v1) -> {
        try {
          return testWithThrowable(v1);
        } catch(final Throwable throwable) {
           SuppressedException.throwUnsafelyAsUnchecked(throwable);
           return false;        }
      };
    }


    /**
     * @param logger The logger to log exceptions on
     * @param message A message to use for logging exceptions
     * @return An interface that will log all exceptions to given logger
     */
    @SuppressWarnings("Duplicates")
    default DoublePredicateWithThrowable<E> withLogging(final Logger logger, final String message) {
        return (final double v1) -> {
            try {
                return testWithThrowable(v1);
            } catch (final Throwable throwable) {
                logger.error(message, v1, throwable);
                throw throwable;
            }
        };
    }


    /**
     * Will log WARNING level exceptions on logger if they occur within the interface
     * @param logger The logger instance to log exceptions on
     * @return An interface that will log exceptions on given logger
     */
    default DoublePredicateWithThrowable<E> withLogging(final Logger logger) {
        return withLogging(logger, "Exception in DoublePredicateWithThrowable with the argument [{}]");
    }


    /**
     * Will log WARNING level exceptions on logger if they occur within the interface
     * @return An interface that will log exceptions on global logger
     */
    default DoublePredicateWithThrowable<E> withLogging() {
        return withLogging(LoggerFactory.getLogger(getClass()));
    }



    /**
     * @param consumer An exception consumer.
     * @return An interface that will log all exceptions to given logger
     */
    @SuppressWarnings("Duplicates")
    default DoublePredicateWithThrowable<E> onException(final Consumer<Throwable> consumer) {
        return (final double v1) -> {
            try {
                return testWithThrowable(v1);
            } catch (final Throwable throwable) {
                consumer.accept(throwable);
                throw throwable;
            }
        };
    }


    /**
     * @param consumer An exception consumer.
     * @return An interface that will log all exceptions to given logger
     */
    @SuppressWarnings("Duplicates")
    default DoublePredicateWithThrowable<E> onException(final java.util.function.BiConsumer<Throwable, Object[]> consumer) {
        return (final double v1) -> {
            try {
                return testWithThrowable(v1);
            } catch (final Throwable throwable) {
                consumer.accept(throwable, new Object[]{v1});
                throw throwable;
            }
        };
    }
}
