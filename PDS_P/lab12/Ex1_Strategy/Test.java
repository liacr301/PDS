package lab12.Ex1_Strategy;

public class Test{
    public static void main(String[] args) {
        PhoneInfo phone1 = new PhoneInfo("model1", "brand1", "cpu1", "price1", "ram1", "camera1");
        PhoneInfo phone2 = new PhoneInfo("model2", "brand2", "cpu2", "price2", "ram2", "camera2");
        PhoneInfo phone3 = new PhoneInfo("model3", "brand3", "cpu3", "price3", "ram3", "camera3");
        PhoneInfo phone4 = new PhoneInfo("model4", "brand4", "cpu4", "price4", "ram4", "camera4");
        PhoneInfo phone5 = new PhoneInfo("model5", "brand5", "cpu5", "price5", "ram5", "camera5");

        PhoneList phoneList = new PhoneList();
        phoneList.add(phone1);
        phoneList.add(phone2);
        phoneList.add(phone3);
        phoneList.add(phone4);
        phoneList.add(phone5);

        phoneList.setOrderStrategy(new SelectionSortStrategy());
        phoneList.order();

        phoneList.setOrderStrategy(new InsertionSortStrategy());
        phoneList.order();

        phoneList.setOrderStrategy(new BubbleSortStrategy());
        phoneList.order();
    }
}