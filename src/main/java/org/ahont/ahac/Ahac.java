package org.ahont.ahac;


import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import org.ahont.ahac.checks.combat.KillAuraA;
import org.ahont.ahac.data.DataManager;
import org.ahont.ahac.listeners.JoinLeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Clase principal de nuestro sistema anti-trampas
 * Contiene los inicializadores y destructores del sistema.
 */
public final class Ahac extends JavaPlugin {

    public static Ahac instance;
    public DataManager dataManager;

    @Override
    public void onLoad(){
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().load();
        Bukkit.getLogger().info("[AHAC] Loading");
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        PacketEvents.getAPI().init();
        dataManager = new DataManager();
        Bukkit.getPluginManager().registerEvents(new JoinLeaveListener(), this);
        PacketEvents.getAPI().getEventManager().registerListener(new KillAuraA("Kill Aura (A)"), PacketListenerPriority.NORMAL);
        Bukkit.getLogger().info("[AHAC] Has started");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        PacketEvents.getAPI().terminate();
    }
}
