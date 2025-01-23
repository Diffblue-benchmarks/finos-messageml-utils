package org.symphonyoss.symphony.messageml.util.instrument.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ProviderIdDiffblueTest {
  /**
   * Test {@link ProviderId#fromValue(String)}.
   * <ul>
   *   <li>When {@code edi}.</li>
   *   <li>Then return {@code EDI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProviderId#fromValue(String)}
   */
  @Test
  public void testFromValue_whenEdi_thenReturnEdi() {
    // Arrange, Act and Assert
    assertEquals(ProviderId.EDI, ProviderId.fromValue("edi"));
  }

  /**
   * Test {@link ProviderId#fromValue(String)}.
   * <ul>
   *   <li>When {@code Text}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProviderId#fromValue(String)}
   */
  @Test
  public void testFromValue_whenText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ProviderId.fromValue("Text"));
  }
}
