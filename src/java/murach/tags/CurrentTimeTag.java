package murach.tags;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

public class CurrentTimeTag extends TagSupport {

  @Override
  public int doStartTag() throws JspException {
    Date currentDate = new Date();
    DateFormat shortDate = DateFormat.getTimeInstance(DateFormat.LONG);
    String currentDateFormatted = shortDate.format(currentDate);

    try {
      JspWriter out = pageContext.getOut();
      out.print(currentDateFormatted);
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
    return SKIP_BODY;
  }
}
