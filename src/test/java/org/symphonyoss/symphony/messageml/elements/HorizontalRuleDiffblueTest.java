package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import org.commonmark.node.Paragraph;
import org.commonmark.node.Text;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class HorizontalRuleDiffblueTest {
  /**
   * Test {@link HorizontalRule#HorizontalRule(Element)}.
   *
   * <p>Method under test: {@link HorizontalRule#HorizontalRule(Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HorizontalRule.<init>(Element)"})
  public void testNewHorizontalRule() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    HorizontalRule actualHorizontalRule = new HorizontalRule(parent2);

    // Assert
    assertEquals(0, actualHorizontalRule.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualHorizontalRule.getFormat());
    assertTrue(actualHorizontalRule.getChildren().isEmpty());
    assertTrue(actualHorizontalRule.getAttributes().isEmpty());
    assertEquals(HorizontalRule.MESSAGEML_TAG, actualHorizontalRule.getMessageMLTag());
    assertEquals(HorizontalRule.MESSAGEML_TAG, actualHorizontalRule.getPresentationMLTag());
    assertSame(parent2, actualHorizontalRule.getParent());
  }

  /**
   * Test {@link HorizontalRule#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link HorizontalRule#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HorizontalRule.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNode_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    HorizontalRule horizontalRule = new HorizontalRule(parent2);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> horizontalRule.buildAttribute(parser, new IIOMetadataNode()));
  }

  /**
   * Test {@link HorizontalRule#asText()}.
   *
   * <p>Method under test: {@link HorizontalRule#asText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String HorizontalRule.asText()"})
  public void testAsText() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals("\n", new HorizontalRule(parent2).asText());
  }

  /**
   * Test {@link HorizontalRule#asMarkdown()}.
   *
   * <p>Method under test: {@link HorizontalRule#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node HorizontalRule.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new HorizontalRule(parent2).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Paragraph);
    Node firstChild = actualAsMarkdownResult.getFirstChild();
    assertTrue(firstChild instanceof Text);
    assertEquals("---", ((Text) firstChild).getLiteral());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(firstChild.getFirstChild());
    assertNull(firstChild.getLastChild());
    assertNull(firstChild.getNext());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(firstChild.getPrevious());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertSame(actualAsMarkdownResult, firstChild.getParent());
  }

  /**
   * Test {@link HorizontalRule#validate()}.
   *
   * <ul>
   *   <li>Given {@link HorizontalRule#HorizontalRule(Element)} with parent is {@link
   *       Bold#Bold(Element)}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link HorizontalRule#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HorizontalRule.validate()"})
  public void testValidate_givenHorizontalRuleWithParentIsBold_thenDoesNotThrow()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new HorizontalRule(parent).validate();
  }

  /**
   * Test {@link HorizontalRule#validate()}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link HorizontalRule#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HorizontalRule.validate()"})
  public void testValidate_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    HorizontalRule horizontalRule = new HorizontalRule(parent);
    horizontalRule.addChild(new Bold(new BulletList(null)));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> horizontalRule.validate());
  }

  /**
   * Test {@link HorizontalRule#areNestedElementsAllowed()}.
   *
   * <p>Method under test: {@link HorizontalRule#areNestedElementsAllowed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HorizontalRule.areNestedElementsAllowed()"})
  public void testAreNestedElementsAllowed() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(new HorizontalRule(parent2).areNestedElementsAllowed());
  }

  /**
   * Test {@link HorizontalRule#toString()}.
   *
   * <p>Method under test: {@link HorizontalRule#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String HorizontalRule.toString()"})
  public void testToString() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertEquals("\n", new HorizontalRule(parent).toString());
  }
}
