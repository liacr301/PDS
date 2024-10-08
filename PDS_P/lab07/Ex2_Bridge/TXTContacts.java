package lab07.Ex2_Bridge;

import java.util.*;
import java.io.*;

public class TXTContacts implements ContactsStorageInterface{
    private File textFile;

    public TXTContacts(File file){
        super();
        this.textFile = file;
    }

    @Override
    public List<Contact> loadContacts(){
        Scanner sc = new Scanner(System.in);
        try {
            List<Contact> list = new ArrayList<>();
            while(sc.hasNext()){
                String line[] = sc.nextLine().split("\\s+");
                for(int i = 0; i < line.length; i++){
                    Contact contact = new Contact(line[i]);
                    list.add(contact);
                }
            }
            sc.close();
            return list;

        } catch (Exception e) {
        }
        sc.close();
        return null;
    }

    @Override
    public boolean saveContacts(List<Contact> list){
        try {
            FileWriter writer = new FileWriter(textFile.getName());
            PrintWriter printWriter = new PrintWriter(writer);
            for(Contact c : list) {
                printWriter.print(c.toString() + " ");
            }
            printWriter.close();
            writer.close();
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
}
