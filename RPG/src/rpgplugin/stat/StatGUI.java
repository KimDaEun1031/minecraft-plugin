package rpgplugin.stat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class StatGUI {
	public Stat s = new Stat();
	
	public void StatusGUI(Player player) {
		long [] i = new long[12];
		i = s.getStat(player.getUniqueId().toString());
		
		Inventory inv = Bukkit.createInventory(null, 45, "����");
		//3�� ������
	}
}
