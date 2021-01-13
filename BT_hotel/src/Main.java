import model.Room;
import service.ProgramManager;
import storage.ReadWriterFile;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Room> r = ReadWriterFile.readFile();
    static ProgramManager programManager = new ProgramManager(r);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n" + "-----Chức năng-----");
            System.out.println("1. Thêm khách thuê");
            System.out.println("2. Hiển thị khách thuê");
            System.out.println("3. Tìm kiếm khách thuê");
            System.out.println("4. Xóa khách thuê");
            System.out.println("5. Sửa thông tin khách thuê");
            System.out.println("6. Sắp xếp theo tên người thuê");
            System.out.println("7. Thanh toán phòng");
            System.out.println("8. Thoát");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    programManager.showRoom();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    edit();
                    break;
                case 6:
                    programManager.sortRoom();
                    break;
                case 7:
                    bill();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    public static void add() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập tên người thuê");
        String name = scanner.nextLine();

        System.out.println("Nhập ngày sinh người thuê");
        String date = scanner.nextLine();

        System.out.println("Nhập chứng minh thư");
        String id = scanner.nextLine();

        System.out.println("Nhập ngày trọ");
        int dateHotel = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập loại phòng");
        String categoryHotel = scanner.nextLine();

        System.out.println("Nhập giá phòng");
        double priceHotel = Double.parseDouble(scanner.nextLine());

        Room room = new Room(name, date, id, dateHotel, categoryHotel, priceHotel);
        programManager.addHotel(room);
        System.out.println("------->Thêm mới thành công<-------");
    }

    public static void delete() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập vào số chứng minh thư");
            String id = scanner.nextLine();
            programManager.deleteRoom(id);

        } catch (Exception e) {
            System.out.println("Nhập sai mời nhập lại");
        }
    }

    public static void search() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập vào số chứng minh thư");
            String id = scanner.nextLine();
            programManager.searchRoom(id);
        } catch (Exception e) {

            System.out.println("Nhập sai mời nhập lại");
        }
    }

    public static void bill() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập vào số chứng minh thư");
            String id = scanner.nextLine();
            programManager.billRoom(id);
        } catch (Exception e) {
            System.out.println("Nhập sai mời nhập lại");
        }
    }

    public static void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số chứng minh thư");
        String index = scanner.nextLine();
        for (int i = 0; i < programManager.getRooms().size(); i++) {
            if (index.equals(programManager.getRooms().get(i).getId())) {
                System.out.println(programManager.getRooms().get(i));

                System.out.println("--------Nhập vào để sửa-------");

                System.out.println("Nhập tên người thuê");
                String name = scanner.nextLine();

                System.out.println("Nhập ngày sinh người thuê");
                String date = scanner.nextLine();

                System.out.println("Nhập chứng minh thư");
                String id = scanner.nextLine();

                System.out.println("Nhập ngày trọ");
                int dateHotel = Integer.parseInt(scanner.nextLine());

                System.out.println("Nhập loại phòng");
                String categoryHotel = scanner.nextLine();

                System.out.println("Nhập giá phòng");
                double priceHotel = Double.parseDouble(scanner.nextLine());

                Room room = new Room(name, date, id, dateHotel, categoryHotel, priceHotel);
                programManager.editRoom(i, room);
                System.out.println("-------->Sửa thành công<--------");
            }
        }
    }
}
