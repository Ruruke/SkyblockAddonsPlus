package moe.ruruke.skyblock.asm.utils

import moe.ruruke.skyblock.tweaker.SkyblockAddonsTransformer

enum class TransformerClass(
    private val seargeClass: String?,
    @field:Suppress("unused") private val notchClass18: String?,
) {
    Minecraft("net/minecraft/client/Minecraft", "ave"),
    EntityItem("net/minecraft/entity/item/EntityItem", "uz"),
    GuiChest("net/minecraft/client/gui/inventory/GuiChest", "ayr"),
    IInventory("net/minecraft/inventory/IInventory", "og"),
    FontRenderer("net/minecraft/client/gui/FontRenderer", "avn"),
    GuiScreen("net/minecraft/client/gui/GuiScreen", "axu"),
    GuiContainer("net/minecraft/client/gui/inventory/GuiContainer", "ayl"),
    ItemStack("net/minecraft/item/ItemStack", "zx"),
    GlStateManager("net/minecraft/client/renderer/GlStateManager", "bfl"),
    Container("net/minecraft/inventory/Container", "xi"),
    Slot("net/minecraft/inventory/Slot", "yg"),
    RenderItem("net/minecraft/client/renderer/entity/RenderItem", "bjh"),
    GuiInventory("net/minecraft/client/gui/inventory/GuiInventory", "azc"),
    IChatComponent("net/minecraft/util/IChatComponent", "eu"),
    IReloadableResourceManager("net/minecraft/client/resources/IReloadableResourceManager", "bng"),
    S2FPacketSetSlot("net/minecraft/network/play/server/S2FPacketSetSlot", "gf"),
    S30PacketWindowItems("net/minecraft/network/play/server/S30PacketWindowItems", "gd"),
    BlockPos("net/minecraft/util/BlockPos", "cj"),
    EntityPlayer("net/minecraft/entity/player/EntityPlayer", "wn"),
    EnumPlayerModelParts("net/minecraft/entity/player/EnumPlayerModelParts", "wo"),
    Entity("net/minecraft/entity/Entity", "pk"),
    SoundManager("net/minecraft/client/audio/SoundManager", "bpx"),
    ISound("net/minecraft/client/audio/ISound", "bpj"),
    SoundPoolEntry("net/minecraft/client/audio/SoundPoolEntry", "bpw"),
    SoundCategory("net/minecraft/client/audio/SoundCategory", "bpg"),
    TileEntityEnderChestRenderer("net/minecraft/client/renderer/tileentity/TileEntityEnderChestRenderer", "bhg"),
    ResourceLocation("net/minecraft/util/ResourceLocation", "jy"),
    ModelChest("net/minecraft/client/model/ModelChest", "baz"),
    EntityPlayerSP("net/minecraft/client/entity/EntityPlayerSP", "bew"),
    EntityRenderer("net/minecraft/client/renderer/EntityRenderer", "bfk"),
    GuiNewChat("net/minecraft/client/gui/GuiNewChat", "avt"),
    Item("net/minecraft/item/Item", "zw"),
    MouseHelper("net/minecraft/util/MouseHelper", "avf"),
    NetHandlerPlayClient("net/minecraft/client/network/NetHandlerPlayClient", "bcy"),
    PlayerControllerMP("net/minecraft/client/multiplayer/PlayerControllerMP", "bda"),
    RendererLivingEntity("net/minecraft/client/renderer/entity/RendererLivingEntity", "bjl"),
    RenderManager("net/minecraft/client/renderer/entity/RenderManager", "biu"),
    EntityLivingBase("net/minecraft/entity/EntityLivingBase", "pr"),
    EnumFacing("net/minecraft/util/EnumFacing", "cq"),
    ICamera("net/minecraft/client/renderer/culling/ICamera", "bia"),

    //    TileEntity("net/minecraft/tileentity/TileEntity", "akw"),
    TileEntityEnderChest("net/minecraft/tileentity/TileEntityEnderChest", "alf"),
    GuiDisconnected("net/minecraft/client/gui/GuiDisconnected", "axh"),
    GuiButton("net/minecraft/client/gui/GuiButton", "avs"),
    GuiIngameMenu("net/minecraft/client/gui/GuiIngameMenu", "axp"),
    `ItemCameraTransforms$TransformType`(
        "net/minecraft/client/renderer/block/model/ItemCameraTransforms\$TransformType",
        "bgr\$b"
    ),
    IBakedModel("net/minecraft/client/resources/model/IBakedModel", "boq"),
    InventoryPlayer("net/minecraft/entity/player/InventoryPlayer", "wm"),
    Potion("net/minecraft/potion/Potion", "pe"),
    RenderEnderman("net/minecraft/client/renderer/entity/RenderEnderman", "bis"),
    EntityEnderman("net/minecraft/entity/monster/EntityEnderman", "vo"),
    ModelBase("net/minecraft/client/model/ModelBase", "bbo"),
    ModelBiped("net/minecraft/client/model/ModelBiped", "bbj"),
    ModelEnderman("net/minecraft/client/model/ModelEnderman", "bbd"),
    RenderGlobal("net/minecraft/client/renderer/RenderGlobal", "bfr"),
    EffectRenderer("net/minecraft/client/particle/EffectRenderer", "bec"),
    EntityFX("net/minecraft/client/particle/EntityFX", "beb"),
    PotionEffect("net/minecraft/potion/PotionEffect", "pf"),
    WorldClient("net/minecraft/client/multiplayer/WorldClient", "bdb"),
    ItemArmor("net/minecraft/item/ItemArmor", "yj"),
    World("net/minecraft/world/World", "adm"),
    IBlockSource("net/minecraft/dispenser/IBlockSource", "ck"),
    WorldRenderer("net/minecraft/client/renderer/WorldRenderer", "bfd"),
    WorldVertexBufferUploader("net/minecraft/client/renderer/WorldVertexBufferUploader", "bfe"),
    IBlockState("net/minecraft/block/state/IBlockState", "alz");

    /**
     * @return The name used for the owner of a field or method, or a field type.
     */
    private var nameRaw: String? = null

    init {
        if (SkyblockAddonsTransformer.isDeobfuscated() || !SkyblockAddonsTransformer.isUsingNotchMappings() ) {
            nameRaw = seargeClass
        } else {
            nameRaw = notchClass18
        }
    }


    /**
     * @return The name used for the owner of a field or method, or a field type.
     */
    fun getNameRaw(): String? {
        return nameRaw
    }

    /**
     * @return The name used in a method descriptor to represent an object.
     */
    fun getName(): String {
        return "L$nameRaw;"
    }

    fun getTransformerName(): String {
        return seargeClass!!.replace("/".toRegex(), ".")
    }
}
