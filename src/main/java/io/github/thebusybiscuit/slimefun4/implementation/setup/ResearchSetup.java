package io.github.thebusybiscuit.slimefun4.implementation.setup;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;

/**
 * This static setup class is used to register all default implementations of
 * {@link Research} on startup.
 *
 * @see Research
 * @see SlimefunItems
 *
 */
public final class ResearchSetup {

    private static boolean alreadyRan = false;

    private ResearchSetup() {}

    public static void setupResearches() {
        if (alreadyRan) {
            throw new UnsupportedOperationException("Researches can only be registered once!");
        }

        alreadyRan = true;

        register("walking_sticks", 0, SlimefunItems.GRANDMAS_WALKING_STICK.getDisplayName(), 1, SlimefunItems.GRANDMAS_WALKING_STICK, SlimefunItems.GRANDPAS_WALKING_STICK);
        register("portable_crafter", 1, SlimefunItems.PORTABLE_CRAFTER.getDisplayName(), 1, SlimefunItems.PORTABLE_CRAFTER);
        register("fortune_cookie", 2, SlimefunItems.FORTUNE_COOKIE.getDisplayName(), 1, SlimefunItems.FORTUNE_COOKIE);
        register("portable_dustbin", 4, SlimefunItems.PORTABLE_DUSTBIN.getDisplayName(), 2, SlimefunItems.PORTABLE_DUSTBIN);
        register("meat_jerky", 5, SlimefunItems.BEEF_JERKY.getDisplayName(), 2, SlimefunItems.BEEF_JERKY, SlimefunItems.FISH_JERKY, SlimefunItems.RABBIT_JERKY, SlimefunItems.MUTTON_JERKY, SlimefunItems.CHICKEN_JERKY, SlimefunItems.PORK_JERKY);
        register("armor_forge", 6, SlimefunItems.ARMOR_FORGE.getDisplayName(), 2, SlimefunItems.ARMOR_FORGE);
        register("glowstone_armor", 7, SlimefunItems.GLOWSTONE_HELMET.getDisplayName(), 3, SlimefunItems.GLOWSTONE_HELMET, SlimefunItems.GLOWSTONE_CHESTPLATE, SlimefunItems.GLOWSTONE_LEGGINGS, SlimefunItems.GLOWSTONE_BOOTS);
        register("lumps", 8, SlimefunItems.MAGIC_LUMP_1.getDisplayName(), 3, SlimefunItems.MAGIC_LUMP_1, SlimefunItems.MAGIC_LUMP_2, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.ENDER_LUMP_1, SlimefunItems.ENDER_LUMP_2, SlimefunItems.ENDER_LUMP_3);
        register("ender_backpack", 9, SlimefunItems.ENDER_BACKPACK.getDisplayName(), 4, SlimefunItems.ENDER_BACKPACK);
        register("ender_armor", 10, SlimefunItems.ENDER_HELMET.getDisplayName(), 4, SlimefunItems.ENDER_HELMET, SlimefunItems.ENDER_CHESTPLATE, SlimefunItems.ENDER_LEGGINGS, SlimefunItems.ENDER_BOOTS);
        register("magic_eye_of_ender", 11, SlimefunItems.MAGIC_EYE_OF_ENDER.getDisplayName(), 4, SlimefunItems.MAGIC_EYE_OF_ENDER);
        register("magic_sugar", 12, SlimefunItems.MAGIC_SUGAR.getDisplayName(), 4, SlimefunItems.MAGIC_SUGAR);
        register("monster_jerky", 13, SlimefunItems.MONSTER_JERKY.getDisplayName(), 5, SlimefunItems.MONSTER_JERKY);
        register("slime_armor", 14, SlimefunItems.SLIME_HELMET.getDisplayName(), 5, SlimefunItems.SLIME_HELMET, SlimefunItems.SLIME_CHESTPLATE, SlimefunItems.SLIME_LEGGINGS, SlimefunItems.SLIME_BOOTS);
        register("sword_of_beheading", 15, SlimefunItems.SWORD_OF_BEHEADING.getDisplayName(), 6, SlimefunItems.SWORD_OF_BEHEADING);
        register("basic_circuit_board", 16, SlimefunItems.BASIC_CIRCUIT_BOARD.getDisplayName(), 8, SlimefunItems.BASIC_CIRCUIT_BOARD);
        register("advanced_circuit_board", 17, SlimefunItems.ADVANCED_CIRCUIT_BOARD.getDisplayName(), 9, SlimefunItems.ADVANCED_CIRCUIT_BOARD);
        register("smeltery", 18, SlimefunItems.SMELTERY.getDisplayName(), 10, SlimefunItems.SMELTERY);
        register("steel", 19, SlimefunItems.STEEL_INGOT.getDisplayName(), 11, SlimefunItems.STEEL_INGOT);
        register("misc_power_items", 20, SlimefunItems.SULFATE.getDisplayName(), 12, SlimefunItems.SULFATE, SlimefunItems.POWER_CRYSTAL);
        register("battery", 21, SlimefunItems.BATTERY.getDisplayName(), 10, SlimefunItems.BATTERY);
        register("steel_plate", 22, SlimefunItems.STEEL_PLATE.getDisplayName(), 14, SlimefunItems.STEEL_PLATE);
        register("steel_thruster", 23, SlimefunItems.STEEL_THRUSTER.getDisplayName(), 14, SlimefunItems.STEEL_THRUSTER);
        register("parachute", 24, SlimefunItems.PARACHUTE.getDisplayName(), 15, SlimefunItems.PARACHUTE);
        register("grappling_hook", 25, SlimefunItems.GRAPPLING_HOOK.getDisplayName(), 15, SlimefunItems.GRAPPLING_HOOK, SlimefunItems.HOOK, SlimefunItems.CHAIN);
        register("jetpacks", 26, SlimefunItems.DURALUMIN_JETPACK.getDisplayName(), 22, SlimefunItems.DURALUMIN_JETPACK, SlimefunItems.BILLON_JETPACK, SlimefunItems.SOLDER_JETPACK, SlimefunItems.STEEL_JETPACK, SlimefunItems.DAMASCUS_STEEL_JETPACK, SlimefunItems.REINFORCED_ALLOY_JETPACK);
        register("multitools", 27, SlimefunItems.DURALUMIN_MULTI_TOOL.getDisplayName(), 18, SlimefunItems.DURALUMIN_MULTI_TOOL, SlimefunItems.SOLDER_MULTI_TOOL, SlimefunItems.BILLON_MULTI_TOOL, SlimefunItems.STEEL_MULTI_TOOL, SlimefunItems.DAMASCUS_STEEL_MULTI_TOOL, SlimefunItems.REINFORCED_ALLOY_MULTI_TOOL);
        register("solar_panel_and_helmet", 28, SlimefunItems.SOLAR_PANEL.getDisplayName(), 17, SlimefunItems.SOLAR_PANEL, SlimefunItems.SOLAR_HELMET);
        register("elemental_staff", 29, SlimefunItems.STAFF_ELEMENTAL.getDisplayName(), 17, SlimefunItems.STAFF_ELEMENTAL);
        register("grind_stone", 30, SlimefunItems.GRIND_STONE.getDisplayName(), 4, SlimefunItems.GRIND_STONE);
        register("cactus_armor", 31, SlimefunItems.CACTUS_BOOTS.getDisplayName(), 5, SlimefunItems.CACTUS_BOOTS, SlimefunItems.CACTUS_CHESTPLATE, SlimefunItems.CACTUS_HELMET, SlimefunItems.CACTUS_LEGGINGS);
        register("gold_pan", 32, SlimefunItems.GOLD_PAN.getDisplayName(), 5, SlimefunItems.GOLD_PAN);
        register("magical_book_cover", 33, SlimefunItems.MAGICAL_BOOK_COVER.getDisplayName(), 5, SlimefunItems.MAGICAL_BOOK_COVER);
        register("slimefun_metals", 34, SlimefunItems.COPPER_INGOT.getDisplayName(), 6, SlimefunItems.COPPER_INGOT, SlimefunItems.TIN_INGOT, SlimefunItems.SILVER_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.ZINC_INGOT, SlimefunItems.MAGNESIUM_INGOT);
        register("ore_crusher", 35, SlimefunItems.ORE_CRUSHER.getDisplayName(), 6, SlimefunItems.ORE_CRUSHER);
        register("bronze", 36, SlimefunItems.BRONZE_INGOT.getDisplayName(), 8, SlimefunItems.BRONZE_INGOT);
        register("alloys", 37, SlimefunItems.BILLON_INGOT.getDisplayName(), 12, SlimefunItems.BILLON_INGOT, SlimefunItems.DURALUMIN_INGOT, SlimefunItems.ALUMINUM_BRASS_INGOT, SlimefunItems.ALUMINUM_BRONZE_INGOT, SlimefunItems.SOLDER_INGOT, SlimefunItems.CORINTHIAN_BRONZE_INGOT, SlimefunItems.BRASS_INGOT);
        register("compressor_and_carbon", 38, SlimefunItems.COMPRESSOR.getDisplayName(), 9, SlimefunItems.COMPRESSOR, SlimefunItems.CARBON);
        register("gilded_iron_armor", 40, SlimefunItems.GILDED_IRON_HELMET.getDisplayName(), 16, SlimefunItems.GILDED_IRON_HELMET, SlimefunItems.GILDED_IRON_CHESTPLATE, SlimefunItems.GILDED_IRON_LEGGINGS, SlimefunItems.GILDED_IRON_BOOTS);
        register("synthetic_diamond", 41, SlimefunItems.COMPRESSED_CARBON.getDisplayName(), 10, SlimefunItems.COMPRESSED_CARBON, SlimefunItems.CARBON_CHUNK, SlimefunItems.SYNTHETIC_DIAMOND);
        register("pressure_chamber", 42, SlimefunItems.PRESSURE_CHAMBER.getDisplayName(), 14, SlimefunItems.PRESSURE_CHAMBER);
        register("synthetic_sapphire", 43, SlimefunItems.SYNTHETIC_SAPPHIRE.getDisplayName(), 16, SlimefunItems.SYNTHETIC_SAPPHIRE);
        register("damascus_steel", 45, SlimefunItems.DAMASCUS_STEEL_INGOT.getDisplayName(), 17, SlimefunItems.DAMASCUS_STEEL_INGOT);
        register("damascus_steel_armor", 46, SlimefunItems.DAMASCUS_STEEL_HELMET.getDisplayName(), 18, SlimefunItems.DAMASCUS_STEEL_HELMET, SlimefunItems.DAMASCUS_STEEL_CHESTPLATE, SlimefunItems.DAMASCUS_STEEL_LEGGINGS, SlimefunItems.DAMASCUS_STEEL_BOOTS);
        register("reinforced_alloy", 47, SlimefunItems.HARDENED_METAL_INGOT.getDisplayName(), 22, SlimefunItems.HARDENED_METAL_INGOT, SlimefunItems.REINFORCED_ALLOY_INGOT);
        register("carbonado", 48, SlimefunItems.RAW_CARBONADO.getDisplayName(), 26, SlimefunItems.RAW_CARBONADO, SlimefunItems.CARBONADO);
        register("magic_workbench", 50, SlimefunItems.MAGIC_WORKBENCH.getDisplayName(), 12, SlimefunItems.MAGIC_WORKBENCH);
        register("wind_staff", 51, SlimefunItems.STAFF_WIND.getDisplayName(), 17, SlimefunItems.STAFF_WIND);
        register("reinforced_armor", 52, SlimefunItems.REINFORCED_ALLOY_HELMET.getDisplayName(), 26, SlimefunItems.REINFORCED_ALLOY_HELMET, SlimefunItems.REINFORCED_ALLOY_CHESTPLATE, SlimefunItems.REINFORCED_ALLOY_LEGGINGS, SlimefunItems.REINFORCED_ALLOY_BOOTS);
        register("ore_washer", 53, SlimefunItems.ORE_WASHER.getDisplayName(), 5, SlimefunItems.ORE_WASHER, SlimefunItems.STONE_CHUNK, SlimefunItems.SIFTED_ORE);
        register("gold_carats", 54, SlimefunItems.GOLD_4K.getDisplayName(), 7, SlimefunItems.GOLD_4K, SlimefunItems.GOLD_6K, SlimefunItems.GOLD_8K, SlimefunItems.GOLD_10K, SlimefunItems.GOLD_12K, SlimefunItems.GOLD_14K, SlimefunItems.GOLD_16K, SlimefunItems.GOLD_18K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_22K, SlimefunItems.GOLD_24K);
        register("silicon", 55, SlimefunItems.SILICON.getDisplayName(), 12, SlimefunItems.SILICON, SlimefunItems.FERROSILICON);
        register("fire_staff", 56, SlimefunItems.STAFF_FIRE.getDisplayName(), 2, SlimefunItems.STAFF_FIRE);
        register("smelters_pickaxe", 57, SlimefunItems.SMELTERS_PICKAXE.getDisplayName(), 17, SlimefunItems.SMELTERS_PICKAXE);
        register("common_talisman", 58, SlimefunItems.COMMON_TALISMAN.getDisplayName(), 14, SlimefunItems.COMMON_TALISMAN);
        register("anvil_talisman", 59, SlimefunItems.TALISMAN_ANVIL.getDisplayName(), 18, SlimefunItems.TALISMAN_ANVIL);
        register("miner_talisman", 60, SlimefunItems.TALISMAN_MINER.getDisplayName(), 18, SlimefunItems.TALISMAN_MINER);
        register("hunter_talisman", 61, SlimefunItems.TALISMAN_HUNTER.getDisplayName(), 18, SlimefunItems.TALISMAN_HUNTER);
        register("lava_talisman", 62, SlimefunItems.TALISMAN_LAVA.getDisplayName(), 18, SlimefunItems.TALISMAN_LAVA);
        register("water_talisman", 63, SlimefunItems.TALISMAN_WATER.getDisplayName(), 18, SlimefunItems.TALISMAN_WATER);
        register("angel_talisman", 64, SlimefunItems.TALISMAN_ANGEL.getDisplayName(), 18, SlimefunItems.TALISMAN_ANGEL);
        register("fire_talisman", 65, SlimefunItems.TALISMAN_FIRE.getDisplayName(), 18, SlimefunItems.TALISMAN_FIRE);
        register("lava_crystal", 67, SlimefunItems.LAVA_CRYSTAL.getDisplayName(), 14, SlimefunItems.LAVA_CRYSTAL);
        register("magician_talisman", 68, SlimefunItems.TALISMAN_MAGICIAN.getDisplayName(), 20, SlimefunItems.TALISMAN_MAGICIAN);
        register("traveller_talisman", 69, SlimefunItems.TALISMAN_TRAVELLER.getDisplayName(), 20, SlimefunItems.TALISMAN_TRAVELLER);
        register("warrior_talisman", 70, SlimefunItems.TALISMAN_WARRIOR.getDisplayName(), 20, SlimefunItems.TALISMAN_WARRIOR);
        register("knight_talisman", 71, SlimefunItems.TALISMAN_KNIGHT.getDisplayName(), 20, SlimefunItems.TALISMAN_KNIGHT);
        register("gilded_iron", 72, SlimefunItems.GILDED_IRON.getDisplayName(), 11, SlimefunItems.GILDED_IRON);
        register("synthetic_emerald", 73, SlimefunItems.SYNTHETIC_EMERALD.getDisplayName(), 17, SlimefunItems.SYNTHETIC_EMERALD);
        register("chainmail_armor", 74, "사슬 갑옷", 8, "CHAIN_HELMET", "CHAIN_CHESTPLATE", "CHAIN_LEGGINGS", "CHAIN_BOOTS");
        register("whirlwind_talisman", 75, SlimefunItems.TALISMAN_WHIRLWIND.getDisplayName(), 19, SlimefunItems.TALISMAN_WHIRLWIND);
        register("wizard_talisman", 76, SlimefunItems.TALISMAN_WIZARD.getDisplayName(), 22, SlimefunItems.TALISMAN_WIZARD);
        register("lumber_axe", 77, SlimefunItems.LUMBER_AXE.getDisplayName(), 21, SlimefunItems.LUMBER_AXE);
        register("hazmat_suit", 79, SlimefunItems.SCUBA_HELMET.getDisplayName(), 21, SlimefunItems.SCUBA_HELMET, SlimefunItems.HAZMAT_CHESTPLATE, SlimefunItems.HAZMAT_LEGGINGS, SlimefunItems.HAZMAT_BOOTS);
        register("uranium", 80, SlimefunItems.TINY_URANIUM.getDisplayName(), 30, SlimefunItems.TINY_URANIUM, SlimefunItems.SMALL_URANIUM, SlimefunItems.URANIUM);
        register("crushed_ore", 81, SlimefunItems.CRUSHED_ORE.getDisplayName(), 25, SlimefunItems.CRUSHED_ORE, SlimefunItems.PULVERIZED_ORE, SlimefunItems.PURE_ORE_CLUSTER);
        register("redstone_alloy", 84, SlimefunItems.REDSTONE_ALLOY.getDisplayName(), 16, SlimefunItems.REDSTONE_ALLOY);
        register("carbonado_tools", 85, SlimefunItems.CARBONADO_MULTI_TOOL.getDisplayName(), 24, SlimefunItems.CARBONADO_MULTI_TOOL, SlimefunItems.CARBONADO_JETPACK, SlimefunItems.CARBONADO_JETBOOTS);
        register("first_aid", 86, SlimefunItems.CLOTH.getDisplayName(), 2, SlimefunItems.CLOTH, SlimefunItems.RAG, SlimefunItems.BANDAGE, SlimefunItems.SPLINT, SlimefunItems.TIN_CAN, SlimefunItems.VITAMINS, SlimefunItems.MEDICINE);
        register("gold_armor", 87, SlimefunItems.GOLDEN_HELMET_12K.getDisplayName(), 13, SlimefunItems.GOLDEN_HELMET_12K, SlimefunItems.GOLDEN_CHESTPLATE_12K, SlimefunItems.GOLDEN_LEGGINGS_12K, SlimefunItems.GOLDEN_BOOTS_12K);
        register("night_vision_googles", 89, SlimefunItems.NIGHT_VISION_GOGGLES.getDisplayName(), 10, SlimefunItems.NIGHT_VISION_GOGGLES);
        register("pickaxe_of_containment", 90, SlimefunItems.PICKAXE_OF_CONTAINMENT.getDisplayName(), 14, SlimefunItems.PICKAXE_OF_CONTAINMENT, SlimefunItems.BROKEN_SPAWNER);
        register("table_saw", 92, SlimefunItems.TABLE_SAW.getDisplayName(), 4, SlimefunItems.TABLE_SAW);
        register("slime_steel_armor", 93, SlimefunItems.SLIME_HELMET_STEEL.getDisplayName(), 27, SlimefunItems.SLIME_HELMET_STEEL, SlimefunItems.SLIME_CHESTPLATE_STEEL, SlimefunItems.SLIME_LEGGINGS_STEEL, SlimefunItems.SLIME_BOOTS_STEEL);
        register("blade_of_vampires", 94, SlimefunItems.BLADE_OF_VAMPIRES.getDisplayName(), 26, SlimefunItems.BLADE_OF_VAMPIRES);
        register("water_staff", 96, SlimefunItems.STAFF_WATER.getDisplayName(), 8, SlimefunItems.STAFF_WATER);
        register("24k_gold_block", 97, SlimefunItems.GOLD_24K_BLOCK.getDisplayName(), 19, SlimefunItems.GOLD_24K_BLOCK);
        register("composter", 99, SlimefunItems.COMPOSTER.getDisplayName(), 3, SlimefunItems.COMPOSTER);
        register("farmer_shoes", 100, SlimefunItems.FARMER_SHOES.getDisplayName(), 4, SlimefunItems.FARMER_SHOES);
        register("explosive_tools", 101, SlimefunItems.EXPLOSIVE_PICKAXE.getDisplayName(), 30, SlimefunItems.EXPLOSIVE_PICKAXE, SlimefunItems.EXPLOSIVE_SHOVEL);
        register("automated_panning_machine", 102, SlimefunItems.AUTOMATED_PANNING_MACHINE.getDisplayName(), 17, SlimefunItems.AUTOMATED_PANNING_MACHINE);
        register("boots_of_the_stomper", 103, SlimefunItems.BOOTS_OF_THE_STOMPER.getDisplayName(), 19, SlimefunItems.BOOTS_OF_THE_STOMPER);
        register("pickaxe_of_the_seeker", 104, SlimefunItems.PICKAXE_OF_THE_SEEKER.getDisplayName(), 19, SlimefunItems.PICKAXE_OF_THE_SEEKER);
        register("backpacks", 105, SlimefunItems.BACKPACK_LARGE.getDisplayName(), 15, SlimefunItems.BACKPACK_LARGE, SlimefunItems.BACKPACK_MEDIUM, SlimefunItems.BACKPACK_SMALL);
        register("woven_backpack", 106, SlimefunItems.WOVEN_BACKPACK.getDisplayName(), 19, SlimefunItems.WOVEN_BACKPACK);
        register("crucible", 107, SlimefunItems.CRUCIBLE.getDisplayName(), 13, SlimefunItems.CRUCIBLE);
        register("gilded_backpack", 108, SlimefunItems.GILDED_BACKPACK.getDisplayName(), 22, SlimefunItems.GILDED_BACKPACK);
        register("armored_jetpack", 111, SlimefunItems.ARMORED_JETPACK.getDisplayName(), 27, SlimefunItems.ARMORED_JETPACK);
        register("ender_talismans", 112, SlimefunItems.ENDER_TALISMAN.getDisplayName(), 28, SlimefunItems.ENDER_TALISMAN);
        register("nickel_and_cobalt", 115, SlimefunItems.NICKEL_INGOT.getDisplayName(), 10, SlimefunItems.NICKEL_INGOT, SlimefunItems.COBALT_INGOT);
        register("magnet", 116, SlimefunItems.MAGNET.getDisplayName(), 16, SlimefunItems.MAGNET);
        register("infused_magnet", 117, SlimefunItems.INFUSED_MAGNET.getDisplayName(), 18, SlimefunItems.INFUSED_MAGNET);
        register("cobalt_pickaxe", 118, SlimefunItems.COBALT_PICKAXE.getDisplayName(), 14, SlimefunItems.COBALT_PICKAXE);
        register("essence_of_afterlife", 119, SlimefunItems.NECROTIC_SKULL.getDisplayName(), 19, SlimefunItems.NECROTIC_SKULL, SlimefunItems.ESSENCE_OF_AFTERLIFE);
        register("bound_backpack", 120, SlimefunItems.BOUND_BACKPACK.getDisplayName(), 22, SlimefunItems.BOUND_BACKPACK);
        register("jetboots", 121, SlimefunItems.DURALUMIN_JETBOOTS.getDisplayName(), 25, SlimefunItems.DURALUMIN_JETBOOTS, SlimefunItems.BILLON_JETBOOTS, SlimefunItems.SOLDER_JETBOOTS, SlimefunItems.STEEL_JETBOOTS, SlimefunItems.DAMASCUS_STEEL_JETBOOTS, SlimefunItems.REINFORCED_ALLOY_JETBOOTS);
        register("armored_jetboots", 122, SlimefunItems.ARMORED_JETBOOTS.getDisplayName(), 27, SlimefunItems.ARMORED_JETBOOTS);
        register("seismic_axe", 123, SlimefunItems.SEISMIC_AXE.getDisplayName(), 29, SlimefunItems.SEISMIC_AXE);
        register("pickaxe_of_vein_mining", 124, SlimefunItems.PICKAXE_OF_VEIN_MINING.getDisplayName(), 29, SlimefunItems.PICKAXE_OF_VEIN_MINING);
        register("bound_weapons", 125, SlimefunItems.SOULBOUND_SWORD.getDisplayName(), 29, SlimefunItems.SOULBOUND_SWORD, SlimefunItems.SOULBOUND_BOW, SlimefunItems.SOULBOUND_TRIDENT);
        register("bound_tools", 126, SlimefunItems.SOULBOUND_PICKAXE.getDisplayName(), 29, SlimefunItems.SOULBOUND_PICKAXE, SlimefunItems.SOULBOUND_AXE, SlimefunItems.SOULBOUND_SHOVEL, SlimefunItems.SOULBOUND_HOE);
        register("bound_armor", 127, SlimefunItems.SOULBOUND_HELMET.getDisplayName(), 29, SlimefunItems.SOULBOUND_HELMET, SlimefunItems.SOULBOUND_CHESTPLATE, SlimefunItems.SOULBOUND_LEGGINGS, SlimefunItems.SOULBOUND_BOOTS);
        register("juicer", 129, SlimefunItems.JUICER.getDisplayName(), 29, SlimefunItems.JUICER, SlimefunItems.APPLE_JUICE, SlimefunItems.MELON_JUICE, SlimefunItems.CARROT_JUICE, SlimefunItems.PUMPKIN_JUICE, SlimefunItems.SWEET_BERRY_JUICE, SlimefunItems.GLOW_BERRY_JUICE);
        register("repaired_spawner", 130, SlimefunItems.REPAIRED_SPAWNER.getDisplayName(), 15, SlimefunItems.REPAIRED_SPAWNER);
        register("enhanced_furnace", 132, SlimefunItems.ENHANCED_FURNACE.getDisplayName(), 7, SlimefunItems.ENHANCED_FURNACE, SlimefunItems.ENHANCED_FURNACE_2);
        register("more_enhanced_furnaces", 133, SlimefunItems.ENHANCED_FURNACE_3.getDisplayName(), 18, SlimefunItems.ENHANCED_FURNACE_3, SlimefunItems.ENHANCED_FURNACE_4, SlimefunItems.ENHANCED_FURNACE_5, SlimefunItems.ENHANCED_FURNACE_6, SlimefunItems.ENHANCED_FURNACE_7);
        register("high_tier_enhanced_furnaces", 134, SlimefunItems.ENHANCED_FURNACE_8.getDisplayName(), 29, SlimefunItems.ENHANCED_FURNACE_8, SlimefunItems.ENHANCED_FURNACE_9, SlimefunItems.ENHANCED_FURNACE_10, SlimefunItems.ENHANCED_FURNACE_11);
        register("reinforced_furnace", 135, SlimefunItems.REINFORCED_FURNACE.getDisplayName(), 32, SlimefunItems.REINFORCED_FURNACE);
        register("carbonado_furnace", 136, SlimefunItems.CARBONADO_EDGED_FURNACE.getDisplayName(), 35, SlimefunItems.CARBONADO_EDGED_FURNACE);
        register("electric_motor", 137, SlimefunItems.ELECTRO_MAGNET.getDisplayName(), 32, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.HEATING_COIL);
        register("block_placer", 138, SlimefunItems.BLOCK_PLACER.getDisplayName(), 17, SlimefunItems.BLOCK_PLACER);
        register("scroll_of_dimensional_teleposition", 142, SlimefunItems.SCROLL_OF_DIMENSIONAL_TELEPOSITION.getDisplayName(), 38, SlimefunItems.SCROLL_OF_DIMENSIONAL_TELEPOSITION);
        register("special_bows", 143, SlimefunItems.EXPLOSIVE_BOW.getDisplayName(), 22, SlimefunItems.EXPLOSIVE_BOW, SlimefunItems.ICY_BOW);
        register("tome_of_knowledge_sharing", 144, SlimefunItems.TOME_OF_KNOWLEDGE_SHARING.getDisplayName(), 30, SlimefunItems.TOME_OF_KNOWLEDGE_SHARING);
        register("flask_of_knowledge", 145, SlimefunItems.FLASK_OF_KNOWLEDGE.getDisplayName(), 13, SlimefunItems.FLASK_OF_KNOWLEDGE);
        register("hardened_glass", 146, SlimefunItems.REINFORCED_PLATE.getDisplayName(), 15, SlimefunItems.REINFORCED_PLATE, SlimefunItems.HARDENED_GLASS);
        register("golden_apple_juice", 149, SlimefunItems.GOLDEN_APPLE_JUICE.getDisplayName(), 24, SlimefunItems.GOLDEN_APPLE_JUICE);
        register("cooler", 150, SlimefunItems.COOLING_UNIT.getDisplayName(), 24, SlimefunItems.COOLING_UNIT, SlimefunItems.COOLER);
        register("ancient_altar", 151, SlimefunItems.ANCIENT_PEDESTAL.getDisplayName(), 15, SlimefunItems.ANCIENT_PEDESTAL, SlimefunItems.ANCIENT_ALTAR);
        register("wither_proof_obsidian", 152, SlimefunItems.WITHER_PROOF_OBSIDIAN.getDisplayName(), 21, SlimefunItems.WITHER_PROOF_OBSIDIAN);
        register("ancient_runes", 155, SlimefunItems.BLANK_RUNE.getDisplayName(), 15, SlimefunItems.BLANK_RUNE, SlimefunItems.EARTH_RUNE, SlimefunItems.WATER_RUNE, SlimefunItems.AIR_RUNE, SlimefunItems.FIRE_RUNE);
        register("special_runes", 156, SlimefunItems.ENDER_RUNE.getDisplayName(), 18, SlimefunItems.ENDER_RUNE, SlimefunItems.RAINBOW_RUNE);
        register("infernal_bonemeal", 157, SlimefunItems.INFERNAL_BONEMEAL.getDisplayName(), 12, SlimefunItems.INFERNAL_BONEMEAL);
        register("rainbow_blocks", 158, SlimefunItems.RAINBOW_CLAY.getDisplayName(), 24, SlimefunItems.RAINBOW_CLAY, SlimefunItems.RAINBOW_GLASS, SlimefunItems.RAINBOW_GLASS_PANE, SlimefunItems.RAINBOW_WOOL, SlimefunItems.RAINBOW_CONCRETE, SlimefunItems.RAINBOW_GLAZED_TERRACOTTA);
        register("infused_hopper", 159, SlimefunItems.INFUSED_HOPPER.getDisplayName(), 22, SlimefunItems.INFUSED_HOPPER);
        register("wither_proof_glass", 160, SlimefunItems.WITHER_PROOF_GLASS.getDisplayName(), 20, SlimefunItems.WITHER_PROOF_GLASS);
        register("duct_tape", 161, SlimefunItems.DUCT_TAPE.getDisplayName(), 14, SlimefunItems.DUCT_TAPE);
        register("plastic_sheet", 162, SlimefunItems.PLASTIC_SHEET.getDisplayName(), 25, SlimefunItems.PLASTIC_SHEET);
        register("android_memory_core", 163, SlimefunItems.ANDROID_MEMORY_CORE.getDisplayName(), 28, SlimefunItems.ANDROID_MEMORY_CORE);
        register("oil", 164, SlimefunItems.OIL_BUCKET.getDisplayName(), 30, SlimefunItems.OIL_BUCKET, SlimefunItems.OIL_PUMP);
        register("fuel", 165, SlimefunItems.FUEL_BUCKET.getDisplayName(), 30, SlimefunItems.FUEL_BUCKET, SlimefunItems.REFINERY);
        register("hologram_projector", 166, SlimefunItems.HOLOGRAM_PROJECTOR.getDisplayName(), 36, SlimefunItems.HOLOGRAM_PROJECTOR);
        register("capacitors", 167, SlimefunItems.SMALL_CAPACITOR.getDisplayName(), 25, SlimefunItems.SMALL_CAPACITOR, SlimefunItems.MEDIUM_CAPACITOR, SlimefunItems.BIG_CAPACITOR);
        register("high_tier_capacitors", 168, SlimefunItems.LARGE_CAPACITOR.getDisplayName(), 32, SlimefunItems.LARGE_CAPACITOR, SlimefunItems.CARBONADO_EDGED_CAPACITOR);
        register("solar_generators", 169, SlimefunItems.SOLAR_GENERATOR.getDisplayName(), 14, SlimefunItems.SOLAR_GENERATOR);
        register("electric_furnaces", 170, SlimefunItems.ELECTRIC_FURNACE.getDisplayName(), 15, SlimefunItems.ELECTRIC_FURNACE);
        register("electric_ore_grinding", 171, SlimefunItems.ELECTRIC_ORE_GRINDER.getDisplayName(), 20, SlimefunItems.ELECTRIC_ORE_GRINDER, SlimefunItems.ELECTRIC_INGOT_PULVERIZER);
        register("heated_pressure_chamber", 172, SlimefunItems.HEATED_PRESSURE_CHAMBER.getDisplayName(), 22, SlimefunItems.HEATED_PRESSURE_CHAMBER);
        register("coal_generator", 173, SlimefunItems.COAL_GENERATOR.getDisplayName(), 14, SlimefunItems.COAL_GENERATOR);
        register("bio_reactor", 173, SlimefunItems.BIO_REACTOR.getDisplayName(), 18, SlimefunItems.BIO_REACTOR);
        register("auto_enchanting", 174, SlimefunItems.AUTO_ENCHANTER.getDisplayName(), 24, SlimefunItems.AUTO_ENCHANTER, SlimefunItems.AUTO_DISENCHANTER);
        register("auto_anvil", 175, SlimefunItems.AUTO_ANVIL.getDisplayName(), 34, SlimefunItems.AUTO_ANVIL, SlimefunItems.AUTO_ANVIL_2);
        register("multimeter", 176, SlimefunItems.MULTIMETER.getDisplayName(), 10, SlimefunItems.MULTIMETER);
        register("gps_setup", 177, SlimefunItems.GPS_TRANSMITTER.getDisplayName(), 28, SlimefunItems.GPS_TRANSMITTER, SlimefunItems.GPS_CONTROL_PANEL, SlimefunItems.GPS_MARKER_TOOL);
        register("gps_emergency_transmitter", 178, SlimefunItems.GPS_EMERGENCY_TRANSMITTER.getDisplayName(), 30, SlimefunItems.GPS_EMERGENCY_TRANSMITTER);
        register("programmable_androids", 179, SlimefunItems.PROGRAMMABLE_ANDROID.getDisplayName(), 50, SlimefunItems.PROGRAMMABLE_ANDROID, SlimefunItems.PROGRAMMABLE_ANDROID_FARMER, SlimefunItems.PROGRAMMABLE_ANDROID_BUTCHER, SlimefunItems.PROGRAMMABLE_ANDROID_FISHERMAN, SlimefunItems.PROGRAMMABLE_ANDROID_MINER, SlimefunItems.PROGRAMMABLE_ANDROID_WOODCUTTER);
        register("android_interfaces", 180, SlimefunItems.ANDROID_INTERFACE_FUEL.getDisplayName(), 26, SlimefunItems.ANDROID_INTERFACE_FUEL, SlimefunItems.ANDROID_INTERFACE_ITEMS);
        register("geo_scanner", 181, SlimefunItems.GPS_GEO_SCANNER.getDisplayName(), 30, SlimefunItems.GPS_GEO_SCANNER, SlimefunItems.PORTABLE_GEO_SCANNER);
        register("combustion_reactor", 182, SlimefunItems.COMBUSTION_REACTOR.getDisplayName(), 38, SlimefunItems.COMBUSTION_REACTOR);
        register("teleporter", 183, SlimefunItems.GPS_TELEPORTATION_MATRIX.getDisplayName(), 42, SlimefunItems.GPS_TELEPORTATION_MATRIX, SlimefunItems.GPS_TELEPORTER_PYLON);
        register("teleporter_activation_plates", 184, SlimefunItems.GPS_ACTIVATION_DEVICE_PERSONAL.getDisplayName(), 36, SlimefunItems.GPS_ACTIVATION_DEVICE_PERSONAL, SlimefunItems.GPS_ACTIVATION_DEVICE_SHARED);
        register("better_solar_generators", 185, SlimefunItems.SOLAR_GENERATOR_2.getDisplayName(), 28, SlimefunItems.SOLAR_GENERATOR_2, SlimefunItems.SOLAR_GENERATOR_3);
        register("better_gps_transmitters", 186, SlimefunItems.GPS_TRANSMITTER_2.getDisplayName(), 36, SlimefunItems.GPS_TRANSMITTER_2, SlimefunItems.GPS_TRANSMITTER_3);
        register("elevator", 187, SlimefunItems.ELEVATOR_PLATE.getDisplayName(), 28, SlimefunItems.ELEVATOR_PLATE);
        register("energized_solar_generator", 188, SlimefunItems.SOLAR_GENERATOR_4.getDisplayName(), 44, SlimefunItems.SOLAR_GENERATOR_4);
        register("energized_gps_transmitter", 189, SlimefunItems.GPS_TRANSMITTER_4.getDisplayName(), 44, SlimefunItems.GPS_TRANSMITTER_4);
        register("energy_regulator", 190, SlimefunItems.ENERGY_REGULATOR.getDisplayName(), 6, SlimefunItems.ENERGY_REGULATOR);
        register("butcher_androids", 191, SlimefunItems.PROGRAMMABLE_ANDROID_BUTCHER.getDisplayName(), 32, SlimefunItems.PROGRAMMABLE_ANDROID_BUTCHER);
        register("organic_food", 192, SlimefunItems.FOOD_FABRICATOR.getDisplayName(), 25, SlimefunItems.FOOD_FABRICATOR, SlimefunItems.WHEAT_ORGANIC_FOOD, SlimefunItems.CARROT_ORGANIC_FOOD, SlimefunItems.POTATO_ORGANIC_FOOD, SlimefunItems.SEEDS_ORGANIC_FOOD, SlimefunItems.BEETROOT_ORGANIC_FOOD, SlimefunItems.MELON_ORGANIC_FOOD, SlimefunItems.APPLE_ORGANIC_FOOD, SlimefunItems.SWEET_BERRIES_ORGANIC_FOOD, SlimefunItems.KELP_ORGANIC_FOOD, SlimefunItems.COCOA_ORGANIC_FOOD, SlimefunItems.SEAGRASS_ORGANIC_FOOD);
        register("auto_breeder", 193, SlimefunItems.AUTO_BREEDER.getDisplayName(), 25, SlimefunItems.AUTO_BREEDER);
        register("advanced_android", 194, SlimefunItems.PROGRAMMABLE_ANDROID_2.getDisplayName(), 60, SlimefunItems.PROGRAMMABLE_ANDROID_2);
        register("advanced_butcher_android", 195, SlimefunItems.PROGRAMMABLE_ANDROID_2_BUTCHER.getDisplayName(), 30, SlimefunItems.PROGRAMMABLE_ANDROID_2_BUTCHER);
        register("advanced_fisherman_android", 196, SlimefunItems.PROGRAMMABLE_ANDROID_2_FISHERMAN.getDisplayName(), 30, SlimefunItems.PROGRAMMABLE_ANDROID_2_FISHERMAN);
        register("animal_growth_accelerator", 197, SlimefunItems.ANIMAL_GROWTH_ACCELERATOR.getDisplayName(), 32, SlimefunItems.ANIMAL_GROWTH_ACCELERATOR);
        register("xp_collector", 198, SlimefunItems.EXP_COLLECTOR.getDisplayName(), 36, SlimefunItems.EXP_COLLECTOR);
        register("organic_fertilizer", 199, SlimefunItems.FOOD_COMPOSTER.getDisplayName(), 36, SlimefunItems.FOOD_COMPOSTER, SlimefunItems.WHEAT_FERTILIZER, SlimefunItems.CARROT_FERTILIZER, SlimefunItems.POTATO_FERTILIZER, SlimefunItems.SEEDS_FERTILIZER, SlimefunItems.BEETROOT_FERTILIZER, SlimefunItems.MELON_FERTILIZER, SlimefunItems.APPLE_FERTILIZER, SlimefunItems.SWEET_BERRIES_FERTILIZER, SlimefunItems.KELP_FERTILIZER, SlimefunItems.COCOA_FERTILIZER, SlimefunItems.SEAGRASS_FERTILIZER);
        register("crop_growth_accelerator", 200, SlimefunItems.CROP_GROWTH_ACCELERATOR.getDisplayName(), 40, SlimefunItems.CROP_GROWTH_ACCELERATOR);
        register("better_crop_growth_accelerator", 201, SlimefunItems.CROP_GROWTH_ACCELERATOR_2.getDisplayName(), 44, SlimefunItems.CROP_GROWTH_ACCELERATOR_2);
        register("reactor_essentials", 202, SlimefunItems.REACTOR_COOLANT_CELL.getDisplayName(), 36, SlimefunItems.REACTOR_COOLANT_CELL, SlimefunItems.NEPTUNIUM, SlimefunItems.PLUTONIUM);
        register("nuclear_reactor", 203, SlimefunItems.NUCLEAR_REACTOR.getDisplayName(), 48, SlimefunItems.NUCLEAR_REACTOR);
        register("freezer", 204, SlimefunItems.FREEZER.getDisplayName(), 20, SlimefunItems.FREEZER);
        register("cargo_basics", 205, SlimefunItems.CARGO_MOTOR.getDisplayName(), 30, SlimefunItems.CARGO_MOTOR, SlimefunItems.CARGO_MANAGER, SlimefunItems.CARGO_CONNECTOR_NODE);
        register("cargo_nodes", 206, SlimefunItems.CARGO_INPUT_NODE.getDisplayName(), 30, SlimefunItems.CARGO_INPUT_NODE, SlimefunItems.CARGO_OUTPUT_NODE);
        register("electric_ingot_machines", 207, SlimefunItems.ELECTRIC_GOLD_PAN.getDisplayName(), 18, SlimefunItems.ELECTRIC_GOLD_PAN, SlimefunItems.ELECTRIC_DUST_WASHER, SlimefunItems.ELECTRIC_INGOT_FACTORY);
        register("medium_tier_electric_ingot_machines", 208, SlimefunItems.ELECTRIC_GOLD_PAN_2.getDisplayName(), 25, SlimefunItems.ELECTRIC_GOLD_PAN_2, SlimefunItems.ELECTRIC_DUST_WASHER_2, SlimefunItems.ELECTRIC_INGOT_FACTORY_2, SlimefunItems.ELECTRIC_ORE_GRINDER_2);
        register("high_tier_electric_ingot_machines", 209, SlimefunItems.ELECTRIC_GOLD_PAN_3.getDisplayName(), 32, SlimefunItems.ELECTRIC_GOLD_PAN_3, SlimefunItems.ELECTRIC_DUST_WASHER_3, SlimefunItems.ELECTRIC_INGOT_FACTORY_3, SlimefunItems.ELECTRIC_ORE_GRINDER_3);
        register("better_food_fabricator", 211, SlimefunItems.FOOD_FABRICATOR_2.getDisplayName(), 28, SlimefunItems.FOOD_FABRICATOR_2, SlimefunItems.FOOD_COMPOSTER_2);
        register("reactor_access_port", 212, SlimefunItems.REACTOR_ACCESS_PORT.getDisplayName(), 18, SlimefunItems.REACTOR_ACCESS_PORT);
        register("fluid_pump", 213, SlimefunItems.FLUID_PUMP.getDisplayName(), 28, SlimefunItems.FLUID_PUMP);
        register("better_freezer", 214, SlimefunItems.FREEZER_2.getDisplayName(), 29, SlimefunItems.FREEZER_2, SlimefunItems.FREEZER_3);
        register("boosted_uranium", 215, SlimefunItems.BOOSTED_URANIUM.getDisplayName(), 30, SlimefunItems.BOOSTED_URANIUM);
        register("trash_can", 216, SlimefunItems.TRASH_CAN.getDisplayName(), 8, SlimefunItems.TRASH_CAN);
        register("advanced_output_node", 217, SlimefunItems.CARGO_OUTPUT_NODE_2.getDisplayName(), 24, SlimefunItems.CARGO_OUTPUT_NODE_2);
        register("carbon_press", 218, SlimefunItems.CARBON_PRESS.getDisplayName(), 28, SlimefunItems.CARBON_PRESS);
        register("electric_smeltery", 219, SlimefunItems.ELECTRIC_SMELTERY.getDisplayName(), 28, SlimefunItems.ELECTRIC_SMELTERY);
        register("better_electric_furnace", 220, SlimefunItems.ELECTRIC_FURNACE_2.getDisplayName(), 20, SlimefunItems.ELECTRIC_FURNACE_2, SlimefunItems.ELECTRIC_FURNACE_3);
        register("better_carbon_press", 221, SlimefunItems.CARBON_PRESS_2.getDisplayName(), 26, SlimefunItems.CARBON_PRESS_2);
        register("empowered_android", 222, SlimefunItems.PROGRAMMABLE_ANDROID_3.getDisplayName(), 60, SlimefunItems.PROGRAMMABLE_ANDROID_3);
        register("empowered_butcher_android", 223, SlimefunItems.PROGRAMMABLE_ANDROID_3_BUTCHER.getDisplayName(), 30, SlimefunItems.PROGRAMMABLE_ANDROID_3_BUTCHER);
        register("empowered_fisherman_android", 224, SlimefunItems.PROGRAMMABLE_ANDROID_3_FISHERMAN.getDisplayName(), 30, SlimefunItems.PROGRAMMABLE_ANDROID_3_FISHERMAN);
        register("high_tier_carbon_press", 225, SlimefunItems.CARBON_PRESS_3.getDisplayName(), 32, SlimefunItems.CARBON_PRESS_3);
        register("wither_assembler", 226, SlimefunItems.WITHER_ASSEMBLER.getDisplayName(), 35, SlimefunItems.WITHER_ASSEMBLER);
        register("better_heated_pressure_chamber", 227, SlimefunItems.HEATED_PRESSURE_CHAMBER_2.getDisplayName(), 20, SlimefunItems.HEATED_PRESSURE_CHAMBER_2);
        register("elytra", 228, "겉날개", 20, "ELYTRA_SCALE", "ELYTRA");
        register("special_elytras", 229, SlimefunItems.INFUSED_ELYTRA.getDisplayName(), 30, SlimefunItems.INFUSED_ELYTRA, SlimefunItems.SOULBOUND_ELYTRA);
        register("electric_crucible", 230, SlimefunItems.ELECTRIFIED_CRUCIBLE.getDisplayName(), 26, SlimefunItems.ELECTRIFIED_CRUCIBLE);
        register("better_electric_crucibles", 231, SlimefunItems.ELECTRIFIED_CRUCIBLE_2.getDisplayName(), 30, SlimefunItems.ELECTRIFIED_CRUCIBLE_2, SlimefunItems.ELECTRIFIED_CRUCIBLE_3);
        register("advanced_electric_smeltery", 232, SlimefunItems.ELECTRIC_SMELTERY_2.getDisplayName(), 28, SlimefunItems.ELECTRIC_SMELTERY_2);
        register("advanced_farmer_android", 233, SlimefunItems.PROGRAMMABLE_ANDROID_2_FARMER.getDisplayName(), 30, SlimefunItems.PROGRAMMABLE_ANDROID_2_FARMER);
        register("lava_generator", 234, SlimefunItems.LAVA_GENERATOR.getDisplayName(), 16, SlimefunItems.LAVA_GENERATOR);
        register("nether_ice", 235, SlimefunItems.NETHER_ICE.getDisplayName(), 45, SlimefunItems.NETHER_ICE, SlimefunItems.ENRICHED_NETHER_ICE, SlimefunItems.NETHER_ICE_COOLANT_CELL);
        register("nether_star_reactor", 236, SlimefunItems.NETHER_STAR_REACTOR.getDisplayName(), 60, SlimefunItems.NETHER_STAR_REACTOR);
        register("blistering_ingots", 237, SlimefunItems.BLISTERING_INGOT.getDisplayName(), 38, SlimefunItems.BLISTERING_INGOT, SlimefunItems.BLISTERING_INGOT_2, SlimefunItems.BLISTERING_INGOT_3);
        register("automatic_ignition_chamber", 239, SlimefunItems.IGNITION_CHAMBER.getDisplayName(), 12, SlimefunItems.IGNITION_CHAMBER);
        register("output_chest", 240, SlimefunItems.OUTPUT_CHEST.getDisplayName(), 20, SlimefunItems.OUTPUT_CHEST);
        register("copper_wire", 241, SlimefunItems.COPPER_WIRE.getDisplayName(), 15, SlimefunItems.COPPER_WIRE);
        register("radiant_backpack", 242, SlimefunItems.RADIANT_BACKPACK.getDisplayName(), 25, SlimefunItems.RADIANT_BACKPACK);
        register("auto_drier", 243, SlimefunItems.AUTO_DRIER.getDisplayName(), 15, SlimefunItems.AUTO_DRIER);
        register("diet_cookie", 244, SlimefunItems.DIET_COOKIE.getDisplayName(), 3, SlimefunItems.DIET_COOKIE);
        register("storm_staff", 245, SlimefunItems.STAFF_STORM.getDisplayName(), 30, SlimefunItems.STAFF_STORM);
        register("soulbound_rune", 246, SlimefunItems.SOULBOUND_RUNE.getDisplayName(), 60, SlimefunItems.SOULBOUND_RUNE);
        register("geo_miner", 247, SlimefunItems.GEO_MINER.getDisplayName(), 24, SlimefunItems.GEO_MINER);
        register("lightning_rune", 248, SlimefunItems.LIGHTNING_RUNE.getDisplayName(), 24, SlimefunItems.LIGHTNING_RUNE);
        register("totem_of_undying", 249, "불사의 토템", 36, "TOTEM_OF_UNDYING");
        register("charging_bench", 250, SlimefunItems.CHARGING_BENCH.getDisplayName(), 8, SlimefunItems.CHARGING_BENCH);
        register("nether_gold_pan", 251, SlimefunItems.NETHER_GOLD_PAN.getDisplayName(), 8, SlimefunItems.NETHER_GOLD_PAN);
        register("electric_press", 252, SlimefunItems.ELECTRIC_PRESS.getDisplayName(), 16, SlimefunItems.ELECTRIC_PRESS, SlimefunItems.ELECTRIC_PRESS_2);
        register("magnesium_generator", 253, SlimefunItems.MAGNESIUM_SALT.getDisplayName(), 20, SlimefunItems.MAGNESIUM_SALT, SlimefunItems.MAGNESIUM_GENERATOR);
        register("kelp_cookie", 254, SlimefunItems.KELP_COOKIE.getDisplayName(), 4, SlimefunItems.KELP_COOKIE);
        register("makeshift_smeltery", 255, SlimefunItems.MAKESHIFT_SMELTERY.getDisplayName(), 6, SlimefunItems.MAKESHIFT_SMELTERY);
        register("tree_growth_accelerator", 256, SlimefunItems.TREE_GROWTH_ACCELERATOR.getDisplayName(), 18, SlimefunItems.TREE_GROWTH_ACCELERATOR);
        register("industrial_miner", 95, SlimefunItems.INDUSTRIAL_MINER.getDisplayName(), 28, SlimefunItems.INDUSTRIAL_MINER);
        register("advanced_industrial_miner", 98, SlimefunItems.ADVANCED_INDUSTRIAL_MINER.getDisplayName(), 36, SlimefunItems.ADVANCED_INDUSTRIAL_MINER);
        register("magical_zombie_pills", 257, SlimefunItems.MAGICAL_ZOMBIE_PILLS.getDisplayName(), 22, SlimefunItems.MAGICAL_ZOMBIE_PILLS);
        register("auto_brewer", 258, SlimefunItems.AUTO_BREWER.getDisplayName(), 30, SlimefunItems.AUTO_BREWER);
        register("enchantment_rune", 259, SlimefunItems.MAGICAL_GLASS.getDisplayName(), 24, SlimefunItems.MAGICAL_GLASS, SlimefunItems.ENCHANTMENT_RUNE);
        register("lead_clothing", 260, SlimefunItems.REINFORCED_CLOTH.getDisplayName(), 14, SlimefunItems.REINFORCED_CLOTH);
        register("tape_measure", 261, SlimefunItems.TAPE_MEASURE.getDisplayName(), 7, SlimefunItems.TAPE_MEASURE);
        register("iron_golem_assembler", 262, SlimefunItems.IRON_GOLEM_ASSEMBLER.getDisplayName(), 30, SlimefunItems.IRON_GOLEM_ASSEMBLER);
        register("shulker_shell", 263, SlimefunItems.SYNTHETIC_SHULKER_SHELL.getDisplayName(), 30, SlimefunItems.SYNTHETIC_SHULKER_SHELL);
        register("villager_rune", 264, SlimefunItems.VILLAGER_RUNE.getDisplayName(), 26, SlimefunItems.VILLAGER_RUNE, SlimefunItems.STRANGE_NETHER_GOO);
        register("climbing_pick", 265, SlimefunItems.CLIMBING_PICK.getDisplayName(), 20, SlimefunItems.CLIMBING_PICK);
        register("even_higher_tier_capacitors", 266, SlimefunItems.ENERGIZED_CAPACITOR.getDisplayName(), 40, SlimefunItems.ENERGIZED_CAPACITOR);
        register("caveman_talisman", 267, SlimefunItems.TALISMAN_CAVEMAN.getDisplayName(), 20, SlimefunItems.TALISMAN_CAVEMAN);
        register("elytra_cap", 268, SlimefunItems.ELYTRA_CAP.getDisplayName(), 20, SlimefunItems.ELYTRA_CAP);
        register("energy_connectors", 269, SlimefunItems.ENERGY_CONNECTOR.getDisplayName(), 12, SlimefunItems.ENERGY_CONNECTOR);
        register("bee_armor", 270, SlimefunItems.BEE_HELMET.getDisplayName(), 24, SlimefunItems.BEE_HELMET, SlimefunItems.BEE_WINGS, SlimefunItems.BEE_LEGGINGS, SlimefunItems.BEE_BOOTS);
        register("wise_talisman", 271, SlimefunItems.TALISMAN_WISE.getDisplayName(), 20, SlimefunItems.TALISMAN_WISE);
        register("book_binder", 272, SlimefunItems.BOOK_BINDER.getDisplayName(), 26, SlimefunItems.BOOK_BINDER);
        register("auto_crafting", 273, SlimefunItems.CRAFTING_MOTOR.getDisplayName(), 30, SlimefunItems.CRAFTING_MOTOR, SlimefunItems.VANILLA_AUTO_CRAFTER, SlimefunItems.ENHANCED_AUTO_CRAFTER, SlimefunItems.ARMOR_AUTO_CRAFTER);
        register("produce_collector", 274, SlimefunItems.PRODUCE_COLLECTOR.getDisplayName(), 20, SlimefunItems.PRODUCE_COLLECTOR);
        register("improved_generators", 275, SlimefunItems.COAL_GENERATOR_2.getDisplayName(), 24, SlimefunItems.COAL_GENERATOR_2, SlimefunItems.LAVA_GENERATOR_2);
        register("ingredients_and_cheese", 276, SlimefunItems.SALT.getDisplayName(), 5, SlimefunItems.SALT, SlimefunItems.WHEAT_FLOUR, SlimefunItems.HEAVY_CREAM, SlimefunItems.CHEESE, SlimefunItems.BUTTER);
        register("medium_tier_auto_enchanting", 277, SlimefunItems.AUTO_ENCHANTER_2.getDisplayName(), 48, SlimefunItems.AUTO_ENCHANTER_2, SlimefunItems.AUTO_DISENCHANTER_2);
        register("portable_teleporter", 278, SlimefunItems.PORTABLE_TELEPORTER.getDisplayName(), 42, SlimefunItems.PORTABLE_TELEPORTER);
        register("trident", 279, "삼지창", 20, "TRIDENT");
        register("farmer_talisman", 280, SlimefunItems.TALISMAN_FARMER.getDisplayName(), 18, SlimefunItems.TALISMAN_FARMER);
        register("rainbow_armor", 281, SlimefunItems.RAINBOW_HELMET.getDisplayName(), 22, SlimefunItems.RAINBOW_HELMET, SlimefunItems.RAINBOW_CHESTPLATE, SlimefunItems.RAINBOW_LEGGINGS, SlimefunItems.RAINBOW_BOOTS);
        
    }

    @ParametersAreNonnullByDefault
    private static void register(String key, int id, String name, int defaultCost, ItemStack... items) {
        Research research = new Research(new NamespacedKey(Slimefun.instance(), key), id, name, defaultCost);

        for (ItemStack item : items) {
            SlimefunItem sfItem = SlimefunItem.getByItem(item);

            if (sfItem != null) {
                research.addItems(sfItem);
            }
        }

        research.register();
    }

    @ParametersAreNonnullByDefault
    private static void register(String key, int id, String name, int defaultCost, String... items) {
        Research research = new Research(new NamespacedKey(Slimefun.instance(), key), id, name, defaultCost);

        for (String itemId : items) {
            SlimefunItem sfItem = SlimefunItem.getById(itemId);

            if (sfItem != null) {
                research.addItems(sfItem);
            }
        }

        research.register();
    }
}
