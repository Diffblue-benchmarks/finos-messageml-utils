package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.commonmark.node.Emphasis;
import org.commonmark.node.Node;
import org.junit.Test;

public class SubscriptDiffblueTest {
  /**
   * Test {@link Subscript#Subscript(Element)}.
   * <p>
   * Method under test: {@link Subscript#Subscript(Element)}
   */
  @Test
  public void testNewSubscript() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Subscript actualSubscript = new Subscript(parent);

    // Assert
    assertEquals(0, actualSubscript.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualSubscript.getFormat());
    assertTrue(actualSubscript.getChildren().isEmpty());
    assertTrue(actualSubscript.getAttributes().isEmpty());
    assertEquals(Subscript.MESSAGEML_TAG, actualSubscript.getMessageMLTag());
    assertEquals(Subscript.MESSAGEML_TAG, actualSubscript.getPresentationMLTag());
    assertSame(parent, actualSubscript.getParent());
  }

  /**
   * Test {@link Subscript#asMarkdown()}.
   * <p>
   * Method under test: {@link Subscript#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Subscript(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Emphasis);
    assertEquals("~", ((Emphasis) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals("~", ((Emphasis) actualAsMarkdownResult).getOpeningDelimiter());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }
}
