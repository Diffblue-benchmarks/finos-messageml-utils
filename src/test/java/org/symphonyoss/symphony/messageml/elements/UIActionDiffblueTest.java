package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class UIActionDiffblueTest {
  /**
   * Test {@link UIAction#UIAction(Element, FormatEnum)}.
   * <p>
   * Method under test: {@link UIAction#UIAction(Element, FormatEnum)}
   */
  @Test
  public void testNewUIAction() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    UIAction actualUiAction = new UIAction(parent, FormatEnum.MESSAGEML);

    // Assert
    Map<String, String> attributes = actualUiAction.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("click", attributes.get("trigger"));
    assertEquals(0, actualUiAction.size());
    assertEquals(FormatEnum.MESSAGEML, actualUiAction.getFormat());
    assertTrue(actualUiAction.getChildren().isEmpty());
    assertEquals(Div.MESSAGEML_TAG, actualUiAction.getPresentationMLTag());
    assertEquals(UIAction.MESSAGEML_TAG, actualUiAction.getMessageMLTag());
    assertSame(parent, actualUiAction.getParent());
  }

  /**
   * Test {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    UIAction uiAction = new UIAction(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    uiAction.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(65L, out.getOffset());
  }

  /**
   * Test {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    UIAction uiAction = new UIAction(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    uiAction.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    uiAction.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(76L, out.getOffset());
  }

  /**
   * Test {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    UIAction uiAction = new UIAction(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    uiAction.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    uiAction.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(109L, out.getOffset());
  }

  /**
   * Test {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    UIAction uiAction = new UIAction(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    uiAction.addChild(new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    uiAction.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(100L, out.getOffset());
  }

  /**
   * Test {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    UIAction uiAction = new UIAction(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    uiAction.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    uiAction.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(97L, out.getOffset());
  }

  /**
   * Test {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    UIAction uiAction = new UIAction(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    uiAction.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    uiAction.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(89L, out.getOffset());
  }

  /**
   * Test {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
    // Arrange
    UIAction uiAction = new UIAction(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    uiAction.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    uiAction.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(129L, out.getOffset());
  }

  /**
   * Test {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
    // Arrange
    UIAction uiAction = new UIAction(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    uiAction.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(65L, out.getOffset());
  }

  /**
   * Test {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() {
    // Arrange
    UIAction uiAction = new UIAction(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    uiAction.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(65L, out.getOffset());
  }

  /**
   * Test {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link UIAction#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML10() {
    // Arrange
    UIAction uiAction = new UIAction(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    uiAction.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(62L, out.getOffset());
  }

  /**
   * Test {@link UIAction#getPresentationMLTag()}.
   * <p>
   * Method under test: {@link UIAction#getPresentationMLTag()}
   */
  @Test
  public void testGetPresentationMLTag() {
    // Arrange, Act and Assert
    assertEquals(Div.MESSAGEML_TAG,
        (new UIAction(new Bold(new BulletList(null)), FormatEnum.MESSAGEML)).getPresentationMLTag());
  }
}
