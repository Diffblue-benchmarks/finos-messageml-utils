package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class TableBodyDiffblueTest {
  /**
   * Test {@link TableBody#TableBody(Element)}.
   * <p>
   * Method under test: {@link TableBody#TableBody(Element)}
   */
  @Test
  public void testNewTableBody() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    TableBody actualTableBody = new TableBody(parent);

    // Assert
    assertEquals(0, actualTableBody.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTableBody.getFormat());
    assertTrue(actualTableBody.getChildren().isEmpty());
    assertTrue(actualTableBody.getAttributes().isEmpty());
    assertEquals(TableBody.MESSAGEML_TAG, actualTableBody.getMessageMLTag());
    assertEquals(TableBody.MESSAGEML_TAG, actualTableBody.getPresentationMLTag());
    assertSame(parent, actualTableBody.getParent());
  }

  /**
   * Test {@link TableBody#toString()}.
   * <p>
   * Method under test: {@link TableBody#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Body", (new TableBody(new Bold(new BulletList(null)))).toString());
  }

  /**
   * Test {@link TableBody#validate()}.
   * <ul>
   *   <li>Given {@link TableBody#TableBody(Element)} with parent is
   * {@link Bold#Bold(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableBody#validate()}
   */
  @Test
  public void testValidate_givenTableBodyWithParentIsBold() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new TableBody(new Bold(new BulletList(mock(Element.class))))).validate();
  }

  /**
   * Test {@link TableBody#validate()}.
   * <ul>
   *   <li>Given {@link TableBody#TableBody(Element)} with parent is
   * {@link Bold#Bold(Element)} addChild {@link Bold#Bold(Element)} with parent is
   * {@link BulletList#BulletList(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableBody#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenTableBodyWithParentIsBoldAddChildBoldWithParentIsBulletList()
      throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "b" is not allowed in "tbody"
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertContentModel(Element.java:709)
    //       at org.symphonyoss.symphony.messageml.elements.TableBody.validate(TableBody.java:44)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TableBody tableBody = new TableBody(new Bold(new BulletList(mock(Element.class))));
    tableBody.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act
    tableBody.validate();
  }
}
