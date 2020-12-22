package rpgplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import rpgplugin.stat.Stat;

public class Main extends JavaPlugin implements Listener {
	
	public Stat s = new Stat();
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "RPG플러그인 활성화");
		
	}
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "RPG플러그인 비활성화");
	}
	@EventHandler
	public void  PlayerJoin(PlayerJoinEvent event) {
		s.CreateNewStat(event.getPlayer().getUniqueId().toString());
		event.setJoinMessage(ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.WHITE + "님께서 입장하셨습니다!");
	}
	
	@EventHandler
	public void Chat(PlayerChatEvent event) {
		Player player = event.getPlayer();
		long[] stat = new long[12];
		stat = s.getStat(player.getUniqueId().toString());
		player.sendMessage("나의 레벨 : " + stat[0] + "  나의 힘 : " + stat[5]);
	}
}
