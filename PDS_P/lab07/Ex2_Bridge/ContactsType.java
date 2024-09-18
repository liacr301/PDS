package lab07.Ex2_Bridge;

import java.util.*;

public class ContactsType implements ContactsInterface {
    private List<Contact> contacts;
    private ContactsStorageInterface contactsStore;

    public ContactsType() {
        this.contacts = new ArrayList<>();
    }

    public List<Contact> getList() {
        return this.contacts;
    }

    public void openAndLoad(ContactsStorageInterface store) {
        this.contacts.addAll(store.loadContacts());
        System.out.println("Contactos adicionados!");
    }

    public void saveAndClose() {

        saveAndClose(contactsStore);
    }

    public void saveAndClose(ContactsStorageInterface store) {
        if (contacts.size() < 1) {
            return;
        } else {
            if (store.saveContacts(this.contacts)) {
                System.out.println("Contactos guardados");
            } else {
                System.out.println("Não foi possivel adicionar os contactos");
            }
        }
    }


    public boolean exist(Contact contact) {
        for (Contact c : this.contacts) {
            if (c.toString().equals(contacts.toString())) {
                return true;
            }
        }
        return false;
    }

    public Contact getByName(String name) {
        for (Contact c : this.contacts) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public boolean add(Contact contact) {
        if (this.exist(contact)) {
            return false;
        } else {
            contacts.add(contact);
            return true;
        }
    }

    public boolean remove(Contact contact) {
        if (contact != null && this.exist(contact)) {
            contacts.remove(contact);
            return true;
        } else {
            return false;
        }
    }
}