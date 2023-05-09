package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DataLoader {
    private Map<Produs, List<MetodaPlata>> dataMap;
    private List<MetodaPlata> listaMetode;
    public DataLoader(){
        dataMap = new HashMap<>();
        listaMetode = new ArrayList<>();
    }
    public void loadData() throws IOException {
        loadProdus();
        loadMetodaPlata();
    }
    private void loadProdus() throws IOException {
        List<String> produsInputData = IncarcareDate.readFile(IncarcareDate.CosCumparaturi_FILE_PATH);
        for (String produsInputDatum : produsInputData) {
            String[] data = produsInputDatum.split(",");
            Produs produs = createProdus(data);
            dataMap.put(produs, new ArrayList<>());
        }
    }
    private Produs createProdus(String[] data) {
        String nume = data[0];
        double pret = Double.parseDouble(data[1]);
        int discount = Integer.parseInt(data[2]);
        int cantitate = Integer.parseInt(data[3]);
        Produs produsNou = new Produs(nume,pret, discount,cantitate);
        return produsNou;
    }
    private void loadMetodaPlata() throws IOException {
        List<String> plati = IncarcareDate.readFile(IncarcareDate.metodaPlata_FILE_PATH);

        for (String line : plati) {
            String[] datePlati = line.split(",");
            MetodaPlata metodaPlata = createMetodaPlata(datePlati);
            listaMetode.add(metodaPlata);
        }
    }
    private MetodaPlata createMetodaPlata(String[] datePlati){
        String card = datePlati[0];
        String cash = datePlati[1];
        MetodaPlata plata = new MetodaPlata(card, cash);
        return plata;
    }
        public Map<Produs, List<MetodaPlata>> getDataMap() {
        return dataMap;
    }
}
