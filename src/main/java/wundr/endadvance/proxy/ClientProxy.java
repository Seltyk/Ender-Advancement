package wundr.endadvance.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import wundr.endadvance.EnderAdvancement;
import wundr.endadvance.item.*;
import wundr.endadvance.item.tool.*;

/**
 * Copyright (c) 2016-2017 wundrweapon
 * @author wundrweapon
 */
@SuppressWarnings("unused")
public class ClientProxy implements IProxy {

	@Override
	public void setModels() {
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.BEBRD, 0, new ModelResourceLocation(EnderAdvancement.BEBRD.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.ENDER_ESSENCE, 0, new ModelResourceLocation(EnderAdvancement.ENDER_ESSENCE.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.ENDER_TWIG, 0, new ModelResourceLocation(EnderAdvancement.ENDER_TWIG.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.HEATED_CORE, 0, new ModelResourceLocation(EnderAdvancement.HEATED_CORE.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.IMPURE_CORE, 0, new ModelResourceLocation(EnderAdvancement.IMPURE_CORE.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.PURE_CORE, 0, new ModelResourceLocation(EnderAdvancement.PURE_CORE.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.AXE_ENDER, 0, new ModelResourceLocation(EnderAdvancement.AXE_ENDER.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.PICKAXE_ENDER, 0, new ModelResourceLocation(EnderAdvancement.PICKAXE_ENDER.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.SHOVEL_ENDER, 0, new ModelResourceLocation(EnderAdvancement.SHOVEL_ENDER.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(EnderAdvancement.SWORD_ENDER, 0, new ModelResourceLocation(EnderAdvancement.SWORD_ENDER.getRegistryName(), "inventory"));
	}
}
