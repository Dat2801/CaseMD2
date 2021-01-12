import java.io.Serializable;

public class Room extends Person implements Serializable {
    private int dateHotel;
    private String categoryHotel;
    private double priceHotel;

    public Room(String name, String date, String id, int dateHotel, String categoryHotel, double priceHotel) {
        super(name, date, id);
        this.dateHotel = dateHotel;
        this.categoryHotel = categoryHotel;
        this.priceHotel = priceHotel;
    }

    public Room(){}

    public int getDateHotel() {
        return dateHotel;
    }

    public void setDateHotel(int dateHotel) {
        this.dateHotel = dateHotel;
    }

    public String getCategoryHotel() {
        return categoryHotel;
    }

    public void setCategoryHotel(String categoryHotel) {
        this.categoryHotel = categoryHotel;
    }

    public double getPriceHotel() {
        return priceHotel;
    }

    public void setPriceHotel(double priceHotel) {
        this.priceHotel = priceHotel;
    }


    public double getTotal(){
        return (getDateHotel() * getPriceHotel());
    }

    @Override
    public String  toString() {
        return "--------Thông tin khách thuê--------"+ "\n" +
                 super.toString() +
                "Số ngày thuê: " + dateHotel + "\n"+
                "Loại phòng: " + categoryHotel + "\n" +
                "Giá phòng: " + priceHotel
                ;

    }
}
