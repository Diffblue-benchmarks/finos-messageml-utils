package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableCellNode;

public class TableHeaderCellDiffblueTest {
  /**
   * Method under test: {@link TableHeaderCell#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new TableHeaderCell(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

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
   * Method under test: {@link TableHeaderCell#TableHeaderCell(Element)}
   */
  @Test
  public void testNewTableHeaderCell() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    TableHeaderCell actualTableHeaderCell = new TableHeaderCell(parent);

    // Assert
    assertEquals(0, actualTableHeaderCell.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTableHeaderCell.getFormat());
    assertTrue(actualTableHeaderCell.getChildren().isEmpty());
    assertTrue(actualTableHeaderCell.getAttributes().isEmpty());
    assertEquals(TableHeaderCell.MESSAGEML_TAG, actualTableHeaderCell.getMessageMLTag());
    assertEquals(TableHeaderCell.MESSAGEML_TAG, actualTableHeaderCell.getPresentationMLTag());
    assertSame(parent, actualTableHeaderCell.getParent());
  }

  /**
   * Method under test: {@link TableHeaderCell#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Cell", (new TableHeaderCell(new Bold(new BulletList(null)))).toString());
  }
}
