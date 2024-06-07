package internal_data;

public class Beverage{
    public String name;
    public int price;
    public int stock;
    public int SlotId;
    public int salesCount;

    //음료 객체 생성
    public Beverage(String name, int price, int stock, int SlotId)
    {
        super();
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.SlotId = SlotId;
        this.salesCount=0;
    }


}
