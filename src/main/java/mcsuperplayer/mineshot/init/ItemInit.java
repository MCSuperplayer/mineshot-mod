package mcsuperplayer.mineshot.init;

import mcsuperplayer.mineshot.MineShot;
import mcsuperplayer.mineshot.integration.curios.CuriosItems;
import mcsuperplayer.mineshot.item.LightbulbItem;
import mcsuperplayer.mineshot.item.MineShotItem;
import mcsuperplayer.mineshot.item.RemoteItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MineShot.MODID);
	public static final DeferredRegister<Item> SOLSTICE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MineShot.MODID);
	public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MineShot.MODID);

	// Items
	
	public static final RegistryObject<Item> ITEM_LIGHTBULB;

	static {
		Item.Properties lightbulbProperties = new Item.Properties().fireResistant().rarity(Rarity.EPIC);
		if (ModList.get().isLoaded("curios")) {
			MineShot.log("Curios Detected, Curio Items generating");
			ITEM_LIGHTBULB = CuriosItems.registerCuriosLightbulb(lightbulbProperties);
		} else {
			MineShot.log("Curios not detected, Normal Items generating");
			ITEM_LIGHTBULB = ITEMS.register("lightbulb", () -> new LightbulbItem(lightbulbProperties));
		}
	}

	public static final RegistryObject<Item> ITEM_REMOTE = ITEMS.register("remote",
			() -> new RemoteItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_ALCOHOL_BOTTLE = ITEMS.register("alcohol_bottle",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_BRANCH = ITEMS.register("branch",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_BRANCH_WET = ITEMS.register("wet_branch",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_TORCH = ITEMS.register("torch",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_KEY = ITEMS.register("key",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_CAMERA = ITEMS.register("camera",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_SCREWDRIVER = ITEMS.register("screwdriver",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_LENS = ITEMS.register("lens",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_BOTTLE = ITEMS.register("bottle",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_BATTERY_BROKEN = ITEMS.register("broken_battery",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_BATTERY_EMPTY = ITEMS.register("empty_battery",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_BAATTERY_CHARGED = ITEMS.register("charged_battery",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_SMOKE_BOTTLE = ITEMS.register("smoke_bottle",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_ACID_BOTTLE = ITEMS.register("acid_bottle",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_SPONGE = ITEMS.register("sponge",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_WET_SPONGE = ITEMS.register("wet_sponge",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_METAL_ROD = ITEMS.register("metal_rod",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_CROWBAR = ITEMS.register("crowbar",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_EMPTY_SYRINGE = ITEMS.register("empty_syringe",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_FILLED_SYRINGE = ITEMS.register("filled_syringe",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_AMBER = ITEMS.register("amber",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_JOURNAL = ITEMS.register("journal",
			() -> new MineShotItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

	public static final RegistryObject<Item> ITEM_FEATHER = ITEMS.register("feather",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_DYE_BOTTLE = ITEMS.register("dye_bottle",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_WATER_TUBE = ITEMS.register("water_tube",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_MAIZE_SEED = ITEMS.register("maize_seed",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_WOOL = ITEMS.register("wool",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_FEATHER_PEN = ITEMS.register("feather_pen",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_DIE = ITEMS.register("die",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_BUTTON = ITEMS.register("button",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_MAGNETIZED_BUTTON = ITEMS.register("magnetized_button",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_TAPED_BUTTON = ITEMS.register("taped_button",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_YOU_TRIED = ITEMS.register("you_tried",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_MAGNETS = ITEMS.register("magnets",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_METAL_CAN = ITEMS.register("metal_can",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_SCISSORS = ITEMS.register("scissors",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_WEIRD_FILM = ITEMS.register("weird_film",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_LENS_CONCAVE = ITEMS.register("concave_lens",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_LENS_CONVEX = ITEMS.register("convex_lens",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_LENS_THIN = ITEMS.register("thin_lens",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_LENS_THICK = ITEMS.register("thick_lens",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_GLITTER_GLUE = ITEMS.register("glitter_glue",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_PHOTO1 = ITEMS.register("photo1",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_PHOTO2 = ITEMS.register("photo2",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_PHOTO3 = ITEMS.register("photo3",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_PHOTO4 = ITEMS.register("photo4",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_PHOTO5 = ITEMS.register("photo5",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_PHOTO_FAIL = ITEMS.register("photo_failed",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_PHOTO7 = ITEMS.register("photo7",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_PHOTO8 = ITEMS.register("photo8",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_PHOTO9 = ITEMS.register("photo9",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_PHOTO10 = ITEMS.register("photo10",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_LIBRARY_CARD = ITEMS.register("library_card",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_GAS_MASK = ITEMS.register("gas_mask",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_GLOVES = ITEMS.register("rubber_gloves",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_RAM_SHIRT = ITEMS.register("novelty_tshirt",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_LIBRARY_CARD_NIKO = ITEMS.register("library_card_picture",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_LIBRARY_CARD_GLUE = ITEMS.register("library_card_sticky",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_PHOTO_GLUE = ITEMS.register("photo_sticky",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_DIRT = ITEMS.register("dirt",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_WATER_PILL = ITEMS.register("water_pill",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_MEDICATED_WATER = ITEMS.register("medicated_water",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_CLOVER = ITEMS.register("clover",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_EMPTY_TUBE = ITEMS.register("empty_tube",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_POND_WATER_BOTTLE = ITEMS.register("pond_water_bottle",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	// Solstice Items

	public static final RegistryObject<Item> ITEM_GLOWING_JOURNAL = SOLSTICE_ITEMS.register("glowing_journal",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_MEMORY_DISK = SOLSTICE_ITEMS.register("memory_disk",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_BACKUP_DISK = SOLSTICE_ITEMS.register("memory_disk_backup",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_BATTERY_GLEN = SOLSTICE_ITEMS.register("battery_glen",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> ITEM_MUSIC_BOX = SOLSTICE_ITEMS.register("music_box",
			() -> new MineShotItem(new Item.Properties().fireResistant()));

	// Block Items

	public static final RegistryObject<BlockItem> BLOCKITEM_BARRENS_SAND = BLOCK_ITEMS.register("barrens_sand",
			() -> new BlockItem(BlockInit.BARRENS_SAND.get(), new Item.Properties()
			));

	public static final RegistryObject<BlockItem> BLOCKITEM_COMPUTER = BLOCK_ITEMS.register("computer",
			() -> new BlockItem(BlockInit.COMPUTER.get(), new Item.Properties()
					.rarity(Rarity.EPIC)
					.stacksTo(1)
			));
}
