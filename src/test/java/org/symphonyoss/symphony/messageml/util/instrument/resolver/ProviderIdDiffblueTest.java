package org.symphonyoss.symphony.messageml.util.instrument.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ProviderIdDiffblueTest {
  /**
   * Method under test: {@link ProviderId#fromValue(String)}
   */
  @Test
  public void testFromValue() {
    // Arrange, Act and Assert
    assertNull(ProviderId.fromValue("Text"));
    assertEquals(ProviderId.EDI, ProviderId.fromValue("edi"));
  }
}
