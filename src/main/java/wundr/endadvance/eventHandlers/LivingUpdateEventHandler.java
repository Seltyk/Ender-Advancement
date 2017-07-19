package wundr.endadvance.eventHandlers;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.endadvance.EnderAdvancement;
import wundr.endadvance.item.EnderItemEssence;

import java.util.ArrayList;

/**
 * Makes portal particles when a non-Enderman entity holds {@link EnderItemEssence} - 2 particles for every piece of Essence<br>
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to Mojang, as the spawnParticle parameters used are from their code
 * @author wundrweapon
 * @see net.minecraft.entity.monster.EntityEnderman#onLivingUpdate()
 */
@EventBusSubscriber(modid = EnderAdvancement.MOD_ID)
@SuppressWarnings("unused")
public class LivingUpdateEventHandler {
	
	/**
	 * This is what actually does the whole "put down some portal particles" thing
	 * @param event the {@link LivingUpdateEvent} being handled
	 */
	@SubscribeEvent
	public static void onLivingUpdate(LivingUpdateEvent event) {
		if(event.getEntity().world.isRemote && !(event.getEntity() instanceof EntityEnderman)) {
			try {
				for(ItemStack stack : event.getEntity().getHeldEquipment()) {
					if(stack.getItem() instanceof EnderItemEssence) {
						for(int i = 0; i < stack.getCount(); i++) {
							event.getEntity().world.spawnParticle(EnumParticleTypes.PORTAL, event.getEntity().posX + (event.getEntity().world.rand.nextDouble() - .5) * event.getEntity().width, event.getEntity().posY + event.getEntity().world.rand.nextDouble() * event.getEntity().height - .25, event.getEntity().posZ + (event.getEntity().world.rand.nextDouble() - .5) * event.getEntity().width, (event.getEntity().world.rand.nextDouble() - .5) * 2, -event.getEntity().world.rand.nextDouble(), (event.getEntity().world.rand.nextDouble() - .5) * 2);
							event.getEntity().world.spawnParticle(EnumParticleTypes.PORTAL, event.getEntity().posX + (event.getEntity().world.rand.nextDouble() - .5) * event.getEntity().width, event.getEntity().posY + event.getEntity().world.rand.nextDouble() * event.getEntity().height - .25, event.getEntity().posZ + (event.getEntity().world.rand.nextDouble() - .5) * event.getEntity().width, (event.getEntity().world.rand.nextDouble() - .5) * 2, -event.getEntity().world.rand.nextDouble(), (event.getEntity().world.rand.nextDouble() - .5) * 2);
						}
					}
				}
			} catch(NullPointerException e) {}
		}
	}
}
