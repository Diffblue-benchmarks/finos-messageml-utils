package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.w3c.dom.Node;

public class TooltipableElementDiffblueTest {
  /**
   * Test {@link TooltipableElement#getPresentationMLTooltipTag()}.
   * <p>
   * Method under test: {@link TooltipableElement#getPresentationMLTooltipTag()}
   */
  @Test
  public void testGetPresentationMLTooltipTag() {
    // Arrange, Act and Assert
    assertEquals(TooltipableElement.TOOLTIPABLE_PRESENTATIONML,
        (new Select(new Bold(new BulletList(mock(Element.class))))).getPresentationMLTooltipTag());
  }

  /**
   * Test {@link TooltipableElement#getTooltipAttributes(String)}.
   * <p>
   * Method under test: {@link TooltipableElement#getTooltipAttributes(String)}
   */
  @Test
  public void testGetTooltipAttributes() {
    // Arrange and Act
    Map<String, String> actualTooltipAttributes = (new Select(new Bold(new BulletList(mock(Element.class)))))
        .getTooltipAttributes("42");

    // Assert
    assertEquals(3, actualTooltipAttributes.size());
    assertEquals("42", actualTooltipAttributes.get(TooltipableElement.DATA_TARGET_ID));
    assertNull(actualTooltipAttributes.get(TooltipableElement.DATA_TITLE));
    assertEquals(TooltipableElement.TOOLTIP_CLASS, actualTooltipAttributes.get(Element.CLASS_ATTR));
  }

  /**
   * Test {@link TooltipableElement#isTooltip()}.
   * <p>
   * Method under test: {@link TooltipableElement#isTooltip()}
   */
  @Test
  public void testIsTooltip() {
    // Arrange, Act and Assert
    assertFalse((new Select(new Bold(new BulletList(mock(Element.class))))).isTooltip());
  }

  /**
   * Test {@link TooltipableElement#isTooltipNode(Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TooltipableElement#isTooltipNode(Node)}
   */
  @Test
  public void testIsTooltipNode_whenIIOMetadataNodeWithFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TooltipableElement.isTooltipNode(new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link TooltipableElement#isTooltipNode(Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@link TooltipableElement#TOOLTIPABLE_PRESENTATIONML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TooltipableElement#isTooltipNode(Node)}
   */
  @Test
  public void testIsTooltipNode_whenIIOMetadataNodeWithTooltipable_presentationml() {
    // Arrange, Act and Assert
    assertFalse(TooltipableElement.isTooltipNode(new IIOMetadataNode(TooltipableElement.TOOLTIPABLE_PRESENTATIONML)));
  }

  /**
   * Test {@link TooltipableElement#validateTooltip()}.
   * <p>
   * Method under test: {@link TooltipableElement#validateTooltip()}
   */
  @Test
  public void testValidateTooltip() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new Select(new Bold(new BulletList(mock(Element.class))))).validateTooltip();
  }
}
