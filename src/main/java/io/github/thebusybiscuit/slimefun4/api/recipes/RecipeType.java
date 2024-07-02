package io.github.thebusybiscuit.slimefun4.api.recipes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.BiConsumer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.bakedlibs.dough.recipes.MinecraftRecipe;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.debug.Debug;
import io.github.thebusybiscuit.slimefun4.core.debug.TestCase;
import io.github.thebusybiscuit.slimefun4.core.multiblocks.MultiBlockMachine;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.altar.AltarRecipe;
import io.github.thebusybiscuit.slimefun4.implementation.items.altar.AncientAltar;

// TODO: Remove this class and rewrite the recipe system
public class RecipeType implements Keyed {

    public static final RecipeType MULTIBLOCK = new RecipeType(new NamespacedKey(Slimefun.instance(), "multiblock"), new CustomItemStack(Material.BRICKS, "&b직접 건설", "", "&a&o직접 월드에 건설하세요"));
    public static final RecipeType ARMOR_FORGE = new RecipeType(new NamespacedKey(Slimefun.instance(), "armor_forge"), SlimefunItems.ARMOR_FORGE, "", "&a&o방어구 제작대에서 제작하세요");
    public static final RecipeType GRIND_STONE = new RecipeType(new NamespacedKey(Slimefun.instance(), "grind_stone"), SlimefunItems.GRIND_STONE, "", "&a&o분쇄기를 사용하여 갈아내세요");
    public static final RecipeType SMELTERY = new RecipeType(new NamespacedKey(Slimefun.instance(), "smeltery"), SlimefunItems.SMELTERY, "", "&a&o제련소를 사용하여 녹이세요");
    public static final RecipeType ORE_CRUSHER = new RecipeType(new NamespacedKey(Slimefun.instance(), "ore_crusher"), SlimefunItems.ORE_CRUSHER, "", "&a&o광석 분쇄기를 사용하여 분쇄하세요");
    public static final RecipeType GOLD_PAN = new RecipeType(new NamespacedKey(Slimefun.instance(), "gold_pan"), SlimefunItems.GOLD_PAN, "", "&a&o자갈에 골드 팬을 사용하여 이 아이템을 얻으세요");
    public static final RecipeType COMPRESSOR = new RecipeType(new NamespacedKey(Slimefun.instance(), "compressor"), SlimefunItems.COMPRESSOR, "", "&a&o압축기를 사용하여 압축하세요");
    public static final RecipeType PRESSURE_CHAMBER = new RecipeType(new NamespacedKey(Slimefun.instance(), "pressure_chamber"), SlimefunItems.PRESSURE_CHAMBER, "", "&a&o압력실을 사용하여 압축하세요");
    public static final RecipeType MAGIC_WORKBENCH = new RecipeType(new NamespacedKey(Slimefun.instance(), "magic_workbench"), SlimefunItems.MAGIC_WORKBENCH, "", "&a&o마법 작업대에서 제작하세요");
    public static final RecipeType ORE_WASHER = new RecipeType(new NamespacedKey(Slimefun.instance(), "ore_washer"), SlimefunItems.ORE_WASHER, "", "&a&o광석 세척기에서 세척하세요");
    public static final RecipeType ENHANCED_CRAFTING_TABLE = new RecipeType(new NamespacedKey(Slimefun.instance(), "enhanced_crafting_table"), SlimefunItems.ENHANCED_CRAFTING_TABLE, "", "&a&o일반 제작대로는", "&a&o이 엄청난 양의 힘을 감당할 수 없습니다...");
    public static final RecipeType JUICER = new RecipeType(new NamespacedKey(Slimefun.instance(), "juicer"), SlimefunItems.JUICER, "", "&a&o주스 제조에 사용됩니다");

    public static final RecipeType ANCIENT_ALTAR = new RecipeType(new NamespacedKey(Slimefun.instance(), "ancient_altar"), SlimefunItems.ANCIENT_ALTAR, (recipe, output) -> {
        AltarRecipe altarRecipe = new AltarRecipe(Arrays.asList(recipe), output);
        AncientAltar altar = ((AncientAltar) SlimefunItems.ANCIENT_ALTAR.getItem());
        altar.getRecipes().add(altarRecipe);
    });

    public static final RecipeType MOB_DROP = new RecipeType(new NamespacedKey(Slimefun.instance(), "mob_drop"), new CustomItemStack(Material.IRON_SWORD, "&b몹 드롭"), RecipeType::registerMobDrop, "", "&r지정된 몹을 처치하여 이 아이템을 획득하세요");
    public static final RecipeType BARTER_DROP = new RecipeType(new NamespacedKey(Slimefun.instance(), "barter_drop"), new CustomItemStack(Material.GOLD_INGOT, "&b교환 드롭"), RecipeType::registerBarterDrop, "&a피글린과 교환하여", "&a이 아이템을 얻을 수 있는 기회가 있습니다");
    public static final RecipeType INTERACT = new RecipeType(new NamespacedKey(Slimefun.instance(), "interact"), new CustomItemStack(Material.PLAYER_HEAD, "&b상호작용", "", "&a&o이 아이템으로 우클릭하세요"));
    public static final RecipeType HEATED_PRESSURE_CHAMBER = new RecipeType(new NamespacedKey(Slimefun.instance(), "heated_pressure_chamber"), SlimefunItems.HEATED_PRESSURE_CHAMBER);
    public static final RecipeType FOOD_FABRICATOR = new RecipeType(new NamespacedKey(Slimefun.instance(), "food_fabricator"), SlimefunItems.FOOD_FABRICATOR);
    public static final RecipeType FOOD_COMPOSTER = new RecipeType(new NamespacedKey(Slimefun.instance(), "food_composter"), SlimefunItems.FOOD_COMPOSTER);
    public static final RecipeType FREEZER = new RecipeType(new NamespacedKey(Slimefun.instance(), "freezer"), SlimefunItems.FREEZER);
    public static final RecipeType REFINERY = new RecipeType(new NamespacedKey(Slimefun.instance(), "refinery"), SlimefunItems.REFINERY);

    public static final RecipeType GEO_MINER = new RecipeType(new NamespacedKey(Slimefun.instance(), "geo_miner"), SlimefunItems.GEO_MINER);
    public static final RecipeType NUCLEAR_REACTOR = new RecipeType(new NamespacedKey(Slimefun.instance(), "nuclear_reactor"), SlimefunItems.NUCLEAR_REACTOR);

    public static final RecipeType NULL = new RecipeType();

    private final ItemStack item;
    private final NamespacedKey key;
    private final String machine;
    private BiConsumer<ItemStack[], ItemStack> consumer;

    private RecipeType() {
        this.item = null;
        this.machine = "";
        this.key = new NamespacedKey(Slimefun.instance(), "null");
    }

    public RecipeType(ItemStack item, String machine) {
        this.item = item;
        this.machine = machine;

        if (machine.length() > 0) {
            this.key = new NamespacedKey(Slimefun.instance(), machine.toLowerCase(Locale.ROOT));
        } else {
            this.key = new NamespacedKey(Slimefun.instance(), "unknown");
        }
    }

    public RecipeType(NamespacedKey key, SlimefunItemStack slimefunItem, String... lore) {
        this(key, slimefunItem, null, lore);
    }

    public RecipeType(NamespacedKey key, ItemStack item, BiConsumer<ItemStack[], ItemStack> callback, String... lore) {
        this.item = new CustomItemStack(item, null, lore);
        this.key = key;
        this.consumer = callback;

        if (item instanceof SlimefunItemStack slimefunItemStack) {
            this.machine = slimefunItemStack.getItemId();
        } else {
            this.machine = "";
        }
    }

    public RecipeType(NamespacedKey key, ItemStack item) {
        this.key = key;
        this.item = item;
        this.machine = item instanceof SlimefunItemStack slimefunItemStack ? slimefunItemStack.getItemId() : "";
    }

    public RecipeType(MinecraftRecipe<?> recipe) {
        this.item = new ItemStack(recipe.getMachine());
        this.machine = "";
        this.key = NamespacedKey.minecraft(recipe.getRecipeClass().getSimpleName().toLowerCase(Locale.ROOT).replace("recipe", ""));
    }

    public void register(ItemStack[] recipe, ItemStack result) {
        if (consumer != null) {
            consumer.accept(recipe, result);
        } else {
            SlimefunItem slimefunItem = SlimefunItem.getById(this.machine);

            if (slimefunItem instanceof MultiBlockMachine mbm) {
                mbm.addRecipe(recipe, result);
            }
        }
    }

    public @Nullable ItemStack toItem() {
        return this.item;
    }

    public @Nonnull ItemStack getItem(Player p) {
        return Slimefun.getLocalization().getRecipeTypeItem(p, this);
    }

    public SlimefunItem getMachine() {
        return SlimefunItem.getById(machine);
    }

    @Override
    public final @Nonnull NamespacedKey getKey() {
        return key;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof RecipeType recipeType) {
            return recipeType.getKey().equals(this.getKey());
        } else {
            return false;
        }
    }

    @Override
    public final int hashCode() {
        return getKey().hashCode();
    }

    @ParametersAreNonnullByDefault
    private static void registerBarterDrop(ItemStack[] recipe, ItemStack output) {
        Slimefun.getRegistry().getBarteringDrops().add(output);
    }

    @ParametersAreNonnullByDefault
    private static void registerMobDrop(ItemStack[] recipe, ItemStack output) {
        String mob = ChatColor.stripColor(recipe[4].getItemMeta().getDisplayName()).toUpperCase(Locale.ROOT).replace(' ', '_').replace("철_골렘", "IRON_GOLEM");
        EntityType entity = EntityType.valueOf(mob);
        Set<ItemStack> dropping = Slimefun.getRegistry().getMobDrops().getOrDefault(entity, new HashSet<>());
        dropping.add(output);
        Slimefun.getRegistry().getMobDrops().put(entity, dropping);
    }

    public static List<ItemStack> getRecipeInputs(MultiBlockMachine machine) {
        if (machine == null) {
            return new ArrayList<>();
        }

        List<ItemStack[]> recipes = machine.getRecipes();
        List<ItemStack> convertible = new ArrayList<>();

        for (int i = 0; i < recipes.size(); i++) {
            if (i % 2 == 0) {
                convertible.add(recipes.get(i)[0]);
            }
        }

        return convertible;
    }

    public static List<ItemStack[]> getRecipeInputList(MultiBlockMachine machine) {
        if (machine == null) {
            return new ArrayList<>();
        }

        List<ItemStack[]> recipes = machine.getRecipes();
        List<ItemStack[]> convertible = new ArrayList<>();

        for (int i = 0; i < recipes.size(); i++) {
            if (i % 2 == 0) {
                convertible.add(recipes.get(i));
            }
        }

        convertible.sort(Comparator.comparing(recipe -> {
            int emptySlots = 9;

            for (ItemStack ingredient : recipe) {
                if (ingredient != null) {
                    emptySlots--;
                }
            }

            return emptySlots;
        }));

        return convertible;
    }

    public static ItemStack getRecipeOutput(MultiBlockMachine machine, ItemStack input) {
        List<ItemStack[]> recipes = machine.getRecipes();
        return recipes.get(((getRecipeInputs(machine).indexOf(input) * 2) + 1))[0].clone();
    }

    public static ItemStack getRecipeOutputList(MultiBlockMachine machine, ItemStack[] input) {
        List<ItemStack[]> recipes = machine.getRecipes();
        ItemStack output = recipes.get((recipes.indexOf(input) + 1))[0];
        SlimefunItem sfItem = SlimefunItem.getByItem(output);

        // Debug.log(TestCase.KUNHO, " Test types {} / {}", sfItem, sfItem.getId());
        

        return output;
    }
}