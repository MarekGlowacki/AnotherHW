package main.Excercises_web_app.Servlets;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/sx", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final AsyncContext asyncContext = request.startAsync(request, response);
        new Thread(new Runnable() {
            @Override
            public void run() {
                asyncContext.getResponse().setContentType("text/plain; charset=utf-8");
                try {
                    Thread.sleep(3000);
                    asyncContext.getResponse().getWriter().println("WItaj, świecie bardziej lub mniej miły!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        response.setContentType("text/plain; charset=utf-8");
        response.getWriter().println("WItaj, świecie bardziej lub mniej miły!");
    }

}
