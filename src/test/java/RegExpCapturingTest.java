import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class RegExpCapturingTest {

  @Test
  public void capturingGroup() {
    Pattern pattern = Pattern.compile(
        "[^:]+(:\\d{3,5})?");
    Matcher matcher = pattern.matcher("localhost:8080");
    assertTrue(matcher.find());
    assertEquals(0, matcher.groupCount());
  }

  @Test
  public void nonGroup() {
    Pattern pattern = Pattern.compile(
        "[^:]+(:\\d{3,5})?");
    Matcher matcher = pattern.matcher("localhost:8080");
    assertTrue(matcher.find());
    assertEquals(0, matcher.groupCount());
  }
}