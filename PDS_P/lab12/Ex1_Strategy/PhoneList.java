package lab12.Ex1_Strategy;

import java.util.ArrayList;

public class PhoneList {
    private ArrayList<PhoneInfo> phoneInfos;
    private OrderStrategy orderStrategy;
    
    public PhoneList() {
        phoneInfos = new ArrayList<>();
    }

    public void add(PhoneInfo phoneInfo) {
        phoneInfos.add(phoneInfo);
        System.out.println("Phone added");
    }

    public void setOrderStrategy(OrderStrategy orderStrategy) {
        this.orderStrategy = orderStrategy;
        System.out.println("Order strategy set");
    }

    public void order() {
        orderStrategy.order(phoneInfos);
    }
}
