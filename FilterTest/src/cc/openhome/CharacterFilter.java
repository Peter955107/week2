package cc.openhome;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebFilter(
    urlPatterns={"/guestbook"},
    initParams={
        @WebInitParam(
            name="ESCAPE_LIST",
            value="/WEB-INF/escapes.txt"
        )
    }
)
public class CharacterFilter extends HttpFilter {
    private Map<String, String> escapes = new HashMap<>();

    @Override
    public void init() throws ServletException {
        try(BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        getServletContext()
                            .getResourceAsStream(getInitParameter("ESCAPE_LIST"))))) {

            String input = null;
            while ((input = reader.readLine()) != null) {
                String[] tokens = input.split("\t");
                escapes.put(tokens[0], tokens[1]);
            }
        } catch (IOException ex) {
            Logger.getLogger(CharacterFilter.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response,
          FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new CharacterRequestWrapper(request, escapes), response);
    }
}