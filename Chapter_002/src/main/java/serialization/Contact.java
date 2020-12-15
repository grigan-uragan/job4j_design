package serialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;

public class Contact implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(Contact.class.getName());
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String code;

    public Contact(int zipCode, String code) {
        this.zipCode = zipCode;
        this.code = code;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Contact{" + "zipCode=" + zipCode + ", code='" + code + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return zipCode == contact.zipCode
                && Objects.equals(code, contact.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode, code);
    }

    public static void main(String[] args) throws IOException {
        final Contact contact = new Contact(12345, "+7(926)555-55-55");
        System.out.println("Before serialisation : " + contact);
        File temp = Files.createTempFile(null, null).toFile();
        try (FileOutputStream out = new FileOutputStream(temp);
             ObjectOutputStream objectOut = new ObjectOutputStream(out)) {
            objectOut.writeObject(contact);
        }

        Contact serialConcat = null;
        try (FileInputStream source = new FileInputStream(temp);
            ObjectInputStream objectInput = new ObjectInputStream(source)) {
            serialConcat = (Contact) objectInput.readObject();
        } catch (ClassNotFoundException e) {
            LOG.error("Some troubles with our serialisation", e);
        }
        System.out.println("After serialisation : " + contact);
        System.out.println(contact.equals(serialConcat));
    }
}
