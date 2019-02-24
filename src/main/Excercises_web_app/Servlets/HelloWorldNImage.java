package main.Excercises_web_app.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(value = "/helloWorldNImage")
public class HelloWorldNImage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println("<html><head><title>Title</title></head>");
        pw.println("<body>");
        pw.println("<p>Siema śięma</p>");
        pw.println("<p>Drugi wiersz</p>");
        pw.println("</body></html>");

//        byte[] bufor = readFile("/home/marek/zalaczniki/obrazek.png");
//        response.setContentType("image/png");
//        response.setContentLength(bufor.length);
//        response.addHeader("Content-Disposition", "attachment;filename=obraz.png");
//        OutputStream os = response.getOutputStream();
//        os.write(bufor);
//        os.flush();
    }

    private byte[] readFile(String fileName) throws IOException {
        File file = new File(fileName);
        long size = file.length();
        byte[] content = new byte[(int)size];
        FileInputStream fis = new FileInputStream(file);
        fis.read(content);
        fis.close();
        return content;
    }
}