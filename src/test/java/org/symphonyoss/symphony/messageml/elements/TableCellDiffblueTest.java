package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
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
   * Test {@link TableCell#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCell#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "td"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.Element.buildAttribute(Element.java:256)
    //       at org.symphonyoss.symphony.messageml.elements.TableCell.buildAttribute(TableCell.java:52)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TableCell tableCell = new TableCell(new Bold(new BulletList(mock(Element.class))));
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    tableCell.buildAttribute(parser, new IIOMetadataNode("foo"));
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

  /**
   * Test {@link TableCell#updateBiContext(BiContext)}.
   * <p>
   * Method under test: {@link TableCell#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    TableCell tableCell = new TableCell(new Bold(new BulletList(mock(Element.class))));

    // Act
    tableCell.updateBiContext(new BiContext());
  }
}
