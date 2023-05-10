package org.thesummoners.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static BufferedWriter bufferedWriter;
    private static String logPath = "src/main/java/org.thesummoners";

    public static BufferedWriter getOrCreateFileWriter() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String fechaFormateada = simpleDateFormat.format(new Date());
        logPath += fechaFormateada + ".log";

        if (bufferedWriter != null)
            return bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(logPath, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bufferedWriter;
    }

    public static void write(String line) {
        try {
            getOrCreateFileWriter().write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(){
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}