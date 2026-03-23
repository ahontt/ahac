package org.ahont.ahac.data;

import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementacion de la clase DataManager que gestiona los datos de los jugadores actualmente en el servidor
 */
public class DataManager {
    private Set<PlayerData> dataSet = new HashSet<>();

    public DataManager(){
        Bukkit.getOnlinePlayers().forEach(this::add);
    }

    public void add(Player p){
        dataSet.add(new PlayerData(p));
    }

    public PlayerData getPlayerData(Player p){
        return dataSet.stream()
                .filter(playerData -> playerData.player == p)
                .findFirst()
                .orElse(null);
    }

    public void remove(Player p){
        dataSet.removeIf(playerData -> playerData.player == p);
    }
}
