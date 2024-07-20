package com.cf6.comandof6.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandChatall implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        String sPrefix = "&8&l【&5&lCF6&8&l】";
        if(player.isOp() || player.hasPermission("cf6.chatall")){
            if(args.length >= 1){
                StringBuilder builder = new StringBuilder();
                for (String arg : args) {
                    builder.append(arg);
                    builder.append(" ");
                }
                String finalMessage = builder.toString();
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&5" + finalMessage), null);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 10.0F, 1.0F);
                }
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', sPrefix + "&aMensaje Enviado a todos los jugadores."));
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',sPrefix+"&8Debes usar el comando &7/chatall <text>."));
            }
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',sPrefix+"&cNo tienes permisos para usar ese comando."));
        }

        return false;
    }
}
