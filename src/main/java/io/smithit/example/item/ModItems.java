package io.smithit.example.item;

import io.smithit.example.TutMod;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot", new Item( new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item MYTHRIL_NUGGET = registerItem("mythril_nugget", new Item( new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item MYTHRIL_RAW = registerItem("mythril_raw", new Item( new FabricItemSettings().group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TutMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        TutMod.LOGGER.info("Registering Mod Items for " + TutMod.MOD_ID);
    }
}
