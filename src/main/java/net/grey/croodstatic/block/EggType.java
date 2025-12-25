package net.grey.croodstatic.block;

import net.minecraft.util.StringRepresentable;

public enum EggType implements StringRepresentable {
    NONE("none"),
    CHICKUNA("chickuna"),
    WILD("wild");

    private final String name;

    EggType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
