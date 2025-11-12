package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableCellNode;

public class TableCellDiffblueTest {
  /**
   * Test {@link TableCell#TableCell(Element)}.
   *
   * <p>Method under test: {@link TableCell#TableCell(Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableCell.<init>(Element)"})
  public void testNewTableCell() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    TableCell actualTableCell = new TableCell(parent2);

    // Assert
    assertEquals(0, actualTableCell.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTableCell.getFormat());
    assertTrue(actualTableCell.getChildren().isEmpty());
    assertTrue(actualTableCell.getAttributes().isEmpty());
    assertEquals(TableCell.MESSAGEML_TAG, actualTableCell.getMessageMLTag());
    assertEquals(TableCell.MESSAGEML_TAG, actualTableCell.getPresentationMLTag());
    assertSame(parent2, actualTableCell.getParent());
  }

  /**
   * Test {@link TableCell#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link TableCell#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableCell.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TableCell tableCell = new TableCell(parent2);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> tableCell.buildAttribute(parser, new IIOMetadataNode("Node Name")));
  }

  /**
   * Test {@link TableCell#asMarkdown()}.
   *
   * <p>Method under test: {@link TableCell#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node TableCell.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new TableCell(parent2).asMarkdown();

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
   *
   * <p>Method under test: {@link TableCell#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TableCell.toString()"})
  public void testToString() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertEquals("Cell", new TableCell(parent).toString());
  }
}
