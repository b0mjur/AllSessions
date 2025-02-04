package MySMS.SMS;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiTestClient {
    private static final String BASE_URL = "http://localhost:8000/graduate";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        try {
            int studentId = 1; // Replace with a valid student ID
            double gpa = 3.5; // Replace with a valid GPA

            // Create JSON request body
            String requestBody = objectMapper.createObjectNode()
                    .put("id", studentId)
                    .put("gpa", gpa)
                    .toString();

            // Send POST request
            URL url = new URL(BASE_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                os.write(requestBody.getBytes());
                os.flush();
            }

            // Get response
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                String response = new String(connection.getInputStream().readAllBytes());
                System.out.println("Response: " + response);
            } else {
                System.out.println("Failed to graduate student.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}