package lab07.Ex2_Bridge;
import java.util.*;
import java.io.*;

public class StorageContactTypes implements ContactsStorageInterface{
    private File file;

    public StorageContactTypes(File file){
        try{
            this.file = file;
        } catch(Exception e) {
            System.exit(1);
        }
    }

    public void newFile(String path){
        try {
            this.file = new File(path);
        } catch (Exception e) {
            System.exit(1);
        }
    }

    public String fileType(){
        String fileType = this.file.getName().split("\\.")[1];
        String format = "";

        if(fileType == "txt"){
            format = "Text";
        } 
        else if (fileType == "bin"){
            format = "Bin";
        }

        return format;
    }

    public List<Contact> loadContacts(){
        String format = fileType();

        try {
            if(format.equals("Text")){
                ContactsStorageInterface storage = new TXTContacts(this.file);
                return storage.loadContacts();
            } 
            if(format.equals("Bin")){
                ContactsStorageInterface storage = new BinaryContacts(this.file);
                return storage.loadContacts();
            }
        } catch (Exception e) {
            System.exit(1);
        }
        
        return null;
    }

    public boolean saveContacts(List<Contact> list){
        String format = fileType();

        try {
            if(format.equals("Text")){
                ContactsStorageInterface storage = new TXTContacts(this.file);
                return storage.saveContacts(list);
            } 
            if(format.equals("Bin")){
                ContactsStorageInterface storage = new BinaryContacts(this.file);
                return storage.saveContacts(list);
            }
        } catch (Exception e) {
            System.exit(1);
        }
        return true;
    }
}
