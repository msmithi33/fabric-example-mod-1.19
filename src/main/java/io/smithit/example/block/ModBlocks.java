package io.smithit.example.block;

import io.smithit.example.TutMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ItemGroup.MISC);
    public static final Block MYTHRIL_BLOCK_RAW = registerBlock("mythril_block_raw",new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ItemGroup.MISC);
    public static final Block MYTHRIL_ORE = registerBlock("mythril_ore",new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()), ItemGroup.MISC);
    public static final Block MYTHRIL_ORE_DEEPSLATE = registerBlock("mythril_ore_deepslate",new Block(FabricBlockSettings.of(Material.STONE).strength(5f).requiresTool()), ItemGroup.MISC);
    public static final Block MYTHRIL_ORE_NETHERRACK = registerBlock("mythril_ore_netherrack",new Block(FabricBlockSettings.of(Material.STONE).strength(5f).requiresTool()), ItemGroup.MISC);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(TutMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(TutMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        TutMod.LOGGER.info("Registering mod blocks for " + TutMod.MOD_ID );
    }
}
