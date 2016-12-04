package wundr.enderAdvancement;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import wundr.enderAdvancement.item.*;
import wundr.enderAdvancement.item.tool.*;

/**
 * Copyright (c) 2016 wundrweapon
 * @author wundrweapon
 */
public class ClientProxy implements IProxy {

	@Override
	public void setModels() {
		ModelLoader.setCustomModelResourceLocation(Main.BEBRD, 0, new ModelResourceLocation(EnderItemTeleportWand.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.ENDER_ESSENCE, 0, new ModelResourceLocation(EnderItemEssence.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.ENDER_TWIG, 0, new ModelResourceLocation(EnderItemStick.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.HEATED_CORE, 0, new ModelResourceLocation(EnderItemHeatedCore.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.IMPURE_CORE, 0, new ModelResourceLocation(EnderItemImpureCore.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.PURE_CORE, 0, new ModelResourceLocation(EnderItemPureCore.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.AXE_ENDER, 0, new ModelResourceLocation(EnderAxe.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.PICKAXE_ENDER, 0, new ModelResourceLocation(EnderPickaxe.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.SHOVEL_ENDER, 0, new ModelResourceLocation(EnderShovel.REGISTRY_RL, "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.SWORD_ENDER, 0, new ModelResourceLocation(EnderSword.REGISTRY_RL, "inventory"));
	}
}
