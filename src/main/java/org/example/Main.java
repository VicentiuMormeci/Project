package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        DataLoader dl = new DataLoader();
        DataSaver ds = new DataSaver();
        dl.loadData();
        Map<Produs, List<MetodaPlata>> data = dl.getDataMap();
        Metode metode = new Metode();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Alegeti o optiune: \n" +
                "0 - Iesire din program \n" +
                "1 - Cos cumparaturi initial \n" +
                "2 - Sectiunea imbracaminte \n" +
                "3 - CosCumparaturi \n" +
                "4 - Metode de plata \n" +
                "5 - Finalizare tranzactie \n");
        while (true) {
            System.out.println("Va rugam introduceti o optiune: ");
            int optiune = Integer.parseInt(scanner.nextLine());
            switch (optiune) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Afiseaza cos cumparaturi: ");
                     metode.afisareProdus(data);
                    break;
                case 2:
                    System.out.println("Imbracaminte ");
                    System.out.println("Introdu numele produsului:");
                    String nume = scanner.nextLine();
                    System.out.println("Introdu pretul produsului: ");
                    double pret = Double.parseDouble(scanner.nextLine());
                    System.out.println("introdu tipul produsului: ");
                    String tip = scanner.nextLine();
                    System.out.println("Introdu numarul de bucati: ");
                    int cantitate = Integer.parseInt(scanner.nextLine());
                    Produs produs = new Produs(nume,pret,cantitate);
                    if (tip.equals("bluza")) {
                        int discount = 30;
                        Clothes imbracaminte = new Clothes(nume, pret, tip, discount, cantitate);
                        imbracaminte.setDiscount(discount);
                        if (imbracaminte.getDiscount() > 0) {
                            imbracaminte.produs();
                        } else {
                            System.out.println("Pretul final nu se poate calcula deoarece discountul nu a fost valid");
                        }
                    }
                    if (tip.equals("pantaloni")) {
                        int discount = 20;
                        Clothes imbracaminte = new Clothes(nume, pret, tip,discount, cantitate);
                        imbracaminte.setDiscount(discount);
                        if (imbracaminte.getDiscount() > 0) {
                            imbracaminte.produs();
                        } else {
                            System.out.println("Pretul final nu se poate calcula deoarece discountul nu a fost valid");
                        }
                    }
                    if (tip.equals("accesoriu")) {
                        int discount = 35;
                        Clothes imbracaminte = new Clothes(nume, pret, tip, discount,cantitate);
                        imbracaminte.setDiscount(discount);
                        if (imbracaminte.getDiscount() > 0) {
                            imbracaminte.produs();
                        } else {
                            System.out.println("Pretul final nu se poate calcula deoarece discountul nu a fost valid");
                        }
                    }
                    metode.adaugaProdus(produs,data);
                    ds.saveData(data);
                    break;
                case 3:
                    System.out.println("CosCumparaturi: ");
                    for (Produs Produs : data.keySet()) {
                        System.out.println("In cos aveti urmatoarele produse: " + "Nume: " + Produs.getNume()+ " " +
                                "Pret: " + Produs.getPret() + " " + "Cantitate: " + Produs.getCantitate());
//                        for (MetodaPlata metodaPlata : data.get(Produs)) {
//                            System.out.println(metodaPlata.getCard());
//                            for (MetodaPlata metodaPlata1:data.get(Produs)) {
//                                System.out.println(metodaPlata1.getCash());
//                            }
//                        }
                        System.out.println("\n");
                    }
//                    metode.afisareProdus(data);
                    ds.saveData(data);
                    System.out.println("Pentru a finaliza cumparaturile apasati tasta 4:");
                    break;
                case 4:
                    while (true) {
                        System.out.println("Selectati una din metodele de plata: \n" +
                                "Tasta 6 pentru plata cu cardul! \n" +
                                "Tasta 7 pentru plata cash - ramburs!\n");
                        int optiuni = Integer.parseInt(scanner.nextLine());
                        switch (optiuni) {
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                            default:
                                System.out.println("plata invalida");
                                break;
                        }
                        if (optiuni == 6) {
                            System.out.println("A-ti ales plata cu cardul!");
                        } else if (optiuni == 7) {
                            System.out.println("A-ti ales plata cash");
                        }
                        ds.saveData(data);
                        break;
                    }
                case 5:
                    System.out.println("Multumim pentru cumparaturi");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiunea nu exista!!");
            }
        }
    }
}