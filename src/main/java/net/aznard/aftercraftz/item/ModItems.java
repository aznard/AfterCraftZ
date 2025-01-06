package net.aznard.aftercraftz.item;

import net.aznard.aftercraftz.AfterCraftZ;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //items
    public static final Item INGOT_COPPER = registerItem("ingot_copper", new Item(new Item.Settings()));

    //foods
    public static final Item CAN_OF_BEANS = registerItem("can_of_beans", new Item(new Item.Settings().food(ModFoodComponents.CAN_OF_BEANS)));
    public static final Item CAN_OF_CARROTS = registerItem("can_of_carrots", new Item(new Item.Settings().food(ModFoodComponents.CAN_OF_CARROTS)));
    public static final Item CAN_OF_PEACHES = registerItem("can_of_peaches", new Item(new Item.Settings().food(ModFoodComponents.CAN_OF_PEACHES)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AfterCraftZ.MOD_ID, name), item);
    }

    public static void registerModItems(){
        AfterCraftZ.LOGGER.info("Registering Mod Items" + AfterCraftZ.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            //items
            fabricItemGroupEntries.add(INGOT_COPPER);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            //foods
            fabricItemGroupEntries.add(CAN_OF_BEANS);
            fabricItemGroupEntries.add(CAN_OF_CARROTS);
            fabricItemGroupEntries.add(CAN_OF_PEACHES);
        });
    }

}
