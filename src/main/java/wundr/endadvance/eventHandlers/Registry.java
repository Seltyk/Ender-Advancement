package wundr.endadvance.eventHandlers;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipesBanners;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.endadvance.EnderAdvancement;

/**
 * Takes care of all the registry work - no thought required. Timing is automated, too<br>
 * Copyright (c) 2016-2017 wundrweapon
 * @author wundrweapon
 */
@EventBusSubscriber(modid = EnderAdvancement.MOD_ID)
@SuppressWarnings("unused")
public class Registry {
	
	//
	//RegistryEvent.Register events
	//
	
	/**
	 * Registers Duper so I don't have to
	 * @param reg the {@link Register} event being handled, specifically for {@link Enchantment}s
	 */
	@SubscribeEvent
	public static void registerEnchantment(Register<Enchantment> reg) {
		reg.getRegistry().register(EnderAdvancement.DUPER);
	}
	
	/**
	 * Registers my items so I don't have to
	 * @param reg the {@link Register} event being handled, specifically for {@link Item}s
	 */
	@SubscribeEvent
	public static void registerItems(Register<Item> reg) {
		reg.getRegistry().registerAll(EnderAdvancement.ITEMS);
	}
	
	/**
	 * Registers the duplication recipe so I don't have to
	 * @param reg the {@link Register} event being handled, specifically for {@link IRecipe}s
	 */
	@SubscribeEvent
	public static void registerRecipe(Register<IRecipe> reg) {
		reg.getRegistry().register(EnderAdvancement.DUPLICATOR);
	}
	
	//
	//ModelRegistryEvent
	//
	
	/**
	 * Registers {@link ModelResourceLocation}s so I don't have to. This way, textures and the like actually work
	 * @param reg the {@link ModelRegistryEvent} event being handled, which lets me set custom MRLs when Forge is ready for them
	 */
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent reg) {
		for(Item i : EnderAdvancement.ITEMS) {
			ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(i.getRegistryName().toString()));
		}
	}
}
