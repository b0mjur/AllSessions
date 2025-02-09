package SMSFromScratch.SMS1;

import SMSFromScratch.SMS1.GraduationService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class StudentHttpServer {
    private GraduationService graduationService;

    public StudentHttpServer(GraduationService graduationService) {
        this.graduationService = graduationService;
    }

    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/graduate", new GraduateStudentHandler());
        server.setExecutor(null);
        server.start();
    }

    private class GraduateStudentHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                int studentId = Integer.parseInt(exchange.getRequestURI().getQuery().split("=")[1]);
                graduationService.graduateStudent(studentId);
                String response = "Student with ID " + studentId + " has graduated.";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
            }
        }
    }
}