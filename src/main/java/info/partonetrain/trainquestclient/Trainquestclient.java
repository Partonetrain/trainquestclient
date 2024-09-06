package info.partonetrain.trainquestclient;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Trainquestclient implements ModInitializer {
	public static final String MOD_ID = "trainquestclient";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static boolean attributesGuiOpen = false;

	@Override
	public void onInitialize() {
		if(FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER){
			LOGGER.info("trainquestclient loaded on server... will do nothing");
		}
	}
}