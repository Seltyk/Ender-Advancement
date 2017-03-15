package wundr.enderAdvancement;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import wundr.enderAdvancement.item.*;
import wundr.enderAdvancement.item.tool.*;

/**
 * Copyright (c) 2016-2017 wundrweapon
 * @author wundrweapon
 */
public class ClientProxy implements IProxy {

	@Override
	public void setModels() {
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.BEBRD, 0, new ModelResourceLocation(EnderItemTeleportWand.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.ENDER_ESSENCE, 0, new ModelResourceLocation(EnderItemEssence.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.ENDER_TWIG, 0, new ModelResourceLocation(EnderItemStick.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.HEATED_CORE, 0, new ModelResourceLocation(EnderItemHeatedCore.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.IMPURE_CORE, 0, new ModelResourceLocation(EnderItemImpureCore.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.PURE_CORE, 0, new ModelResourceLocation(EnderItemPureCore.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.AXE_ENDER, 0, new ModelResourceLocation(EnderAxe.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.PICKAXE_ENDER, 0, new ModelResourceLocation(EnderPickaxe.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.SHOVEL_ENDER, 0, new ModelResourceLocation(EnderShovel.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.SWORD_ENDER, 0, new ModelResourceLocation(EnderSword.REGISTRY_RL, "inventory"));
	}
}
