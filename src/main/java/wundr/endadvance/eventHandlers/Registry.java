package wundr.endadvance.eventHandlers;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;
import wundr.endadvance.EnderAdvancement;

/**
 * Takes care of all the registry work - no thought required. Timing is automated, too<br>
 * Copyright (c) 2016-2017 wundrweapon
 * @author wundrweapon
 */
@EventBusSubscriber(modid = EnderAdvancement.MOD_ID)
@SuppressWarnings("unused")
public class Registry {
	/**
	 * Registers the duplication recipe so I don't have to
	 * @param reg the {@link Register} event being handled, specifically for {@link IRecipe}s
	 */
	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public static void register(Register reg) {
		reg.getRegistry().registerAll(EnderAdvancement.REGISTRY_ENTRIES);
	}
	
	/**
	 * Registers {@link ModelResourceLocation}s so I don't have to. This way, textures and the like actually work
	 * @param reg the {@link ModelRegistryEvent} event being handled, which lets me set custom MRLs when Forge is ready for them
	 */
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent reg) {
		for(Impl delegate : EnderAdvancement.REGISTRY_ENTRIES) {
			if(delegate instanceof Item) {
				ModelLoader.setCustomModelResourceLocation((Item) delegate, 0, new ModelResourceLocation(delegate.getRegistryName().toString()));
			}
		}
	}
}
