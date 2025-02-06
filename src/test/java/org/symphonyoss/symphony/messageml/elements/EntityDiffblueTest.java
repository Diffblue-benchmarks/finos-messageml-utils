package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.w3c.dom.Node;

public class EntityDiffblueTest {
  /**
   * Test {@link Entity#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>Given {@link BulletList#BulletList(Element)} with parent is
   * {@link Element}.</li>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_givenBulletListWithParentIsElement_whenIIOMetadataNodeWithFoo()
      throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "cash"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.Entity.buildAttribute(Entity.java:59)
    //       at org.symphonyoss.symphony.messageml.elements.Keyword.buildAttribute(Keyword.java:48)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    CashTag cashTag = new CashTag(new Bold(new BulletList(mock(Element.class))), 1);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    cashTag.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test {@link Entity#asEntityJson(ObjectNode)}.
   * <ul>
   *   <li>Then traverse return {@link TreeTraversingParser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#asEntityJson(ObjectNode)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAsEntityJson_thenTraverseReturnTreeTraversingParser() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    CashTag cashTag = new CashTag(new Bold(new BulletList(mock(Element.class))), 1);
    ObjectNode parent = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    ObjectNode actualAsEntityJsonResult = cashTag.asEntityJson(parent);

    // Assert
    assertTrue(actualAsEntityJsonResult.traverse() instanceof TreeTraversingParser);
    assertEquals("{\n" + "  \"keyword1\" : {\n" + "    \"type\" : \"org.symphonyoss.fin.security\",\n"
        + "    \"version\" : \"1.0\",\n" + "    \"id\" : [ {\n"
        + "      \"type\" : \"org.symphonyoss.fin.security.id.ticker\",\n" + "      \"value\" : null\n" + "    } ]\n"
        + "  }\n" + "}", parent.toPrettyString());
    assertEquals("{\n" + "  \"type\" : \"org.symphonyoss.fin.security\",\n" + "  \"version\" : \"1.0\",\n"
        + "  \"id\" : [ {\n" + "    \"type\" : \"org.symphonyoss.fin.security.id.ticker\",\n" + "    \"value\" : null\n"
        + "  } ]\n" + "}", actualAsEntityJsonResult.toPrettyString());
    assertEquals(1, parent.size());
    assertEquals(3, actualAsEntityJsonResult.size());
    assertEquals(JsonNodeType.OBJECT, actualAsEntityJsonResult.getNodeType());
    assertFalse(actualAsEntityJsonResult.isArray());
    assertFalse(actualAsEntityJsonResult.isBigDecimal());
    assertFalse(actualAsEntityJsonResult.isBigInteger());
    assertFalse(actualAsEntityJsonResult.isBinary());
    assertFalse(actualAsEntityJsonResult.isBoolean());
    assertFalse(actualAsEntityJsonResult.isDouble());
    assertFalse(actualAsEntityJsonResult.isFloat());
    assertFalse(actualAsEntityJsonResult.isFloatingPointNumber());
    assertFalse(actualAsEntityJsonResult.isInt());
    assertFalse(actualAsEntityJsonResult.isIntegralNumber());
    assertFalse(actualAsEntityJsonResult.isLong());
    assertFalse(actualAsEntityJsonResult.isMissingNode());
    assertFalse(actualAsEntityJsonResult.isNull());
    assertFalse(actualAsEntityJsonResult.isNumber());
    assertFalse(actualAsEntityJsonResult.isPojo());
    assertFalse(actualAsEntityJsonResult.isShort());
    assertFalse(actualAsEntityJsonResult.isTextual());
    assertFalse(actualAsEntityJsonResult.isValueNode());
    assertFalse(parent.isEmpty());
    assertFalse(actualAsEntityJsonResult.isEmpty());
    assertFalse(parent.iterator().hasNext());
    assertFalse(actualAsEntityJsonResult.iterator().hasNext());
    assertTrue(actualAsEntityJsonResult.isContainerNode());
    assertTrue(actualAsEntityJsonResult.isObject());
  }

  /**
   * Test {@link Entity#asEntityJson(ObjectNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#asEntityJson(ObjectNode)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAsEntityJson_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.symphonyoss.symphony.messageml.elements.Entity.asEntityJson(Entity.java:66)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).asEntityJson(null);
  }

  /**
   * Test {@link Entity#validate()}.
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@link Element}.</li>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#validate()}
   */
  @Test
  public void testValidate_givenBoldWithParentIsElement_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new CashTag(new Bold(mock(Element.class)), "The attribute \"tag\" is required", "42")).validate());
  }

  /**
   * Test {@link Entity#getEntityId(int)}.
   * <p>
   * Method under test: {@link Entity#getEntityId(int)}
   */
  @Test
  public void testGetEntityId() {
    // Arrange, Act and Assert
    assertEquals("keyword1", (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).getEntityId(1));
  }

  /**
   * Test {@link Entity#getPresentationMLTag()}.
   * <p>
   * Method under test: {@link Entity#getPresentationMLTag()}
   */
  @Test
  public void testGetPresentationMLTag() {
    // Arrange, Act and Assert
    assertEquals(Span.MESSAGEML_TAG,
        (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).getPresentationMLTag());
  }
}
