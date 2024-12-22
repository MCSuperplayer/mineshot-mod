package mcsuperplayer.mineshot.init;

import mcsuperplayer.mineshot.MineShot;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabInit {
	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,MineShot.MODID);

	public static final RegistryObject<CreativeModeTab> MINESHOT_TAB = TABS.register("mineshot_tab",
		() -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.mineshot_tab"))
			.icon(ItemInit.ITEM_LIGHTBULB.get()::getDefaultInstance)
			.displayItems((displayParams, output) -> {
						ItemInit.ITEMS.getEntries().forEach(item -> {
							output.accept(item.get().getDefaultInstance());
						});
			})
			.build()
		);

	public static final RegistryObject<CreativeModeTab> SOLSTICE_TAB = TABS.register("mineshot_tab_solstice", 
			() -> CreativeModeTab.builder()
				.title(Component.translatable("itemGroup.mineshot_solstice_tab"))
				.icon(ItemInit.ITEM_CLOVER.get()::getDefaultInstance)
				.displayItems((displayParams, output) -> {
						ItemInit.SOLSTICE_ITEMS.getEntries().forEach(item -> {
							output.accept(item.get().getDefaultInstance());
						});
				})
				.build()
		);
	
	public static final RegistryObject<CreativeModeTab> MINESHOT_BLOCKS = TABS.register("mineshot_tab_blocks", 
			() -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.mineshot_blocks_tab"))
					.icon(ItemInit.BLOCKITEM_BARRENS_SAND.get()::getDefaultInstance)
					.displayItems((displayParams, output) -> {
						ItemInit.BLOCK_ITEMS.getEntries().forEach(item -> {
							output.accept(item.get().getDefaultInstance());
						});
					})
					.build()
		);
}
