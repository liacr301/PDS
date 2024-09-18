package lab07.Ex3_Adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvancedPrinter implements PrinterInterface {
    private Map<Integer, Document> printQueue;
    private int jobIdCounter;

    public AdvancedPrinter() {
        printQueue = new HashMap<>();
        jobIdCounter = 0;
    }

    @Override
    public int print(Document doc) {
        printQueue.put(jobIdCounter, doc);
        System.out.println("Spooling 1 document.");
        return jobIdCounter++; // Retorna o ID do trabalho de impressão
    }

    @Override
    public List<Integer> print(List<Document> docs) {
        List<Integer> jobIds = new ArrayList<>();
        for (Document doc : docs) {
            printQueue.put(jobIdCounter, doc);
            System.out.println("Spooling 1 document.");
            jobIds.add(jobIdCounter++);
        }
        return jobIds; // Retorna uma lista de IDs de trabalhos de impressão
    }

    @Override
    public void showQueuedJobs() {
        if (printQueue.isEmpty()) {
            System.out.println("No spooled jobs");
        } else {
            System.out.println("Spooled jobs:");
            for (Map.Entry<Integer, Document> entry : printQueue.entrySet()) {
                System.out.println(" * Job " + entry.getKey() + ": \"" + entry.getValue().getContent() + "\"");
            }
        }
    }

    @Override
    public boolean cancelJob(int jobId) {
        if (printQueue.containsKey(jobId)) {
            printQueue.remove(jobId);
            System.out.println("Cancelled Job " + jobId);
            return true;
        } else {
            System.out.println("Job " + jobId + " does not exist or cannot be cancelled.");
            return false;
        }
    }

    @Override
    public void cancelAll() {
        if (!printQueue.isEmpty()) {
            printQueue.clear();
            System.out.println("Cancelled all jobs.");
        } else {
            System.out.println("No spooled jobs to cancel.");
        }
    }

    @Override
    public void refill() {
        System.out.println("Reabastecendo tinta e papel...");
        // Simular a reposição de tinta e papel
        try {
            Thread.sleep(2000); // Esperar 2 segundos para simular o tempo de reposição
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Reabastecimento concluído.");
    }
}
