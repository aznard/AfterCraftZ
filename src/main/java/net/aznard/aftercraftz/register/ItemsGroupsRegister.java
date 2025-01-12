package net.aznard.aftercraftz.register;

import net.aznard.aftercraftz.AfterCraftZ;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemsGroupsRegister {

    public static final ItemGroup AFTERCRAFTZ_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AfterCraftZ.MOD_ID, "aftercraftz_items_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ItemsRegister.INGOT_COPPER))
                    .displayName(Text.translatable("itemgroup.aftercraftz.items_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ItemsRegister.INGOT_COPPER);
                        entries.add(ItemsRegister.THOMPSON);
                    }).build());

    public static final ItemGroup AFTERCRAFTZ_FOODS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AfterCraftZ.MOD_ID, "aftercraftz_foods_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ItemsRegister.CAN_OF_BEANS))
                    .displayName(Text.translatable("itemgroup.aftercraftz.foods_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ItemsRegister.CAN_OF_BEANS);
                        entries.add(ItemsRegister.CAN_OF_CARROTS);
                        entries.add(ItemsRegister.CAN_OF_PEACHES);
                    }).build());

    public static final ItemGroup AFTERCRAFTZ_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AfterCraftZ.MOD_ID, "aftercraftz_blocks_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(BlocksRegister.BLACK_BRICK))
                    .displayName(Text.translatable("itemgroup.aftercraftz.blocks_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(BlocksRegister.BLACK_BRICK);
                        entries.add(BlocksRegister.BROWN_BRICK);
                    }).build());


    public static void registerItemGroups() {
        AfterCraftZ.LOGGER.info("Registering item groups for " + AfterCraftZ.MOD_ID);
    }
}
