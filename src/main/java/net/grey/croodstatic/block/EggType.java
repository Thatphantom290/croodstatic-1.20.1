package net.grey.croodstatic.block;

import net.minecraft.util.StringRepresentable;

public enum EggType implements StringRepresentable {
    NONE("none"),
    WILD("wild"),
    NORMAL("normal");

    private final String name;

    EggType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
