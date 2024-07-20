package com.cf6.comandof6.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDiscord implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',""));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"           &6✸&8&l『&7&lDISCORD &3&lLINK&8&l』&6✸"));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&8══════════════════════"));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"     &5&nhttps://discord.gg/djKyQWY5vN"));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&8══════════════════════"));
        return false;
    }
}
