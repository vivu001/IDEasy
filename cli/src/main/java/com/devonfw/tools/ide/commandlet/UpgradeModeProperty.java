package com.devonfw.tools.ide.commandlet;

import java.util.Locale;

import com.devonfw.tools.ide.completion.CompletionCandidateCollector;
import com.devonfw.tools.ide.context.IdeContext;
import com.devonfw.tools.ide.property.EnumProperty;

/**
 * {@link EnumProperty} for {@link UpgradeMode} that controls auto-completion of the {@code --mode} option.
 */
public class UpgradeModeProperty extends EnumProperty<UpgradeMode> {

  /**
   * The constructor.
   */
  public UpgradeModeProperty() {
    super("--mode", false, null, UpgradeMode.class);
  }

  @Override
  protected void completeValue(String arg, IdeContext context, Commandlet commandlet, CompletionCandidateCollector collector) {

    for (UpgradeMode mode : UpgradeMode.values()) {
      String text = mode.name().toLowerCase(Locale.ROOT);
      if (text.startsWith(arg)) {
        collector.add(text, null, this, commandlet);
      }
    }
  }
}
