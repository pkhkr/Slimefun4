package io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.entities;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Wither;
import org.bukkit.inventory.ItemStack;

import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;

import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

/**
 * The {@link WitherAssembler} is an electrical machine that can automatically spawn
 * a {@link Wither} if the required ingredients have been provided.
 * 
 * @author TheBusyBiscuit
 * 
 * @see IronGolemAssembler
 *
 */
public class WitherAssembler extends AbstractEntityAssembler<Wither> {

    @ParametersAreNonnullByDefault
    public WitherAssembler(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public int getCapacity() {
        return 4096;
    }

    @Override
    public int getEnergyConsumption() {
        return 4096;
    }

    @Override
    public ItemStack getHead() {
        return new ItemStack(Material.WITHER_SKELETON_SKULL, 3);
    }

    @Override
    public Material getHeadBorder() {
        return Material.BLACK_STAINED_GLASS_PANE;
    }

    @Override
    public ItemStack getBody() {
        return new ItemStack(Material.SOUL_SAND, 4);
    }

    @Override
    public Material getBodyBorder() {
        return Material.BROWN_STAINED_GLASS_PANE;
    }

    @Override
    protected void constructMenu(BlockMenuPreset preset) {
        preset.addItem(1, new CustomItemStack(getHead(), "&7위더 스켈레톤 해골 슬롯", "", "&f이 슬롯은 위더 스켈레톤 해골을 받습니다"), ChestMenuUtils.getEmptyClickHandler());
        preset.addItem(7, new CustomItemStack(getBody(), "&7소울 샌드 슬롯", "", "&f이 슬롯은 소울 샌드를 받습니다"), ChestMenuUtils.getEmptyClickHandler());
        preset.addItem(13, new CustomItemStack(Material.CLOCK, "&7쿨다운: &b30초", "", "&f이 기계는 작동하는 데 최대 30초가 걸립니다", "&f그러니 시간을 주세요!"), ChestMenuUtils.getEmptyClickHandler());
    }

    @Override
    public Wither spawnEntity(Location l) {
        return l.getWorld().spawn(l, Wither.class);
    }

}
