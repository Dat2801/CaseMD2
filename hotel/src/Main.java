import model.Person;
import model.Room;
import service.ProgramManager;
import storage.ReadWriterFile;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Room> roomList = ReadWriterFile.readFile();
    static ProgramManager programManager = new ProgramManager(roomList);
    static final String REGEX_MENU = "^[0-8]$";
    static final String REGEX_DATE = "^[0-9]{2}$";
    static final String REGEX_PRICE = "^[0-9]{6}$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        String checkMenu;
        do {
            System.out.println("\n" + "----- Chức năng -----");
            System.out.println("1. Thêm khách thuê");
            System.out.println("2. Hiển thị khách thuê");
            System.out.println("3. Tìm kiếm khách thuê");
            System.out.println("4. Xóa khách thuê");
            System.out.println("5. Sửa thông tin khách thuê");
            System.out.println("6. Sắp xếp theo tên người thuê");
            System.out.println("7. Thanh toán phòng");
            System.out.println("8. Thoát");

            do {
                System.out.println("----- Mời bạn chọn chức năng -----");
                checkMenu = scanner.nextLine();

            } while (!checkMenu.matches(REGEX_MENU));
            choice = Integer.parseInt(checkMenu);
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
                default:
                    System.out.println("Nhập sai!! Nhập lại đi");
                    break;
            }
        } while (choice != 0);
    }

    public static void add() {
        Scanner scanner = new Scanner(System.in);
        String str1;
        int dateRoom;
        double priceRoom;

        System.out.println("Nhập tên người thuê");
        String name = scanner.nextLine();

        System.out.println("Nhập ngày sinh người thuê");
        String date = scanner.nextLine();

        System.out.println("Nhập chứng minh thư");
        String id = scanner.nextLine();

        do {
            System.out.println("Nhập ngày trọ");
            str1 = scanner.nextLine();
            dateRoom = Integer.parseInt(str1);
            if (!str1.matches(REGEX_DATE)) {
                System.out.println("Nhập sai mời nhập lại");
            }
        } while (!str1.matches(REGEX_DATE));

        System.out.println("Nhập loại phòng");
        String categoryRoom = scanner.nextLine();

        do {
            System.out.println("Nhập giá phòng");
            str1 = scanner.nextLine();
            priceRoom = Double.parseDouble(str1);
            if (!str1.matches(REGEX_PRICE)) {
                System.out.println("Nhập sai mời nhập lại");
            }
        } while (!str1.matches(REGEX_PRICE));

        Person person = new Person(name, date, id);

        Room room = new Room(person, dateRoom, categoryRoom, priceRoom);
        programManager.addRoom(room);
        System.out.println("------->Thêm mới thành công<-------");
    }

    public static void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số chứng minh thư");
        String id = scanner.nextLine();
        programManager.deleteRoom(id);
    }

    public static void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chứng minh thư");
        String id = scanner.nextLine();
        programManager.searchRoom(id);
    }

    public static void bill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số chứng minh thư");
        String id = scanner.nextLine();
        programManager.billRoom(id);
    }

    public static void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số chứng minh thư");
        String index = scanner.nextLine();
        for (int i = 0; i < programManager.getRooms().size(); i++) {
            if (index.equals(programManager.getRooms().get(i).getPerson().getId())) {
                System.out.println(programManager.getRooms().get(i));

                System.out.println("--------Nhập vào để sửa-------");

                System.out.println("Nhập tên người thuê");
                String name = scanner.nextLine();

                System.out.println("Nhập ngày sinh người thuê");
                String date = scanner.nextLine();

                System.out.println("Nhập chứng minh thư");
                String id = scanner.nextLine();
                try {
                    System.out.println("Nhập ngày trọ");
                    int dateHotel = Integer.parseInt(scanner.nextLine());

                    System.out.println("Nhập loại phòng");
                    String categoryHotel = scanner.nextLine();

                    System.out.println("Nhập giá phòng");
                    double priceHotel = Double.parseDouble(scanner.nextLine());
                    Person person = new Person(name, id, date);

                    Room room = new Room(person, dateHotel, categoryHotel, priceHotel);
                    programManager.editRoom(i, room);
                    System.out.println("-------->Sửa thành công<--------");
                } catch (Exception e) {
                    System.out.println("Nhập sai mời nhập lại");
                }
            }
        }
    }
}
