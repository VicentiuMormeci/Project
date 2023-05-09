package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class Metode {

    public void afisareProdus(Map<Produs, List<MetodaPlata>> dataMap){
        System.out.println(dataMap.keySet());
    }

    public void adaugaProdus(Produs produs, Map<Produs, List<MetodaPlata>> dataMap){
        dataMap.put(produs, new ArrayList<>());
    }
}

