package com.cf6.comandof6;

import com.cf6.comandof6.commands.CommandChat;
import com.cf6.comandof6.commands.CommandChatall;
import com.cf6.comandof6.commands.CommandDiscord;
import com.cf6.comandof6.commands.Commands;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class ComandoF6 extends JavaPlugin {
    public String prefix = "&8&l【&5&lCF6&8&l】";
    private LuckPerms luckPerms;
    @Override
    public void onEnable() {
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            luckPerms = provider.getProvider();
        }
        onlineaddSbPrincipal();
        regisrterCommand();
        Bukkit.getPluginManager().registerEvents(new ListenersManager(this),this);
    }
    public void regisrterCommand(){
        getCommand("discord").setExecutor(new CommandDiscord());
        getCommand("comandoF6").setExecutor(new Commands(this));
        getCommand("chat").setExecutor(new CommandChat());
        getCommand("chatall").setExecutor(new CommandChatall());
    }

    @Override
    public void onDisable() {
    }
    public void onlineaddSbPrincipal() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            ScoreboardCF6.crearScoreBoardPrincipal(p,this);
        }
    }
    public LuckPerms getLuckPerms() {
        return luckPerms;
    }
}
