package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.commonmark.node.Emphasis;
import org.commonmark.node.Node;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class ItalicDiffblueTest {
  /**
   * Test {@link Italic#Italic(Element)}.
   * <p>
   * Method under test: {@link Italic#Italic(Element)}
   */
  @Test
  public void testNewItalic() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Italic actualItalic = new Italic(parent);

    // Assert
    assertEquals(0, actualItalic.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualItalic.getFormat());
    assertTrue(actualItalic.getChildren().isEmpty());
    assertTrue(actualItalic.getAttributes().isEmpty());
    assertEquals(Italic.MESSAGEML_TAG, actualItalic.getMessageMLTag());
    assertEquals(Italic.MESSAGEML_TAG, actualItalic.getPresentationMLTag());
    assertSame(parent, actualItalic.getParent());
  }

  /**
   * Test {@link Italic#asMarkdown()}.
   * <p>
   * Method under test: {@link Italic#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Italic(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

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
   * <ul>
   *   <li>Given {@link Italic#Italic(Element)} with parent is
   * {@link Bold#Bold(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Italic#validate()}
   */
  @Test
  public void testValidate_givenItalicWithParentIsBold() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new Italic(new Bold(new BulletList(mock(Element.class))))).validate();
  }

  /**
   * Test {@link Italic#validate()}.
   * <ul>
   *   <li>Given {@link Italic#Italic(Element)} with parent is
   * {@link Bold#Bold(Element)} addChild {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Italic#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenItalicWithParentIsBoldAddChildNull() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertContentModel(Element.java:701)
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertPhrasingContent(Element.java:673)
    //       at org.symphonyoss.symphony.messageml.elements.Italic.validate(Italic.java:44)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Italic italic = new Italic(new Bold(new BulletList(mock(Element.class))));
    italic.addChild(null);

    // Act
    italic.validate();
  }
}
