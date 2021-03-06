package org.slieb.throwables;
import org.junit.Test;
import static org.slieb.throwables.ToDoubleBiFunctionWithThrowable.asToDoubleBiFunctionWithThrowable;
public class ToDoubleBiFunctionWithThrowableConvertTest {
 @Test(expected = RuntimeException.class)
 public void testThrowRuntimeException() {
    asToDoubleBiFunctionWithThrowable((v1, v2) -> {
      throw new RuntimeException("expected error");
    }).applyAsDouble(null, null);
 }

 @Test(expected = Error.class)
 public void testThrowError() {
    asToDoubleBiFunctionWithThrowable((v1, v2) -> {
      throw new Error("expected error");
    }).applyAsDouble(null, null);
 }

 @Test
 public void testAnnotatedWithFunctionalInterface() {
    ToDoubleBiFunctionWithThrowable.class.isAnnotationPresent(FunctionalInterface.class);
 }

 @Test
 public void testNormalOperation() {
    asToDoubleBiFunctionWithThrowable((v1, v2) -> {
 return 0;
    }).applyAsDouble(null, null);
 }

}
