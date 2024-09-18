package lab07.Ex3_Adapter;

import java.util.ArrayList;
import java.util.List;

public class BasicPrinter implements PrinterInterface {
    private int inkAmount;
    private int paperAmount;

    public BasicPrinter() {
        this.inkAmount = 4;
        this.paperAmount = 4;
    }

    @Override
    public int print(Document doc) {
        // Adaptando a chamada para lidar com um único documento por vez.
        List<Document> docList = new ArrayList<>();
        docList.add(doc);
        List<Integer> jobIds = print(docList);
        return jobIds.isEmpty() ? -1 : jobIds.get(0); // Retornar o ID do trabalho ou -1 se a impressão falhar
    }

    @Override
    public List<Integer> print(List<Document> docs) {
        if (inkAmount <= 0 || paperAmount <= 0) {
            System.out.println("Erro: Sem tinta ou papel suficiente.");
            return new ArrayList<>();
        }

        // Verifica se há papel suficiente para imprimir todas as páginas
        if (docs.size() > paperAmount) {
            System.out.println("Erro: Não há papel suficiente para imprimir todas as páginas.");
            return new ArrayList<>();
        }

        // Verifica se há tinta suficiente para imprimir todas as páginas
        int totalPages = docs.size();
        int inkRequired = totalPages * 2; // Supondo que cada página requer 2 de tinta
        if (inkRequired > inkAmount) {
            System.out.println("Erro: Não há tinta suficiente para imprimir todas as páginas.");
            return new ArrayList<>();
        }

        // Imprime cada página
        List<Integer> jobIds = new ArrayList<>();
        for (Document doc : docs) {
            System.out.println("Imprimindo página: " + doc.getContent());
            jobIds.add(0); // Simular a atribuição de um ID de trabalho
        }

        // Atualiza a quantidade de tinta e papel restante
        inkAmount -= inkRequired;
        paperAmount -= totalPages;

        return jobIds;
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
        inkAmount = 4;
        paperAmount = 4;
        System.out.println("Impressora recarregada com sucesso.");
    }
}
