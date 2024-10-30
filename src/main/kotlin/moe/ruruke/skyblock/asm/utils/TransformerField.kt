package moe.ruruke.skyblock.asm.utils


import moe.ruruke.skyblock.tweaker.SkyblockAddonsTransformer
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.FieldInsnNode


enum class TransformerField(deobfName: String, seargeName: String, notchName18: String, private val type: String) {
    // GuiScreen
    width("width", "field_146294_l", "l", "I"),
    height("height", "field_146295_m", "m", "I"),
    buttonList("buttonList", "field_146292_n", "n", "Ljava/util/List;"),

    // GuiButton
    id("id", "field_146127_k", "k", "I"),

    // GuiContainer
    lowerChestInventory("lowerChestInventory", "field_147015_w", "w", TransformerClass.IInventory.getName()),
    guiLeft("guiLeft", "field_147003_i", "i", "I"),
    guiTop("guiTop", "field_147009_r", "r", "I"),
    fontRendererObj("fontRendererObj", "field_146289_q", "q", TransformerClass.FontRenderer.getName()),
    inventorySlots("inventorySlots", "field_147002_h", "h", TransformerClass.Container.getName()),
    theSlot("theSlot", "field_147006_u", "u", TransformerClass.Slot.getName()),
    xSize("xSize", "field_146999_f", "f", "I"),
    ySize("ySize", "field_147000_g", "g", "I"),  // GuiInventory
    //    oldMouseX("oldMouseX", "field_147048_u", "u", "F"),
    //    oldMouseY("oldMouseY", "field_147047_v", "v", "F"),

    // Minecraft
    mcResourceManager(
        "mcResourceManager",
        "field_110451_am",
        "ay",
        TransformerClass.IReloadableResourceManager.getName()
    ),
    currentScreen("currentScreen", "field_71462_r", "m", TransformerClass.GuiScreen.getName()),

    // FontRenderer
    //    textColor("textColor", "field_78304_r", "q", "I"),
    red("red", "field_78291_n", "m", "F"),
    green("green", "field_179186_b", "b", "F"),
    blue("blue", "field_78292_o", "n", "F"),
    alpha("alpha", "field_78305_q", "p", "F"),
    italicStyle("italicStyle", "field_78301_u", "t", "Z"),

    // EntityLivingBase
    hurtTime("hurtTime", "field_70737_aN ", "au", "I"),

    // EntityPlayer
    inventory("inventory", "field_71071_by", "bi", TransformerClass.InventoryPlayer.getName()),

    // InventoryPlayer
    currentItem("currentItem", "field_70461_c", "c", "I"),
    armorInventory("armorInventory", "field_70460_b", "b", "[" + TransformerClass.ItemStack.getName()),

    renderEndNanoTime("renderEndNanoTime", "field_78510_Z", "F", "J");

    var _name = ""
    fun getName(): String {
        return _name
    }

    init {
        _name = if (SkyblockAddonsTransformer.isDeobfuscated) {
            deobfName
        } else {
            if (SkyblockAddonsTransformer.isUsingNotchMappings()) {
                notchName18
            } else {
                seargeName
            }
        }
    }

    fun getType(): String {
        return type
    }

    fun getField(currentClass: TransformerClass): FieldInsnNode {
        return FieldInsnNode(
            Opcodes.GETFIELD, currentClass.nameRaw, _name,
            type
        )
    }

    fun putField(currentClass: TransformerClass): FieldInsnNode {
        return FieldInsnNode(
            Opcodes.PUTFIELD, currentClass.nameRaw, _name,
            type
        )
    }

    fun matches(fieldInsnNode: FieldInsnNode): Boolean {
        return this.name == fieldInsnNode.name && this.type == fieldInsnNode.desc
    }
}
