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
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class ListItemDiffblueTest {
  /**
   * Test {@link ListItem#ListItem(Element)}.
   *
   * <p>Method under test: {@link ListItem#ListItem(Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListItem.<init>(Element)"})
  public void testNewListItem() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    ListItem actualListItem = new ListItem(parent2);

    // Assert
    assertEquals(0, actualListItem.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualListItem.getFormat());
    assertTrue(actualListItem.getChildren().isEmpty());
    assertTrue(actualListItem.getAttributes().isEmpty());
    assertEquals(ListItem.MESSAGEML_TAG, actualListItem.getMessageMLTag());
    assertEquals(ListItem.MESSAGEML_TAG, actualListItem.getPresentationMLTag());
    assertSame(parent2, actualListItem.getParent());
  }

  /**
   * Test {@link ListItem#validate()}.
   *
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ListItem#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListItem.validate()"})
  public void testValidate_givenBoldWithParentIsNull_thenDoesNotThrow()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(new Bold(null));

    // Act and Assert
    new ListItem(parent).validate();
  }

  /**
   * Test {@link ListItem#validate()}.
   *
   * <ul>
   *   <li>Given {@link BulletList#BulletList(Element)} with parent is {@code null}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link ListItem#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListItem.validate()"})
  public void testValidate_givenBulletListWithParentIsNull_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> new ListItem(parent).validate());
  }

  /**
   * Test {@link ListItem#asMarkdown()}.
   *
   * <p>Method under test: {@link ListItem#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node ListItem.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new ListItem(parent2).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof org.commonmark.node.ListItem);
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }
}
