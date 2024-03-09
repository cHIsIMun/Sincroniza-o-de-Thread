import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class FileMerger implements Runnable {
    private String inputFilePath;
    private String outputFilePath;

    public FileMerger(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
            String line;
            while ((line = br.readLine()) != null) {
                writeToFileSynchronized(line, outputFilePath);
            }
            br.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    // Método sincronizado para escrever no arquivo de saída
    private static synchronized void writeToFileSynchronized(String content, String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine(); // Adiciona uma nova linha antes da frase
            bw.write(content); // Adiciona a frase
            bw.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}