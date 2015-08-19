package com.commonsware.cwac.anddown;

public class AndDown {
  static {
    System.loadLibrary("anddown");
  }

  public static native String markdownToHtml(String raw);
  public static native String markdownToHtml(String raw, int extensions);
  
  public enum Extensions {
    HOEDOWN_EXT_TABLES (1 << 0),
    HOEDOWN_EXT_FENCED_CODE (1 << 1),
    HOEDOWN_EXT_FOOTNOTES (1 << 2),

    /* span-level extensions */
    HOEDOWN_EXT_AUTOLINK (1 << 3),
    HOEDOWN_EXT_STRIKETHROUGH (1 << 4),
    HOEDOWN_EXT_UNDERLINE (1 << 5),
    HOEDOWN_EXT_HIGHLIGHT (1 << 6),
    HOEDOWN_EXT_QUOTE (1 << 7),
    HOEDOWN_EXT_SUPERSCRIPT (1 << 8),
    HOEDOWN_EXT_MATH (1 << 9),

    /* other flags */
    HOEDOWN_EXT_NO_INTRA_EMPHASIS (1 << 11),
    HOEDOWN_EXT_SPACE_HEADERS (1 << 12),
    HOEDOWN_EXT_MATH_EXPLICIT (1 << 13),

    /* negative flags */
    HOEDOWN_EXT_DISABLE_INDENTED_CODE (1 << 14);
    
    private final int value;
    
    private Extensions (int value)
    {
      this.value = value;
    }
    
    public int getValue ()
    {
      return value;
    }
  }
}
