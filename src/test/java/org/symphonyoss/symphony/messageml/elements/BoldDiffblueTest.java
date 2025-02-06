package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.commonmark.node.Node;
import org.commonmark.node.StrongEmphasis;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class BoldDiffblueTest {
  /**
   * Test {@link Bold#Bold(Element)}.
   * <p>
   * Method under test: {@link Bold#Bold(Element)}
   */
  @Test
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
   * <p>
   * Method under test: {@link Bold#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Bold(new BulletList(mock(Element.class)))).asMarkdown();

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
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is
   * {@link BulletList#BulletList(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Bold#validate()}
   */
  @Test
  public void testValidate_givenBoldWithParentIsBulletList() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new Bold(new BulletList(mock(Element.class)))).validate();
  }

  /**
   * Test {@link Bold#validate()}.
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is
   * {@link BulletList#BulletList(Element)} addChild {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Bold#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenBoldWithParentIsBulletListAddChildNull() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertContentModel(Element.java:701)
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertPhrasingContent(Element.java:673)
    //       at org.symphonyoss.symphony.messageml.elements.Bold.validate(Bold.java:44)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(null);

    // Act
    bold.validate();
  }
}
