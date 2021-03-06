package org.slieb.throwables;

import java.lang.FunctionalInterface;
import java.lang.SuppressWarnings;
import java.lang.Throwable;
import java.util.function.Consumer;
import java.util.function.ToLongFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Generated from ToLongFunction
 * Extends java.util.function.ToLongFunction to allow for a checked exception.
 *
 * @param <T> some generic flag
 * @param <E> The extension
 */
@FunctionalInterface
@SuppressWarnings({"WeakerAccess"})
public interface ToLongFunctionWithThrowable<T, E extends Throwable> extends ToLongFunction<T> {

    /**
     * Utility method to mark lambdas of type ToLongFunctionWithThrowable
     *
     * @param tolongfunctionwiththrowable The interface instance
     * @param <T> Generic that corresponds to the same generic on ToLongFunction  
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <T, E extends Throwable> ToLongFunctionWithThrowable<T, E> castToLongFunctionWithThrowable(final ToLongFunctionWithThrowable<T, E> tolongfunctionwiththrowable) {
        return tolongfunctionwiththrowable;
    }

    /**
     * Utility method to unwrap lambdas of type ToLongFunction and withUncheckedThrowable any Exception
     *
     * @param tolongfunctionwiththrowable The interface instance
     * @param <T> Generic that corresponds to the same generic on ToLongFunction  
     * @param <E> The type this interface is allowed to throw
     * @throws E the original Exception from tolongfunctionwiththrowable
     * @return the cast interface
     */
    static <T, E extends Throwable> ToLongFunction<T> aToLongFunctionThatUnsafelyThrowsUnchecked(final ToLongFunctionWithThrowable<T, E> tolongfunctionwiththrowable) throws E {
        return tolongfunctionwiththrowable.thatUnsafelyThrowsUnchecked();
    }

    /**
     * Utility method to convert ToLongFunctionWithThrowable
     * @param tolongfunction The interface instance
     * @param <T> Generic that corresponds to the same generic on ToLongFunction  
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <T, E extends Throwable> ToLongFunctionWithThrowable<T, E> asToLongFunctionWithThrowable(final ToLongFunction<T> tolongfunction) {
        return tolongfunction::applyAsLong;
    }

    /**
     * Overridden method of ToLongFunctionWithThrowable that will call applyAsLongWithThrowable, but catching any exceptions.
     *
     * @param v1 parameter to overridden method
     * @return the value
     */
    @Override
    default long applyAsLong(final T v1) {
        try {
            return applyAsLongWithThrowable(v1);
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
    long applyAsLongWithThrowable(final T v1) throws E;


    /**
     * @return An interface that will wrap the result in an optional, and return an empty optional when an exception occurs.
     */
    default java.util.function.Function<T, java.util.OptionalLong>     thatReturnsOptional() {
      return (v1)     -> {
        try {
          return java.util.OptionalLong.of(applyAsLongWithThrowable(v1));
        } catch(Throwable throwable) {
          return java.util.OptionalLong.empty();
        }
      };
    }


    /**
     * @param defaultReturnValue A value to return if any throwable is caught.
     * @return An interface that returns a default value if any exception occurs.
     */
    default ToLongFunction<T> thatReturnsOnCatch(final long defaultReturnValue) {
      return (final T v1) -> {
        try {
          return applyAsLongWithThrowable(v1);
        } catch(final Throwable throwable) {
          return defaultReturnValue;
        }
      };
    }


    /**
     * @throws E if an exception E has been thrown, it is rethrown by this method
     * @return An interface that is only returned if no exception has been thrown.
     */
    default ToLongFunction<T> thatUnsafelyThrowsUnchecked() throws E {
      return (final T v1) -> {
        try {
          return applyAsLongWithThrowable(v1);
        } catch(final Throwable throwable) {
           SuppressedException.throwUnsafelyAsUnchecked(throwable);
           return 0;        }
      };
    }


    /**
     * @param logger The logger to log exceptions on
     * @param message A message to use for logging exceptions
     * @return An interface that will log all exceptions to given logger
     */
    @SuppressWarnings("Duplicates")
    default ToLongFunctionWithThrowable<T, E> withLogging(final Logger logger, final String message) {
        return (final T v1) -> {
            try {
                return applyAsLongWithThrowable(v1);
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
    default ToLongFunctionWithThrowable<T, E> withLogging(final Logger logger) {
        return withLogging(logger, "Exception in ToLongFunctionWithThrowable with the argument [{}]");
    }


    /**
     * Will log WARNING level exceptions on logger if they occur within the interface
     * @return An interface that will log exceptions on global logger
     */
    default ToLongFunctionWithThrowable<T, E> withLogging() {
        return withLogging(LoggerFactory.getLogger(getClass()));
    }



    /**
     * @param consumer An exception consumer.
     * @return An interface that will log all exceptions to given logger
     */
    @SuppressWarnings("Duplicates")
    default ToLongFunctionWithThrowable<T, E> onException(final Consumer<Throwable> consumer) {
        return (final T v1) -> {
            try {
                return applyAsLongWithThrowable(v1);
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
    default ToLongFunctionWithThrowable<T, E> onException(final java.util.function.BiConsumer<Throwable, Object[]> consumer) {
        return (final T v1) -> {
            try {
                return applyAsLongWithThrowable(v1);
            } catch (final Throwable throwable) {
                consumer.accept(throwable, new Object[]{v1});
                throw throwable;
            }
        };
    }
}
