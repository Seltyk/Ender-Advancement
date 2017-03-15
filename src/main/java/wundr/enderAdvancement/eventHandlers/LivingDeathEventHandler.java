package wundr.enderAdvancement.eventHandlers;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.enderAdvancement.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
@EventBusSubscriber
public class LivingDeathEventHandler {
	private static int oneChance, twoChance;
	
	public LivingDeathEventHandler(int singleChance, int doubleChance) {
		oneChance = singleChance;
		twoChance = doubleChance;
	}
	
	@SubscribeEvent
	public static void onLivingDeath(LivingDeathEvent event) {
		if(event.getEntity() instanceof EntityEnderman) {
			Random rand = new Random(event.getEntity().worldObj.getSeed());
			
			if(rand.nextInt(oneChance) == oneChance - 1) {
				if(rand.nextInt(twoChance) == twoChance - 1) {
//					event.getEntity().dropItem(EnderAdvancement.ENDER_ESSENCE, 2);
					event.getEntity().worldObj.spawnEntityInWorld(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY + .1, event.getEntity().posZ, new ItemStack(EnderAdvancement.ENDER_ESSENCE, 2)));
				} else {
//					event.getEntity().dropItem(EnderAdvancement.ENDER_ESSENCE, 1);
					event.getEntity().worldObj.spawnEntityInWorld(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY + .1, event.getEntity().posZ, new ItemStack(EnderAdvancement.ENDER_ESSENCE, 1)));
				}
			}
		}
	}
}
