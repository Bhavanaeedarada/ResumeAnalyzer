import java.io.*;
import java.util.*;

public class ResumeAnalyzer {
    public static void main(String[] args) {
        String fileName = "resume.txt.txt"; // Name of your resume file
        StringBuilder content = new StringBuilder();

        // Step 1: Read the file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Step 2: Store resume content in a string
        String resumeText = content.toString();
        System.out.println("===== Resume Content =====");
        System.out.println(resumeText);

        // Step 3: Count words
        String[] words = resumeText.trim().split("\\s+");
        int wordCount = words.length;

        // Step 4: Find keywords
        String[] keywords = {"Java", "Python", "HTML", "CSS", "JavaScript", "Machine Learning", "SQL"};
        List<String> foundKeywords = new ArrayList<>();

        for (String keyword : keywords) {
            if (resumeText.toLowerCase().contains(keyword.toLowerCase())) {
                foundKeywords.add(keyword);
            }
        }

        // Step 5: Print results
        System.out.println("\n===== Resume Analysis =====");
        System.out.println("Total Words: " + wordCount);
        System.out.println("Skills Found: " + foundKeywords);
        System.out.println("===========================");
    }
}
