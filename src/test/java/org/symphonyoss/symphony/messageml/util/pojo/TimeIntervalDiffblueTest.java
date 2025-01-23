package org.symphonyoss.symphony.messageml.util.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class TimeIntervalDiffblueTest {
  /**
   * Test {@link TimeInterval#assertIsValid()}.
   * <ul>
   *   <li>Given {@link TimeInterval} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid_givenTimeInterval() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> (new TimeInterval()).assertIsValid());
  }

  /**
   * Test {@link TimeInterval#assertIsValid()}.
   * <ul>
   *   <li>Given {@link TimeInterval} (default constructor) From is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid_givenTimeIntervalFromIsNull() throws InvalidInputException {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime("foo");
    timeInterval.setFrom(null);
    timeInterval.setTo(null);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> timeInterval.assertIsValid());
  }

  /**
   * Test {@link TimeInterval#assertIsValid()}.
   * <ul>
   *   <li>Given {@link TimeInterval} (default constructor) From is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid_givenTimeIntervalFromIsNull2() throws InvalidInputException {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime("foo");
    timeInterval.setFrom(null);
    timeInterval.setTo("foo");

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> timeInterval.assertIsValid());
  }

  /**
   * Test {@link TimeInterval#assertIsValid()}.
   * <ul>
   *   <li>Given {@link TimeInterval} (default constructor) Time is
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid_givenTimeIntervalTimeIsFoo() throws InvalidInputException {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime("foo");
    timeInterval.setFrom("foo");
    timeInterval.setTo(null);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> timeInterval.assertIsValid());
  }

  /**
   * Test {@link TimeInterval#assertIsValid()}.
   * <ul>
   *   <li>Given {@link TimeInterval} (default constructor) Time is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid_givenTimeIntervalTimeIsNull() throws InvalidInputException {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime(null);
    timeInterval.setFrom("foo");
    timeInterval.setTo(null);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> timeInterval.assertIsValid());
  }

  /**
   * Test {@link TimeInterval#assertIsValid()}.
   * <ul>
   *   <li>Given {@link TimeInterval} (default constructor) Time is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid_givenTimeIntervalTimeIsNull2() throws InvalidInputException {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime(null);
    timeInterval.setFrom("foo");
    timeInterval.setTo("foo");

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> timeInterval.assertIsValid());
  }

  /**
   * Test {@link TimeInterval#getType()}.
   * <ul>
   *   <li>Given {@link TimeInterval} (default constructor) From is
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeInterval#getType()}
   */
  @Test
  public void testGetType_givenTimeIntervalFromIsNull_thenReturnNull() {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime("foo");
    timeInterval.setFrom(null);
    timeInterval.setTo("foo");

    // Act and Assert
    assertNull(timeInterval.getType());
  }

  /**
   * Test {@link TimeInterval#getType()}.
   * <ul>
   *   <li>Given {@link TimeInterval} (default constructor) From is
   * {@code null}.</li>
   *   <li>Then return {@code time}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeInterval#getType()}
   */
  @Test
  public void testGetType_givenTimeIntervalFromIsNull_thenReturnTime() {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime("foo");
    timeInterval.setFrom(null);
    timeInterval.setTo(null);

    // Act and Assert
    assertEquals("time", timeInterval.getType());
  }

  /**
   * Test {@link TimeInterval#getType()}.
   * <ul>
   *   <li>Given {@link TimeInterval} (default constructor) Time is
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeInterval#getType()}
   */
  @Test
  public void testGetType_givenTimeIntervalTimeIsFoo_thenReturnNull() {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime("foo");
    timeInterval.setFrom("foo");
    timeInterval.setTo(null);

    // Act and Assert
    assertNull(timeInterval.getType());
  }

  /**
   * Test {@link TimeInterval#getType()}.
   * <ul>
   *   <li>Given {@link TimeInterval} (default constructor) Time is
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeInterval#getType()}
   */
  @Test
  public void testGetType_givenTimeIntervalTimeIsNull_thenReturnNull() {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime(null);
    timeInterval.setFrom("foo");
    timeInterval.setTo(null);

    // Act and Assert
    assertNull(timeInterval.getType());
  }

  /**
   * Test {@link TimeInterval#getType()}.
   * <ul>
   *   <li>Given {@link TimeInterval} (default constructor) Time is
   * {@code null}.</li>
   *   <li>Then return {@code range}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeInterval#getType()}
   */
  @Test
  public void testGetType_givenTimeIntervalTimeIsNull_thenReturnRange() {
    // Arrange
    TimeInterval timeInterval = new TimeInterval();
    timeInterval.setTime(null);
    timeInterval.setFrom("foo");
    timeInterval.setTo("foo");

    // Act and Assert
    assertEquals("range", timeInterval.getType());
  }

  /**
   * Test {@link TimeInterval#getType()}.
   * <ul>
   *   <li>Given {@link TimeInterval} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeInterval#getType()}
   */
  @Test
  public void testGetType_givenTimeInterval_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TimeInterval()).getType());
  }

  /**
   * Test getters and setters.
   * <p>
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

    // Assert
    assertEquals("Time", actualTime);
    assertEquals("alice.liddell@example.org", actualTimeInterval.getTo());
    assertEquals("jane.doe@example.org", actualFrom);
  }
}
