import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class ReadWriterFile {
    public static final String HOTEL_TXT = "hotel.txt";

    public static void writerFile(ArrayList<Room> rooms) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(HOTEL_TXT);
            ObjectOutputStream obj = new ObjectOutputStream(fileOutputStream);
            obj.writeObject(rooms);
            obj.flush();
            obj.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Room> readFile() {
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(HOTEL_TXT);
            ObjectInputStream obj = new ObjectInputStream(fileInputStream);
            rooms = (ArrayList<Room>) obj.readObject();
            obj.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }


}
