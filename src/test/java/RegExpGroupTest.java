import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class RegExpGroupTest {

  public static final Pattern PATTERN = Pattern.compile(
      "=?\"(.*)\",=?\"(.*)\",=?\"(.*)\",=?\"(.*)\",=?\"(.*)\",=?\"(.*)\",=\"(.*)\",=\"(.*)\"");

  @Test
  public void group() {

    String input =
            "=\"EXPEDIA_x\",\"IHG-y\",\"HISHA\",\"IDU0G\",\"XADN\",\"3101\","
                + "=\"requestId:xxx,Direct Codes do not match. - No valid hotel for "
                + "HotelCode = \"\"HISHA\"\",BrandCode = \"\"IC\"\", "
                + "ChainCode = \"\"IC\"\" OR no match for "
                + "RoomTypeCode = \"\"XADN\"\" "
                + "RatePlanCode = \"\"IDU0G\"\"\",=\"2022-02-23T03:32:01Z\"";

    final Matcher matcher = PATTERN.matcher(input);
    assertTrue(matcher.find());
    assertEquals("EXPEDIA_x", matcher.group(1));
    assertEquals("IHG-y", matcher.group(2));
    assertEquals("HISHA", matcher.group(3));
    assertEquals("IDU0G", matcher.group(4));
    assertEquals("XADN", matcher.group(5));
    assertEquals("3101", matcher.group(6));
    assertEquals("requestId:xxx,Direct Codes do not match. - No valid hotel "
        + "for HotelCode = \"\"HISHA\"\",BrandCode = \"\"IC\"\", ChainCode = \"\"IC\"\" "
        + "OR no match for RoomTypeCode = \"\"XADN\"\" RatePlanCode = \"\"IDU0G\"\"", matcher.group(7));
    assertEquals("2022-02-23T03:32:01Z", matcher.group(8));
  }}
