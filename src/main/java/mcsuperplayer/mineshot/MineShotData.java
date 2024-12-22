package mcsuperplayer.mineshot;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;

public class MineShotData extends SavedData {
	public static final String DATA_NAME = "mineshot_vars";
	public String textengine_fulltext = "";
	public String textengine_writetext = "";
	public String textengine_type = "";
	public String textengine_char = "silent";
	public int textengine_timer = 0;
	public String remoteCode = "-";

	public static MineShotData load(CompoundTag tag) {
		MineShotData data = new MineShotData();
		data.read(tag);
		return data;
	}

	public void read(CompoundTag nbt) {
		textengine_fulltext = nbt.getString("textengine_fulltext");
		textengine_writetext = nbt.getString("textengine_writetext");
		textengine_type = nbt.getString("textengine_type");
		textengine_char = nbt.getString("textengine_char");
		remoteCode = nbt.getString("remoteCode");
	}

	public void syncData() {
		this.setDirty();
	}

	static MineShotData ClientSide = new MineShotData();

	public static MineShotData get(LevelAccessor world) {
		if (world instanceof ServerLevelAccessor serverLevelAcc) {
			return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage()
					.computeIfAbsent(e -> MineShotData.load(e), MineShotData::new, DATA_NAME);
		} else {
			return ClientSide;
		}
	}

	@Override
	public CompoundTag save(CompoundTag tag) {
		// TODO Auto-generated method stub
		tag.putString("remoteCode", remoteCode);
		return tag;
	}
}
