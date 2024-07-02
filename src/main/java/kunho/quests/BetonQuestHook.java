package kunho.quests;


import org.betonquest.betonquest.BetonQuest;
import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.api.CountingObjective;
import org.betonquest.betonquest.api.profiles.OnlineProfile;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.betonquest.betonquest.utils.PlayerConverter;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.util.Collections;
import java.util.HashSet;


@SuppressWarnings("DuplicatedCode")
public class BetonQuestHook {

    public static void register() {
        BetonQuest.getInstance().registerObjectives("slimefun_enchantcraft", EnchantCraftObjective.class);
        BetonQuest.getInstance().registerObjectives("slimefun_use_goldpan", GoldPanObjective.class);
        BetonQuest.getInstance().registerObjectives("slimefun_makeshift_smeltery", MakeshiftSmelteryObjective.class);

    }


    public static class EnchantCraftObjective extends CountingObjective implements Listener {

        private final HashSet<String> sfItems;

        public EnchantCraftObjective(Instruction instruction) throws InstructionParseException {
            super(instruction, "slimefun_enchantcraft");
            sfItems = new HashSet<>();
            Collections.addAll(sfItems, instruction.getArray());
            targetAmount = instruction.getVarNum();
            preCheckAmountNotLessThanOne(targetAmount);
            // final QuestPackage pack = instruction.getPackage(); 
        }

        @EventHandler (ignoreCancelled = true)
        public void onEvent(EnchantCraftEvent event) {
            OnlineProfile onlineProfile = PlayerConverter.getID(event.getPlayer());
            if (!containsPlayer(onlineProfile)) {
                return;
            }

            if (this.sfItems.contains(event.getSfItem().getId()) && this.checkConditions(onlineProfile)) {
                getCountingData(onlineProfile).progress(1);
                completeIfDoneOrNotify(onlineProfile);
            }
        }

        @Override
        public void start() {
            Bukkit.getPluginManager().registerEvents(this, BetonQuest.getInstance());
        }

        @Override
        public void stop() {
            HandlerList.unregisterAll(this);
        }
    }

    public static class GoldPanObjective extends CountingObjective implements Listener {


        public GoldPanObjective(Instruction instruction) throws InstructionParseException {
            super(instruction, "slimefun_use_goldpan");
            targetAmount = instruction.getVarNum();
            preCheckAmountNotLessThanOne(targetAmount);
        }

        @EventHandler (ignoreCancelled = true)
        public void onEvent(GoldPanEvent event) {
            OnlineProfile onlineProfile = PlayerConverter.getID(event.getPlayer());
            if (!containsPlayer(onlineProfile)) {
                return;
            }

            if (this.checkConditions(onlineProfile)) {
                getCountingData(onlineProfile).progress(1);
                completeIfDoneOrNotify(onlineProfile);
            }
        }

        @Override
        public void start() {
            Bukkit.getPluginManager().registerEvents(this, BetonQuest.getInstance());
        }

        @Override
        public void stop() {
            HandlerList.unregisterAll(this);
        }
    }

    public static class MakeshiftSmelteryObjective extends CountingObjective implements Listener {

        private final HashSet<String> sfItems;

        public MakeshiftSmelteryObjective(Instruction instruction) throws InstructionParseException {
            super(instruction, "slimefun_makeshift_smeltery");
            sfItems = new HashSet<>();
            Collections.addAll(sfItems, instruction.getArray());
            targetAmount = instruction.getVarNum();
            preCheckAmountNotLessThanOne(targetAmount);
            // final QuestPackage pack = instruction.getPackage();
        }

        @EventHandler (ignoreCancelled = true)
        public void onEvent(MakeshiftSmelteryEvent event) {
            OnlineProfile onlineProfile = PlayerConverter.getID(event.getPlayer());
            if (!containsPlayer(onlineProfile)) {
                return;
            }

            if (this.sfItems.contains(event.getSfItem().getId()) && this.checkConditions(onlineProfile)) {
                getCountingData(onlineProfile).progress(1);
                completeIfDoneOrNotify(onlineProfile);
            }
        }

        @Override
        public void start() {
            Bukkit.getPluginManager().registerEvents(this, BetonQuest.getInstance());
        }

        @Override
        public void stop() {
            HandlerList.unregisterAll(this);
        }
    }
}
