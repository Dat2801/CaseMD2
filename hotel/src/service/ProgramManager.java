package service;

import model.Room;
import storage.ReadWriterFile;

import java.util.*;

public class ProgramManager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Room> rooms;

    public ProgramManager(ArrayList<Room> r) {
        this.rooms = r;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void addHotel(Room room) {
        rooms = ReadWriterFile.readFile();
        rooms.add(room);
        ReadWriterFile.writerFile(rooms);
    }

    public void showRoom() {
        System.out.println("---------Thông tin khách thuê trọ-------");
        System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s"
                , "Tên khách thuê"
                , "Ngày sinh"
                , "Số chứng minh thư"
                , "Ngày trọ"
                , "Loại phòng"
                , "Giá phòng");
        for (Room room : rooms) {
            System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s"
                    , room.getName()
                    , room.getDate()
                    , room.getId()
                    , room.getDateHotel()
                    , room.getCategoryHotel()
                    , room.getPriceHotel() + "vnđ");
        }
        ReadWriterFile.readFile();
    }

    public void deleteRoom(String id) {
        for (int i = 0; i < rooms.size(); i++) {
            if (id.equals(rooms.get(i).getId())) {
                rooms.remove(i);
                i--;
            }
        }
        System.out.println("Xóa khách trọ thành công");
        ReadWriterFile.writerFile(rooms);
    }

    public void searchRoom(String id) {
        for (Room room : rooms) {
            if (id.equals(room.getId())) {
                System.out.println("-----------Thông tin khách thuê-----------");
                System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s"
                        , "Tên khách thuê"
                        , "Ngày sinh"
                        , "Số chứng minh thư"
                        , "Ngày trọ"
                        , "Loại phòng"
                        , "Giá phòng");
                System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s"
                        , room.getName()
                        , room.getDate()
                        , room.getId()
                        , room.getDateHotel()
                        , room.getCategoryHotel()
                        , room.getPriceHotel() + "vnđ");
            }
        }
    }

    public void billRoom(String id) {
        for (Room room : rooms) {
            if (id.equals(room.getId())) {
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
                        , room.getName()
                        , room.getDate()
                        , room.getId()
                        , room.getDateHotel()
                        , room.getCategoryHotel()
                        , room.getPriceHotel() + "vnđ"
                        , room.getTotal() + "vnđ");
            }
        }
        ReadWriterFile.writerFile(rooms);
    }

    public void editRoom(int index, Room room) {
        rooms.set(index, room);
        ReadWriterFile.writerFile(rooms);
    }

    class SortRoom implements Comparator<Room>{
        @Override
        public int compare(Room room1, Room room2) {
            return  room1.getName().compareTo(room2.getName());
        }
    }
    public void sortRoom(){
        Collections.sort(rooms, new SortRoom());
        System.out.println("----Sắp xếp thành công----");
        ReadWriterFile.writerFile(rooms);

    }
}


