package stufe6;

import static java.lang.String.format;

public class FacebookLikes {

  public static String whoLikesIt(String... names) {
    switch (names.length) {
      case 0:
        return "no one likes this";
      case 1:
        return format("%s likes this", names[0]);
      case 2:
        return format("%s and %s like this", names[0], names[1]);
      case 3:
        return format("%s, %s and %s like this", names[0], names[1], names[2]);
      default:
        return format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
    }
  }

  private static String switchCasesSuck(String... names) {
    int len = names.length;
    if (len <= 1) {
      return format("%s likes this", len == 0 ? "no one" : names[0]);
    } else if (len == 2) {
      return format("%s and %s like this", names[0], names[1]);
    } else if (len == 3) {
      return format("%s, %s and %s like this", names[0], names[1], names[2]);
    } else {
      return format("%s, %s and %d others like this", names[0], names[1], len - 2);
    }
  }
}
