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
   * Test {@link DateInterval#getType()}.
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) Day is {@code foo}.</li>
   *   <li>Then return {@code date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateInterval#getType()}
   */
  @Test
  public void testGetType_givenDateIntervalDayIsFoo_thenReturnDate() {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setDay("foo");
    dateInterval.setDaysOfWeek(null);
    dateInterval.setTo(null);

    // Act and Assert
    assertEquals("date", dateInterval.getType());
  }

  /**
   * Test {@link DateInterval#getType()}.
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) DaysOfWeek is array of
   * {@link Integer} with one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateInterval#getType()}
   */
  @Test
  public void testGetType_givenDateIntervalDaysOfWeekIsArrayOfIntegerWithOne_thenReturnNull() {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(new Integer[]{1});
    dateInterval.setTo("foo");

    // Act and Assert
    assertNull(dateInterval.getType());
  }

  /**
   * Test {@link DateInterval#getType()}.
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) From is
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateInterval#getType()}
   */
  @Test
  public void testGetType_givenDateIntervalFromIsFoo_thenReturnNull() {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom("foo");
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(null);
    dateInterval.setTo(null);

    // Act and Assert
    assertNull(dateInterval.getType());
  }

  /**
   * Test {@link DateInterval#getType()}.
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) From is
   * {@code foo}.</li>
   *   <li>Then return {@code range}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateInterval#getType()}
   */
  @Test
  public void testGetType_givenDateIntervalFromIsFoo_thenReturnRange() {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom("foo");
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(null);
    dateInterval.setTo("foo");

    // Act and Assert
    assertEquals("range", dateInterval.getType());
  }

  /**
   * Test {@link DateInterval#getType()}.
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateInterval#getType()}
   */
  @Test
  public void testGetType_givenDateInterval_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DateInterval()).getType());
  }

  /**
   * Test {@link DateInterval#getType()}.
   * <ul>
   *   <li>Then return {@code weekdays}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateInterval#getType()}
   */
  @Test
  public void testGetType_thenReturnWeekdays() {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(new Integer[]{1});
    dateInterval.setTo(null);

    // Act and Assert
    assertEquals("weekdays", dateInterval.getType());
  }

  /**
   * Test {@link DateInterval#assertIsValid()}.
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) Day is {@code foo}.</li>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid_givenDateIntervalDayIsFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setDay("foo");
    dateInterval.setDaysOfWeek(null);
    dateInterval.setTo(null);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateInterval.assertIsValid());
  }

  /**
   * Test {@link DateInterval#assertIsValid()}.
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) DaysOfWeek is array of
   * {@link Integer} with minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid_givenDateIntervalDaysOfWeekIsArrayOfIntegerWithMinusOne() throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(new Integer[]{-1});
    dateInterval.setTo(null);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateInterval.assertIsValid());
  }

  /**
   * Test {@link DateInterval#assertIsValid()}.
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) DaysOfWeek is array of
   * {@link Integer} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid_givenDateIntervalDaysOfWeekIsArrayOfIntegerWithOne() throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(new Integer[]{1});
    dateInterval.setTo("foo");

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateInterval.assertIsValid());
  }

  /**
   * Test {@link DateInterval#assertIsValid()}.
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) From is
   * {@code foo}.</li>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid_givenDateIntervalFromIsFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom("foo");
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(null);
    dateInterval.setTo(null);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateInterval.assertIsValid());
  }

  /**
   * Test {@link DateInterval#assertIsValid()}.
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) From is
   * {@code foo}.</li>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid_givenDateIntervalFromIsFoo_thenThrowInvalidInputException2()
      throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom("foo");
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(null);
    dateInterval.setTo("foo");

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateInterval.assertIsValid());
  }

  /**
   * Test {@link DateInterval#assertIsValid()}.
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor).</li>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  public void testAssertIsValid_givenDateInterval_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> (new DateInterval()).assertIsValid());
  }

  /**
   * Test getters and setters.
   * <p>
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

    // Assert
    assertEquals("Day", actualDay);
    assertEquals("alice.liddell@example.org", actualDateInterval.getTo());
    assertEquals("jane.doe@example.org", actualFrom);
    assertSame(daysOfWeek, actualDaysOfWeek);
    assertArrayEquals(new Integer[]{1}, actualDaysOfWeek);
  }
}
