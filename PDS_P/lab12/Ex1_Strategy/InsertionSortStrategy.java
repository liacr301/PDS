package lab12.Ex1_Strategy;

import java.util.ArrayList;

public class InsertionSortStrategy implements OrderStrategy{

    @Override 
    public void order(ArrayList<PhoneInfo> infos){
         System.out.println("Insertion Sort");
    }
}
