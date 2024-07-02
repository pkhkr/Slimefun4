package kunho.quests;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
/**
 * 강화 제작대 이벤트
 */
public class EnchantCraftEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Entity entity;
    private final SlimefunItem sfItem;

    public EnchantCraftEvent(
            @Nullable Entity entity,
            @Nullable SlimefunItem sfItem
    ) {
        this.entity = entity;
        this.sfItem = sfItem;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return getHandlerList();
    }


    /**
     * Get the entity that triggered the event
     * This would be null if the crop is broken by respawn anchor
     * The breaker can be a TNT, creeper.
     * If the pot is a vanilla farmland, it can be trampled by entities
     *
     * @return entity
     */
    @Nullable
    public Entity getEntity() {
        return entity;
    }

    @Nullable
    public SlimefunItem getSfItem() {
        return sfItem;
    }


    @Nullable
    public Player getPlayer() {
        if (entity instanceof Player player) {
            return player;
        }
        return null;
    }

}
