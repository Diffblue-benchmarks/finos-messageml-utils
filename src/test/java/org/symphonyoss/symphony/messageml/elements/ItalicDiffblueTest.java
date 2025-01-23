package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.commonmark.node.Emphasis;
import org.commonmark.node.Node;
import org.junit.Test;

public class ItalicDiffblueTest {
  /**
   * Test {@link Italic#Italic(Element)}.
   * <p>
   * Method under test: {@link Italic#Italic(Element)}
   */
  @Test
  public void testNewItalic() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Italic actualItalic = new Italic(parent);

    // Assert
    assertEquals(0, actualItalic.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualItalic.getFormat());
    assertTrue(actualItalic.getChildren().isEmpty());
    assertTrue(actualItalic.getAttributes().isEmpty());
    assertEquals(Italic.MESSAGEML_TAG, actualItalic.getMessageMLTag());
    assertEquals(Italic.MESSAGEML_TAG, actualItalic.getPresentationMLTag());
    assertSame(parent, actualItalic.getParent());
  }

  /**
   * Test {@link Italic#asMarkdown()}.
   * <p>
   * Method under test: {@link Italic#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Italic(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Emphasis);
    assertEquals("_", ((Emphasis) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals("_", ((Emphasis) actualAsMarkdownResult).getOpeningDelimiter());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }
}
