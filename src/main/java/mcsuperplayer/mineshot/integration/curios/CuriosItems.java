package mcsuperplayer.mineshot.integration.curios;

import mcsuperplayer.mineshot.init.ItemInit;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.RegistryObject;

public class CuriosItems {

	public static RegistryObject<Item> registerCuriosLightbulb(Properties lightbulbProperties) {
		return ItemInit.ITEMS.register("lightbulb",
				() -> new LightbulbCurioItem(lightbulbProperties));
	}

}
