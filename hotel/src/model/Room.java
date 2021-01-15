package model;

import java.io.Serializable;

public class Room extends Person implements Serializable {
    private int dateOfStay;
    private String categoryRoom;
    private double priceRoom;

    public Room(String name, String date, String id, int dateOfStay, String categoryRoom, double priceRoom) {
        super(name, date, id);
        this.dateOfStay = dateOfStay;
        this.categoryRoom = categoryRoom;
        this.priceRoom = priceRoom;
    }

    public Room() {
    }

    public int getDateOfStay() {
        return dateOfStay;
    }

    public void setDateOfStay(int dateOfStay) {
        this.dateOfStay = dateOfStay;
    }

    public String getCategoryRoom() {
        return categoryRoom;
    }

    public void setCategoryRoom(String categoryRoom) {
        this.categoryRoom = categoryRoom;
    }

    public double getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(double priceRoom) {
        this.priceRoom = priceRoom;
    }

    public double getTotal() {
        return (getDateOfStay() * getPriceRoom());
    }

    @Override
    public String toString() {
        return "--------Thông tin khách thuê--------" + "\n" +
                super.toString() +
                "Số ngày thuê: " + dateOfStay + "\n" +
                "Loại phòng: " + categoryRoom + "\n" +
                "Giá phòng: " + priceRoom
                ;
    }
}
