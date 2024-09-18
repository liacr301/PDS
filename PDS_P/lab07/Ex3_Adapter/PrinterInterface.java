package lab07.Ex3_Adapter;

import java.util.List;

public interface PrinterInterface {
    public int print(Document doc);
    public List<Integer> print(List<Document> docs);
    public void showQueuedJobs();
    public boolean cancelJob(int jobId);
    public void cancelAll();
    public void refill();
}
