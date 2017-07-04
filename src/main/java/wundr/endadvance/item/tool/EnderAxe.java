package wundr.endadvance.item.tool;

import net.minecraft.item.ItemAxe;
import net.minecraft.util.ResourceLocation;
import wundr.endadvance.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderAxe extends ItemAxe {
	private final String name = "axe";
	
	public EnderAxe(ToolMaterial material) {
		super(material, 12, -2.8f);
		setRegistryName(new ResourceLocation(EnderAdvancement.MOD_ID + ":" + name));
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + name);
	}
}
