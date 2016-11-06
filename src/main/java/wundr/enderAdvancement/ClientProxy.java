package wundr.enderAdvancement;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Copyright (c) 2016 wundrweapon
 * @author wundrweapon
 */
public class ClientProxy implements IProxy {

	@Override
	public void setModels() {
		ModelLoader.setCustomModelResourceLocation(Main.bebpd, 0, new ModelResourceLocation(new ResourceLocation(Main.MOD_ID + ":bebpd"), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.enderEssence, 0, new ModelResourceLocation(new ResourceLocation(Main.MOD_ID + ":essence"), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.enderInfusedTwig, 0, new ModelResourceLocation(new ResourceLocation(Main.MOD_ID + ":twig"), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.heatedEnderCore, 0, new ModelResourceLocation(new ResourceLocation(Main.MOD_ID + ":heated_core"), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.impureEnderCore, 0, new ModelResourceLocation(new ResourceLocation(Main.MOD_ID + ":impure_core"), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.pureEnderCore, 0, new ModelResourceLocation(new ResourceLocation(Main.MOD_ID + ":pure_core"), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.enderAxe, 0, new ModelResourceLocation(new ResourceLocation(Main.MOD_ID + ":axe"), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.enderPickaxe, 0, new ModelResourceLocation(new ResourceLocation(Main.MOD_ID + ":pick"), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.enderShovel, 0, new ModelResourceLocation(new ResourceLocation(Main.MOD_ID + ":shovel"), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Main.enderSword, 0, new ModelResourceLocation(new ResourceLocation(Main.MOD_ID + ":sword"), "inventory"));
	}
}
