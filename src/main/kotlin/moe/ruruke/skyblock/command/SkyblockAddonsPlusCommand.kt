package moe.ruruke.skyblock.command

import moe.ruruke.skyblock.SkyblockAddonsPlus
import moe.ruruke.skyblock.utils.Test
import moe.ruruke.skyblock.utils.Utils
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender

public class SkyblockAddonsPlusCommand : CommandBase() {
    private val HEADER: String = "§7§m----------------§7[ §b§lSkyblockAddonsPlus §7]§7§m----------------"
    private val FOOTER: String = "§7§m-----------------------------------------------------"
    private val main = SkyblockAddonsPlus
    override fun getCommandName(): String {
        return "skyblockaddonsplus"
    }

    /**
     * Returns the required permission level for this command.
     */
    override fun getRequiredPermissionLevel(): Int {
        return 0
    }

    /**
     * Returns the aliases of this command
     */
    override fun getCommandAliases(): List<String> {
        return listOf("saa")
    }
    override fun getCommandUsage(sender: ICommandSender?): String {
        return HEADER;
    }

    override fun processCommand(sender: ICommandSender?, args: Array<out String>?) {
        var s = Utils.getPlayerViewPosition()
        main.utils!!.sendMessage("skyblockaddonsplus  Skyblock? > ${main.utils!!.isOnSkyblock()} Hypixel? > ${main.utils!!.isOnHypixel} ProfileName > ${main.utils!!.getProfileName()}")
        Test().a()
    }
}