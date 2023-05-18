package org.thesummoners.model.objeto;

import javafx.collections.ObservableList;

public class ObjetoInitializer {
    public ObjetoInitializer() {
    }

    /**
     * Según el nombre del objeto se crea un tipo de objeto u otro
     * @return
     */
    public static ObservableList<Objeto> objetoList() {
        Objeto.objetoList.clear();
        Objeto.objetoList.addAll(new Objeto[]{new Objeto("pesa"), new Objeto("pluma"), new Objeto("chaleco"), new Objeto("baston"), new Objeto("pilas")});
        return Objeto.objetoList;
    }
}
