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
public class DatePickerNodeDiffblueTest {
  @InjectMocks private DatePickerNode datePickerNode;

  /**
   * Test {@link DatePickerNode#DatePickerNode(String, String, String)}.
   *
   * <p>Method under test: {@link DatePickerNode#DatePickerNode(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePickerNode.<init>(String, String, String)"})
  public void testNewDatePickerNode() {
    // Arrange and Act
    DatePickerNode actualDatePickerNode = new DatePickerNode("Label", "127.0.0.1", "Placeholder");

    // Assert
    assertNull(actualDatePickerNode.getParent());
    assertNull(actualDatePickerNode.getFirstChild());
    assertNull(actualDatePickerNode.getLastChild());
    assertNull(actualDatePickerNode.getNext());
    assertNull(actualDatePickerNode.getPrevious());
  }

  /**
   * Test {@link DatePickerNode#getText()}.
   *
   * <p>Method under test: {@link DatePickerNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DatePickerNode.getText()"})
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals("", datePickerNode.getText());
  }
}
