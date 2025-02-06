package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.OptionNode;

public class OptionDiffblueTest {
  /**
   * Test {@link Option#Option(Element)}.
   * <p>
   * Method under test: {@link Option#Option(Element)}
   */
  @Test
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
  public void testValidate() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new Option(new Bold(new BulletList(mock(Element.class))))).validate());
  }

  /**
   * Test {@link Option#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Option#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "option"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.Option.buildAttribute(Option.java:60)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Option option = new Option(new Bold(new BulletList(mock(Element.class))));
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    option.buildAttribute(parser, new IIOMetadataNode("foo"));
  }
}
