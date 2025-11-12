package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EntityJsonParserBuilderDiffblueTest {
  /**
   * Test {@link EntityJsonParserBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityJsonParserBuilder#build()}
   *   <li>default or parameterless constructor of {@link EntityJsonParserBuilder}
   *   <li>{@link EntityJsonParserBuilder#withUnrestrictedSchemaLoad(boolean)}
   *   <li>{@link EntityJsonParserBuilder#isUnrestrictedSchemaLoad()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityJsonParserBuilder.<init>()",
    "org.symphonyoss.symphony.entityjson.EntityJsonParser EntityJsonParserBuilder.build()",
    "boolean EntityJsonParserBuilder.isUnrestrictedSchemaLoad()",
    "EntityJsonParserBuilder EntityJsonParserBuilder.withUnrestrictedSchemaLoad(boolean)"
  })
  public void testBuild() {
    // Arrange and Act
    EntityJsonParserBuilder actualEntityJsonParserBuilder = new EntityJsonParserBuilder();
    EntityJsonParserBuilder actualWithUnrestrictedSchemaLoadResult =
        actualEntityJsonParserBuilder.withUnrestrictedSchemaLoad(true);
    actualWithUnrestrictedSchemaLoadResult.build();

    // Assert
    assertTrue(actualEntityJsonParserBuilder.isUnrestrictedSchemaLoad());
    assertTrue(actualWithUnrestrictedSchemaLoadResult.isUnrestrictedSchemaLoad());
  }
}
