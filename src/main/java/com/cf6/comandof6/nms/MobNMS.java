package com.cf6.comandof6.nms;

import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class MobNMS {
    public static EntityLiving golem;
    public static void spawnGolem () {

        Entity entity = Bukkit.getWorld("lobby").spawnEntity(new Location(Bukkit.getWorld("lobby"),6.5,110,1.5), EntityType.IRON_GOLEM);

        spawnArmorStand(entity);

        entity.setCustomName(ChatColor.translateAlternateColorCodes('&',"&8[&e&lClick Derecho&8]"));
        entity.setCustomNameVisible(true);
        net.minecraft.server.v1_8_R3.Entity nmsgolem =  ((CraftEntity)entity ).getHandle();


        NBTTagCompound ntb = new NBTTagCompound();
        nmsgolem.c(ntb);
        ntb.setBoolean("NoAI",true);

        golem = (EntityLiving) nmsgolem;
        golem.a(ntb);
        golem.f(180);
    }
    public static void spawnArmorStand(Entity entity) {
        Entity[] entities = entity.getLocation().getChunk().getEntities();
        for (Entity e : entities) {
            if (e.getType().equals(EntityType.ARMOR_STAND)) {
                e.remove();
            }
        }
        Entity armord = entity.getWorld().spawnEntity(new Location(entity.getWorld(),entity.getLocation().getX(),entity.getLocation().getY()+1.3,entity.getLocation().getZ()),EntityType.ARMOR_STAND);
        ArmorStand armorStand = (ArmorStand) armord;
        armorStand.setGravity(false);
        armorStand.setVisible(false);
        armorStand.setCustomName(ChatColor.translateAlternateColorCodes('&',"&6Teletransportar Al Spawn"));
        armorStand.setCustomNameVisible(true);

        armord = armorStand.getWorld().spawnEntity(new Location(armorStand.getWorld(),armorStand.getLocation().getX(),armorStand.getLocation().getY()+0.3,armorStand.getLocation().getZ()),EntityType.ARMOR_STAND);
        armorStand = (ArmorStand) armord;
        armorStand.setGravity(false);
        armorStand.setVisible(false);
        armorStand.setCustomName(ChatColor.translateAlternateColorCodes('&',"&8&l[&5&lUn&6&lServer&5&lRandom&8&l]"));
        armorStand.setCustomNameVisible(true);

    }
}
