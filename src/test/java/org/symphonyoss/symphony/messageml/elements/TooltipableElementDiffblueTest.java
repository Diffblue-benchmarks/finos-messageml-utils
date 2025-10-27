package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.w3c.dom.Node;

public class TooltipableElementDiffblueTest {
  /**
   * Method under test: {@link TooltipableElement#getPresentationMLTooltipTag()}
   */
  @Test
  public void testGetPresentationMLTooltipTag() {
    // Arrange, Act and Assert
    assertEquals(TooltipableElement.TOOLTIPABLE_PRESENTATIONML,
        (new Select(new Bold(new BulletList(mock(Element.class))))).getPresentationMLTooltipTag());
  }

  /**
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
   * Method under test: {@link TooltipableElement#isTooltip()}
   */
  @Test
  public void testIsTooltip() {
    // Arrange, Act and Assert
    assertFalse((new Select(new Bold(new BulletList(mock(Element.class))))).isTooltip());
  }

  /**
   * Method under test: {@link TooltipableElement#isTooltipNode(Node)}
   */
  @Test
  public void testIsTooltipNode() {
    // Arrange, Act and Assert
    assertFalse(TooltipableElement.isTooltipNode(new IIOMetadataNode("foo")));
    assertFalse(TooltipableElement.isTooltipNode(new IIOMetadataNode(TooltipableElement.TOOLTIPABLE_PRESENTATIONML)));
  }
}
