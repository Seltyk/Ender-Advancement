package wundr.endadvance.eventHandlers;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.endadvance.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
@EventBusSubscriber
@SuppressWarnings("unused")
public class LivingDeathEventHandler {
	
	@SubscribeEvent
	public static void onLivingDeath(LivingDeathEvent event) {
		if(event.getEntity() instanceof EntityEnderman) {
			Random rand = new Random(event.getEntity().world.getSeed());
			
			if(rand.nextInt(EnderAdvancement.singleChance) == EnderAdvancement.singleChance - 1) {
				if(rand.nextInt(EnderAdvancement.doubleChance) == EnderAdvancement.doubleChance - 1) {
					event.getEntity().world.spawnEntity(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY + .1, event.getEntity().posZ, new ItemStack(EnderAdvancement.ENDER_ESSENCE, 2))); //Using world is the same as using getEntityWorld()
				} else {
					event.getEntity().world.spawnEntity(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY + .1, event.getEntity().posZ, new ItemStack(EnderAdvancement.ENDER_ESSENCE, 1))); //Using world is the same as using getEntityWorld()
				}
			}
		}
	}
}
