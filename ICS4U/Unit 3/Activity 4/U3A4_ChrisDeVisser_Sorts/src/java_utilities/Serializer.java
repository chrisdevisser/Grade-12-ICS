package java_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Maintains objects to serialize and deserialize.
 * Every object stored must implement ISerializable.
 *
 * @author Chris DeVisser
 */
public class Serializer {
    /**
     * Holds the file to use for reading and writing.
     */
    private String _file;

    /**
     * Creates a new instance.
     * The file will be overwritten on every save.
     *
     * @param file The file to use for reading and writing.
     */
    public Serializer(String file) {
        _file = file;
    }

    /**
     * Serializes objects to file.
     * All objects must implement ISerializable.
     * 
     * @param arr A list of objects to serialize.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void serialize(List<Object> arr) throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream(_file);
        ObjectOutputStream oout = new ObjectOutputStream(fout);

        for (Object o : arr) {
            oout.writeObject(o);
        }
    }

    /**
     * Deserializes objects from file.
     *
     * @return A list of objects in the file in the order serialized.
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public List<Object> deserialize() throws ClassNotFoundException, FileNotFoundException, IOException {
        List<Object> arr = new ArrayList<Object>();

        FileInputStream fin = new FileInputStream(_file);
        ObjectInputStream oin = new ObjectInputStream(fin);

        for (;;) {
            try {
                arr.add(oin.readObject());
            } catch (IOException ex) {
                break;
            }
        }

        return arr;
    }
}
