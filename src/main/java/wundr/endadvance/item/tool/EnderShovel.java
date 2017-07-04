package wundr.endadvance.item.tool;

import net.minecraft.item.ItemSpade;
import net.minecraft.util.ResourceLocation;
import wundr.endadvance.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderShovel extends ItemSpade {
	private final String name = "shovel";
	
	public EnderShovel(ToolMaterial material) {
		super(material);
		setRegistryName(new ResourceLocation(EnderAdvancement.MOD_ID + ":" + name));
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + name);
	}
}
