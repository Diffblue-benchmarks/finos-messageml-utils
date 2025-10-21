package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.OptionNode;

public class OptionDiffblueTest {
  /**
   * Test {@link Option#Option(Element)}.
   * <p>
   * Method under test: {@link Option#Option(Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Option.<init>(Element)"})
  public void testNewOption() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Option actualOption = new Option(parent);

    // Assert
    assertEquals(0, actualOption.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualOption.getFormat());
    assertTrue(actualOption.getChildren().isEmpty());
    assertTrue(actualOption.getAttributes().isEmpty());
    assertEquals(Option.MESSAGEML_TAG, actualOption.getMessageMLTag());
    assertEquals(Option.MESSAGEML_TAG, actualOption.getPresentationMLTag());
    assertSame(parent, actualOption.getParent());
  }

  /**
   * Test {@link Option#asMarkdown()}.
   * <p>
   * Method under test: {@link Option#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Option.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Option(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof OptionNode);
    assertEquals("-", ((OptionNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals("\n", ((OptionNode) actualAsMarkdownResult).getClosingDelimiter());
    assertNull(((OptionNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link Option#validate()}.
   * <p>
   * Method under test: {@link Option#validate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Option.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new Option(new Bold(new BulletList(mock(Element.class))))).validate());
  }
}
