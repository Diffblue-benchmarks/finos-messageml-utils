package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.util.Set;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.elements.DialogChild.Title;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;
import org.w3c.dom.Node;

public class SplittableElementDiffblueTest {
  /**
   * Test {@link SplittableElement#splittableAsPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link SplittableElement#splittableAsPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SplittableElement.splittableAsPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testSplittableAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Select select = new Select(parent2);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    select.splittableAsPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(51L, out.getOffset());
  }

  /**
   * Test {@link SplittableElement#splittableAsPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link SplittableElement#splittableAsPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SplittableElement.splittableAsPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testSplittableAsPresentationML2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Select select = new Select(parent2);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    select.splittableAsPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(51L, out.getOffset());
  }

  /**
   * Test {@link SplittableElement#splittableAsPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link SplittableElement#splittableAsPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SplittableElement.splittableAsPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testSplittableAsPresentationML3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Select select = new Select(parent2);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    select.splittableAsPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(51L, out.getOffset());
  }

  /**
   * Test {@link SplittableElement#splittableAsPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link SplittableElement#splittableAsPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SplittableElement.splittableAsPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testSplittableAsPresentationML4() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Select select = new Select(parent2);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    select.splittableAsPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(50L, out.getOffset());
  }

  /**
   * Test {@link SplittableElement#splittableRemove()}.
   *
   * <p>Method under test: {@link SplittableElement#splittableRemove()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SplittableElement.splittableRemove()"})
  public void testSplittableRemove() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Set<String> actualSplittableRemoveResult = new Select(parent2).splittableRemove();

    // Assert
    assertEquals(2, actualSplittableRemoveResult.size());
    assertTrue(actualSplittableRemoveResult.contains(Title.MESSAGEML_TAG));
    assertTrue(actualSplittableRemoveResult.contains(LabelableElement.LABEL));
  }

  /**
   * Test {@link SplittableElement#isSplittableNodeComponent(Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link LabelableElement#LABEL}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SplittableElement#isSplittableNodeComponent(Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SplittableElement.isSplittableNodeComponent(Node)"})
  public void testIsSplittableNodeComponent_whenIIOMetadataNodeWithLabel_thenReturnTrue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Select select = new Select(parent2);

    // Act
    boolean actualIsSplittableNodeComponentResult =
        select.isSplittableNodeComponent(new IIOMetadataNode(LabelableElement.LABEL));

    // Assert
    assertTrue(actualIsSplittableNodeComponentResult);
  }

  /**
   * Test {@link SplittableElement#isSplittableNodeComponent(Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link Span#MESSAGEML_TAG}.
   * </ul>
   *
   * <p>Method under test: {@link SplittableElement#isSplittableNodeComponent(Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SplittableElement.isSplittableNodeComponent(Node)"})
  public void testIsSplittableNodeComponent_whenIIOMetadataNodeWithMessageml_tag() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Select select = new Select(parent2);

    // Act
    boolean actualIsSplittableNodeComponentResult =
        select.isSplittableNodeComponent(new IIOMetadataNode(Span.MESSAGEML_TAG));

    // Assert
    assertFalse(actualIsSplittableNodeComponentResult);
  }

  /**
   * Test {@link SplittableElement#isSplittableNodeComponent(Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SplittableElement#isSplittableNodeComponent(Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SplittableElement.isSplittableNodeComponent(Node)"})
  public void testIsSplittableNodeComponent_whenIIOMetadataNode_thenReturnFalse() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Select select = new Select(parent2);

    // Act and Assert
    assertFalse(select.isSplittableNodeComponent(new IIOMetadataNode()));
  }

  /**
   * Test {@link SplittableElement#validateSplittable()}.
   *
   * <p>Method under test: {@link SplittableElement#validateSplittable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SplittableElement.validateSplittable()"})
  public void testValidateSplittable() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new Select(parent).validateSplittable();
  }

  /**
   * Test {@link SplittableElement#isSplittable()}.
   *
   * <p>Method under test: {@link SplittableElement#isSplittable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SplittableElement.isSplittable()"})
  public void testIsSplittable() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(new Select(parent2).isSplittable());
  }

  /**
   * Test {@link SplittableElement#getElementId()}.
   *
   * <ul>
   *   <li>Then return {@link DatePicker#MESSAGEML_TAG}.
   * </ul>
   *
   * <p>Method under test: {@link SplittableElement#getElementId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SplittableElement.getElementId()"})
  public void testGetElementId_thenReturnMessageml_tag() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals(
        DatePicker.MESSAGEML_TAG, new DatePicker(parent2, FormatEnum.MESSAGEML).getElementId());
  }
}
