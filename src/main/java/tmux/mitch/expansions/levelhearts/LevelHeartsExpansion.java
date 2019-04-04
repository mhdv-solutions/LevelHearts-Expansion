package tmux.mitch.expansions.levelhearts;

import com.zettelnet.levelhearts.LevelHearts;
import com.zettelnet.levelhearts.health.HealthManager;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public final class LevelHeartsExpansion extends PlaceholderExpansion {

  private final String VERSION = getClass().getPackage().getImplementationVersion();

  @Override
  public String getIdentifier() {
    return "levelhearts";
  }

  @Override
  public String getAuthor() {
    return "tmux";
  }

  @Override
  public String getVersion() {
    return VERSION;
  }

  @Override
  public String getRequiredPlugin() {
    return "LevelHearts";
  }

  @Override
  public String onRequest(OfflinePlayer offlinePlayer, String identifier) {
    if (offlinePlayer == null || !offlinePlayer.isOnline()) {
      return null;
    }

    final Player player = offlinePlayer.getPlayer();
    final HealthManager healthManager = LevelHearts.getHealthManager();

    switch (identifier) {
      case "health":
        return Double.toString(healthManager.getHealth(player));

      case "health_max":
        return Double.toString(healthManager.getMaxHealth(player));

      case "health_remaining":
        return Double.toString(0);

      case "health_needed":
        return Double.toString(1);

      default:
        return null;
    }
  }

}
