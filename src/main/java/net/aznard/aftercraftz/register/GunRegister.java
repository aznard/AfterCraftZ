package net.aznard.aftercraftz.register;

import net.aznard.aftercraftz.AfterCraftZ;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.item.ItemStack;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GunRegister extends Item {

    private final String name;
    private final double weight;
    private final int damage;
    private final String type;

    public GunRegister(Settings settings, String name, double weight, int damage, String type) {
        super(settings);
        this.name = name;
        this.weight = weight;
        this.damage = damage;
        this.type = type;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            shoot(world, user);
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    private void shoot(World world, PlayerEntity user) {
        // Placeholder for shooting logic
        user.sendMessage(Text.of(this.name + " fired!"), true);
        // Add projectile entity spawn logic here
    }

    @Override
    public Text getName() {
        return Text.of(name);
    }

    public double getWeight() {
        return weight;
    }

    public int getDamage() {
        return damage;
    }

    public String getType() {
        return type;
    }

    public static class Guns {
        public static final Item M4 = new GunRegister(new GunRegister.Settings(), "M4", 5.5, 15, "rifle");
        public static final Item PISTOL = new GunRegister(new GunRegister.Settings(), "Pistol", 2.0, 8, "handgun");

        public static void registerGuns() {
            Registry.register(Registries.ITEM, Identifier.of("aftercraftz", "m4"), M4);
            Registry.register(Registries.ITEM, Identifier.of("aftercraftz", "pistol"), PISTOL);
        }
    }

    public static void registerGuns() {
        AfterCraftZ.LOGGER.info("Registering item groups for " + AfterCraftZ.MOD_ID);
    }
}
