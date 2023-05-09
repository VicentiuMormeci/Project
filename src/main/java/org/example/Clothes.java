package org.example;

public class Clothes extends Produs{
    private String tip;


    public Clothes(String nume, double pret, String tip, int discount, int cantitate) {
        super(nume, pret, discount, cantitate);
        this.getDiscount();
        this.tip = tip;
    }

//    public int getDiscount() {
//        return 0;
//    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
