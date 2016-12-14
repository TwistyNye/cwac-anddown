package com.commonsware.cwac.anddown;


/**
 * Android-compliant wrapper around hoedown, a C-based Markdown parser and HTML
 * generator
 */
public class AndDown
{
  /**
   * constant, which specify empty MarkDown extensions
   */
  public static final int EMPTY_MARKDOWN_EXTENSIONS = 0;


  /**
   * static initialization: load the hoedown native library
   */
  static
  {
    System.loadLibrary ("anddown");
  }


  /**
   * Convert specified MarkDown source code to HTML, using specified extensions
   *
   * @param raw        MarkDown source code
   * @param extensions selected extensions (@see #Extensions)
   *
   * @return generated HTML markup
   */
  /*
   * The earlier release of 0.2.4 left a zero in
   * place of `extensions`.  This activation of the
   * HoeDown 3.0.1 Extensions should merit a new
   * version number, so that Projects using them
   * should find release 0.2.5 or later.
   */
  public static native String markdownToHtml (String raw, int extensions);


  /**
   * Convert specified MarkDown source code to HTML
   *
   * @param raw MarkDown source code
   *
   * @return generated HTML markup
   */
  public static String markdownToHtml (String raw)
  {
    return markdownToHtml (raw, EMPTY_MARKDOWN_EXTENSIONS);
  }

  /**
   * MarkDown extensions, supported by the library. Will be used as ORed
   * bit mask (@see #markdownToHtml(String raw, int extensions))
   */
  public enum Extensions
  {
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


    /**
     * Integer value associated with enumeration element
     */
    private final int value;


    /**
     * constructor to set the value associated with enumeration element
     *
     * @param value value associated with enumeration element
     */
    private Extensions (int value)
    {
      this.value = value;
    }


    /**
     * get the value associated with enumeration element
     *
     * @return the value associated with enumeration element
     */
    public int getValue ()
    {
      return value;
    }
  }
}
