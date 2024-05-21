package in;

import javax.swing.*;

public class Beverage{
    public String name;
    public int price;
    public int stock;
    public int SlotId;



    public Beverage(String name, int price, int stock, int SlotId)
    {
        super();
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.SlotId = SlotId;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

}
