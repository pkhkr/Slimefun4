package io.github.thebusybiscuit.slimefun4.implementation.items.cargo;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;

import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;

public class CargoInputNode extends AbstractFilterNode {

    private static final int[] BORDER = { 0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17, 18, 22, 23, 26, 27, 31, 32, 33, 34, 35, 36, 40, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53 };

    private static final String ROUND_ROBIN_MODE = "round-robin";
    private static final String SMART_FILL_MODE = "smart-fill";

    @ParametersAreNonnullByDefault
    public CargoInputNode(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, ItemStack recipeOutput) {
        super(itemGroup, item, recipeType, recipe, recipeOutput);
    }

    @Override
    protected int[] getBorder() {
        return BORDER;
    }

    @Override
    protected void onPlace(BlockPlaceEvent e) {
        super.onPlace(e);

        BlockStorage.addBlockInfo(e.getBlock(), ROUND_ROBIN_MODE, String.valueOf(false));
        BlockStorage.addBlockInfo(e.getBlock(), SMART_FILL_MODE, String.valueOf(false));
    }

    @Override
    protected void updateBlockMenu(BlockMenu menu, Block b) {
        super.updateBlockMenu(menu, b);

        String roundRobinMode = BlockStorage.getLocationInfo(b.getLocation(), ROUND_ROBIN_MODE);
        if (!BlockStorage.hasBlockInfo(b) || roundRobinMode == null || roundRobinMode.equals(String.valueOf(false))) {
            menu.replaceExistingItem(24, new CustomItemStack(HeadTexture.ENERGY_REGULATOR.getAsItemStack(), "&7라운드 로빈 모드: &4\u2718", "", "&e> 클릭하여 라운드 로빈 모드 활성화", "&e(아이템이 채널에 균등하게 분배됩니다)"));
            menu.addMenuClickHandler(24, (p, slot, item, action) -> {
                BlockStorage.addBlockInfo(b, ROUND_ROBIN_MODE, String.valueOf(true));
                updateBlockMenu(menu, b);
                return false;
            });
        } else {
            menu.replaceExistingItem(24, new CustomItemStack(HeadTexture.ENERGY_REGULATOR.getAsItemStack(), "&7라운드 로빈 모드: &2\u2714", "", "&e> 클릭하여 라운드 로빈 모드 비활성화", "&e(아이템이 채널에 균등하게 분배됩니다)"));
            menu.addMenuClickHandler(24, (p, slot, item, action) -> {
                BlockStorage.addBlockInfo(b, ROUND_ROBIN_MODE, String.valueOf(false));
                updateBlockMenu(menu, b);
                return false;
            });
        }

        String smartFillNode = BlockStorage.getLocationInfo(b.getLocation(), SMART_FILL_MODE);
        if (!BlockStorage.hasBlockInfo(b) || smartFillNode == null || smartFillNode.equals(String.valueOf(false))) {
            menu.replaceExistingItem(16, new CustomItemStack(Material.WRITABLE_BOOK, "&7\"스마트 채우기\" 모드: &4\u2718", "", "&e> 클릭하여 \"스마트 채우기\" 모드 활성화", "", "&f이 모드에서는 화물 노드가 인벤토리에", "&f일정한 양의 아이템을 유지하려고 시도합니다.", "&f이는 완벽하지 않으며 구성된 아이템 스택 전에", "&f오는 빈 슬롯을 여전히 채울 것입니다."));
            menu.addMenuClickHandler(16, (p, slot, item, action) -> {
                BlockStorage.addBlockInfo(b, SMART_FILL_MODE, String.valueOf(true));
                updateBlockMenu(menu, b);
                return false;
            });
        } else {
            menu.replaceExistingItem(16, new CustomItemStack(Material.WRITTEN_BOOK, "&7\"스마트 채우기\" 모드: &2\u2714", "", "&e> 클릭하여 \"스마트 채우기\" 모드 비활성화", "", "&f이 모드에서는 화물 노드가 인벤토리에", "&f일정한 양의 아이템을 유지하려고 시도합니다.", "&f이는 완벽하지 않으며 구성된 아이템 스택 전에", "&f오는 빈 슬롯을 여전히 채울 것입니다."));
            menu.addMenuClickHandler(16, (p, slot, item, action) -> {
                BlockStorage.addBlockInfo(b, SMART_FILL_MODE, String.valueOf(false));
                updateBlockMenu(menu, b);
                return false;
            });
        }
    }

}
