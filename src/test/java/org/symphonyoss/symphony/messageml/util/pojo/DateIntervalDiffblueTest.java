package org.symphonyoss.symphony.messageml.util.pojo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class DateIntervalDiffblueTest {
  /**
   * Test {@link DateInterval#getType()}.
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) Day is {@code foo}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DateInterval.getType()"})
  public void testGetType_givenDateIntervalDayIsFoo_thenReturnNull() {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom("foo");
    dateInterval.setDay("foo");
    dateInterval.setDaysOfWeek(new Integer[] {1});
    dateInterval.setTo("foo");

    // Act and Assert
    assertNull(dateInterval.getType());
  }

  /**
   * Test {@link DateInterval#getType()}.
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) DaysOfWeek is {@code null}.
   *   <li>Then return {@code range}.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DateInterval.getType()"})
  public void testGetType_givenDateIntervalDaysOfWeekIsNull_thenReturnRange() {
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
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) From is {@code foo}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DateInterval.getType()"})
  public void testGetType_givenDateIntervalFromIsFoo_thenReturnNull() {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom("foo");
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(new Integer[] {1});
    dateInterval.setTo("foo");

    // Act and Assert
    assertNull(dateInterval.getType());
  }

  /**
   * Test {@link DateInterval#getType()}.
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) From is {@code null}.
   *   <li>Then return {@code date}.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DateInterval.getType()"})
  public void testGetType_givenDateIntervalFromIsNull_thenReturnDate() {
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
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) From is {@code null}.
   *   <li>Then return {@code weekdays}.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DateInterval.getType()"})
  public void testGetType_givenDateIntervalFromIsNull_thenReturnWeekdays() {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(new Integer[] {1});
    dateInterval.setTo(null);

    // Act and Assert
    assertEquals("weekdays", dateInterval.getType());
  }

  /**
   * Test {@link DateInterval#getType()}.
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DateInterval.getType()"})
  public void testGetType_givenDateInterval_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new DateInterval().getType());
  }

  /**
   * Test {@link DateInterval#assertIsValid()}.
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) Day is {@code foo}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateInterval.assertIsValid()"})
  public void testAssertIsValid_givenDateIntervalDayIsFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom("foo");
    dateInterval.setDay("foo");
    dateInterval.setDaysOfWeek(new Integer[] {1});
    dateInterval.setTo("foo");

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateInterval.assertIsValid());
  }

  /**
   * Test {@link DateInterval#assertIsValid()}.
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) Day is {@code foo}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateInterval.assertIsValid()"})
  public void testAssertIsValid_givenDateIntervalDayIsFoo_thenThrowInvalidInputException2()
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
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) DaysOfWeek is array of {@link Integer}
   *       with minus one.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateInterval.assertIsValid()"})
  public void testAssertIsValid_givenDateIntervalDaysOfWeekIsArrayOfIntegerWithMinusOne()
      throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(new Integer[] {-1});
    dateInterval.setTo(null);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateInterval.assertIsValid());
  }

  /**
   * Test {@link DateInterval#assertIsValid()}.
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) DaysOfWeek is array of {@link Integer}
   *       with three and one.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateInterval.assertIsValid()"})
  public void testAssertIsValid_givenDateIntervalDaysOfWeekIsArrayOfIntegerWithThreeAndOne()
      throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(new Integer[] {3, 1});
    dateInterval.setTo(null);

    // Act and Assert
    dateInterval.assertIsValid();
  }

  /**
   * Test {@link DateInterval#assertIsValid()}.
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) DaysOfWeek is empty array of {@link
   *       Integer}.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateInterval.assertIsValid()"})
  public void testAssertIsValid_givenDateIntervalDaysOfWeekIsEmptyArrayOfInteger()
      throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(new Integer[] {});
    dateInterval.setTo(null);

    // Act and Assert
    dateInterval.assertIsValid();
  }

  /**
   * Test {@link DateInterval#assertIsValid()}.
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) DaysOfWeek is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateInterval.assertIsValid()"})
  public void testAssertIsValid_givenDateIntervalDaysOfWeekIsNull() throws InvalidInputException {
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
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor) From is {@code foo}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateInterval.assertIsValid()"})
  public void testAssertIsValid_givenDateIntervalFromIsFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom("foo");
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(new Integer[] {1});
    dateInterval.setTo("foo");

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateInterval.assertIsValid());
  }

  /**
   * Test {@link DateInterval#assertIsValid()}.
   *
   * <ul>
   *   <li>Given {@link DateInterval} (default constructor).
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateInterval.assertIsValid()"})
  public void testAssertIsValid_givenDateInterval_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> new DateInterval().assertIsValid());
  }

  /**
   * Test {@link DateInterval#assertIsValid()}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link DateInterval#assertIsValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateInterval.assertIsValid()"})
  public void testAssertIsValid_thenDoesNotThrow() throws InvalidInputException {
    // Arrange
    DateInterval dateInterval = new DateInterval();
    dateInterval.setFrom(null);
    dateInterval.setDay(null);
    dateInterval.setDaysOfWeek(new Integer[] {1});
    dateInterval.setTo(null);

    // Act and Assert
    dateInterval.assertIsValid();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DateInterval.<init>()",
    "String DateInterval.getDay()",
    "Integer[] DateInterval.getDaysOfWeek()",
    "String DateInterval.getFrom()",
    "String DateInterval.getTo()",
    "void DateInterval.setDay(String)",
    "void DateInterval.setDaysOfWeek(Integer[])",
    "void DateInterval.setFrom(String)",
    "void DateInterval.setTo(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DateInterval actualDateInterval = new DateInterval();
    actualDateInterval.setDay("Day");
    Integer[] daysOfWeek = new Integer[] {1};
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
    assertArrayEquals(new Integer[] {1}, actualDaysOfWeek);
  }
}
