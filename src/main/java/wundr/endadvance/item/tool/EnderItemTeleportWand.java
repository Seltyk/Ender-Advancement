package wundr.endadvance.item.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;
import wundr.endadvance.EnderAdvancement;
import wundr.endadvance.item.EnderItem;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file<br>
 * Credits to Mojang, as the spawnParticle and playSound parameters used are from their code
 * @author wundrweapon
 * @see net.minecraft.entity.monster.EntityEnderman#attemptTeleport(double, double, double)
 */
public class EnderItemTeleportWand extends EnderItem {
	public EnderItemTeleportWand() {
		super("bebrd");
	}
	
	/**
	 * Teleports on right click, given circumstances
	 * @param world the {@link World} in which the item was right clicked
	 * @param player the {@link EntityPlayer} who right clicked this item
	 * @param hand the player's hand containing this item
	 * @return
	 */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		
		//Just because I don't want to constantly refer back to them
		boolean clearFallDamage = EnderAdvancement.canTeleportResetFallDamage;
		boolean teleportAir = EnderAdvancement.canTeleportToAir;
		boolean teleportStuck = EnderAdvancement.canTeleportDangerously;
		double distance = EnderAdvancement.teleportDistance;
		
		RayTraceResult tracedBlock = player.rayTrace(distance, 1); //Ray trace from the player hits a block
		
		if(tracedBlock.typeOfHit != Type.ENTITY) {
			BlockPos blockAbove = new BlockPos(tracedBlock.getBlockPos().getX(), tracedBlock.getBlockPos().getY() + 1, tracedBlock.getBlockPos().getZ());
			BlockPos blockTwoAbove = new BlockPos(tracedBlock.getBlockPos().getX(), tracedBlock.getBlockPos().getY() + 2, tracedBlock.getBlockPos().getZ());
			
			double endPosX = tracedBlock.getBlockPos().getX() + .5;
			double endPosY = tracedBlock.getBlockPos().getY() + 1;
			double endPosZ = tracedBlock.getBlockPos().getZ() + .5;
			
			boolean endPosAir = world.isAirBlock(tracedBlock.getBlockPos());
			boolean endPosStuck = !world.isAirBlock(blockAbove) || !world.isAirBlock(blockTwoAbove);
			
			//
			//This if/else clusterfuck is just that
			//
			
			//Runs if the end location would neither be in the air or in a block
			if(!endPosAir && !endPosStuck) {
				
				//This repeated block resets the player's fall distance, thus negating fall damage, if permitted. For those who with to use the BEBRD as a fall damage prevention tool
				if(clearFallDamage) {
					player.fallDistance = 0;
				}
				
				//This repeated block spawns portal particles client-side
				if(world.isRemote) {
					for(int i = 0; i < 10; i++) {
						world.spawnParticle(EnumParticleTypes.PORTAL, player.posX + (world.rand.nextDouble() - .5) * player.width, player.posY + world.rand.nextDouble() * player.height - .25, player.posZ + (world.rand.nextDouble() - .5) * player.width, (world.rand.nextDouble() - .5) * 2, -world.rand.nextDouble(), (world.rand.nextDouble() - .5) * 2);
					}
				}
				
				//This repeated block plays a teleport sound at the start location, moved the player, gives the BEBRD a cooldown, and plays a teleport sound at the end location
				player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
				player.setPosition(endPosX, endPosY, endPosZ);
				player.getCooldownTracker().setCooldown(this, 5);
				player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
				
				return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
			} else if(endPosAir && !endPosStuck) { //Runs if the end location is in the air but not in a block
				if(teleportAir) {
					if(clearFallDamage) {
						player.fallDistance = 0;
					}
					
					if(world.isRemote) {
						for(int i = 0; i < 10; i++) {
							world.spawnParticle(EnumParticleTypes.PORTAL, player.posX + (world.rand.nextDouble() - .5) * player.width, player.posY + world.rand.nextDouble() * player.height - .25, player.posZ + (world.rand.nextDouble() - .5) * player.width, (world.rand.nextDouble() - .5) * 2, -world.rand.nextDouble(), (world.rand.nextDouble() - .5) * 2);
						}
					}
					
					player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					player.setPosition(endPosX, endPosY, endPosZ);
					player.getCooldownTracker().setCooldown(this, 5);
					player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					
					return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItem(hand)); //Allowed to teleport into the air
				} else {
					return ActionResult.newResult(EnumActionResult.PASS, player.getHeldItem(hand)); //Not allowed to teleport into the air
				}
			} else if(!endPosAir && endPosStuck) { //Runs if the end location is in a block but not in the air
				if(teleportStuck) {
					if(clearFallDamage) {
						player.fallDistance = 0;
					}
					
					if(world.isRemote) {
						for(int i = 0; i < 10; i++) {
							world.spawnParticle(EnumParticleTypes.PORTAL, player.posX + (world.rand.nextDouble() - .5) * player.width, player.posY + world.rand.nextDouble() * player.height - .25, player.posZ + (world.rand.nextDouble() - .5) * player.width, (world.rand.nextDouble() - .5) * 2, -world.rand.nextDouble(), (world.rand.nextDouble() - .5) * 2);
						}
					}
					
					player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					player.setPosition(endPosX, endPosY, endPosZ);
					player.getCooldownTracker().setCooldown(this, 5);
					player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					
					return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItem(hand)); //Allowed to teleport into a block
				} else {
					return ActionResult.newResult(EnumActionResult.PASS, player.getHeldItem(hand)); //Not allowed to teleport into a block
				}
			} else if(endPosAir && endPosStuck) { //Runs if the end location is in a block and in the air
				if(teleportAir) {
					if(teleportStuck) {
						if(clearFallDamage) {
							player.fallDistance = 0;
						}
						
						if(world.isRemote) {
							for(int i = 0; i < 10; i++) {
								world.spawnParticle(EnumParticleTypes.PORTAL, player.posX + (world.rand.nextDouble() - .5) * player.width, player.posY + world.rand.nextDouble() * player.height - .25, player.posZ + (world.rand.nextDouble() - .5) * player.width, (world.rand.nextDouble() - .5) * 2, -world.rand.nextDouble(), (world.rand.nextDouble() - .5) * 2);
							}
						}
						
						player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
						player.setPosition(endPosX, endPosY, endPosZ);
						player.getCooldownTracker().setCooldown(this, 5);
						player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
						
						return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItem(hand)); //Allowed to teleport into the air and into a block
					} else {
						return ActionResult.newResult(EnumActionResult.PASS, player.getHeldItem(hand)); //Allowed to teleport into the air but not into a block
					}
				} else {
					return ActionResult.newResult(EnumActionResult.PASS, player.getHeldItem(hand)); //Not allowed to teleport into the air
				}
			} else {
				return ActionResult.newResult(EnumActionResult.FAIL, player.getHeldItem(hand)); //This only runs if the player somehow circumvents all possible if statement outcomes
			}
		} else {
			return ActionResult.newResult(EnumActionResult.PASS, player.getHeldItem(hand)); //Hits an entity
		}
	}
}
