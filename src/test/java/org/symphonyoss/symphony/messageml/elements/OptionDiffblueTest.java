package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.OptionNode;

public class OptionDiffblueTest {
  /**
   * Test {@link Option#Option(Element)}.
   *
   * <p>Method under test: {@link Option#Option(Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Option.<init>(Element)"})
  public void testNewOption() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Option actualOption = new Option(parent2);

    // Assert
    assertEquals(0, actualOption.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualOption.getFormat());
    assertTrue(actualOption.getChildren().isEmpty());
    assertTrue(actualOption.getAttributes().isEmpty());
    assertEquals(Option.MESSAGEML_TAG, actualOption.getMessageMLTag());
    assertEquals(Option.MESSAGEML_TAG, actualOption.getPresentationMLTag());
    assertSame(parent2, actualOption.getParent());
  }

  /**
   * Test {@link Option#asMarkdown()}.
   *
   * <p>Method under test: {@link Option#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Option.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new Option(parent2).asMarkdown();

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
   *
   * <p>Method under test: {@link Option#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Option.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> new Option(parent).validate());
  }

  /**
   * Test {@link Option#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Option#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Option.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Option option = new Option(parent2);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> option.buildAttribute(parser, new IIOMetadataNode("foo")));
  }
}
