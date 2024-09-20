package Studentsdetails;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Studentpost {
    private static void addStudent(String studentJson) throws Exception {
        String urlString = "http://localhost:1337/api/students"; 
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true); 
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = studentJson.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_CREATED) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Failed to add student.");
        }
    }
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "John Doe");
        student.put("age", 21);
        student.put("major", "Computer Science");
        String studentJson = student.toString();

        try {
            addStudent(studentJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
