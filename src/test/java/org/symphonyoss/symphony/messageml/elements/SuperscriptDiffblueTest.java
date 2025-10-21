package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.commonmark.node.Emphasis;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SuperscriptDiffblueTest {
  /**
   * Test {@link Superscript#Superscript(Element)}.
   * <p>
   * Method under test: {@link Superscript#Superscript(Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Superscript.<init>(Element)"})
  public void testNewSuperscript() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Superscript actualSuperscript = new Superscript(parent);

    // Assert
    assertEquals(0, actualSuperscript.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualSuperscript.getFormat());
    assertTrue(actualSuperscript.getChildren().isEmpty());
    assertTrue(actualSuperscript.getAttributes().isEmpty());
    assertEquals(Superscript.MESSAGEML_TAG, actualSuperscript.getMessageMLTag());
    assertEquals(Superscript.MESSAGEML_TAG, actualSuperscript.getPresentationMLTag());
    assertSame(parent, actualSuperscript.getParent());
  }

  /**
   * Test {@link Superscript#asMarkdown()}.
   * <p>
   * Method under test: {@link Superscript#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Superscript.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Superscript(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Emphasis);
    assertEquals("^", ((Emphasis) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals("^", ((Emphasis) actualAsMarkdownResult).getOpeningDelimiter());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }
}
