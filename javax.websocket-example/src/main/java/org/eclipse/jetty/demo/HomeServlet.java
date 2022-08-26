package org.eclipse.jetty.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            PrintWriter printWriter = resp.getWriter();
            //Указываем что информация на странице это json
            resp.setContentType("application/json");

            //Добавляем в ответ заголовок чтобы небыло ошибки связанной с CORS
            //указывает браузеру разрешить доступ к ресурсу из любого источника
            resp.setHeader("Access-Control-Allow-Origin", "*");

            //Пример JSON
            String employeeJsonString = """
                {"users": {"Second" : {"login" : "Second", "password" : "aaaa"}, "First" : {"login" : "First", "password" : "1111"}  } }
                """;
            //Печатаем на странице
            printWriter.print(employeeJsonString);
        }
}
