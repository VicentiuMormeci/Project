package org.example;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class DataSaver {
    public void saveData(Map<Produs, List<MetodaPlata>> data) throws IOException {
        saveProdus(data);
        saveMetodaPlata(data);
    }

    private void saveProdus(Map<Produs, List<MetodaPlata>> data) throws IOException {
        Set<Produs> setProdus = data.keySet();
        String continut = "";
        for (Produs produs:setProdus){
            continut = continut.concat(produs.toString().concat("\n"));
        }
        IncarcareDate.writeFile(IncarcareDate.CosCumparaturi_FILE_PATH, continut);
    }
    private void saveMetodaPlata(Map<Produs, List<MetodaPlata>> data) throws IOException {
        String continut = "";
        for (List<MetodaPlata> valoriDinMap : data.values()) {
            for (MetodaPlata metodaPlata : valoriDinMap) {
                continut = continut.concat(metodaPlata.toString().concat("\n"));
            }
        }
        IncarcareDate.writeFile(IncarcareDate.metodaPlata_FILE_PATH, continut);
    }

}
