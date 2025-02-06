package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.commonmark.node.Node;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

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
   * Test {@link ListItem#validate()}.
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@link Element}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListItem#validate()}
   */
  @Test
  public void testValidate_givenBoldWithParentIsElement() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new ListItem(new BulletList(new Bold(mock(Element.class))))).validate();
  }

  /**
   * Test {@link ListItem#validate()}.
   * <ul>
   *   <li>Given {@link BulletList#BulletList(Element)} with parent is
   * {@link Element}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListItem#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenBulletListWithParentIsElement() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "li" can only be a child of the following elements: [orderedlist, bulletlist]
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertParent(Element.java:741)
    //       at org.symphonyoss.symphony.messageml.elements.ListItem.validate(ListItem.java:40)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ListItem(new Bold(new BulletList(mock(Element.class))))).validate();
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
