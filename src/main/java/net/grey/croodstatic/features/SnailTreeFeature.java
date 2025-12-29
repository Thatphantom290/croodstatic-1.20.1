package net.grey.croodstatic.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public class SnailTreeFeature extends Feature<NoneFeatureConfiguration> {
    public SnailTreeFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        if (!(context.level() instanceof ServerLevel serverLevel)) {
            return false;
        }

        BlockPos pos = context.origin();
        StructureTemplateManager manager = serverLevel.getStructureManager();

        String[] variants = {
                "snail_tree",
                "snail_tree1"
        };

        String chosen = variants[serverLevel.getRandom().nextInt(variants.length)];

        StructureTemplate template = manager.get(new ResourceLocation("croodstatic", chosen)).orElse(null);
        if (template == null) {
            return false;
        }

        Rotation[] rotations = {Rotation.NONE, Rotation.CLOCKWISE_90, Rotation.CLOCKWISE_180, Rotation.COUNTERCLOCKWISE_90};
        Rotation chosenRotation = rotations[serverLevel.getRandom().nextInt(rotations.length)];

        Mirror chosenMirror = serverLevel.getRandom().nextBoolean() ? Mirror.NONE : Mirror.FRONT_BACK;

        StructurePlaceSettings settings = new StructurePlaceSettings()
                .setIgnoreEntities(false)
                .setRotation(chosenRotation)
                .setMirror(chosenMirror);

        template.placeInWorld(serverLevel, pos, pos, settings, serverLevel.getRandom(), 2);
        return true;
    }
}
