package net.grey.croodstatic.block.custom;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class MoistGrass extends Block {
    public static final EnumProperty<Variant> VARIANT = EnumProperty.create("variant", Variant.class);

    public MoistGrass(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(VARIANT, Variant.TYPE1));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(VARIANT);
    }

    public enum Variant implements StringRepresentable {
        TYPE1("type1"),
        TYPE2("type2");

        private final String name;
        Variant(String name) { this.name = name; }
        @Override
        public String getSerializedName() { return name; }
    }
}
