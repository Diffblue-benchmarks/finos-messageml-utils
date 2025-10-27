package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.w3c.dom.Node;

public class LabelableElementDiffblueTest {
  /**
   * Method under test: {@link LabelableElement#getPresentationMLLabelTag()}
   */
  @Test
  public void testGetPresentationMLLabelTag() {
    // Arrange, Act and Assert
    assertEquals(LabelableElement.LABEL,
        (new Select(new Bold(new BulletList(mock(Element.class))))).getPresentationMLLabelTag());
  }

  /**
   * Method under test: {@link LabelableElement#getLabelAttribute(String)}
   */
  @Test
  public void testGetLabelAttribute() {
    // Arrange and Act
    Map<String, String> actualLabelAttribute = (new Select(new Bold(new BulletList(mock(Element.class)))))
        .getLabelAttribute("42");

    // Assert
    assertEquals(1, actualLabelAttribute.size());
    assertEquals("42", actualLabelAttribute.get(LabelableElement.LABEL_FOR));
  }

  /**
   * Method under test: {@link LabelableElement#isLabel()}
   */
  @Test
  public void testIsLabel() {
    // Arrange, Act and Assert
    assertFalse((new Select(new Bold(new BulletList(mock(Element.class))))).isLabel());
  }

  /**
   * Method under test: {@link LabelableElement#isLabelNode(Node)}
   */
  @Test
  public void testIsLabelNode() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertFalse(select.isLabelNode(new IIOMetadataNode("foo")));
  }

  /**
   * Method under test: {@link LabelableElement#isLabelNode(Node)}
   */
  @Test
  public void testIsLabelNode2() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertTrue(select.isLabelNode(new IIOMetadataNode(LabelableElement.LABEL)));
  }
}
