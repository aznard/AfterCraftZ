package net.aznard.aftercraftz;

import net.aznard.aftercraftz.register.BlocksRegister;
import net.aznard.aftercraftz.register.GunRegister;
import net.aznard.aftercraftz.register.ItemsRegister;
import net.aznard.aftercraftz.register.ItemsGroupsRegister;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AfterCraftZ implements ModInitializer {
	public static final String MOD_ID = "aftercraftz";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ItemsGroupsRegister.registerItemGroups();
		GunRegister.registerGuns();

		ItemsRegister.registerModItems();
		BlocksRegister.registerBlocks();
	}
}