package wundr.endadvance.eventHandlers;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.endadvance.EnderAdvancement;

/**
 * Drops {@link wundr.endadvance.item.EnderItemEssence} when necessary (assuming RNG)<br>
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
@EventBusSubscriber(modid = EnderAdvancement.MOD_ID)
@SuppressWarnings("unused")
public class LivingDeathEventHandler {
	
	/**
	 * Drops 0-2 {@link wundr.endadvance.item.EnderItemEssence} on the death of a vanilla Enderman
	 * @param event the {@link LivingDeathEvent} being handled
	 */
	@SubscribeEvent
	public static void onLivingDeath(LivingDeathEvent event) {
		if(event.getEntity().getClass() == EntityEnderman.class && event.getEntity().world.rand.nextInt(EnderAdvancement.singleChance) == EnderAdvancement.singleChance - 1) {
			if(event.getEntity().world.rand.nextInt(EnderAdvancement.doubleChance) == EnderAdvancement.doubleChance - 1) {
				event.getEntity().world.spawnEntity(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY + .1, event.getEntity().posZ, new ItemStack(EnderAdvancement.ENDER_ESSENCE, 2))); //Using world is the same as using getEntityWorld()
			} else {
				event.getEntity().world.spawnEntity(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY + .1, event.getEntity().posZ, new ItemStack(EnderAdvancement.ENDER_ESSENCE, 1))); //Using world is the same as using getEntityWorld()
			}
		}
	}
}
