package kr.tpsw.triggertool2.command;

import java.util.Arrays;

import kr.tpsw.triggertool2.AbstractTTCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tirggertool2.kr.tpsw.api.bukkit.API;

public class SethealthCommand extends AbstractTTCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (this.isValidArguments(args)) {
			super.runCommand(args);
		} else {
			sender.sendMessage("올바르지 않은 명령어: " + label + " " + Arrays.toString(args));
		}
		return true;
	}

	@Override
	public void run(Player target, String[] args) {
		if (target != null) {
			int h = Integer.valueOf(args[1]);
			int mh = target.getMaxHealth();
			if (h <= mh) {
				target.setHealth(h);
			}
		}
	}

	@Override
	public boolean isValidArguments(String[] args) {
		if (args.length == 2) {
			if (API.isIntegerPositive(args[1])) {
				return true;
			}
		}
		return false;
	}

}
