package cc.openhome;

import java.util.*;
import javax.servlet.http.*;

public class CharacterRequestWrapper extends HttpServletRequestWrapper {
    private Map<String, String> escapes;

    public CharacterRequestWrapper(HttpServletRequest request, Map<String, String> escapes) {
        super(request);
        this.escapes = escapes;
    }

    @Override
    public String getParameter(String name) {
        return Optional.ofNullable(getRequest().getParameter(name))
                       .map(this::escape)
                       .orElse(null);
    }

    private String escape(String value) {
        String result = value;
        for(String origin : escapes.keySet()) {
            result = result.replaceAll(origin, escapes.get(origin));
        }
        return result;
    }
}