package io.github.thebusybiscuit.slimefun4.implementation.items.electric.reactors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.bakedlibs.dough.protection.Interaction;
import io.github.thebusybiscuit.slimefun4.api.events.ReactorExplodeEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.HologramOwner;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineProcessHolder;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.machines.MachineProcessor;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.cargo.ReactorAccessPort;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.AbstractEnergyProvider;
import io.github.thebusybiscuit.slimefun4.implementation.operations.FuelOperation;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.utils.itemstack.ItemStackWrapper;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AGenerator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;

/**
 * The abstract {@link Reactor} class is very similar to {@link AGenerator} but is
 * exclusively used for Reactors.
 * 
 * @author John000708
 * @author AlexLander123
 * @author TheBusyBiscuit
 * 
 * @see AGenerator
 * @see NuclearReactor
 * @see NetherStarReactor
 *
 */
public abstract class Reactor extends AbstractEnergyProvider implements HologramOwner, MachineProcessHolder<FuelOperation> {

    private static final String MODE = "reactor-mode";
    private static final int INFO_SLOT = 49;
    private static final int COOLANT_DURATION = 50;
    private static final BlockFace[] WATER_BLOCKS = { BlockFace.NORTH, BlockFace.NORTH_EAST, BlockFace.EAST, BlockFace.SOUTH_EAST, BlockFace.SOUTH, BlockFace.SOUTH_WEST, BlockFace.WEST, BlockFace.NORTH_WEST };

    private static final int[] border = { 0, 1, 2, 3, 5, 6, 7, 8, 12, 13, 14, 21, 23 };
    private static final int[] border_1 = { 9, 10, 11, 18, 20, 27, 29, 36, 38, 45, 46, 47 };
    private static final int[] border_2 = { 15, 16, 17, 24, 26, 33, 35, 42, 44, 51, 52, 53 };
    private static final int[] border_3 = { 30, 31, 32, 39, 41, 48, 50 };

    // No coolant border
    private static final int[] border_4 = { 25, 34, 43 };

    private final Set<Location> explosionsQueue = new HashSet<>();
    private final MachineProcessor<FuelOperation> processor = new MachineProcessor<>(this);

    @ParametersAreNonnullByDefault
    protected Reactor(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        processor.setProgressBar(getProgressBar());

        new BlockMenuPreset(getId(), getInventoryTitle()) {

            @Override
            public void init() {
                constructMenu(this);
            }

            @Override
            public void newInstance(BlockMenu menu, Block b) {
                if (BlockStorage.getLocationInfo(b.getLocation(), MODE) == null) {
                    BlockStorage.addBlockInfo(b, MODE, ReactorMode.GENERATOR.toString());
                }

                updateInventory(menu, b);
            }

            @Override
            public boolean canOpen(Block b, Player p) {
                return p.hasPermission("slimefun.inventory.bypass") || Slimefun.getProtectionManager().hasPermission(p, b.getLocation(), Interaction.INTERACT_BLOCK);
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                return new int[0];
            }
        };

        addItemHandler(onBreak());
        registerDefaultFuelTypes();
    }

    @Override
    public MachineProcessor<FuelOperation> getMachineProcessor() {
        return processor;
    }

    @Nonnull
    private BlockBreakHandler onBreak() {
        return new SimpleBlockBreakHandler() {

            @Override
            public void onBlockBreak(@Nonnull Block b) {
                BlockMenu inv = BlockStorage.getInventory(b);

                if (inv != null) {
                    inv.dropItems(b.getLocation(), getFuelSlots());
                    inv.dropItems(b.getLocation(), getCoolantSlots());
                    inv.dropItems(b.getLocation(), getOutputSlots());
                }

                processor.endOperation(b);
                removeHologram(b);
            }
        };
    }

    protected void updateInventory(@Nonnull BlockMenu menu, @Nonnull Block b) {
        ReactorMode mode = getReactorMode(b.getLocation());

        switch (mode) {
            case GENERATOR:
                menu.replaceExistingItem(4, new CustomItemStack(SlimefunItems.NUCLEAR_REACTOR, "&7초점: &e전기", "", "&6원자로가 전력 생산에 집중합니다", "&6에너지 네트워크에 전력이 필요하지 않으면", "&6전력을 생산하지 않습니다", "", "&7\u21E8 클릭하여 초점을 &e생산으로 변경"));
                menu.addMenuClickHandler(4, (p, slot, item, action) -> {
                    BlockStorage.addBlockInfo(b, MODE, ReactorMode.PRODUCTION.toString());
                    updateInventory(menu, b);
                    return false;
                });
                break;
            case PRODUCTION:
                menu.replaceExistingItem(4, new CustomItemStack(SlimefunItems.PLUTONIUM, "&7초점: &e생산", "", "&6원자로가 물품 생산에 집중합니다", "&6에너지 네트워크에 전력이 필요하지 않아도", "&6계속 작동하며 그 동안에는", "&6전력을 생산하지 않습니다", "", "&7\u21E8 클릭하여 초점을 &e전력 생산으로 변경"));
                menu.addMenuClickHandler(4, (p, slot, item, action) -> {
                    BlockStorage.addBlockInfo(b, MODE, ReactorMode.GENERATOR.toString());
                    updateInventory(menu, b);
                    return false;
                });
                break;
            default:
                break;
        }

        BlockMenu port = getAccessPort(b.getLocation());

        if (port != null) {
            menu.replaceExistingItem(INFO_SLOT, new CustomItemStack(Material.GREEN_WOOL, "&7접근 포트", "", "&6감지됨", "", "&7> 클릭하여 접근 포트 보기"));
            menu.addMenuClickHandler(INFO_SLOT, (p, slot, item, action) -> {
                port.open(p);
                updateInventory(menu, b);

                return false;
            });
        } else {
            menu.replaceExistingItem(INFO_SLOT, new CustomItemStack(Material.RED_WOOL, "&7접근 포트", "", "&c감지되지 않음", "", "&7접근 포트는", "&7원자로 위 3블록에", "&7설치되어야 합니다!"));
            menu.addMenuClickHandler(INFO_SLOT, (p, slot, item, action) -> {
                updateInventory(menu, b);
                menu.open(p);
                return false;
            });
        }
    }

    private void constructMenu(@Nonnull BlockMenuPreset preset) {
        for (int i : border) {
            preset.addItem(i, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }

        for (int i : border_1) {
            preset.addItem(i, new CustomItemStack(Material.LIME_STAINED_GLASS_PANE, " "), ChestMenuUtils.getEmptyClickHandler());
        }

        for (int i : border_3) {
            preset.addItem(i, new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, " "), ChestMenuUtils.getEmptyClickHandler());
        }

        preset.addItem(22, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "), ChestMenuUtils.getEmptyClickHandler());

        preset.addItem(1, new CustomItemStack(getFuelIcon(), "&7연료 슬롯", "", "&f이 슬롯은 다음과 같은 방사성 연료를 받습니다:", "&2우라늄 &f또는 &a넵투늄"), ChestMenuUtils.getEmptyClickHandler());

        for (int i : border_2) {
            preset.addItem(i, new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE, " "), ChestMenuUtils.getEmptyClickHandler());
        }

        if (needsCooling()) {
            preset.addItem(7, new CustomItemStack(getCoolant(), "&b냉각제 슬롯", "", "&f이 슬롯은 냉각제 셀을 받습니다", "&4냉각제 셀이 없으면", "&4원자로가 폭발할 것입니다"));
        } else {
            preset.addItem(7, new CustomItemStack(Material.BARRIER, "&b냉각제 슬롯", "", "&f이 슬롯은 냉각제 셀을 받습니다"));

            for (int i : border_4) {
                preset.addItem(i, new CustomItemStack(Material.BARRIER, "&c냉각제 불필요"), ChestMenuUtils.getEmptyClickHandler());
            }
        }
    }

    @Nonnull
    protected ReactorMode getReactorMode(@Nonnull Location l) {
        ReactorMode mode = ReactorMode.GENERATOR;

        if (BlockStorage.hasBlockInfo(l) && BlockStorage.getLocationInfo(l, MODE).equals(ReactorMode.PRODUCTION.toString())) {
            mode = ReactorMode.PRODUCTION;
        }

        return mode;
    }

    public abstract void extraTick(@Nonnull Location l);

    /**
     * This method returns the {@link ItemStack} that is required to cool this {@link Reactor}.
     * If it returns null, then no cooling is required.
     * 
     * @return The {@link ItemStack} required to cool this {@link Reactor}
     */
    @Nullable
    public abstract ItemStack getCoolant();

    /**
     * This method returns the displayed icon above the fuel input slot.
     * It should reflect the {@link ItemStack} used to power the reactor.
     * This method does <b>not</b> determine the fuel input, only the icon.
     * 
     * @return The {@link ItemStack} used as the fuel icon for this {@link Reactor}.
     */
    @Nonnull
    public abstract ItemStack getFuelIcon();

    /**
     * This method returns whether this {@link Reactor} requires as some form of
     * coolant.
     * It is a not-null check performed on {@link #getCoolant()}
     * 
     * @return Whether this {@link Reactor} requires cooling
     */
    protected final boolean needsCooling() {
        return getCoolant() != null;
    }

    @Override
    public int[] getInputSlots() {
        return new int[] { 19, 28, 37, 25, 34, 43 };
    }

    public int[] getFuelSlots() {
        return new int[] { 19, 28, 37 };
    }

    @Nonnull
    public int[] getCoolantSlots() {
        return needsCooling() ? new int[] { 25, 34, 43 } : new int[0];
    }

    @Override
    public int[] getOutputSlots() {
        return new int[] { 40 };
    }

    @Override
    public int getGeneratedOutput(Location l, Config data) {
        BlockMenu inv = BlockStorage.getInventory(l);
        BlockMenu accessPort = getAccessPort(l);
        FuelOperation operation = processor.getOperation(l);

        if (operation != null) {
            extraTick(l);

            if (!operation.isFinished()) {
                return generateEnergy(l, data, inv, accessPort, operation);
            } else {
                createByproduct(l, inv, accessPort, operation);
                return 0;
            }
        } else {
            burnNextFuel(l, inv, accessPort);
            return 0;
        }
    }

    private int generateEnergy(@Nonnull Location l, @Nonnull Config data, @Nonnull BlockMenu inv, @Nullable BlockMenu accessPort, @Nonnull FuelOperation operation) {
        int produced = getEnergyProduction();
        String energyData = data.getString("energy-charge");
        int charge = 0;

        if (energyData != null) {
            charge = Integer.parseInt(energyData);
        }

        int space = getCapacity() - charge;

        if (space >= produced || getReactorMode(l) != ReactorMode.GENERATOR) {
            operation.addProgress(1);
            checkForWaterBlocks(l);
            processor.updateProgressBar(inv, 22, operation);

            if (needsCooling() && !hasEnoughCoolant(l, inv, accessPort, operation)) {
                explosionsQueue.add(l);
                return 0;
            }
        }

        if (space >= produced) {
            return getEnergyProduction();
        } else {
            return 0;
        }
    }

    @Override
    public boolean willExplode(Location l, Config data) {
        boolean explosion = explosionsQueue.contains(l);

        if (explosion) {
            Slimefun.runSync(() -> {
                ReactorExplodeEvent event = new ReactorExplodeEvent(l, Reactor.this);
                Bukkit.getPluginManager().callEvent(event);

                BlockStorage.getInventory(l).close();
                removeHologram(l.getBlock());
            });

            explosionsQueue.remove(l);
            processor.endOperation(l);
        }

        return explosion;
    }

    private void checkForWaterBlocks(Location l) {
        Slimefun.runSync(() -> {
            /*
             * We will pick a surrounding block at random and see if this is water.
             * If it isn't, then we will make it explode.
             */
            int index = ThreadLocalRandom.current().nextInt(WATER_BLOCKS.length);
            BlockFace randomNeighbour = WATER_BLOCKS[index];

            if (l.getBlock().getRelative(randomNeighbour).getType() != Material.WATER) {
                explosionsQueue.add(l);
            }
        });
    }

    private void createByproduct(@Nonnull Location l, @Nonnull BlockMenu inv, @Nullable BlockMenu accessPort, @Nonnull FuelOperation operation) {
        inv.replaceExistingItem(22, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "));
        ItemStack result = operation.getResult();

        if (result != null) {
            inv.pushItem(result.clone(), getOutputSlots());
        }

        if (accessPort != null) {
            for (int slot : getOutputSlots()) {
                if (inv.getItemInSlot(slot) != null) {
                    inv.replaceExistingItem(slot, accessPort.pushItem(inv.getItemInSlot(slot), ReactorAccessPort.getOutputSlots()));
                }
            }
        }

        processor.endOperation(l);
    }

    private void burnNextFuel(Location l, BlockMenu inv, BlockMenu accessPort) {
        Map<Integer, Integer> found = new HashMap<>();
        MachineFuel fuel = findFuel(inv, found);

        if (accessPort != null) {
            restockFuel(inv, accessPort);
        }

        if (fuel != null) {
            for (Map.Entry<Integer, Integer> entry : found.entrySet()) {
                inv.consumeItem(entry.getKey(), entry.getValue());
            }

            processor.startOperation(l, new FuelOperation(fuel));
        }
    }

    /**
     * This method cools the given {@link Reactor}.
     * 
     * @param reactor
     *            The {@link Location} of this {@link Reactor}
     * @param menu
     *            The {@link Inventory} of this {@link Reactor}
     * @param accessPort
     *            The {@link ReactorAccessPort}, if available
     * @param operation
     *            The {@link FuelOperation} of this {@link Reactor}
     * 
     * @return Whether the {@link Reactor} was successfully cooled, if not it should explode
     */
    private boolean hasEnoughCoolant(@Nonnull Location reactor, @Nonnull BlockMenu menu, @Nullable BlockMenu accessPort, @Nonnull FuelOperation operation) {
        boolean requiresCoolant = operation.getProgress() % COOLANT_DURATION == 0;

        if (requiresCoolant) {
            ItemStack coolant = ItemStackWrapper.wrap(getCoolant());

            if (accessPort != null) {
                for (int slot : getCoolantSlots()) {
                    if (SlimefunUtils.isItemSimilar(accessPort.getItemInSlot(slot), coolant, true, false)) {
                        ItemStack remainingItem = menu.pushItem(accessPort.getItemInSlot(slot), getCoolantSlots());
                        accessPort.replaceExistingItem(slot, remainingItem);
                    }
                }
            }

            for (int slot : getCoolantSlots()) {
                if (SlimefunUtils.isItemSimilar(menu.getItemInSlot(slot), coolant, true, false)) {
                    menu.consumeItem(slot);
                    updateHologram(reactor.getBlock(), "&b\u2744 &7100%");
                    return true;
                }
            }

            return false;
        } else {
            updateHologram(reactor.getBlock(), "&b\u2744 &7" + getPercentage(operation.getRemainingTicks(), operation.getTotalTicks()) + "%");
        }

        return true;
    }

    private float getPercentage(int time, int total) {
        int passed = ((total - time) % COOLANT_DURATION);
        return Math.round(((((COOLANT_DURATION - passed) * 100.0F) / COOLANT_DURATION) * 100.0F) / 100.0F);
    }

    @ParametersAreNonnullByDefault
    private void restockFuel(BlockMenu menu, BlockMenu port) {
        for (int slot : getFuelSlots()) {
            for (MachineFuel fuelType : fuelTypes) {
                if (fuelType.test(port.getItemInSlot(slot)) && menu.fits(new CustomItemStack(port.getItemInSlot(slot), 1), getFuelSlots())) {
                    port.replaceExistingItem(slot, menu.pushItem(port.getItemInSlot(slot), getFuelSlots()));
                    return;
                }
            }
        }
    }

    @Nullable
    @ParametersAreNonnullByDefault
    private MachineFuel findFuel(BlockMenu menu, Map<Integer, Integer> found) {
        for (MachineFuel fuel : fuelTypes) {
            for (int slot : getInputSlots()) {
                if (fuel.test(menu.getItemInSlot(slot))) {
                    found.put(slot, fuel.getInput().getAmount());
                    return fuel;
                }
            }
        }

        return null;
    }

    @Nullable
    protected BlockMenu getAccessPort(@Nonnull Location l) {
        Location port = new Location(l.getWorld(), l.getX(), l.getY() + 3, l.getZ());

        if (BlockStorage.check(port, SlimefunItems.REACTOR_ACCESS_PORT.getItemId())) {
            return BlockStorage.getInventory(port);
        } else {
            return null;
        }
    }

}
