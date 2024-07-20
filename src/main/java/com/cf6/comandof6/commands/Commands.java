package com.cf6.comandof6.commands;

import com.cf6.comandof6.ComandoF6;
import com.cf6.comandof6.prueba.Scoreboard;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Commands implements CommandExecutor {
    private ComandoF6 plugin;
    private EntityPlayer npc;
    private PlayerConnection connection;
    public Commands (ComandoF6 plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (args.length >= 1) {
            if (player.isOp()) {
                if (args[0].equalsIgnoreCase("sb")) {
                    Scoreboard.crearScoreBoardMGIniciar(player);
                    player.sendMessage(plugin.prefix + "Create SB");
                } else if (args[0].equalsIgnoreCase("entity")) {

                    Location location = player.getLocation();

                    MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
                    WorldServer nmsWorld = ((CraftWorld) Bukkit.getWorld("lobby")).getHandle();

                    GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "SPAWN");
                    npc = new EntityPlayer(nmsServer, nmsWorld, gameProfile, new PlayerInteractManager(nmsWorld));
                    npc.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());

                    connection = ((CraftPlayer)player).getHandle().playerConnection;
                    connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
                    connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
                    player.sendMessage("NPC CREADO");

                } else if (args[0].equalsIgnoreCase("prueba")) {
                    connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));
                    player.sendMessage("Bye");


                } else if (args[0].equalsIgnoreCase("prueba2")) {
                    connection.sendPacket(new PacketPlayOutKickDisconnect(IChatBaseComponent.ChatSerializer.a("bye")));
                    player.sendMessage("kick");


                }
                else if (args[0].equalsIgnoreCase("prueba3")) {
                    connection.sendPacket(new PacketPlayOutCamera());
                    player.sendMessage("camara");

                }
                else if (args[0].equalsIgnoreCase("prueba4")) {
                    if (connection.player == null) {
                        player.sendMessage("null");
                    }else {
                        player.sendMessage("NO null");

                    }
                }
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.prefix+"&cNo tienes permisos para usar ese comando."));
            }
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.prefix+"&cComando desconocico"));
        }
        return false;
    }
}
