package Misc;

import java.io.*;
import java.util.Base64;

public class Serialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        AppleProduct macBook = new AppleProduct();
        macBook.headphonePort = "headphonePort2020";
        macBook.thunderboltPort = "thunderboltPort2020";

        String serializedString  = serializeObjectToString(macBook);
        System.out.println("Serialized Object " + serializedString);

        Object obj = deSerializeObjectFromString(serializedString);
    }

    static Object deSerializeObjectFromString(String string) throws IOException, ClassNotFoundException {

        byte[] data = Base64.getDecoder().decode(string);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }

    /*
    For Serialization we are first converting the Object to Byte array
    then we serialize it to
     */
    static String serializeObjectToString(Serializable object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(object);
        oos.close();

        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
}

class AppleProduct implements Serializable {
    private static final long serialVersionUID = 1234567L;
    public String headphonePort;
    public String thunderboltPort;
}
