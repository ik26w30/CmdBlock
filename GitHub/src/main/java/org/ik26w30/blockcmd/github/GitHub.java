package org.ik26w30.blockcmd.github;

import org.bukkit.plugin.java.JavaPlugin;
import org.ik26w30.blockcmd.github.block.CmdTabBlock;
import org.ik26w30.blockcmd.github.cmd.MainCommand;
import org.ik26w30.blockcmd.github.file.FileManager;

public final class GitHub extends JavaPlugin {
    private static GitHub instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        registerEvents();
        registerConfig();
        registerCommands();
    }

    private void registerCommands() {
        this.getCommand("github").setExecutor(new MainCommand());
    }

    private void registerConfig() {
        FileManager.setupConfig();
        FileManager.customFile.addDefault("Messages", "");
        FileManager.customFile.options().copyDefaults(true);
        FileManager.saveFile();
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new CmdTabBlock(), this);
    }

    public static GitHub getInstance(){
        if(instance == null){
            instance = new GitHub();
        }
        return instance;
    }

}
