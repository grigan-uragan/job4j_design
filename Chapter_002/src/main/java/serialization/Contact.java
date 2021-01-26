package serialization;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

@XmlElement(value = "contact")
public class Contact {

    private int zipCode;

    private String code;

    public Contact() {
    }

    public Contact(int zipCode, String code) {
        this.zipCode = zipCode;
        this.code = code;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlAttribute
    public int getZipCode() {
        return zipCode;
    }

    @XmlAttribute
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

}
