package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

public class SplittableElementDiffblueTest {
  /**
   * Method under test:
   * {@link SplittableElement#splittableAsPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testSplittableAsPresentationML() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    select.splittableAsPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(51L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link SplittableElement#splittableAsPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testSplittableAsPresentationML2() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    select.splittableAsPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(51L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link SplittableElement#splittableAsPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testSplittableAsPresentationML3() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    select.splittableAsPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(51L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link SplittableElement#splittableAsPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testSplittableAsPresentationML4() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    select.splittableAsPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(50L, out.getOffset());
  }

  /**
   * Method under test: {@link SplittableElement#splittableRemove()}
   */
  @Test
  public void testSplittableRemove() {
    // Arrange and Act
    Set<String> actualSplittableRemoveResult = (new Select(new Bold(new BulletList(mock(Element.class)))))
        .splittableRemove();

    // Assert
    assertEquals(2, actualSplittableRemoveResult.size());
    assertTrue(actualSplittableRemoveResult.contains(DialogChild.Title.MESSAGEML_TAG));
    assertTrue(actualSplittableRemoveResult.contains(LabelableElement.LABEL));
  }

  /**
   * Method under test: {@link SplittableElement#isSplittableNodeComponent(Node)}
   */
  @Test
  public void testIsSplittableNodeComponent() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertFalse(select.isSplittableNodeComponent(new IIOMetadataNode("foo")));
  }

  /**
   * Method under test: {@link SplittableElement#isSplittableNodeComponent(Node)}
   */
  @Test
  public void testIsSplittableNodeComponent2() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertTrue(select.isSplittableNodeComponent(new IIOMetadataNode(LabelableElement.LABEL)));
  }

  /**
   * Method under test: {@link SplittableElement#isSplittableNodeComponent(Node)}
   */
  @Test
  public void testIsSplittableNodeComponent3() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertFalse(select.isSplittableNodeComponent(new IIOMetadataNode(Span.MESSAGEML_TAG)));
  }

  /**
   * Method under test: {@link SplittableElement#isSplittable()}
   */
  @Test
  public void testIsSplittable() {
    // Arrange, Act and Assert
    assertFalse((new Select(new Bold(new BulletList(mock(Element.class))))).isSplittable());
  }

  /**
   * Method under test: {@link SplittableElement#getElementId()}
   */
  @Test
  public void testGetElementId() {
    // Arrange, Act and Assert
    assertEquals(DatePicker.MESSAGEML_TAG,
        (new DatePicker(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).getElementId());
  }

  /**
   * Method under test:
   * {@link SplittableElement#fillAttributes(MessageMLParser, Node)}
   */
  @Test
  public void testFillAttributes() throws InvalidInputException, DOMException {
    // Arrange
    Select select = new Select(new Bold(new BulletList(null)));
    MessageMLParser parser = mock(MessageMLParser.class);
    Optional<Map<Class<? extends SplittableElement>, Map<String, String>>> ofResult = Optional.of(new HashMap<>());
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Map<String, String>>>>when(
            parser.getAllSplittableAttributes(Mockito.<String>any()))
        .thenReturn(ofResult);
    Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>> ofResult2 = Optional.of(new HashMap<>());
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>>>when(
            parser.getAllSplittableValues(Mockito.<String>any()))
        .thenReturn(ofResult2);
    Node item = mock(Node.class);
    when(item.getTextContent()).thenReturn("Not all who wander are lost");

    // Act
    select.fillAttributes(parser, item);

    // Assert
    verify(parser).getAllSplittableAttributes(eq("Not all who wander are lost"));
    verify(parser).getAllSplittableValues(eq("Not all who wander are lost"));
    verify(item).getTextContent();
    assertTrue(select.getAttributes().isEmpty());
  }

  /**
   * Method under test:
   * {@link SplittableElement#fillAttributes(MessageMLParser, Node)}
   */
  @Test
  public void testFillAttributes2() throws InvalidInputException, DOMException {
    // Arrange
    Select select = new Select(new Bold(new BulletList(null)));

    HashMap<Class<? extends SplittableElement>, Map<String, String>> resultClassMapMap = new HashMap<>();
    Class<SplittableElement> forNameResult = SplittableElement.class;
    resultClassMapMap.put(forNameResult, new HashMap<>());
    Optional<Map<Class<? extends SplittableElement>, Map<String, String>>> ofResult = Optional.of(resultClassMapMap);
    MessageMLParser parser = mock(MessageMLParser.class);
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Map<String, String>>>>when(
            parser.getAllSplittableAttributes(Mockito.<String>any()))
        .thenReturn(ofResult);
    Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>> ofResult2 = Optional.of(new HashMap<>());
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>>>when(
            parser.getAllSplittableValues(Mockito.<String>any()))
        .thenReturn(ofResult2);
    Node item = mock(Node.class);
    when(item.getTextContent()).thenReturn("Not all who wander are lost");

    // Act
    select.fillAttributes(parser, item);

    // Assert
    verify(parser).getAllSplittableAttributes(eq("Not all who wander are lost"));
    verify(parser).getAllSplittableValues(eq("Not all who wander are lost"));
    verify(item).getTextContent();
    assertTrue(select.getAttributes().isEmpty());
  }

  /**
   * Method under test:
   * {@link SplittableElement#fillAttributes(MessageMLParser, Node)}
   */
  @Test
  public void testFillAttributes3() throws InvalidInputException, DOMException {
    // Arrange
    Select select = new Select(new Bold(new BulletList(null)));
    MessageMLParser parser = mock(MessageMLParser.class);
    Optional<Map<Class<? extends SplittableElement>, Map<String, String>>> emptyResult = Optional.empty();
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Map<String, String>>>>when(
            parser.getAllSplittableAttributes(Mockito.<String>any()))
        .thenReturn(emptyResult);
    Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>> ofResult = Optional.of(new HashMap<>());
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>>>when(
            parser.getAllSplittableValues(Mockito.<String>any()))
        .thenReturn(ofResult);
    Node item = mock(Node.class);
    when(item.getTextContent()).thenReturn("Not all who wander are lost");

    // Act
    select.fillAttributes(parser, item);

    // Assert
    verify(parser).getAllSplittableAttributes(eq("Not all who wander are lost"));
    verify(parser).getAllSplittableValues(eq("Not all who wander are lost"));
    verify(item).getTextContent();
    assertTrue(select.getAttributes().isEmpty());
  }

  /**
   * Method under test:
   * {@link SplittableElement#fillAttributes(MessageMLParser, Node)}
   */
  @Test
  public void testFillAttributes4() throws InvalidInputException, DOMException {
    // Arrange
    Select select = new Select(new Bold(new BulletList(null)));

    HashMap<Class<? extends SplittableElement>, Pair<String, String>> resultClassPairMap = new HashMap<>();
    Class<SplittableElement> forNameResult = SplittableElement.class;
    ImmutablePair<String, String> nullPairResult = ImmutablePair.nullPair();
    resultClassPairMap.put(forNameResult, nullPairResult);
    Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>> ofResult = Optional.of(resultClassPairMap);
    MessageMLParser parser = mock(MessageMLParser.class);
    Optional<Map<Class<? extends SplittableElement>, Map<String, String>>> ofResult2 = Optional.of(new HashMap<>());
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Map<String, String>>>>when(
            parser.getAllSplittableAttributes(Mockito.<String>any()))
        .thenReturn(ofResult2);
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>>>when(
            parser.getAllSplittableValues(Mockito.<String>any()))
        .thenReturn(ofResult);
    Node item = mock(Node.class);
    when(item.getTextContent()).thenReturn("Not all who wander are lost");

    // Act
    select.fillAttributes(parser, item);

    // Assert
    verify(parser).getAllSplittableAttributes(eq("Not all who wander are lost"));
    verify(parser).getAllSplittableValues(eq("Not all who wander are lost"));
    verify(item).getTextContent();
    Map<String, String> attributes = select.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get(null));
  }

  /**
   * Method under test:
   * {@link SplittableElement#fillAttributes(MessageMLParser, Node)}
   */
  @Test
  public void testFillAttributes5() throws InvalidInputException, DOMException {
    // Arrange
    Select select = new Select(new Bold(new BulletList(null)));
    MessageMLParser parser = mock(MessageMLParser.class);
    Optional<Map<Class<? extends SplittableElement>, Map<String, String>>> ofResult = Optional.of(new HashMap<>());
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Map<String, String>>>>when(
            parser.getAllSplittableAttributes(Mockito.<String>any()))
        .thenReturn(ofResult);
    Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>> emptyResult = Optional.empty();
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>>>when(
            parser.getAllSplittableValues(Mockito.<String>any()))
        .thenReturn(emptyResult);
    Node item = mock(Node.class);
    when(item.getTextContent()).thenReturn("Not all who wander are lost");

    // Act
    select.fillAttributes(parser, item);

    // Assert
    verify(parser).getAllSplittableAttributes(eq("Not all who wander are lost"));
    verify(parser).getAllSplittableValues(eq("Not all who wander are lost"));
    verify(item).getTextContent();
    assertTrue(select.getAttributes().isEmpty());
  }

  /**
   * Method under test:
   * {@link SplittableElement#fillAttributes(MessageMLParser, Node, Map)}
   */
  @Test
  public void testFillAttributes6() throws InvalidInputException, DOMException {
    // Arrange
    Select select = new Select(new Bold(new BulletList(null)));
    MessageMLParser parser = mock(MessageMLParser.class);
    Optional<Map<Class<? extends SplittableElement>, Map<String, String>>> ofResult = Optional.of(new HashMap<>());
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Map<String, String>>>>when(
            parser.getAllSplittableAttributes(Mockito.<String>any()))
        .thenReturn(ofResult);
    Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>> ofResult2 = Optional.of(new HashMap<>());
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>>>when(
            parser.getAllSplittableValues(Mockito.<String>any()))
        .thenReturn(ofResult2);
    Node item = mock(Node.class);
    when(item.getTextContent()).thenReturn("Not all who wander are lost");
    HashMap<String, String> attributes = new HashMap<>();

    // Act
    select.fillAttributes(parser, item, attributes);

    // Assert
    verify(parser).getAllSplittableAttributes(eq("Not all who wander are lost"));
    verify(parser).getAllSplittableValues(eq("Not all who wander are lost"));
    verify(item).getTextContent();
    assertTrue(attributes.isEmpty());
  }

  /**
   * Method under test:
   * {@link SplittableElement#fillAttributes(MessageMLParser, Node, Map)}
   */
  @Test
  public void testFillAttributes7() throws InvalidInputException, DOMException {
    // Arrange
    Select select = new Select(new Bold(new BulletList(null)));

    HashMap<Class<? extends SplittableElement>, Map<String, String>> resultClassMapMap = new HashMap<>();
    Class<SplittableElement> forNameResult = SplittableElement.class;
    resultClassMapMap.put(forNameResult, new HashMap<>());
    Optional<Map<Class<? extends SplittableElement>, Map<String, String>>> ofResult = Optional.of(resultClassMapMap);
    MessageMLParser parser = mock(MessageMLParser.class);
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Map<String, String>>>>when(
            parser.getAllSplittableAttributes(Mockito.<String>any()))
        .thenReturn(ofResult);
    Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>> ofResult2 = Optional.of(new HashMap<>());
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>>>when(
            parser.getAllSplittableValues(Mockito.<String>any()))
        .thenReturn(ofResult2);
    Node item = mock(Node.class);
    when(item.getTextContent()).thenReturn("Not all who wander are lost");
    HashMap<String, String> attributes = new HashMap<>();

    // Act
    select.fillAttributes(parser, item, attributes);

    // Assert
    verify(parser).getAllSplittableAttributes(eq("Not all who wander are lost"));
    verify(parser).getAllSplittableValues(eq("Not all who wander are lost"));
    verify(item).getTextContent();
    assertTrue(attributes.isEmpty());
  }

  /**
   * Method under test:
   * {@link SplittableElement#fillAttributes(MessageMLParser, Node, Map)}
   */
  @Test
  public void testFillAttributes8() throws InvalidInputException, DOMException {
    // Arrange
    Select select = new Select(new Bold(new BulletList(null)));
    MessageMLParser parser = mock(MessageMLParser.class);
    Optional<Map<Class<? extends SplittableElement>, Map<String, String>>> emptyResult = Optional.empty();
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Map<String, String>>>>when(
            parser.getAllSplittableAttributes(Mockito.<String>any()))
        .thenReturn(emptyResult);
    Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>> ofResult = Optional.of(new HashMap<>());
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>>>when(
            parser.getAllSplittableValues(Mockito.<String>any()))
        .thenReturn(ofResult);
    Node item = mock(Node.class);
    when(item.getTextContent()).thenReturn("Not all who wander are lost");
    HashMap<String, String> attributes = new HashMap<>();

    // Act
    select.fillAttributes(parser, item, attributes);

    // Assert
    verify(parser).getAllSplittableAttributes(eq("Not all who wander are lost"));
    verify(parser).getAllSplittableValues(eq("Not all who wander are lost"));
    verify(item).getTextContent();
    assertTrue(attributes.isEmpty());
  }

  /**
   * Method under test:
   * {@link SplittableElement#fillAttributes(MessageMLParser, Node, Map)}
   */
  @Test
  public void testFillAttributes9() throws InvalidInputException, DOMException {
    // Arrange
    Select select = new Select(new Bold(new BulletList(null)));

    HashMap<Class<? extends SplittableElement>, Pair<String, String>> resultClassPairMap = new HashMap<>();
    Class<SplittableElement> forNameResult = SplittableElement.class;
    ImmutablePair<String, String> nullPairResult = ImmutablePair.nullPair();
    resultClassPairMap.put(forNameResult, nullPairResult);
    Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>> ofResult = Optional.of(resultClassPairMap);
    MessageMLParser parser = mock(MessageMLParser.class);
    Optional<Map<Class<? extends SplittableElement>, Map<String, String>>> ofResult2 = Optional.of(new HashMap<>());
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Map<String, String>>>>when(
            parser.getAllSplittableAttributes(Mockito.<String>any()))
        .thenReturn(ofResult2);
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>>>when(
            parser.getAllSplittableValues(Mockito.<String>any()))
        .thenReturn(ofResult);
    Node item = mock(Node.class);
    when(item.getTextContent()).thenReturn("Not all who wander are lost");
    HashMap<String, String> attributes = new HashMap<>();

    // Act
    select.fillAttributes(parser, item, attributes);

    // Assert
    verify(parser).getAllSplittableAttributes(eq("Not all who wander are lost"));
    verify(parser).getAllSplittableValues(eq("Not all who wander are lost"));
    verify(item).getTextContent();
    assertEquals(1, attributes.size());
    assertNull(attributes.get(null));
  }

  /**
   * Method under test:
   * {@link SplittableElement#fillAttributes(MessageMLParser, Node, Map)}
   */
  @Test
  public void testFillAttributes10() throws InvalidInputException, DOMException {
    // Arrange
    Select select = new Select(new Bold(new BulletList(null)));
    MessageMLParser parser = mock(MessageMLParser.class);
    Optional<Map<Class<? extends SplittableElement>, Map<String, String>>> ofResult = Optional.of(new HashMap<>());
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Map<String, String>>>>when(
            parser.getAllSplittableAttributes(Mockito.<String>any()))
        .thenReturn(ofResult);
    Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>> emptyResult = Optional.empty();
    Mockito
        .<Optional<Map<Class<? extends SplittableElement>, Pair<String, String>>>>when(
            parser.getAllSplittableValues(Mockito.<String>any()))
        .thenReturn(emptyResult);
    Node item = mock(Node.class);
    when(item.getTextContent()).thenReturn("Not all who wander are lost");
    HashMap<String, String> attributes = new HashMap<>();

    // Act
    select.fillAttributes(parser, item, attributes);

    // Assert
    verify(parser).getAllSplittableAttributes(eq("Not all who wander are lost"));
    verify(parser).getAllSplittableValues(eq("Not all who wander are lost"));
    verify(item).getTextContent();
    assertTrue(attributes.isEmpty());
  }
}
