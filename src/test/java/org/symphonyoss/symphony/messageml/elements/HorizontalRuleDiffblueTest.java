package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.commonmark.node.Text;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class HorizontalRuleDiffblueTest {
  /**
   * Test {@link HorizontalRule#HorizontalRule(Element)}.
   * <p>
   * Method under test: {@link HorizontalRule#HorizontalRule(Element)}
   */
  @Test
  public void testNewHorizontalRule() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    HorizontalRule actualHorizontalRule = new HorizontalRule(parent);

    // Assert
    assertEquals(0, actualHorizontalRule.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualHorizontalRule.getFormat());
    assertTrue(actualHorizontalRule.getChildren().isEmpty());
    assertTrue(actualHorizontalRule.getAttributes().isEmpty());
    assertEquals(HorizontalRule.MESSAGEML_TAG, actualHorizontalRule.getMessageMLTag());
    assertEquals(HorizontalRule.MESSAGEML_TAG, actualHorizontalRule.getPresentationMLTag());
    assertSame(parent, actualHorizontalRule.getParent());
  }

  /**
   * Test {@link HorizontalRule#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HorizontalRule#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "hr"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.HorizontalRule.buildAttribute(HorizontalRule.java:41)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HorizontalRule horizontalRule = new HorizontalRule(new Bold(new BulletList(mock(Element.class))));
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    horizontalRule.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test {@link HorizontalRule#asText()}.
   * <p>
   * Method under test: {@link HorizontalRule#asText()}
   */
  @Test
  public void testAsText() {
    // Arrange, Act and Assert
    assertEquals("\n", (new HorizontalRule(new Bold(new BulletList(mock(Element.class))))).asText());
  }

  /**
   * Test {@link HorizontalRule#asMarkdown()}.
   * <p>
   * Method under test: {@link HorizontalRule#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new HorizontalRule(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Paragraph);
    Node firstChild = actualAsMarkdownResult.getFirstChild();
    assertTrue(firstChild instanceof Text);
    assertEquals("---", ((Text) firstChild).getLiteral());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(firstChild.getFirstChild());
    assertNull(firstChild.getLastChild());
    assertNull(firstChild.getNext());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(firstChild.getPrevious());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertSame(actualAsMarkdownResult, firstChild.getParent());
  }

  /**
   * Test {@link HorizontalRule#validate()}.
   * <p>
   * Method under test: {@link HorizontalRule#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "hr" may not have child elements or text content
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertNoContent(Element.java:645)
    //       at org.symphonyoss.symphony.messageml.elements.HorizontalRule.validate(HorizontalRule.java:58)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HorizontalRule horizontalRule = new HorizontalRule(new Bold(new BulletList(mock(Element.class))));
    horizontalRule.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act
    horizontalRule.validate();
  }

  /**
   * Test {@link HorizontalRule#validate()}.
   * <ul>
   *   <li>Given {@link HorizontalRule#HorizontalRule(Element)} with parent is
   * {@link Bold#Bold(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HorizontalRule#validate()}
   */
  @Test
  public void testValidate_givenHorizontalRuleWithParentIsBold() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new HorizontalRule(new Bold(new BulletList(mock(Element.class))))).validate();
  }

  /**
   * Test {@link HorizontalRule#areNestedElementsAllowed()}.
   * <p>
   * Method under test: {@link HorizontalRule#areNestedElementsAllowed()}
   */
  @Test
  public void testAreNestedElementsAllowed() {
    // Arrange, Act and Assert
    assertFalse((new HorizontalRule(new Bold(new BulletList(mock(Element.class))))).areNestedElementsAllowed());
  }

  /**
   * Test {@link HorizontalRule#toString()}.
   * <p>
   * Method under test: {@link HorizontalRule#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("\n", (new HorizontalRule(new Bold(new BulletList(null)))).toString());
  }
}
