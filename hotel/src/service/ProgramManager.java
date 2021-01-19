package service;

import com.sun.xml.internal.ws.addressing.WsaTubeHelper;
import model.Room;
import storage.ReadWriterFile;

import java.util.*;

public class ProgramManager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Room> rooms;

    public ProgramManager(ArrayList<Room> roomList) {
        this.rooms = roomList;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms = ReadWriterFile.readFile();
        rooms.add(room);
        ReadWriterFile.writerFile(rooms);
    }

    public void showRoom() {
        System.out.println("-------------------- Thông tin khách thuê trọ --------------------");
        System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s"
                , "Tên khách thuê"
                , "Ngày sinh"
                , "Số chứng minh thư"
                , "Ngày trọ"
                , "Loại phòng"
                , "Giá phòng");
        for (Room room : rooms) {
            System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s"
                    , room.getPerson().getName()
                    , room.getPerson().getDate()
                    , room.getPerson().getId()
                    , room.getDateOfStay()
                    , room.getCategoryRoom()
                    , room.getPriceRoom() + "vnđ");
        }
        ReadWriterFile.readFile();
    }

    public void deleteRoom(String id) {
        for (int i = 0; i < rooms.size(); i++) {
            if (id.equals(rooms.get(i).getPerson().getId())) {
                rooms.remove(i);
                i--;
            }
        }
        System.out.println("------Xóa khách trọ thành công-----");
        ReadWriterFile.writerFile(rooms);
    }

    public void searchRoom(String id) {
        for (Room room : rooms) {
            if (id.equals(room.getPerson().getId())) {
                System.out.println("-----------Thông tin khách thuê-----------");
                System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s"
                        , "Tên khách thuê"
                        , "Ngày sinh"
                        , "Số chứng minh thư"
                        , "Ngày trọ"
                        , "Loại phòng"
                        , "Giá phòng");
                System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s"
                        , room.getPerson().getName()
                        , room.getPerson().getDate()
                        , room.getPerson().getId()
                        , room.getDateOfStay()
                        , room.getCategoryRoom()
                        , room.getPriceRoom() + "vnđ" + "\n");
            }
        }
    }

    public void billRoom(String id) {
        for (Room room : rooms) {
            if (id.equals(room.getPerson().getId())) {
                System.out.println("----------Thông tin khách thuê-----------");
                System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                        , "Tên khách thuê"
                        , "Ngày sinh"
                        , "Số chứng minh thư"
                        , "Ngày trọ"
                        , "Loại phòng"
                        , "Giá phòng"
                        , "Thanh toán");
                System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                        , room.getPerson().getName()
                        , room.getPerson().getDate()
                        , room.getPerson().getId()
                        , room.getDateOfStay()
                        , room.getCategoryRoom()
                        , room.getPriceRoom() + "vnđ"
                        , room.getTotal() + "vnđ" + "\n");
            }
        }
        ReadWriterFile.writerFile(rooms);
    }

    public void editRoom(int index, Room room) {
        rooms.set(index, room);
        ReadWriterFile.writerFile(rooms);
    }

    class SortRoom implements Comparator<Room> {
        @Override
        public int compare(Room room1, Room room2) {
            return room1.getPerson().getName().compareTo(room2.getPerson().getName());
        }
    }

    public void sortRoom() {
        Collections.sort(rooms, new SortRoom());
        System.out.println("----Sắp xếp thành công----");
        ReadWriterFile.writerFile(rooms);
    }

}


