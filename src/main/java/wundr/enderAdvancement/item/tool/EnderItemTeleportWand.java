package wundr.enderAdvancement.item.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;
import wundr.enderAdvancement.Main;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file<br>
 * Credits to Mojang, as the spawnParticle and playSound parameters used are from their code
 * 
 * @author wundrweapon
 * @see net.minecraft.entity.monster.EntityEnderman
 */
public class EnderItemTeleportWand extends Item {
	private boolean clearFallDamage, teleportAir, teleportStuck;
	private double distance;
	private static String name = "bebrd";
	public static final ResourceLocation REGISTRY_RL = new ResourceLocation(Main.MOD_ID + ":" + name);
	
	public EnderItemTeleportWand() {
		setRegistryName(REGISTRY_RL);
		setUnlocalizedName(Main.MOD_ID + "_" + name);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		clearFallDamage = Main.canTakeFallDamageFromTeleport;
		teleportAir = Main.canTeleportToAir;
		teleportStuck = Main.canTeleportDangerously;
		distance = Main.teleportDistance;
		
		RayTraceResult tracedBlock = player.rayTrace(distance, 1);
		
		if(tracedBlock.typeOfHit != Type.ENTITY) {
			BlockPos blockAbove = new BlockPos(tracedBlock.getBlockPos().getX(), tracedBlock.getBlockPos().getY() + 1, tracedBlock.getBlockPos().getZ());
			BlockPos blockTwoAbove = new BlockPos(tracedBlock.getBlockPos().getX(), tracedBlock.getBlockPos().getY() + 2, tracedBlock.getBlockPos().getZ());
			
			double endPosX = tracedBlock.getBlockPos().getX() + .5;
			double endPosY = tracedBlock.getBlockPos().getY() + 1;
			double endPosZ = tracedBlock.getBlockPos().getZ() + .5;
			
			boolean endPosAir = world.isAirBlock(tracedBlock.getBlockPos());
			boolean endPosStuck = !world.isAirBlock(blockAbove) || !world.isAirBlock(blockTwoAbove);
			
			//This is a mess
			if(!endPosAir && !endPosStuck) {
				if(clearFallDamage) {
					player.fallDistance = 0;
				}
				
				if(world.isRemote) {
					for(int i = 0; i < 10; i++) {
						world.spawnParticle(EnumParticleTypes.PORTAL, player.posX + (world.rand.nextDouble() - .5) * player.width, player.posY + world.rand.nextDouble() * player.height - .25, player.posZ + (world.rand.nextDouble() - .5) * player.width, (world.rand.nextDouble() - .5) * 2, -world.rand.nextDouble(), (world.rand.nextDouble() - .5) * 2);
					}
				}
				
				world.playSound((EntityPlayer) null, new BlockPos(endPosX, endPosY, endPosZ), SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.HOSTILE, 1, 1);
				player.setPosition(endPosX, endPosY, endPosZ);
				player.getCooldownTracker().setCooldown(this, 5);
				player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
				
				return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
			} else if(endPosAir && !endPosStuck) {
				if(teleportAir) {
					if(clearFallDamage) {
						player.fallDistance = 0;
					}
					
					if(world.isRemote) {
						for(int i = 0; i < 10; i++) {
							world.spawnParticle(EnumParticleTypes.PORTAL, player.posX + (world.rand.nextDouble() - .5) * player.width, player.posY + world.rand.nextDouble() * player.height - .25, player.posZ + (world.rand.nextDouble() - .5) * player.width, (world.rand.nextDouble() - .5) * 2, -world.rand.nextDouble(), (world.rand.nextDouble() - .5) * 2);
						}
					}
					
					world.playSound((EntityPlayer) null, new BlockPos(endPosX, endPosY, endPosZ), SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.HOSTILE, 1, 1);
					player.setPosition(endPosX, endPosY, endPosZ);
					player.getCooldownTracker().setCooldown(this, 5);
					player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					
					return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
				} else {
					return ActionResult.newResult(EnumActionResult.PASS, stack);
				}
			} else if(!endPosAir && endPosStuck) {
				if(teleportStuck) {
					if(clearFallDamage) {
						player.fallDistance = 0;
					}
					
					if(world.isRemote) {
						for(int i = 0; i < 10; i++) {
							world.spawnParticle(EnumParticleTypes.PORTAL, player.posX + (world.rand.nextDouble() - .5) * player.width, player.posY + world.rand.nextDouble() * player.height - .25, player.posZ + (world.rand.nextDouble() - .5) * player.width, (world.rand.nextDouble() - .5) * 2, -world.rand.nextDouble(), (world.rand.nextDouble() - .5) * 2);
						}
					}
					
					world.playSound((EntityPlayer) null, new BlockPos(endPosX, endPosY, endPosZ), SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.HOSTILE, 1, 1);
					player.setPosition(endPosX, endPosY, endPosZ);
					player.getCooldownTracker().setCooldown(this, 5);
					player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					
					return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
				} else {
					return ActionResult.newResult(EnumActionResult.PASS, stack);
				}
			} else if(endPosAir && endPosStuck) {
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
						
						world.playSound((EntityPlayer) null, new BlockPos(endPosX, endPosY, endPosZ), SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.HOSTILE, 1, 1);
						player.setPosition(endPosX, endPosY, endPosZ);
						player.getCooldownTracker().setCooldown(this, 5);
						player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
						
						return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
					} else {
						return ActionResult.newResult(EnumActionResult.PASS, stack);
					}
				} else {
					return ActionResult.newResult(EnumActionResult.PASS, stack);
				}
			} else {
				return ActionResult.newResult(EnumActionResult.FAIL, stack);
			}
		} else {
			return ActionResult.newResult(EnumActionResult.PASS, stack);
		}
	}
}
