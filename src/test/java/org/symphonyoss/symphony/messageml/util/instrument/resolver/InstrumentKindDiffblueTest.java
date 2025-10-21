package org.symphonyoss.symphony.messageml.util.instrument.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InstrumentKindDiffblueTest {
  /**
   * Test {@link InstrumentKind#fromValue(String)}.
   * <ul>
   *   <li>When {@code equity}.</li>
   *   <li>Then return {@code EQUITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentKind#fromValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstrumentKind InstrumentKind.fromValue(String)"})
  public void testFromValue_whenEquity_thenReturnEquity() {
    // Arrange, Act and Assert
    assertEquals(InstrumentKind.EQUITY, InstrumentKind.fromValue("equity"));
  }

  /**
   * Test {@link InstrumentKind#fromValue(String)}.
   * <ul>
   *   <li>When {@code Text}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentKind#fromValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstrumentKind InstrumentKind.fromValue(String)"})
  public void testFromValue_whenText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(InstrumentKind.fromValue("Text"));
  }

  /**
   * Test {@link InstrumentKind#toValues()}.
   * <p>
   * Method under test: {@link InstrumentKind#toValues()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List InstrumentKind.toValues()"})
  public void testToValues() {
    // Arrange and Act
    List<String> actualToValuesResult = InstrumentKind.toValues();

    // Assert
    assertEquals(3, actualToValuesResult.size());
    assertEquals("equity", actualToValuesResult.get(0));
    assertEquals("fxcross", actualToValuesResult.get(2));
    assertEquals("index", actualToValuesResult.get(1));
  }

  /**
   * Test {@link InstrumentKind#getValue()}.
   * <p>
   * Method under test: {@link InstrumentKind#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InstrumentKind.getValue()"})
  public void testGetValue() {
    // Arrange, Act and Assert
    assertEquals("equity", InstrumentKind.valueOf("EQUITY").getValue());
  }
}
