package kr.tpsw.triggertool2.command;

import java.util.Arrays;

import kr.tpsw.triggertool2.AbstractTTCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatUserCommand extends AbstractTTCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (this.isValidArguments(args)) {
			super.runCommand(args);
		} else {
			sender.sendMessage("�ùٸ��� ���� ��ɾ�: " + label + " " + Arrays.toString(args));
		}
		return true;
	}

	@Override
	public void run(Player target, String[] args) {
		if (target != null) {
			for (int i = 0; i < 20; i++) {
				target.sendMessage("");
			}
		}
	}

	@Override
	public boolean isValidArguments(String[] args) {
		if (args.length == 1) {
			return true;
		} else {
			return false;
		}
	}

}
