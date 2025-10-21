package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.w3c.dom.Node;

public class TooltipableElementDiffblueTest {
  /**
   * Test {@link TooltipableElement#getPresentationMLTooltipTag()}.
   * <p>
   * Method under test: {@link TooltipableElement#getPresentationMLTooltipTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TooltipableElement.getPresentationMLTooltipTag()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map TooltipableElement.getTooltipAttributes(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TooltipableElement.isTooltip()"})
  public void testIsTooltip() {
    // Arrange, Act and Assert
    assertFalse((new Select(new Bold(new BulletList(mock(Element.class))))).isTooltip());
  }

  /**
   * Test {@link TooltipableElement#isTooltipNode(Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TooltipableElement#isTooltipNode(Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TooltipableElement.isTooltipNode(Node)"})
  public void testIsTooltipNode_whenIIOMetadataNodeWithFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TooltipableElement.isTooltipNode(new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link TooltipableElement#isTooltipNode(Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link TooltipableElement#TOOLTIPABLE_PRESENTATIONML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TooltipableElement#isTooltipNode(Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TooltipableElement.isTooltipNode(Node)"})
  public void testIsTooltipNode_whenIIOMetadataNodeWithTooltipable_presentationml() {
    // Arrange, Act and Assert
    assertFalse(TooltipableElement.isTooltipNode(new IIOMetadataNode(TooltipableElement.TOOLTIPABLE_PRESENTATIONML)));
  }
}
