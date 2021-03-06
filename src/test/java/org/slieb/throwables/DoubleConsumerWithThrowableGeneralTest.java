package org.slieb.throwables;

import org.junit.Test;
import java.util.concurrent.atomic.AtomicReference;
import static org.slieb.throwables.DoubleConsumerWithThrowable.castDoubleConsumerWithThrowable;
import static org.junit.Assert.assertEquals;
public class DoubleConsumerWithThrowableGeneralTest {
 @Test
 public void testThrowsNothing() {
        castDoubleConsumerWithThrowable((v1) -> {
      throw new Exception("expect exception");
    }).thatThrowsNothing().accept(0);
 }

 @Test
 public void testThrowsNothingNormalOperation() {
    castDoubleConsumerWithThrowable((v1) -> {}).thatThrowsNothing().accept(0);
 }

 @Test
 public void testOnException() {
        AtomicReference<java.lang.Throwable> reference = new AtomicReference<>();
        java.lang.Exception expected = new java.lang.Exception("expected");
        try {
        castDoubleConsumerWithThrowable((v1) -> {
      throw expected;
    }).onException(reference::set).accept(0);
        } catch (Throwable ignored) {}
        assertEquals(expected, reference.get());
 }

}
