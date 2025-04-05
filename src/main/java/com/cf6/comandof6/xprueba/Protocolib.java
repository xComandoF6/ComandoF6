package com.cf6.comandof6.xprueba;

public class Protocolib {
    public void packet () {
        /*
        ProtocolManager manager = ProtocolLibrary.getProtocolManager();

        manager.addPacketListener(new PacketAdapter(this, ListenerPriority.NORMAL, PacketType.Play.Client.POSITION) {

            @Override
            public void onPacketReceiving(PacketEvent event) {
                PacketContainer packet = event.getPacket();
                Player p = event.getPlayer();

                double x = packet.getDoubles().read(0);
                double y = packet.getDoubles().read(1);
                double z = packet.getDoubles().read(2);
                boolean isOnGround = packet.getBooleans().read(0);

                p.sendMessage("LEYENDO PACKET X: "+x+" Y :"+y+" Z: "+z);
                p.sendMessage("OnGround: "+isOnGround);
            }
        });


        manager.addPacketListener(new PacketAdapter(this, PacketType.Play.Server.REL_ENTITY_MOVE) {
            @Override
            public void onPacketSending(PacketEvent event) {
                PacketContainer packet = event.getPacket();

                Player p = event.getPlayer();
                int entidadID = packet.getIntegers().read(0);
                Entity entity = manager.getEntityFromID(p.getWorld(),entidadID);
                double x = entity.getLocation().getX();
                double y = entity.getLocation().getY();
                double z = entity.getLocation().getZ();

                p.sendMessage("Recibiendo Entidad:"+entity.getType()+" X: "+x+" Y :"+y+" Z: "+z);
            }
        });



                    manager.addPacketListener(new PacketAdapter(this, PacketType.Play.Client.ENTITY_ACTION) {
                        @Override
                        public void onPacketSending(PacketEvent event) {
                            PacketContainer packet = event.getPacket();

                            int id = packet.getIntegers().read(0);
                            EnumWrappers.PlayerAction action = packet.getPlayerActions().read(0);
                            int nose = packet.getIntegers().read(1);
                            if (id == 0 && !action.equals(EnumWrappers.PlayerAction.STOP_SNEAKING) && nose == 100) {
                                Bukkit.getPlayer("iComandoF6").sendMessage("A");
                            } else {
                                Bukkit.getPlayer("iComandoF6").sendMessage("B");

                            }

                        }
                    });

         */

    }
}
