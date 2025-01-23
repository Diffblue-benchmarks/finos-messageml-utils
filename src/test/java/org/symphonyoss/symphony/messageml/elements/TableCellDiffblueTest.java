package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableCellNode;

public class TableCellDiffblueTest {
  /**
   * Test {@link TableCell#TableCell(Element)}.
   * <p>
   * Method under test: {@link TableCell#TableCell(Element)}
   */
  @Test
  public void testNewTableCell() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    TableCell actualTableCell = new TableCell(parent);

    // Assert
    assertEquals(0, actualTableCell.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTableCell.getFormat());
    assertTrue(actualTableCell.getChildren().isEmpty());
    assertTrue(actualTableCell.getAttributes().isEmpty());
    assertEquals(TableCell.MESSAGEML_TAG, actualTableCell.getMessageMLTag());
    assertEquals(TableCell.MESSAGEML_TAG, actualTableCell.getPresentationMLTag());
    assertSame(parent, actualTableCell.getParent());
  }

  /**
   * Test {@link TableCell#asMarkdown()}.
   * <p>
   * Method under test: {@link TableCell#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new TableCell(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TableCellNode);
    assertEquals("   ", ((TableCellNode) actualAsMarkdownResult).getDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link TableCell#toString()}.
   * <p>
   * Method under test: {@link TableCell#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Cell", (new TableCell(new Bold(new BulletList(null)))).toString());
  }
}
