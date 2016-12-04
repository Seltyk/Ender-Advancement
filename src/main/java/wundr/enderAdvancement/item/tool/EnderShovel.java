package wundr.enderAdvancement.item.tool;

import net.minecraft.item.ItemSpade;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.Main;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * 
 * @author wundrweapon
 */
public class EnderShovel extends ItemSpade {
	private static String name = "shovel";
	public static final ResourceLocation REGISTRY_RL = new ResourceLocation(Main.MOD_ID + ":" + name);
	
	public EnderShovel(ToolMaterial material) {
		super(material);
		setRegistryName(REGISTRY_RL);
		setUnlocalizedName(Main.MOD_ID + "_" + name);
	}
}
