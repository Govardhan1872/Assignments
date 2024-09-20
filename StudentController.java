package Studentsdetails;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StudentController {
    private static void fetchStudentDetails(String studentId) throws Exception {
        String urlString = "http://localhost:1337/api/students/" + studentId;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("Student Details: " + response.toString());
        } else {
            System.out.println("Failed to fetch student details.");
        }
    }
    public static void main(String[] args) {
        String studentId = "12345"; // Example student ID

        try {
            fetchStudentDetails(studentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
