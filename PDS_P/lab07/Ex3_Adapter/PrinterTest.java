package lab07.Ex3_Adapter;

import java.util.ArrayList;
import java.util.List;

public class PrinterTest {
    private static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Teste com AdvancedPrinterAdapter
        System.out.println("Teste com AdvancedPrinterAdapter:");

        // Criando uma instância de AdvancedPrinter
        AdvancedPrinter advancedPrinter = new AdvancedPrinter();
        AdvancedPrinterAdapter advancedAdapter = new AdvancedPrinterAdapter(advancedPrinter);

        Document doc1 = new Document("lab07/Ex3_Adapter/text1.txt");
        int jobId1 = advancedAdapter.print(doc1);
        pause(2000);

        List<Document> docList = new ArrayList<>();
        docList.add(new Document("lab07/Ex3_Adapter/text2.txt"));
        docList.add(new Document("lab07/Ex3_Adapter/text3.txt"));
        List<Integer> jobIds = advancedAdapter.print(docList);
        pause(2000);

        advancedAdapter.showQueuedJobs();
        pause(2000);

        advancedAdapter.cancelJob(6);
        advancedAdapter.showQueuedJobs();
        pause(2000);

        advancedAdapter.cancelAll();
        advancedAdapter.showQueuedJobs();
        pause(2000);

        // Teste com BasicPrinterAdapter
        System.out.println("Teste com BasicPrinterAdapter:");

        // Criando uma instância de BasicPrinter
        BasicPrinter basicPrinter = new BasicPrinter();
        BasicPrinterAdapter basicAdapter = new BasicPrinterAdapter(basicPrinter);

        Document doc2 = new Document("lab07/Ex3_Adapter/text1.txt");
        int jobId2 = basicAdapter.print(doc2);
        pause(2000);

        basicAdapter.refill();
        pause(2000);

        // Tentar cancelar um trabalho que não existe
        basicAdapter.cancelJob(6); 
        pause(2000);

        // Cancelar todos os trabalhos
        basicAdapter.cancelAll(); 
    }
}
