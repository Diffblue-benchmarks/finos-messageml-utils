package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.w3c.dom.Node;

public class EntityDiffblueTest {
  /**
   * Test {@link Entity#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    CashTag cashTag = new CashTag(parent2, 1);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> cashTag.buildAttribute(parser, new IIOMetadataNode(Element.CLASS_ATTR)));
  }

  /**
   * Test {@link Entity#asEntityJson(ObjectNode)}.
   *
   * <ul>
   *   <li>Then return {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is
   *       withExactBigDecimals {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#asEntityJson(ObjectNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode Entity.asEntityJson(ObjectNode)"})
  public void testAsEntityJson_thenReturnObjectNodeWithNcIsWithExactBigDecimalsTrue() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    CashTag cashTag = new CashTag(parent, 1);

    ObjectNode parent2 = mock(ObjectNode.class);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode objectNode = new ObjectNode(nc);
    when(parent2.path(Mockito.<String>any())).thenReturn(objectNode);

    // Act
    ObjectNode actualAsEntityJsonResult = cashTag.asEntityJson(parent2);

    // Assert
    verify(parent2).path("keyword1");
    assertSame(objectNode, actualAsEntityJsonResult);
  }

  /**
   * Test {@link Entity#validate()}.
   *
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@code null}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.validate()"})
  public void testValidate_givenBoldWithParentIsNull_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    CashTag cashTag = new CashTag(new Bold(null), "The attribute \"tag\" is required", "42");

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> cashTag.validate());
  }

  /**
   * Test {@link Entity#validate()}.
   *
   * <ul>
   *   <li>Given {@link BulletList#BulletList(Element)} with parent is {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Entity#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.validate()"})
  public void testValidate_givenBulletListWithParentIsNull_thenDoesNotThrow()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new CashTag(parent, 1, "42").validate();
  }

  /**
   * Test {@link Entity#getEntityId(int)}.
   *
   * <p>Method under test: {@link Entity#getEntityId(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Entity.getEntityId(int)"})
  public void testGetEntityId() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals("keyword1", new CashTag(parent2, 1).getEntityId(1));
  }

  /**
   * Test {@link Entity#getPresentationMLTag()}.
   *
   * <p>Method under test: {@link Entity#getPresentationMLTag()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Entity.getPresentationMLTag()"})
  public void testGetPresentationMLTag() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals(Span.MESSAGEML_TAG, new CashTag(parent2, 1).getPresentationMLTag());
  }
}
