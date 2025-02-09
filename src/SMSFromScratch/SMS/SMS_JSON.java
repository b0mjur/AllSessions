package SMSFromScratch.SMS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SMS_JSON {
    private List<Student> students;

    public static void saveToJson(List<Student> students, Gson gson, String fileName) {
        String filePath = "C:\\Users\\vital\\FullStackPortnov\\Java\\MyCode\\" + fileName; // Construct the file path
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(students, writer);
            System.out.println("Students saved to JSON file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> loadFromJson(Gson gson, String fileName) {
        String filePath = "C:\\Users\\vital\\FullStackPortnov\\Java\\MyCode\\" + fileName; // Construct the file path
        System.out.println("Loading from file: " + filePath); // Print the file path
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, new TypeToken<ArrayList<Student>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}