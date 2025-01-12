package net.aznard.aftercraftz.keybinds;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class Keybinding {

    private final KeyBinding keyBinding;
    private final String buttonLabel; // String shown on buttons
    private final String description; // Full name shown in menu

    public Keybinding(String name, int key, String buttonLabel, String description) {
        this.keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.aftercraftz." + name,
                InputUtil.Type.KEYSYM,
                key,
                "category.aftercraftz"
        ));
        this.buttonLabel = buttonLabel;
        this.description = description;
    }

    public boolean isDown() {
        return keyBinding.isPressed();
    }

    public String getButtonLabel() {
        return buttonLabel;
    }

    public String getDescription() {
        return description;
    }

    public int getKey() {
        return InputUtil.fromTranslationKey(keyBinding.getBoundKeyTranslationKey()).getCode();
    }
}
