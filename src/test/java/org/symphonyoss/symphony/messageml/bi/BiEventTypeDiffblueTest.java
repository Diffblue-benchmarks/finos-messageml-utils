package org.symphonyoss.symphony.messageml.bi;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BiEventTypeDiffblueTest {
  /**
   * Test {@link BiEventType#getType()}.
   *
   * <p>Method under test: {@link BiEventType#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BiEventType.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals("MESSAGEML_MESSAGE_SENT", BiEventType.valueOf("MESSAGEML_MESSAGE_SENT").getType());
  }
}
