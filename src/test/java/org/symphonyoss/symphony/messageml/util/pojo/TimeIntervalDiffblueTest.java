package org.symphonyoss.symphony.messageml.util.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class TimeIntervalDiffblueTest {
  /**
   * Method under test: {@link TimeInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> (new TimeInterval()).assertIsValid());
  }

  /**
   * Method under test: {@link TimeInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid2() throws InvalidInputException {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime(null);
    timeInterval.setFrom("foo");
    timeInterval.setTo(null);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> timeInterval.assertIsValid());
  }

  /**
   * Method under test: {@link TimeInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid3() throws InvalidInputException {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime(null);
    timeInterval.setFrom("foo");
    timeInterval.setTo("foo");

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> timeInterval.assertIsValid());
  }

  /**
   * Method under test: {@link TimeInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid4() throws InvalidInputException {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime("foo");
    timeInterval.setFrom(null);
    timeInterval.setTo(null);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> timeInterval.assertIsValid());
  }

  /**
   * Method under test: {@link TimeInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid5() throws InvalidInputException {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime("foo");
    timeInterval.setFrom(null);
    timeInterval.setTo("foo");

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> timeInterval.assertIsValid());
  }

  /**
   * Method under test: {@link TimeInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid6() throws InvalidInputException {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime("foo");
    timeInterval.setFrom("foo");
    timeInterval.setTo(null);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> timeInterval.assertIsValid());
  }

  /**
   * Method under test: {@link TimeInterval#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull((new TimeInterval()).getType());
  }

  /**
   * Method under test: {@link TimeInterval#getType()}
   */
  @Test
  public void testGetType2() {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime(null);
    timeInterval.setFrom("foo");
    timeInterval.setTo(null);

    // Act and Assert
    assertNull(timeInterval.getType());
  }

  /**
   * Method under test: {@link TimeInterval#getType()}
   */
  @Test
  public void testGetType3() {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime(null);
    timeInterval.setFrom("foo");
    timeInterval.setTo("foo");

    // Act and Assert
    assertEquals("range", timeInterval.getType());
  }

  /**
   * Method under test: {@link TimeInterval#getType()}
   */
  @Test
  public void testGetType4() {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime("foo");
    timeInterval.setFrom(null);
    timeInterval.setTo(null);

    // Act and Assert
    assertEquals("time", timeInterval.getType());
  }

  /**
   * Method under test: {@link TimeInterval#getType()}
   */
  @Test
  public void testGetType5() {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime("foo");
    timeInterval.setFrom(null);
    timeInterval.setTo("foo");

    // Act and Assert
    assertNull(timeInterval.getType());
  }

  /**
   * Method under test: {@link TimeInterval#getType()}
   */
  @Test
  public void testGetType6() {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime("foo");
    timeInterval.setFrom("foo");
    timeInterval.setTo(null);

    // Act and Assert
    assertNull(timeInterval.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TimeInterval}
   *   <li>{@link TimeInterval#setFrom(String)}
   *   <li>{@link TimeInterval#setTime(String)}
   *   <li>{@link TimeInterval#setTo(String)}
   *   <li>{@link TimeInterval#getFrom()}
   *   <li>{@link TimeInterval#getTime()}
   *   <li>{@link TimeInterval#getTo()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TimeInterval actualTimeInterval = new TimeInterval();
    actualTimeInterval.setFrom("jane.doe@example.org");
    actualTimeInterval.setTime("Time");
    actualTimeInterval.setTo("alice.liddell@example.org");
    String actualFrom = actualTimeInterval.getFrom();
    String actualTime = actualTimeInterval.getTime();

    // Assert that nothing has changed
    assertEquals("Time", actualTime);
    assertEquals("alice.liddell@example.org", actualTimeInterval.getTo());
    assertEquals("jane.doe@example.org", actualFrom);
  }
}
