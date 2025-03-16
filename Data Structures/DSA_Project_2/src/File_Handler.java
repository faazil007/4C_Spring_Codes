import java.io.*;
import java.util.*;

public class File_Handler {
    private String path;
    private boolean append;

    public File_Handler(String path) {
        this.path = path;
        this.append = false;
    }

    public File_Handler(String path, boolean append) {
        this.path = path;
        this.append = append;
    }

    public void writeData(String data) throws IOException {
        FileWriter writer = new FileWriter(path, append);
        writer.write(data);
        writer.close();
    }

    public String readData() throws IOException {
        String fileData = "";
        FileReader reader = new FileReader(path);
        int ascii;
        while ((ascii = reader.read()) != -1) {
            fileData = fileData + (char) ascii;
        }
        return fileData;
    }

    public void removeData(String patientName) throws IOException {
        File inputFile = new File(path);
        File tempFile = new File("temp_" + path);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            // Skip the patient to be deleted
            if (!currentLine.contains(patientName)) {
                writer.write(currentLine + System.lineSeparator());
            }
        }
        writer.close();
        reader.close();
        // Delete the original file
        inputFile.delete();
        // Rename the temp file to original file
        tempFile.renameTo(inputFile);
    }
}
