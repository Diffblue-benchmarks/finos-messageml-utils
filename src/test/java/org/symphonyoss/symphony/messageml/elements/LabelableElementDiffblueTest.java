package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.w3c.dom.Node;

public class LabelableElementDiffblueTest {
  /**
   * Test {@link LabelableElement#getPresentationMLLabelTag()}.
   * <p>
   * Method under test: {@link LabelableElement#getPresentationMLLabelTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LabelableElement.getPresentationMLLabelTag()"})
  public void testGetPresentationMLLabelTag() {
    // Arrange, Act and Assert
    assertEquals(LabelableElement.LABEL,
        (new Select(new Bold(new BulletList(mock(Element.class))))).getPresentationMLLabelTag());
  }

  /**
   * Test {@link LabelableElement#getLabelAttribute(String)}.
   * <p>
   * Method under test: {@link LabelableElement#getLabelAttribute(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map LabelableElement.getLabelAttribute(String)"})
  public void testGetLabelAttribute() {
    // Arrange and Act
    Map<String, String> actualLabelAttribute = (new Select(new Bold(new BulletList(mock(Element.class)))))
        .getLabelAttribute("42");

    // Assert
    assertEquals(1, actualLabelAttribute.size());
    assertEquals("42", actualLabelAttribute.get(LabelableElement.LABEL_FOR));
  }

  /**
   * Test {@link LabelableElement#isLabel()}.
   * <p>
   * Method under test: {@link LabelableElement#isLabel()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LabelableElement.isLabel()"})
  public void testIsLabel() {
    // Arrange, Act and Assert
    assertFalse((new Select(new Bold(new BulletList(mock(Element.class))))).isLabel());
  }

  /**
   * Test {@link LabelableElement#isLabelNode(Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LabelableElement#isLabelNode(Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LabelableElement.isLabelNode(Node)"})
  public void testIsLabelNode_whenIIOMetadataNodeWithFoo_thenReturnFalse() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertFalse(select.isLabelNode(new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link LabelableElement#isLabelNode(Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link LabelableElement#LABEL}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LabelableElement#isLabelNode(Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LabelableElement.isLabelNode(Node)"})
  public void testIsLabelNode_whenIIOMetadataNodeWithLabel_thenReturnTrue() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertTrue(select.isLabelNode(new IIOMetadataNode(LabelableElement.LABEL)));
  }
}
