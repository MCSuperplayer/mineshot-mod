package mcsuperplayer.mineshot.init;

import mcsuperplayer.mineshot.MineShot;
import mcsuperplayer.mineshot.blockentity.ComputerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MineShot.MODID);
	public static final RegistryObject<BlockEntityType<ComputerBlockEntity>> COMPUTER_BLOCK_ENTITY = BLOCK_ENTITIES.register("computer_block_entity", 
			() -> BlockEntityType.Builder.of(ComputerBlockEntity::new, BlockInit.COMPUTER.get()).build(null));
}
