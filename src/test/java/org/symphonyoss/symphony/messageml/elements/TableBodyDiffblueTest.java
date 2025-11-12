package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class TableBodyDiffblueTest {
  /**
   * Test {@link TableBody#TableBody(Element)}.
   *
   * <p>Method under test: {@link TableBody#TableBody(Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableBody.<init>(Element)"})
  public void testNewTableBody() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    TableBody actualTableBody = new TableBody(parent2);

    // Assert
    assertEquals(0, actualTableBody.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTableBody.getFormat());
    assertTrue(actualTableBody.getChildren().isEmpty());
    assertTrue(actualTableBody.getAttributes().isEmpty());
    assertEquals(TableBody.MESSAGEML_TAG, actualTableBody.getMessageMLTag());
    assertEquals(TableBody.MESSAGEML_TAG, actualTableBody.getPresentationMLTag());
    assertSame(parent2, actualTableBody.getParent());
  }

  /**
   * Test {@link TableBody#toString()}.
   *
   * <p>Method under test: {@link TableBody#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TableBody.toString()"})
  public void testToString() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertEquals("Body", new TableBody(parent).toString());
  }

  /**
   * Test {@link TableBody#validate()}.
   *
   * <ul>
   *   <li>Given {@link TableBody#TableBody(Element)} with parent is {@link Bold#Bold(Element)}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TableBody#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableBody.validate()"})
  public void testValidate_givenTableBodyWithParentIsBold_thenDoesNotThrow()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new TableBody(parent).validate();
  }

  /**
   * Test {@link TableBody#validate()}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link TableBody#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableBody.validate()"})
  public void testValidate_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    TableBody tableBody = new TableBody(parent);
    tableBody.addChild(new Bold(new BulletList(null)));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> tableBody.validate());
  }
}
