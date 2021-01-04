package org.ik26w30.blockcmd.github.file;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.ik26w30.blockcmd.github.GitHub;

import java.io.File;
import java.io.IOException;

public class FileManager {
    public FileManager instanceconfig;

    private static File file = new File(GitHub.getInstance().getDataFolder(), "messages.yml");
    public static FileConfiguration customFile = (FileConfiguration) YamlConfiguration.loadConfiguration(file);

    public static void setupConfig(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                //
            }
        }
    }

    public static FileConfiguration getYaml(){
        return customFile;
    }

    public static void saveFile(){
        try {
            customFile.save(file);
        } catch (IOException e) {
            //
        }
    }

    public static void reloadFile(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
