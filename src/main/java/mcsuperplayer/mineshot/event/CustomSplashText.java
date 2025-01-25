package mcsuperplayer.mineshot.event;

import java.lang.reflect.Field;

import mcsuperplayer.mineshot.MineShot;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

@Mod.EventBusSubscriber(modid = MineShot.MODID, value = Dist.CLIENT)
public class CustomSplashText {

	@SubscribeEvent
	public static void onMainMenuInit(ScreenEvent.Init.Post event) {
		
		if (event.getScreen() instanceof TitleScreen titleScreen) {
			Minecraft mc = Minecraft.getInstance();
			String playername = mc.getUser().getName();
			try {
			    Field splashField;

				splashField = ObfuscationReflectionHelper.findField(TitleScreen.class, "f_96721_");

			    splashField.setAccessible(true);
			    SplashRenderer splashRenderer = (SplashRenderer) splashField.get(titleScreen);

				MineShot.log("titleScreen.splash (splashRenderer) accessible!");

				Field splashTextField = ObfuscationReflectionHelper.findField(splashRenderer.getClass(), "f_279597_");
				splashTextField.setAccessible(true);
				splashTextField.set(splashRenderer, "You only have one shot, " + playername + ".");

				MineShot.log("Custom Splash Text confirmed!");
            } catch (Exception e) {
				MineShot.log(e.toString());
			}
		}
	}

}
