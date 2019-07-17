package cc.openhome;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfTag extends SimpleTagSupport {
    private boolean test;

    @Override
    public void doTag() throws JspException {
        if (test) {
            try {
                getJspBody().invoke(null);
            } catch (java.io.IOException ex) {
                throw new JspException("IfTag 執行錯誤", ex);
            }
        }
    }

    public void setTest(boolean test) {
        this.test = test;
    }
}