package lab12.Ex1_Strategy;

import java.util.ArrayList;

public class SelectionSortStrategy implements OrderStrategy{
    @Override
    public void order(ArrayList<PhoneInfo> infos) {
        System.out.println("Selection Sort");
    }
}
