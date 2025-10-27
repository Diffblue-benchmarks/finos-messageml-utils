package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.commonmark.node.Text;
import org.junit.Test;

public class HorizontalRuleDiffblueTest {
  /**
   * Method under test: {@link HorizontalRule#asText()}
   */
  @Test
  public void testAsText() {
    // Arrange, Act and Assert
    assertEquals("\n", (new HorizontalRule(new Bold(new BulletList(mock(Element.class))))).asText());
  }

  /**
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
   * Method under test: {@link HorizontalRule#areNestedElementsAllowed()}
   */
  @Test
  public void testAreNestedElementsAllowed() {
    // Arrange, Act and Assert
    assertFalse((new HorizontalRule(new Bold(new BulletList(mock(Element.class))))).areNestedElementsAllowed());
  }

  /**
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
   * Method under test: {@link HorizontalRule#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("\n", (new HorizontalRule(new Bold(new BulletList(null)))).toString());
  }
}
