import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class RegExpGreedyLazyTest {

  @Test
  public void greedy() {
    final Pattern pattern = Pattern.compile("<div>.*<\\/div>");
    final Matcher matcher = pattern.matcher("<div>Hello</div><div>World</div>");
    assertTrue(matcher.find());
    assertEquals("<div>Hello</div><div>World</div>", matcher.group());
    assertFalse(matcher.find());
  }

  @Test
  public void lazy() {
    final Pattern pattern = Pattern.compile("<div>.*?<\\/div>");
    final Matcher matcher = pattern.matcher("<div>Hello</div><div>World</div>");
    assertTrue(matcher.find());
    assertEquals("<div>Hello</div>", matcher.group());
    assertTrue(matcher.find());
    assertEquals("<div>World</div>", matcher.group());
  }
}
