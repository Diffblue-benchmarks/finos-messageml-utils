package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TimezonePickerNodeDiffblueTest {
  @InjectMocks private TimezonePickerNode timezonePickerNode;

  /**
   * Test {@link TimezonePickerNode#TimezonePickerNode(String, String, String)}.
   *
   * <p>Method under test: {@link TimezonePickerNode#TimezonePickerNode(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePickerNode.<init>(String, String, String)"})
  public void testNewTimezonePickerNode() {
    // Arrange and Act
    TimezonePickerNode actualTimezonePickerNode =
        new TimezonePickerNode("Label", "127.0.0.1", "Placeholder");

    // Assert
    assertNull(actualTimezonePickerNode.getParent());
    assertNull(actualTimezonePickerNode.getFirstChild());
    assertNull(actualTimezonePickerNode.getLastChild());
    assertNull(actualTimezonePickerNode.getNext());
    assertNull(actualTimezonePickerNode.getPrevious());
  }

  /**
   * Test {@link TimezonePickerNode#getText()}.
   *
   * <p>Method under test: {@link TimezonePickerNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TimezonePickerNode.getText()"})
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals("", timezonePickerNode.getText());
  }
}
