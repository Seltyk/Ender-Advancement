package wundr.endadvance.item.tool;

import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import wundr.endadvance.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderSword extends ItemSword {
	private final String name = "sword";
	
	public EnderSword(ToolMaterial material)  {
		super(material);
		setRegistryName(new ResourceLocation(EnderAdvancement.MOD_ID + ":" + name));
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + name);
	}
}
