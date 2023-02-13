package FileIO;

import java.io.*;

public class FileIO implements FileIOInterface
{
    private String fileName = "file.txt";

    public String getFileName() {return fileName;}

    public void setFileName(String fileName) {this.fileName = fileName;}

    @Override
    public void saveToFile(Object object)  // method for saving object to file
    {

        try {
            FileOutputStream fos = new FileOutputStream(fileName);   // for working with file, fos - потік
            ObjectOutputStream oos = new ObjectOutputStream(fos);    // to work with our object (fos)
            oos.writeObject(object);  // writing object to file
            oos.close();    // closing file
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public Object loadFromFile()     // read object from file
    {
        Object result = null;

        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return result;
    }
}
