package me.linus.momentum.module.modules.movement;

import me.linus.momentum.module.Module;
import me.linus.momentum.setting.checkbox.Checkbox;
import net.minecraft.network.play.client.CPacketPlayer;

/**
 * @author linustouchtips
 * @since 11/26/2020
 */

public class AirJump extends Module {
    public AirJump() {
        super("AirJump", Category.MOVEMENT, "Allows you to jump in the air");
    }

    public static Checkbox packet = new Checkbox("Packet", true);

    @Override
    public void setup() {
        addSetting(packet);
    }

    @Override
    public void onUpdate() {
        if (nullCheck())
            return;

        mc.player.onGround = true;

        if (packet.getValue()) {
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.41999998688698D, mc.player.posZ, true));
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.7531999805211997D, mc.player.posZ, true));
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.00133597911214D, mc.player.posZ, true));
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.16610926093821D, mc.player.posZ, true));
        }
    }
}
