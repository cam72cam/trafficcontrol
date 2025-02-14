package com.clussmanproductions.trafficcontrol;

import com.clussmanproductions.trafficcontrol.blocks.BlockChannelizer;
import com.clussmanproductions.trafficcontrol.blocks.BlockCone;
import com.clussmanproductions.trafficcontrol.blocks.BlockCrossingGateBase;
import com.clussmanproductions.trafficcontrol.blocks.BlockCrossingGateCrossbuck;
import com.clussmanproductions.trafficcontrol.blocks.BlockCrossingGateGate;
import com.clussmanproductions.trafficcontrol.blocks.BlockCrossingGateLamps;
import com.clussmanproductions.trafficcontrol.blocks.BlockCrossingGatePole;
import com.clussmanproductions.trafficcontrol.blocks.BlockCrossingRelayNE;
import com.clussmanproductions.trafficcontrol.blocks.BlockCrossingRelayNW;
import com.clussmanproductions.trafficcontrol.blocks.BlockCrossingRelaySE;
import com.clussmanproductions.trafficcontrol.blocks.BlockCrossingRelaySW;
import com.clussmanproductions.trafficcontrol.blocks.BlockCrossingRelayTopNE;
import com.clussmanproductions.trafficcontrol.blocks.BlockCrossingRelayTopNW;
import com.clussmanproductions.trafficcontrol.blocks.BlockCrossingRelayTopSE;
import com.clussmanproductions.trafficcontrol.blocks.BlockCrossingRelayTopSW;
import com.clussmanproductions.trafficcontrol.blocks.BlockDrum;
import com.clussmanproductions.trafficcontrol.blocks.BlockLightSource;
import com.clussmanproductions.trafficcontrol.blocks.BlockOverhead;
import com.clussmanproductions.trafficcontrol.blocks.BlockOverheadCrossbuck;
import com.clussmanproductions.trafficcontrol.blocks.BlockOverheadLamps;
import com.clussmanproductions.trafficcontrol.blocks.BlockOverheadPole;
import com.clussmanproductions.trafficcontrol.blocks.BlockSafetranMechanical;
import com.clussmanproductions.trafficcontrol.blocks.BlockSafetranType3;
import com.clussmanproductions.trafficcontrol.blocks.BlockShuntBorder;
import com.clussmanproductions.trafficcontrol.blocks.BlockShuntIsland;
import com.clussmanproductions.trafficcontrol.blocks.BlockSign;
import com.clussmanproductions.trafficcontrol.blocks.BlockStreetLightDouble;
import com.clussmanproductions.trafficcontrol.blocks.BlockStreetLightSingle;
import com.clussmanproductions.trafficcontrol.blocks.BlockWigWag;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@ObjectHolder("trafficcontrol")
public class ModBlocks {
	@ObjectHolder("crossing_gate_base")
	public static BlockCrossingGateBase crossing_gate_base;
	@ObjectHolder("crossing_gate_gate")
	public static BlockCrossingGateGate crossing_gate_gate;
	@ObjectHolder("crossing_gate_lamps")
	public static BlockCrossingGateLamps crossing_gate_lamps;
	@ObjectHolder("crossing_gate_pole")
	public static BlockCrossingGatePole crossing_gate_pole;
	@ObjectHolder("crossing_gate_crossbuck")
	public static BlockCrossingGateCrossbuck crossing_gate_crossbuck;
	@ObjectHolder("safetran_type_3")
	public static BlockSafetranType3 safetran_type_3;
	@ObjectHolder("crossing_relay_se")
	public static BlockCrossingRelaySE crossing_relay_se;
	@ObjectHolder("crossing_relay_sw")
	public static BlockCrossingRelaySW crossing_relay_sw;
	@ObjectHolder("crossing_relay_nw")
	public static BlockCrossingRelayNW crossing_relay_nw;
	@ObjectHolder("crossing_relay_ne")
	public static BlockCrossingRelayNE crossing_relay_ne;
	@ObjectHolder("crossing_relay_top_sw")
	public static BlockCrossingRelayTopSW crossing_relay_top_sw;
	@ObjectHolder("crossing_relay_top_se")
	public static BlockCrossingRelayTopSE crossing_relay_top_se;
	@ObjectHolder("crossing_relay_top_nw")
	public static BlockCrossingRelayTopNW crossing_relay_top_nw;
	@ObjectHolder("crossing_relay_top_ne")
	public static BlockCrossingRelayTopNE crossing_relay_top_ne;
	@ObjectHolder("overhead_pole")
	public static BlockOverheadPole overhead_pole;
	@ObjectHolder("overhead")
	public static BlockOverhead overhead;
	@ObjectHolder("overhead_lamps")
	public static BlockOverheadLamps overhead_lamps;
	@ObjectHolder("overhead_crossbuck")
	public static BlockOverheadCrossbuck overhead_crossbuck;
	@ObjectHolder("safetran_mechanical")
	public static BlockSafetranMechanical safetran_mechanical;
	@ObjectHolder("sign")
	public static BlockSign sign;
	@ObjectHolder("cone")
	public static BlockCone cone;
	@ObjectHolder("channelizer")
	public static BlockChannelizer channelizer;
	@ObjectHolder("drum")
	public static BlockDrum drum;
	@ObjectHolder("street_light_single")
	public static BlockStreetLightSingle street_light_single;
	@ObjectHolder("light_source")
	public static BlockLightSource light_source;
	@ObjectHolder("street_light_double")
	public static BlockStreetLightDouble street_light_double;
	@ObjectHolder("wig_wag")
	public static BlockWigWag wig_wag;
	@ObjectHolder("shunt_border")
	public static BlockShuntBorder shunt_border;
	@ObjectHolder("shunt_island")
	public static BlockShuntIsland shunt_island;
	
	@SideOnly(Side.CLIENT)
	public static void initModels(ModelRegistryEvent e)
	{
		crossing_gate_base.initModel();
		crossing_gate_gate.initModel();
		crossing_gate_lamps.initModel();
		crossing_gate_pole.initModel();
		crossing_gate_crossbuck.initModel();
		safetran_type_3.initModel();
		overhead_pole.initModel();
		overhead.initModel();
		overhead_lamps.initModel();
		overhead_crossbuck.initModel();
		safetran_mechanical.initModel();
		sign.initModel();
		cone.initModel();
		channelizer.initModel();
		drum.initModel();
		street_light_single.initModel();
		street_light_double.initModel();
		wig_wag.initModel();
		shunt_border.initModel();
		shunt_island.initModel();
	}
}
