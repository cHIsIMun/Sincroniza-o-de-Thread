public class MergeFilesWithThreads {

    public static void main(String[] args) {
        // Caminhos para os arquivos de entrada
        String[] filePaths = {"frases1.txt", "frases2.txt", "frases3.txt"};
        
        // Cria uma thread para cada arquivo de entrada
        for (String path : filePaths) {
            new Thread(new FileMerger(path, "todasFrases.txt")).start();
        }
    }
}
