package net.aznard.aftercraftz.block;

import net.aznard.aftercraftz.AfterCraftZ;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //blocks
    public static final Block BROWN_BRICK = registerBlock("brown_brick",
            new Block(
                    AbstractBlock.Settings.create()
                            .strength(2f, 3f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));

    public static final Block BLACK_BRICK = registerBlock("black_brick",
            new Block(
                    AbstractBlock.Settings.create()
                            .strength(2f, 3f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AfterCraftZ.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(AfterCraftZ.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks() {
        AfterCraftZ.LOGGER.info("Registering blocks for " + AfterCraftZ.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {

            //blocks
            fabricItemGroupEntries.add(ModBlocks.BROWN_BRICK);
            fabricItemGroupEntries.add(ModBlocks.BLACK_BRICK);
        });
    }
}
