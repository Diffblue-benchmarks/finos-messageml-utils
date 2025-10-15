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
import org.commonmark.node.StrongEmphasis;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

@RunWith(MockitoJUnitRunner.class)
public class BoldDiffblueTest {
  @InjectMocks private Bold bold;

  /**
   * Test {@link Bold#Bold(Element)}.
   *
   * <p>Method under test: {@link Bold#Bold(Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bold.<init>(Element)"})
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
   *
   * <p>Method under test: {@link Bold#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Bold.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    // Act
    Node actualAsMarkdownResult = new Bold(parent).asMarkdown();

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

  /**
   * Test {@link Bold#validate()}.
   *
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@link BulletList#BulletList(Element)}
   *       addChild {@link Bold#Bold(Element)} with parent is {@link
   *       BulletList#BulletList(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link Bold#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bold.validate()"})
  public void testValidate_givenBoldWithParentIsBulletListAddChildBoldWithParentIsBulletList()
      throws InvalidInputException {
    // Arrange
    Bold bold = new Bold(new BulletList(null));
    bold.addChild(new Bold(new BulletList(null)));

    // Act and Assert
    bold.validate();
  }

  /**
   * Test {@link Bold#validate()}.
   *
   * <ul>
   *   <li>Given {@link Bold}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Bold#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bold.validate()"})
  public void testValidate_givenBold_thenDoesNotThrow() throws InvalidInputException {
    // Arrange, Act and Assert
    bold.validate();
  }

  /**
   * Test {@link Bold#validate()}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Bold#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bold.validate()"})
  public void testValidate_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange
    Bold bold = new Bold(new BulletList(null));
    bold.addChild(new BulletList(new Bold(new Code(null, "en"))));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> bold.validate());
  }
}
