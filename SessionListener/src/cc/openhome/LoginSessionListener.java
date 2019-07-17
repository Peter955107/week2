package cc.openhome;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class LoginSessionListener implements HttpSessionListener {
    private static int count;

    public static int getCount() {
        return count;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        LoginSessionListener.count++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        LoginSessionListener.count--;
    }
}