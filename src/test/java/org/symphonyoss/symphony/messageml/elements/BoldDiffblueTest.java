package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.commonmark.node.Node;
import org.commonmark.node.StrongEmphasis;
import org.junit.Test;

public class BoldDiffblueTest {
  /**
   * Test {@link Bold#Bold(Element)}.
   * <p>
   * Method under test: {@link Bold#Bold(Element)}
   */
  @Test
  public void testNewBold() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    // Act
    Bold actualBold = new Bold(parent);

    // Assert
    assertEquals(0, actualBold.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualBold.getFormat());
    assertTrue(actualBold.getChildren().isEmpty());
    assertTrue(actualBold.getAttributes().isEmpty());
    assertEquals(Bold.MESSAGEML_TAG, actualBold.getMessageMLTag());
    assertEquals(Bold.MESSAGEML_TAG, actualBold.getPresentationMLTag());
    assertSame(parent, actualBold.getParent());
  }

  /**
   * Test {@link Bold#asMarkdown()}.
   * <p>
   * Method under test: {@link Bold#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Bold(new BulletList(mock(Element.class)))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof StrongEmphasis);
    assertEquals("**", ((StrongEmphasis) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals("**", ((StrongEmphasis) actualAsMarkdownResult).getOpeningDelimiter());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }
}
