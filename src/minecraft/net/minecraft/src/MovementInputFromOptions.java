package net.minecraft.src;

public class MovementInputFromOptions extends MovementInput
{
    private GameSettings gameSettings;

    public MovementInputFromOptions(GameSettings gamesettings)
    {
        gameSettings = gamesettings;
    }

    public void updatePlayerMoveState(EntityPlayer entityplayer)
    {
        moveStrafe = 0.0F;
        moveForward = 0.0F;
        if (gameSettings.keyBindForward.pressed)
        {
            moveForward++;
        }
        if (gameSettings.keyBindBack.pressed)
        {
            moveForward--;
        }
        if (gameSettings.keyBindLeft.pressed)
        {
            moveStrafe++;
        }
        if (gameSettings.keyBindRight.pressed)
        {
            moveStrafe--;
        }
        jump = gameSettings.keyBindJump.pressed;
        sneak = gameSettings.keyBindSneak.pressed;
        if (sneak)
        {
            moveStrafe *= 0.29999999999999999D;
            moveForward *= 0.29999999999999999D;
        }
    }
}
