package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.w3c.dom.Node;

@RunWith(MockitoJUnitRunner.class)
public class LabelableElementDiffblueTest {
  @InjectMocks private Select select;

  /**
   * Test {@link LabelableElement#getPresentationMLLabelTag()}.
   *
   * <p>Method under test: {@link LabelableElement#getPresentationMLLabelTag()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LabelableElement.getPresentationMLLabelTag()"})
  public void testGetPresentationMLLabelTag() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals(LabelableElement.LABEL, new Select(parent2).getPresentationMLLabelTag());
  }

  /**
   * Test {@link LabelableElement#getLabelAttribute(String)}.
   *
   * <p>Method under test: {@link LabelableElement#getLabelAttribute(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LabelableElement.getLabelAttribute(String)"})
  public void testGetLabelAttribute() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Map<String, String> actualLabelAttribute = new Select(parent2).getLabelAttribute("42");

    // Assert
    assertEquals(1, actualLabelAttribute.size());
    assertEquals("42", actualLabelAttribute.get(LabelableElement.LABEL_FOR));
  }

  /**
   * Test {@link LabelableElement#isLabel()}.
   *
   * <p>Method under test: {@link LabelableElement#isLabel()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LabelableElement.isLabel()"})
  public void testIsLabel() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(new Select(parent2).isLabel());
  }

  /**
   * Test {@link LabelableElement#isLabelNode(Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link LabelableElement#LABEL}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LabelableElement#isLabelNode(Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LabelableElement.isLabelNode(Node)"})
  public void testIsLabelNode_whenIIOMetadataNodeWithLabel_thenReturnTrue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Select select = new Select(parent2);

    // Act
    boolean actualIsLabelNodeResult =
        select.isLabelNode(new IIOMetadataNode(LabelableElement.LABEL));

    // Assert
    assertTrue(actualIsLabelNodeResult);
  }

  /**
   * Test {@link LabelableElement#isLabelNode(Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LabelableElement#isLabelNode(Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LabelableElement.isLabelNode(Node)"})
  public void testIsLabelNode_whenIIOMetadataNode_thenReturnFalse() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Select select = new Select(parent2);

    // Act and Assert
    assertFalse(select.isLabelNode(new IIOMetadataNode()));
  }

  /**
   * Test {@link LabelableElement#validateLabel()}.
   *
   * <p>Method under test: {@link LabelableElement#validateLabel()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LabelableElement.validateLabel()"})
  public void testValidateLabel() throws InvalidInputException {
    // Arrange, Act and Assert
    select.validateLabel();
  }
}
