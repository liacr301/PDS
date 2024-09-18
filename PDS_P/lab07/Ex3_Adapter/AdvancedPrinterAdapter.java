package lab07.Ex3_Adapter;

import java.util.List;

public class AdvancedPrinterAdapter implements PrinterInterface {
    private AdvancedPrinter advancedPrinter;

    public AdvancedPrinterAdapter(AdvancedPrinter advancedPrinter) {
        this.advancedPrinter = advancedPrinter;
    }

    @Override
    public int print(Document doc) {
        return advancedPrinter.print(doc);
    }

    @Override
    public List<Integer> print(List<Document> docs) {
        return advancedPrinter.print(docs);
    }

    @Override
    public void showQueuedJobs() {
        advancedPrinter.showQueuedJobs();
    }

    @Override
    public boolean cancelJob(int jobId) {
        return advancedPrinter.cancelJob(jobId);
    }

    @Override
    public void cancelAll() {
        advancedPrinter.cancelAll();
    }

    @Override
    public void refill() {
        advancedPrinter.refill();
    }
}
