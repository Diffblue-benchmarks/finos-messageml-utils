package org.symphonyoss.symphony.messageml.util.pojo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class DateIntervalDiffblueTest {
  /**
   * Method under test: {@link DateInterval#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull((new DateInterval()).getType());
  }

  /**
   * Method under test: {@link DateInterval#getType()}
   */
  @Test
  public void testGetType2() {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setTo(null);
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(new Integer[]{1});

    // Act and Assert
    assertEquals("weekdays", dateInterval.getType());
  }

  /**
   * Method under test: {@link DateInterval#getType()}
   */
  @Test
  public void testGetType3() {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setTo(null);
    dateInterval.setDay("foo");
    dateInterval.setDaysOfWeek(null);

    // Act and Assert
    assertEquals("date", dateInterval.getType());
  }

  /**
   * Method under test: {@link DateInterval#getType()}
   */
  @Test
  public void testGetType4() {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setTo(null);
    dateInterval.setDay("foo");
    dateInterval.setDaysOfWeek(new Integer[]{1});

    // Act and Assert
    assertNull(dateInterval.getType());
  }

  /**
   * Method under test: {@link DateInterval#getType()}
   */
  @Test
  public void testGetType5() {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom("foo");
    dateInterval.setTo(null);
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(null);

    // Act and Assert
    assertNull(dateInterval.getType());
  }

  /**
   * Method under test: {@link DateInterval#getType()}
   */
  @Test
  public void testGetType6() {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom("foo");
    dateInterval.setTo("foo");
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(null);

    // Act and Assert
    assertEquals("range", dateInterval.getType());
  }

  /**
   * Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> (new DateInterval()).assertIsValid());
  }

  /**
   * Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid2() throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setTo(null);
    dateInterval.setDay("foo");
    dateInterval.setDaysOfWeek(null);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateInterval.assertIsValid());
  }

  /**
   * Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid3() throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setTo(null);
    dateInterval.setDay("foo");
    dateInterval.setDaysOfWeek(new Integer[]{1});

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateInterval.assertIsValid());
  }

  /**
   * Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid4() throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom("foo");
    dateInterval.setTo(null);
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(null);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateInterval.assertIsValid());
  }

  /**
   * Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid5() throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom("foo");
    dateInterval.setTo("foo");
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(null);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateInterval.assertIsValid());
  }

  /**
   * Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid6() throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setTo(null);
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(new Integer[]{-1});

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateInterval.assertIsValid());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DateInterval}
   *   <li>{@link DateInterval#setDay(String)}
   *   <li>{@link DateInterval#setDaysOfWeek(Integer[])}
   *   <li>{@link DateInterval#setFrom(String)}
   *   <li>{@link DateInterval#setTo(String)}
   *   <li>{@link DateInterval#getDay()}
   *   <li>{@link DateInterval#getDaysOfWeek()}
   *   <li>{@link DateInterval#getFrom()}
   *   <li>{@link DateInterval#getTo()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DateInterval actualDateInterval = new DateInterval();
    actualDateInterval.setDay("Day");
    Integer[] daysOfWeek = new Integer[]{1};
    actualDateInterval.setDaysOfWeek(daysOfWeek);
    actualDateInterval.setFrom("jane.doe@example.org");
    actualDateInterval.setTo("alice.liddell@example.org");
    String actualDay = actualDateInterval.getDay();
    Integer[] actualDaysOfWeek = actualDateInterval.getDaysOfWeek();
    String actualFrom = actualDateInterval.getFrom();

    // Assert that nothing has changed
    assertEquals("Day", actualDay);
    assertEquals("alice.liddell@example.org", actualDateInterval.getTo());
    assertEquals("jane.doe@example.org", actualFrom);
    assertSame(daysOfWeek, actualDaysOfWeek);
    assertArrayEquals(new Integer[]{1}, actualDaysOfWeek);
  }
}
