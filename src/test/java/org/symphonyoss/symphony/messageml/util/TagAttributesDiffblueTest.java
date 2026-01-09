package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TagAttributesDiffblueTest {
  /**
   * Test new {@link TagAttributes} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TagAttributes}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagAttributes.<init>()"})
  public void testNewTagAttributes() {
    // Arrange and Act
    TagAttributes actualTagAttributes = new TagAttributes();

    // Assert
    assertNull(actualTagAttributes.getBbgcompticker());
    assertNull(actualTagAttributes.getBbgmarketsector());
    assertNull(actualTagAttributes.getCountrycode());
    assertNull(actualTagAttributes.getFallbackTicker());
    assertNull(actualTagAttributes.getFigi());
    assertNull(actualTagAttributes.getFigiTicker());
    assertNull(actualTagAttributes.getFullBbgCompTicker());
    assertNull(actualTagAttributes.getInstrumentclass());
    assertNull(actualTagAttributes.getIsin());
    assertNull(actualTagAttributes.getLocalcode());
    assertNull(actualTagAttributes.getOperationalMic());
    assertNull(actualTagAttributes.getReturnMainListing());
    assertNull(actualTagAttributes.getUniqueId());
    assertNull(actualTagAttributes.getUscode());
  }
}
