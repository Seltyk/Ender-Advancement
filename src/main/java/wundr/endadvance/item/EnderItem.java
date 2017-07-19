package wundr.endadvance.item;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import wundr.endadvance.EnderAdvancement;

/**
 * Simplifies the writing of code for non-tool items (plus BEBRD) within the mod<br>
 * Copyright (c) 2017 wundrweapon
 * @author wundrweapon
 */
public class EnderItem extends Item {
	
	/**
	 * Constructs an Ender item. Just pass in a name thingy and this will cut down some code
	 * @param name pretty self-explanitory
	 */
	public EnderItem(String name) {
		setRegistryName( new ResourceLocation(EnderAdvancement.MOD_ID + ":" + name));
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + name);
	}
}
