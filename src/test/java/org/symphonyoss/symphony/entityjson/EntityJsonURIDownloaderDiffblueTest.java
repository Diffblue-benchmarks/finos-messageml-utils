package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EntityJsonURIDownloaderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityJsonURIDownloader}
   *   <li>{@link EntityJsonURIDownloader#getInstance()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityJsonURIDownloader.<init>()",
    "com.github.fge.jsonschema.core.load.download.URIDownloader EntityJsonURIDownloader.getInstance()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new EntityJsonURIDownloader().getInstance() instanceof EntityJsonURIDownloader);
  }
}
