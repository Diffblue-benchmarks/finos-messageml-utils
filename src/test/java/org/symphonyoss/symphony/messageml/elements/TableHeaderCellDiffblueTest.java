package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableCellNode;

public class TableHeaderCellDiffblueTest {
  /**
   * Test {@link TableHeaderCell#TableHeaderCell(Element)}.
   *
   * <p>Method under test: {@link TableHeaderCell#TableHeaderCell(Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableHeaderCell.<init>(Element)"})
  public void testNewTableHeaderCell() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    TableHeaderCell actualTableHeaderCell = new TableHeaderCell(parent2);

    // Assert
    assertEquals(0, actualTableHeaderCell.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTableHeaderCell.getFormat());
    assertTrue(actualTableHeaderCell.getChildren().isEmpty());
    assertTrue(actualTableHeaderCell.getAttributes().isEmpty());
    assertEquals(TableHeaderCell.MESSAGEML_TAG, actualTableHeaderCell.getMessageMLTag());
    assertEquals(TableHeaderCell.MESSAGEML_TAG, actualTableHeaderCell.getPresentationMLTag());
    assertSame(parent2, actualTableHeaderCell.getParent());
  }

  /**
   * Test {@link TableHeaderCell#asMarkdown()}.
   *
   * <p>Method under test: {@link TableHeaderCell#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node TableHeaderCell.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new TableHeaderCell(parent2).asMarkdown();

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
   * Test {@link TableHeaderCell#toString()}.
   *
   * <p>Method under test: {@link TableHeaderCell#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TableHeaderCell.toString()"})
  public void testToString() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertEquals("Cell", new TableHeaderCell(parent).toString());
  }
}
