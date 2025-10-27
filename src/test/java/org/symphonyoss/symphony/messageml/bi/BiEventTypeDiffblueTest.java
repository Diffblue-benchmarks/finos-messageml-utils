package org.symphonyoss.symphony.messageml.bi;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BiEventTypeDiffblueTest {
  /**
   * Method under test: {@link BiEventType#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals("MESSAGEML_MESSAGE_SENT", BiEventType.valueOf("MESSAGEML_MESSAGE_SENT").getType());
  }
}
