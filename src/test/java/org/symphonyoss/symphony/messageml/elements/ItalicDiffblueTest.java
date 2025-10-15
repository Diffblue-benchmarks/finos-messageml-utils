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
import org.commonmark.node.Emphasis;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

@RunWith(MockitoJUnitRunner.class)
public class ItalicDiffblueTest {
  @InjectMocks private Italic italic;

  /**
   * Test {@link Italic#Italic(Element)}.
   *
   * <p>Method under test: {@link Italic#Italic(Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Italic.<init>(Element)"})
  public void testNewItalic() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Italic actualItalic = new Italic(parent2);

    // Assert
    assertEquals(0, actualItalic.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualItalic.getFormat());
    assertTrue(actualItalic.getChildren().isEmpty());
    assertTrue(actualItalic.getAttributes().isEmpty());
    assertEquals(Italic.MESSAGEML_TAG, actualItalic.getMessageMLTag());
    assertEquals(Italic.MESSAGEML_TAG, actualItalic.getPresentationMLTag());
    assertSame(parent2, actualItalic.getParent());
  }

  /**
   * Test {@link Italic#asMarkdown()}.
   *
   * <p>Method under test: {@link Italic#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Italic.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new Italic(parent2).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Emphasis);
    assertEquals("_", ((Emphasis) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals("_", ((Emphasis) actualAsMarkdownResult).getOpeningDelimiter());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link Italic#validate()}.
   *
   * <ul>
   *   <li>Given {@link Italic#Italic(Element)} with parent is {@link Bold#Bold(Element)} addChild
   *       {@link Bold#Bold(Element)} with parent is {@link BulletList#BulletList(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link Italic#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Italic.validate()"})
  public void testValidate_givenItalicWithParentIsBoldAddChildBoldWithParentIsBulletList()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    Italic italic = new Italic(parent);
    italic.addChild(new Bold(new BulletList(null)));

    // Act and Assert
    italic.validate();
  }

  /**
   * Test {@link Italic#validate()}.
   *
   * <ul>
   *   <li>Given {@link Italic}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Italic#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Italic.validate()"})
  public void testValidate_givenItalic_thenDoesNotThrow() throws InvalidInputException {
    // Arrange, Act and Assert
    italic.validate();
  }

  /**
   * Test {@link Italic#validate()}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Italic#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Italic.validate()"})
  public void testValidate_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    Italic italic = new Italic(parent);
    italic.addChild(new BulletList(new Bold(new Code(null, "en"))));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> italic.validate());
  }
}
