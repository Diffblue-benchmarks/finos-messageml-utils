package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.commonmark.node.Emphasis;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SubscriptDiffblueTest {
  /**
   * Test {@link Subscript#Subscript(Element)}.
   *
   * <p>Method under test: {@link Subscript#Subscript(Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Subscript.<init>(Element)"})
  public void testNewSubscript() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Subscript actualSubscript = new Subscript(parent2);

    // Assert
    assertEquals(0, actualSubscript.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualSubscript.getFormat());
    assertTrue(actualSubscript.getChildren().isEmpty());
    assertTrue(actualSubscript.getAttributes().isEmpty());
    assertEquals(Subscript.MESSAGEML_TAG, actualSubscript.getMessageMLTag());
    assertEquals(Subscript.MESSAGEML_TAG, actualSubscript.getPresentationMLTag());
    assertSame(parent2, actualSubscript.getParent());
  }

  /**
   * Test {@link Subscript#asMarkdown()}.
   *
   * <p>Method under test: {@link Subscript#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Subscript.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new Subscript(parent2).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Emphasis);
    assertEquals("~", ((Emphasis) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals("~", ((Emphasis) actualAsMarkdownResult).getOpeningDelimiter());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }
}
