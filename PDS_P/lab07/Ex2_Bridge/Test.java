package lab07.Ex2_Bridge;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        ContactsType listContacts = new ContactsType();

        //inserir ficheiros num aramazenamento
        File file = new File("contacts.txt");
        ContactsStorageInterface storage = new StorageContactTypes(file);
        
        //usar a interface 
        listContacts.openAndLoad(storage);
        listContacts.getByName("Lia");
        listContacts.add(new Contact("Joao Sousa", 965376343));
        listContacts.getByName("Joao");

        listContacts.remove(listContacts.getByName("Lia Cardoso"));
        listContacts.exist(new Contact("Joana Amaral, 918889521"));
    
        //Abrir ficheiro binario
        file = new File("binary.bin");
        storage = new StorageContactTypes(file);
        listContacts.saveAndClose(storage);
        for(Contact c: listContacts.getList()){
            c.toString();
        }
        listContacts.getList();
        listContacts.openAndLoad(storage);
        for(Contact c: listContacts.getList()){
            c.toString();
        }
    }
}
