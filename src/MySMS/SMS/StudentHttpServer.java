package MySMS.SMS;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class StudentHttpServer {
    private static final int PORT = 8000;
    private StudentService studentService;
    private ObjectMapper objectMapper = new ObjectMapper();

    public StudentHttpServer(StudentService studentService) {
        this.studentService = studentService;
    }

    private class GraduateHandler implements HttpHandler {
        private GraduateStudentService graduateStudentService;

        public GraduateHandler(StudentService studentService) {
            this.graduateStudentService = new GraduateStudentService(studentService);
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!exchange.getRequestMethod().equals("POST")) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            String requestBody = new String(exchange.getRequestBody().readAllBytes());
            JsonNode jsonNode = objectMapper.readTree(requestBody);
            int studentId = jsonNode.get("id").asInt();
            double gpa = jsonNode.get("gpa").asDouble();

            String result = graduateStudentService.graduateStudent(studentId, gpa);

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, result.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(result.getBytes());
            os.close();
        }
    }

    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/graduate", new GraduateHandler(studentService));
        server.setExecutor(null);
        server.start();
        System.out.println("HTTP server started on port " + PORT);
    }
}