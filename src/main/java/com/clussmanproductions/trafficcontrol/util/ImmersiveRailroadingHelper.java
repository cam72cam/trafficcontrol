package com.clussmanproductions.trafficcontrol.util;
import java.util.List;
import java.util.UUID;

import cam72cam.immersiverailroading.blocks.BlockRailBase;
import cam72cam.immersiverailroading.entity.EntityMoveableRollingStock;
import cam72cam.immersiverailroading.tile.TileRailBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ImmersiveRailroadingHelper {
	public static Vec3d findOrigin(BlockPos currentPos, EnumFacing signalFacing, World world)
	{
		Vec3d retVal = new Vec3d(0, -1, 0);
		
		EnumFacing searchDirection = signalFacing.rotateY().rotateY().rotateY();
		
		BlockPos workingPos = new BlockPos(currentPos.getX(), currentPos.getY() - 3, currentPos.getZ());
		for(int y = 0; y < 6; y++)
		{
			for(int i = 0; i <= 10; i++)
			{
				workingPos = workingPos.offset(searchDirection);
				
				if (world.getBlockState(workingPos).getBlock() instanceof BlockRailBase)
				{
					TileRailBase tile = (TileRailBase)world.getTileEntity(workingPos);
					if (tile == null)
					{
						continue;
					}
					
					Vec3d current = new Vec3d(workingPos.getX(), workingPos.getY(), workingPos.getZ());
					
					Vec3d center = tile.getNextPosition(current, new Vec3d(0, 0, 0));
					
					retVal = new Vec3d(center.x, center.y, center.z);
					break;
				}
			}
			
			workingPos = new BlockPos(currentPos.getX(), workingPos.getY() + 1, currentPos.getZ());
		}
		
		return retVal;
	}
	
	public static Vec3d getNextPosition(Vec3d currentPosition, Vec3d motion, World world)
	{
		BlockPos currentBlockPos = new BlockPos(currentPosition.x, currentPosition.y, currentPosition.z);
		TileEntity te = world.getTileEntity(currentBlockPos);
		
		int attempt = 0;
		while(te == null && attempt < 8)
		{
			switch(attempt)
			{
				case 0:
					currentBlockPos = currentBlockPos.up();
					break;
				case 1:
					currentBlockPos = currentBlockPos.down(2);
					break;
				case 2:
					currentBlockPos = currentBlockPos.up();
					EnumFacing direction = EnumFacing.getFacingFromVector((float)motion.x, (float)motion.y, (float)motion.z).rotateY();
					currentBlockPos = currentBlockPos.offset(direction);
					break;
				case 3:
					direction = EnumFacing.getFacingFromVector((float)motion.x, (float)motion.y, (float)motion.z).rotateY().rotateY().rotateY();
					currentBlockPos = currentBlockPos.offset(direction, 2);
					break;
				case 4:
					currentBlockPos = currentBlockPos.up();
					break;
				case 5:
					currentBlockPos = currentBlockPos.down(2);
					break;
				case 6:
					direction = EnumFacing.getFacingFromVector((float)motion.x, (float)motion.y, (float)motion.z).rotateY();
					currentBlockPos = currentBlockPos.offset(direction, 2);
					break;
				case 7:
					currentBlockPos = currentBlockPos.up(2);
					break;
			}
			
			te = world.getTileEntity(currentBlockPos);
			attempt++;
		}
		
		if (te == null)
		{
			return currentPosition;
		}
		
		TileRailBase railBase = (TileRailBase)te;
		
		return railBase.getNextPosition(currentPosition, motion);
	}
	
	public static Tuple<UUID, Vec3d> getStockNearby(Vec3d currentPosition, World world)
	{
		BlockPos currentBlockPos = new BlockPos(currentPosition.x, currentPosition.y, currentPosition.z);
		
		AxisAlignedBB bb = new AxisAlignedBB(currentBlockPos.south().west(), currentBlockPos.up(3).east().north());
		List<EntityMoveableRollingStock> stocks = world.getEntitiesWithinAABB(EntityMoveableRollingStock.class, bb);
		
		if (!stocks.isEmpty())
		{
			EntityMoveableRollingStock stock = stocks.get(0);
			return new Tuple<UUID, Vec3d>(stock.getPersistentID(), stock.getVelocity());
		}
		else
		{
			return null;
		}
	}

	public static boolean blockPosIsRail(BlockPos pos, World world)
	{
		return world.getBlockState(pos).getBlock() instanceof BlockRailBase;
	}
}