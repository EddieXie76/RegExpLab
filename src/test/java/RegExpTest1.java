import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class RegExpTest1 {

  @Test
  public void compile_one_time() {
    final Pattern pattern = Pattern.compile("test(ing)?_\\w+");
    for (int i = 0; i < 100_000_000; i++) {
      final Matcher matcher = pattern.matcher("test_hello");
      assertTrue(matcher.find());
    }
  }

  @Test
  public void compile_each_time() {
    for (int i = 0; i < 100_000_000; i++) {
      final Pattern pattern = Pattern.compile("test(ing)?_\\w+");
      final Matcher matcher = pattern.matcher("test_hello");
      assertTrue(matcher.find());
    }
  }
}
