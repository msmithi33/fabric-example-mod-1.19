package io.smithit.example.util;

import io.smithit.example.TutMod;
import io.smithit.example.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
    public static void registerItems() {
        registerFuels();
    }

    public static void registerFuels() {
        TutMod.LOGGER.info("Registering Fuels for " + TutMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(ModItems.LILAC_FLOWER_BULB, 200);
    }
}
