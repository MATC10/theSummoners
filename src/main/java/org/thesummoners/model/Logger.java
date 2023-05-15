package org.thesummoners.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger implements AutoCloseable{

    private BufferedWriter writer;

    public Logger(){

        try {
            String filePath = "";
            writer = new BufferedWriter(new FileWriter(filePath,true));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
