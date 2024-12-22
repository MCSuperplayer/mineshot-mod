package mcsuperplayer.mineshot;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = MineShot.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

//    private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
//            .comment("Whether to log the dirt block on common setup")
//            .define("logDirtBlock", true);
//
	private static final ForgeConfigSpec.IntValue TEXTENGINE_DELAY = BUILDER
			.comment("Delay in ticks between Letters written by the text engine.")
			.defineInRange("textengineDelay", 1, 0, 20);

//    public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
//            .comment("What you want the introduction message to be for the magic number")
//            .define("magicNumberIntroduction", "The magic number is... ");
//
//    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
//            .comment("A list of items to log on common setup.")
//            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);

	static final ForgeConfigSpec SPEC = BUILDER.build();

//    public static boolean logDirtBlock;
	public static int textengine_delay;
//    public static String magicNumberIntroduction;
//    public static Set<Item> items;


	@SubscribeEvent
	static void onLoad(final ModConfigEvent event) {
		textengine_delay = TEXTENGINE_DELAY.get();
	}
}