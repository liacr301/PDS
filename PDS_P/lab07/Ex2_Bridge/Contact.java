package lab07.Ex2_Bridge;

public class Contact {
    private String name;
    private int phoneNumber;

    public Contact(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(){
        this(null, 0);

    }

    public Contact(String name){
        this(name,0);
    }

    public String getName(){
        return this.name;
    }
    public void setName(String n){
         this.name = n;
    }

    public int getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber){
         this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return this.name + " - " + this.phoneNumber;
    }
}
