package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class ExpandableCardHeaderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExpandableCardHeader#ExpandableCardHeader(Element, FormatEnum)}
   *   <li>{@link ExpandableCardHeader#getPresentationMLTag()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.<init>(Element, FormatEnum)",
    "String ExpandableCardHeader.getPresentationMLTag()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    ExpandableCardHeader actualExpandableCardHeader =
        new ExpandableCardHeader(parent, FormatEnum.MESSAGEML);
    String actualPresentationMLTag = actualExpandableCardHeader.getPresentationMLTag();

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualExpandableCardHeader.getFormat());
    assertTrue(actualExpandableCardHeader.getChildren().isEmpty());
    assertTrue(actualExpandableCardHeader.getAttributes().isEmpty());
    assertEquals(Div.MESSAGEML_TAG, actualPresentationMLTag);
    assertEquals(ExpandableCardHeader.MESSAGEML_TAG, actualExpandableCardHeader.getMessageMLTag());
    assertSame(parent, actualExpandableCardHeader.getParent());
  }

  /**
   * Test {@link ExpandableCardHeader#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link ExpandableCardHeader#buildAttribute(MessageMLParser,
   * org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExpandableCardHeader.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNode_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> expandableCardHeader.buildAttribute(parser, new IIOMetadataNode()));
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    expandableCardHeader.addChild(new Bold(parent3));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(53L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(42L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(42L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML4() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(40L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML5() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    expandableCardHeader.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(86L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML6() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    expandableCardHeader.addChild(new Button(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(77L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML7() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    expandableCardHeader.addChild(new CardBody(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(74L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML8() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent2));
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);

    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent4, FormatEnum.MESSAGEML);
    expandableCardHeader.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(66L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML9() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    expandableCardHeader.addChild(new CashTag(parent4, 1));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(106L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML10() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    expandableCardHeader.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(81L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML11() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Checkbox(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent5, FormatEnum.MESSAGEML);
    expandableCardHeader.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(99L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML12() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Button(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent5, FormatEnum.MESSAGEML);
    expandableCardHeader.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(90L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML13() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CardBody(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent5, FormatEnum.MESSAGEML);
    expandableCardHeader.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(87L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML14() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CashTag(parent3, 1));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent5, FormatEnum.MESSAGEML);
    expandableCardHeader.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(119L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>When {@link XmlPrintStream#XmlPrintStream(OutputStream)} with outputStream is {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link ExpandableCardHeader#asPresentationML(XmlPrintStream,
   * MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandableCardHeader.asPresentationML(XmlPrintStream, MessageMLContext)"
  })
  public void testAsPresentationML_whenXmlPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    ExpandableCardHeader expandableCardHeader =
        new ExpandableCardHeader(parent2, FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(42L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asMarkdown()}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node ExpandableCardHeader.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult =
        new ExpandableCardHeader(parent2, FormatEnum.MESSAGEML).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Paragraph);
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link ExpandableCardHeader#validate()}.
   *
   * <p>Method under test: {@link ExpandableCardHeader#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExpandableCardHeader.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new ExpandableCardHeader(parent, FormatEnum.MESSAGEML).validate());
  }
}
