package io.github.thebusybiscuit.slimefun4.implementation.setup;

import java.time.Month;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.FlexItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.LockedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SeasonalItemGroup;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;

/**
 * This class holds a reference to every {@link ItemGroup}
 * found in Slimefun itself.
 * 
 * Addons should use their own {@link ItemGroup} hence why the visible of this class was now
 * changed to package-private. Only {@link SlimefunItemSetup} has access to this class.
 * 
 * @author TheBusyBiscuit
 * 
 * @see ItemGroup
 * @see LockedItemGroup
 * @see SeasonalItemGroup
 *
 */
class DefaultItemGroups {

    // Standard Item Groups
    protected final ItemGroup weapons = new ItemGroup(new NamespacedKey(Slimefun.instance(), "weapons"), new CustomItemStack(SlimefunItems.BLADE_OF_VAMPIRES, "&7무기"), 1);
    protected final ItemGroup tools = new ItemGroup(new NamespacedKey(Slimefun.instance(), "tools"), new CustomItemStack(SlimefunItems.SMELTERS_PICKAXE, "&7도구"), 1);
    protected final ItemGroup usefulItems = new ItemGroup(new NamespacedKey(Slimefun.instance(), "items"), new CustomItemStack(SlimefunItems.BACKPACK_MEDIUM, "&7유용한 아이템"), 1);
    protected final ItemGroup basicMachines = new ItemGroup(new NamespacedKey(Slimefun.instance(), "basic_machines"), new CustomItemStack(SlimefunItems.ENHANCED_CRAFTING_TABLE, "&7기본 기계"), 1);
    protected final ItemGroup food = new ItemGroup(new NamespacedKey(Slimefun.instance(), "food"), new CustomItemStack(SlimefunItems.FORTUNE_COOKIE, "&7음식"), 2);
    protected final ItemGroup armor = new ItemGroup(new NamespacedKey(Slimefun.instance(), "armor"), new CustomItemStack(SlimefunItems.DAMASCUS_STEEL_CHESTPLATE, "&7갑옷"), 2);

    // 마법
    protected final ItemGroup magicalResources = new ItemGroup(new NamespacedKey(Slimefun.instance(), "magical_items"), new CustomItemStack(SlimefunItems.ENDER_RUNE, "&7마법 아이템"), 2);
    protected final ItemGroup magicalGadgets = new ItemGroup(new NamespacedKey(Slimefun.instance(), "magical_gadgets"), new CustomItemStack(SlimefunItems.INFUSED_ELYTRA, "&7마법 가젯"), 3);
    protected final ItemGroup magicalArmor = new ItemGroup(new NamespacedKey(Slimefun.instance(), "magical_armor"), new CustomItemStack(SlimefunItems.ENDER_HELMET, "&7마법 갑옷"), 2);

    // 자원 및 기술 관련
    protected final ItemGroup misc = new ItemGroup(new NamespacedKey(Slimefun.instance(), "misc"), new CustomItemStack(SlimefunItems.TIN_CAN, "&7기타"), 2);
    protected final ItemGroup technicalComponents = new ItemGroup(new NamespacedKey(Slimefun.instance(), "tech_misc"), new CustomItemStack(SlimefunItems.HEATING_COIL, "&7기술 부품"), 2);
    protected final ItemGroup technicalGadgets = new ItemGroup(new NamespacedKey(Slimefun.instance(), "technical_gadgets"), new CustomItemStack(SlimefunItems.STEEL_JETPACK, "&7기술 가젯"), 3);
    protected final ItemGroup resources = new ItemGroup(new NamespacedKey(Slimefun.instance(), "resources"), new CustomItemStack(SlimefunItems.SYNTHETIC_SAPPHIRE, "&7자원"), 1);

    // 잠긴 아이템 그룹
    protected final LockedItemGroup electricity = new LockedItemGroup(new NamespacedKey(Slimefun.instance(), "electricity"), new CustomItemStack(SlimefunItems.NUCLEAR_REACTOR, "&b에너지와 전기"), 4, basicMachines.getKey());
    protected final LockedItemGroup androids = new LockedItemGroup(new NamespacedKey(Slimefun.instance(), "androids"), new CustomItemStack(SlimefunItems.PROGRAMMABLE_ANDROID, "&c프로그래밍 가능한 안드로이드"), 4, basicMachines.getKey());
    protected final ItemGroup cargo = new LockedItemGroup(new NamespacedKey(Slimefun.instance(), "cargo"), new CustomItemStack(SlimefunItems.CARGO_MANAGER, "&c화물 관리"), 4, basicMachines.getKey());
    protected final LockedItemGroup gps = new LockedItemGroup(new NamespacedKey(Slimefun.instance(), "gps"), new CustomItemStack(SlimefunItems.GPS_TRANSMITTER, "&bGPS 기반 기계"), 4, basicMachines.getKey());

    // 계절 아이템 그룹
    protected final SeasonalItemGroup christmas = new SeasonalItemGroup(new NamespacedKey(Slimefun.instance(), "christmas"), Month.DECEMBER, 1, new CustomItemStack(SlimefunUtils.getCustomHead("215ba31cde2671b8f176de6a9ffd008035f0590d63ee240be6e8921cd2037a45"), ChatUtils.christmas("크리스마스") + " &7(12월 한정)"));
    protected final SeasonalItemGroup valentinesDay = new SeasonalItemGroup(new NamespacedKey(Slimefun.instance(), "valentines_day"), Month.FEBRUARY, 2, new CustomItemStack(SlimefunUtils.getCustomHead("55d89431d14bfef2060461b4a3565614dc51115c001fae2508e8684bc0ae6a80"), "&d발렌타인 데이" + " &7(2월 14일)"));
    protected final SeasonalItemGroup easter = new SeasonalItemGroup(new NamespacedKey(Slimefun.instance(), "easter"), Month.APRIL, 2, new CustomItemStack(HeadTexture.EASTER_EGG.getAsItemStack(), "&6부활절" + " &7(4월)"));
    protected final SeasonalItemGroup birthday = new SeasonalItemGroup(new NamespacedKey(Slimefun.instance(), "birthday"), Month.OCTOBER, 1, new CustomItemStack(Material.FIREWORK_ROCKET, "&a&lTheBusyBiscuit의 생일 &7(10월 26일)"));
    protected final SeasonalItemGroup halloween = new SeasonalItemGroup(new NamespacedKey(Slimefun.instance(), "halloween"), Month.OCTOBER, 1, new CustomItemStack(Material.JACK_O_LANTERN, "&6&l할로윈 &7(10월 31일)"));

    // Flex 아이템 그룹
    protected final FlexItemGroup rickFlexGroup = new RickFlexGroup(new NamespacedKey(Slimefun.instance(), "rick"));
}

