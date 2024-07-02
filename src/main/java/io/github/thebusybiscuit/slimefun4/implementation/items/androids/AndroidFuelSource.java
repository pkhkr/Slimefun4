package io.github.thebusybiscuit.slimefun4.implementation.items.androids;

import javax.annotation.Nonnull;

import org.bukkit.inventory.ItemStack;

import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;

/**
 * This enum covers all different fuel sources a {@link ProgrammableAndroid} can have.
 * 
 * @author TheBusyBiscuit
 *
 */
public enum AndroidFuelSource {

    /**
     * 이 {@link ProgrammableAndroid}는 고체 연료로 작동합니다. 예: 나무 또는 석탄
     */
    SOLID("", "&f이 안드로이드는 고체 연료로 작동합니다", "&f예: 석탄, 나무 등..."),

    /**
     * 이 {@link ProgrammableAndroid}는 액체 연료로 작동합니다. 예: 연료, 기름 또는 용암
     */
    LIQUID("", "&f이 안드로이드는 액체 연료로 작동합니다", "&f예: 용암, 기름, 연료 등..."),

    /**
     * 이 {@link ProgrammableAndroid}는 핵연료로 작동합니다. 예: 우라늄
     */
    NUCLEAR("", "&f이 안드로이드는 방사성 연료로 작동합니다", "&f예: 우라늄, 넵투늄 또는 강화 우라늄");

    private final String[] lore;

    AndroidFuelSource(@Nonnull String... lore) {
        this.lore = lore;
    }

    /**
     * 이 메서드는 이 {@link AndroidFuelSource}에 대한 표시용 {@link ItemStack}을 반환합니다.
     * 
     * @return 표시할 {@link ItemStack}
     */
    @Nonnull
    public ItemStack getItem() {
        return new CustomItemStack(HeadTexture.GENERATOR.getAsItemStack(), "&8\u21E9 &c연료 입력 &8\u21E9", lore);
    }

}
