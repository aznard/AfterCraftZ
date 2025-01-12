package net.aznard.aftercraftz.keybinds;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class Keybindings {

    public static KeyBinding shiftMod;
    public static KeyBinding ctrlMod;
    public static KeyBinding altMod;
    public static KeyBinding cancelBuild;
    public static KeyBinding keyQ;
    public static KeyBinding keyW;
    public static KeyBinding keyE;
    public static KeyBinding keyR;
    public static KeyBinding keyT;
    public static KeyBinding keyY;
    public static KeyBinding keyU;
    public static KeyBinding keyI;
    public static KeyBinding keyO;
    public static KeyBinding keyP;
    public static KeyBinding keyV;
    public static KeyBinding keyL;
    public static KeyBinding keyM;
    public static KeyBinding keyF;
    public static KeyBinding keyC;
    public static KeyBinding keyD;
    public static KeyBinding keyJ;
    public static KeyBinding keyK;
    public static KeyBinding keyG;
    public static KeyBinding stop;
    public static KeyBinding hold;
    public static KeyBinding move;
    public static KeyBinding build;
    public static KeyBinding gather;
    public static KeyBinding garrison;
    public static KeyBinding chat;
    public static KeyBinding tab;

    public static KeyBinding[] nums = new KeyBinding[10];
    public static KeyBinding[] fnums = new KeyBinding[12];

    public static void initializeKeybindings() {
        shiftMod = registerKeyBinding("shift_mod", GLFW.GLFW_KEY_LEFT_SHIFT);
        ctrlMod = registerKeyBinding("ctrl_mod", GLFW.GLFW_KEY_LEFT_CONTROL);
        altMod = registerKeyBinding("alt_mod", GLFW.GLFW_KEY_LEFT_ALT);
        cancelBuild = registerKeyBinding("cancel_build", GLFW.GLFW_KEY_DELETE);
        keyQ = registerKeyBinding("key_q", GLFW.GLFW_KEY_Q);
        keyW = registerKeyBinding("key_w", GLFW.GLFW_KEY_W);
        keyE = registerKeyBinding("key_e", GLFW.GLFW_KEY_E);
        keyR = registerKeyBinding("key_r", GLFW.GLFW_KEY_R);
        keyT = registerKeyBinding("key_t", GLFW.GLFW_KEY_T);
        keyY = registerKeyBinding("key_y", GLFW.GLFW_KEY_Y);
        keyU = registerKeyBinding("key_u", GLFW.GLFW_KEY_U);
        keyI = registerKeyBinding("key_i", GLFW.GLFW_KEY_I);
        keyO = registerKeyBinding("key_o", GLFW.GLFW_KEY_O);
        keyP = registerKeyBinding("key_p", GLFW.GLFW_KEY_P);
        keyV = registerKeyBinding("key_v", GLFW.GLFW_KEY_V);
        keyL = registerKeyBinding("key_l", GLFW.GLFW_KEY_L);
        keyM = registerKeyBinding("key_m", GLFW.GLFW_KEY_M);
        keyF = registerKeyBinding("key_f", GLFW.GLFW_KEY_F);
        keyC = registerKeyBinding("key_c", GLFW.GLFW_KEY_C);
        keyD = registerKeyBinding("key_d", GLFW.GLFW_KEY_D);
        keyJ = registerKeyBinding("key_j", GLFW.GLFW_KEY_J);
        keyK = registerKeyBinding("key_k", GLFW.GLFW_KEY_K);
        keyG = registerKeyBinding("key_g", GLFW.GLFW_KEY_G);
        stop = registerKeyBinding("stop", GLFW.GLFW_KEY_S);
        hold = registerKeyBinding("hold", GLFW.GLFW_KEY_H);
        move = registerKeyBinding("move", GLFW.GLFW_KEY_M);
        build = registerKeyBinding("build", GLFW.GLFW_KEY_B);
        gather = registerKeyBinding("gather", GLFW.GLFW_KEY_G);
        garrison = registerKeyBinding("garrison", GLFW.GLFW_KEY_N);
        chat = registerKeyBinding("chat", GLFW.GLFW_KEY_ENTER);
        tab = registerKeyBinding("tab", GLFW.GLFW_KEY_TAB);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = registerKeyBinding("key_num_" + i, GLFW.GLFW_KEY_0 + i);
        }

        for (int i = 0; i < fnums.length; i++) {
            fnums[i] = registerKeyBinding("key_fnum_" + (i + 1), GLFW.GLFW_KEY_F1 + i);
        }
    }

    private static KeyBinding registerKeyBinding(String name, int key) {
        return KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.reignofnether." + name,
                InputUtil.Type.KEYSYM,
                key,
                "category.reignofnether"
        ));
    }

    public static KeyBinding getNum(int i) {
        return nums[i];
    }

    public static KeyBinding getFnum(int i) {
        return fnums[i - 1];
    }
}
