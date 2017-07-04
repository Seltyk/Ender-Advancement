package wundr.endadvance.item;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import wundr.endadvance.EnderAdvancement;

/**
 * Simplifies the writing of code for non-tool items within the mod<br>
 * Copyright (c) 2017 wundrweapon
 * @author wundrweapon
 */
public class EnderItem extends Item {
	private final ResourceLocation registryLocation;
	
	public EnderItem(String name) {
		registryLocation = new ResourceLocation(EnderAdvancement.MOD_ID + ":" + name);
		
		setRegistryName(registryLocation);
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + name);
	}
	
	public final ResourceLocation getRegistryLocation() {
		return registryLocation;
	}
}
