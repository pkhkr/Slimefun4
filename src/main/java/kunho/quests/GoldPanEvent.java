package kunho.quests;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 골드팬 사용 이벤트
 */
public class GoldPanEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Entity entity;

    public GoldPanEvent(
            @Nullable Entity entity
    ) {
        this.entity = entity;
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
    public Player getPlayer() {
        if (entity instanceof Player player) {
            return player;
        }
        return null;
    }

}
