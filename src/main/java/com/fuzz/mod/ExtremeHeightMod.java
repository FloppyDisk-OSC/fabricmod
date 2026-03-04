// src/main/java/com/fuzz/mod/ExtremeHeightMod.java
package com.fuzz.mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.OverworldChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.OverworldChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;

public class ExtremeHeightMod implements ModInitializer {

    public static final String MOD_ID = "extremeheightmod";

    @Override
    public void onInitialize() {
        System.out.println("ExtremeHeightMod loaded! ⛏️ Min Y = -128, Max Y = 512");

        // This hooks into every biome and sets custom generation for new chunks
        BiomeModifications.create(new Identifier(MOD_ID, "adjust_height"))
            .add(GenerationStep.Feature.UNDERGROUND_ORES, BiomeSelectors.foundInOverworld(), (biome, context) -> {
                if (biome.getGenerationSettings() instanceof OverworldChunkGeneratorConfig config) {
                    // Set new min/max heights for terrain generation
                    config.setMinY(-128);
                    config.setHeight(640); // maxY = minY + height = -128 + 640 = 512
                }
            });
    }
}
