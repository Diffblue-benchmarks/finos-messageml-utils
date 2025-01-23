package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.commonmark.node.Node;
import org.junit.Test;

public class ListItemDiffblueTest {
  /**
   * Test {@link ListItem#ListItem(Element)}.
   * <p>
   * Method under test: {@link ListItem#ListItem(Element)}
   */
  @Test
  public void testNewListItem() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    ListItem actualListItem = new ListItem(parent);

    // Assert
    assertEquals(0, actualListItem.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualListItem.getFormat());
    assertTrue(actualListItem.getChildren().isEmpty());
    assertTrue(actualListItem.getAttributes().isEmpty());
    assertEquals(ListItem.MESSAGEML_TAG, actualListItem.getMessageMLTag());
    assertEquals(ListItem.MESSAGEML_TAG, actualListItem.getPresentationMLTag());
    assertSame(parent, actualListItem.getParent());
  }

  /**
   * Test {@link ListItem#asMarkdown()}.
   * <p>
   * Method under test: {@link ListItem#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new ListItem(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof org.commonmark.node.ListItem);
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }
}
