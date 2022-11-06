package io.smithit.example.block;

import io.smithit.example.TutMod;
import io.smithit.example.block.custom.SpeedBlock;
import io.smithit.example.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {
//https://www.youtube.com/watch?v=VjvIE3wxISo
    private static FabricBlockSettings mythrilBlockSettings = FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool();
    private static FabricBlockSettings mythrilOreSettings = FabricBlockSettings.of(Material.METAL).strength(4.5f).requiresTool();
    private static FabricBlockSettings mythrilItemSettings = FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool();


    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block", new Block(mythrilBlockSettings), ModItemGroup.MYTHRIL, "tooltip.tutmod.mythril_block");
    public static final Block MYTHRIL_BLOCK_RAW = registerBlock("mythril_block_raw", new Block(mythrilBlockSettings), ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_ORE = registerBlock("mythril_ore", new Block(mythrilOreSettings), ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_ORE_DEEPSLATE = registerBlock("mythril_ore_deepslate", new Block(mythrilOreSettings.strength(5f)), ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_ORE_NETHERRACK = registerBlock("mythril_ore_netherrack", new Block(mythrilOreSettings.strength(5f)), ModItemGroup.MYTHRIL);

    public static final Block MYTHRIL_BUTTON = registerBlock("mythril_button", new StoneButtonBlock(mythrilItemSettings.noCollision()), ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_PRESSURE_PLATE = registerBlock("mythril_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, mythrilItemSettings), ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_FENCE = registerBlock("mythril_fence", new FenceBlock(mythrilItemSettings), ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_FENCE_GATE = registerBlock("mythril_fence_gate", new FenceGateBlock(mythrilItemSettings), ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_WALL = registerBlock("mythril_wall", new WallBlock(mythrilItemSettings), ModItemGroup.MYTHRIL);


    public static final Block SPEED_BLOCK = registerBlock("speed_block",new SpeedBlock(FabricBlockSettings.of(Material.METAL)), ModItemGroup.MYTHRIL);

    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(TutMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(TutMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)) {
            @Override
            public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                tooltip.add(Text.translatable(tooltipKey));
            }
        });
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(TutMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(TutMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        TutMod.LOGGER.info("Registering mod blocks for " + TutMod.MOD_ID );
    }
}
