package lab07.Ex3_Adapter;

import java.util.ArrayList;
import java.util.List;

public class BasicPrinterAdapter implements PrinterInterface {
    private BasicPrinter basicPrinter;

    public BasicPrinterAdapter(BasicPrinter basicPrinter) {
        this.basicPrinter = basicPrinter;
    }

    @Override
    public int print(Document doc) {
        // Adaptando a chamada para a impressora básica para lidar com um único documento por vez.
        List<Document> docList = new ArrayList<>();
        docList.add(doc);
        List<Integer> jobIds = basicPrinter.print(docList);
        return jobIds.isEmpty() ? -1 : jobIds.get(0); // Retornar o ID do trabalho ou -1 se a impressão falhar
    }

    @Override
    public List<Integer> print(List<Document> docs) {
        // Adaptando a chamada para a impressora básica para lidar com uma lista de documentos.
        return basicPrinter.print(docs);
    }

    @Override
    public void showQueuedJobs() {
        // Não suportado pela impressora básica
        System.out.println("Operation not supported by BasicPrinter");
    }

    @Override
    public boolean cancelJob(int jobId) {
        // Não suportado pela impressora básica
        System.out.println("Operation not supported by BasicPrinter");
        return false;
    }

    @Override
    public void cancelAll() {
        // Não suportado pela impressora básica
        System.out.println("Operation not supported by BasicPrinter");
    }

    @Override
    public void refill() {
        // Suportado pela impressora básica
        basicPrinter.refill();
    }
}
