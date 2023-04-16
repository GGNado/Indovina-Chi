package com.gigi;

import com.gigi.managers.FileManager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String destPath = System.getProperty("user.dir") + File.separator + "resources";
        for (int i = 1; i < 24; i++){
            InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream("img/" + i + ".jpg");
            if (resourceAsStream != null) {
                File destDir = new File(destPath);
                FileUtils.forceMkdir(destDir);
                File destFile = new File(destDir, "img/" + i + ".jpg");
                if (!destFile.exists())
                    FileUtils.copyInputStreamToFile(resourceAsStream, destFile);
            }
        }

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("files/config.yml");
        if (inputStream != null){
            File destDir = new File(destPath);
            FileUtils.forceMkdir(destDir);
            File destFile = new File(destDir, "files/config.yml");
            if (!destFile.exists())
                FileUtils.copyInputStreamToFile(inputStream, destFile);
        }

        FileManager fileManager = new FileManager(new File("resources/files/config.yml"));
        ArrayList<Persona> persone = new ArrayList<>();
        for (int i = 1; i <= 21; i++) {
            persone.add(fileManager.getPersona(i));
        }

        new FrameStart(persone);
    }
}
