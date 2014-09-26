package com.gjkf.fc.handler;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBeach;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenEnd;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenHell;
import net.minecraft.world.biome.BiomeGenHills;
import net.minecraft.world.biome.BiomeGenJungle;
import net.minecraft.world.biome.BiomeGenMesa;
import net.minecraft.world.biome.BiomeGenMushroomIsland;
import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.biome.BiomeGenRiver;
import net.minecraft.world.biome.BiomeGenSnow;
import net.minecraft.world.biome.BiomeGenStoneBeach;
import net.minecraft.world.biome.BiomeGenTaiga;
import net.minecraftforge.common.BiomeDictionary;

public class BiomesHandler{

	public static Map<Enum, Double> biomesMap = new HashMap<Enum, Double>();
	public static Map<BiomeGenBase, Double> vanillaBiomes = new HashMap<BiomeGenBase, Double>();

	public static void registerVanillaBiomes(){
		BiomeDictionary.registerBiomeType(new BiomeGenBeach(16), BiomeDictionary.Type.BEACH, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.HOT);
		BiomeDictionary.registerBiomeType(new BiomeGenForest(27, 2), BiomeDictionary.Type.FOREST);
		BiomeDictionary.registerBiomeType(new BiomeGenForest(28, 2), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS);
		BiomeDictionary.registerBiomeType(new BiomeGenBeach(26), BiomeDictionary.Type.COLD, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.HOT);
		BiomeDictionary.registerBiomeType(new BiomeGenTaiga(30, 0), BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY);
		BiomeDictionary.registerBiomeType(new BiomeGenTaiga(31, 0), BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.HILLS);
		BiomeDictionary.registerBiomeType(new BiomeGenOcean(24), BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WATER);
		BiomeDictionary.registerBiomeType(new BiomeGenDesert(2), BiomeDictionary.Type.SANDY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY);
		BiomeDictionary.registerBiomeType(new BiomeGenDesert(17), BiomeDictionary.Type.SANDY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY);
		BiomeDictionary.registerBiomeType(new BiomeGenHills(3, false), BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS);
		BiomeDictionary.registerBiomeType(new BiomeGenHills(20, true), BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS);
		BiomeDictionary.registerBiomeType(new BiomeGenHills(34, true), BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS);
		BiomeDictionary.registerBiomeType(new BiomeGenForest(4, 0), BiomeDictionary.Type.FOREST);
		BiomeDictionary.registerBiomeType(new BiomeGenForest(18, 0), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS);
		BiomeDictionary.registerBiomeType(new BiomeGenOcean(10), BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WATER);
		BiomeDictionary.registerBiomeType(new BiomeGenRiver(11), BiomeDictionary.Type.COLD, BiomeDictionary.Type.RIVER);
		BiomeDictionary.registerBiomeType(new BiomeGenHell(8), BiomeDictionary.Type.NETHER);
		BiomeDictionary.registerBiomeType(new BiomeGenSnow(13, false), BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS);
		BiomeDictionary.registerBiomeType(new BiomeGenSnow(12, false), BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.PLAINS);
		BiomeDictionary.registerBiomeType(new BiomeGenJungle(21, false), BiomeDictionary.Type.JUNGLE);
		BiomeDictionary.registerBiomeType(new BiomeGenJungle(23, false), BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HILLS);
		BiomeDictionary.registerBiomeType(new BiomeGenJungle(22, false), BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HILLS);
		BiomeDictionary.registerBiomeType(new BiomeGenTaiga(32, 1), BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST);
		BiomeDictionary.registerBiomeType(new BiomeGenTaiga(33, 1), BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS);
		BiomeDictionary.registerBiomeType(new BiomeGenStoneBeach(25), BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.HILLS);
		BiomeDictionary.registerBiomeType(new BiomeGenMesa(38, false, true), BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.HILLS);
		BiomeDictionary.registerBiomeType(new BiomeGenMesa(39, false, false), BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.HILLS);
		BiomeDictionary.registerBiomeType(new BiomeGenMushroomIsland(14), BiomeDictionary.Type.MUSHROOM);
		BiomeDictionary.registerBiomeType(new BiomeGenMushroomIsland(15), BiomeDictionary.Type.MUSHROOM);
		BiomeDictionary.registerBiomeType(new BiomeGenSnow(12, false), BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WATER);
		BiomeDictionary.registerBiomeType(new BiomeGenPlains(1), BiomeDictionary.Type.PLAINS);
		BiomeDictionary.registerBiomeType(new BiomeGenRiver(7), BiomeDictionary.Type.RIVER);
		BiomeDictionary.registerBiomeType(new BiomeGenForest(29, 3), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE);
		BiomeDictionary.registerBiomeType(new BiomeGenStoneBeach(25), BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.DRY);
		BiomeDictionary.registerBiomeType(new BiomeGenStoneBeach(25), BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.DRY);
		BiomeDictionary.registerBiomeType(new BiomeGenEnd(9), BiomeDictionary.Type.END);
		BiomeDictionary.registerBiomeType(new BiomeGenStoneBeach(25), BiomeDictionary.Type.BEACH);
		BiomeDictionary.registerBiomeType(BiomeGenBase.swampland, BiomeDictionary.Type.SWAMP);
		BiomeDictionary.registerBiomeType(new BiomeGenTaiga(5, 0), BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY);
		BiomeDictionary.registerBiomeType(new BiomeGenTaiga(19, 0), BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.HILLS);
	}

	public static void putAllBiomes(){
		biomesMap.put(BiomeDictionary.Type.BEACH, 303.15);
		biomesMap.put(BiomeDictionary.Type.COLD, 278.15);
		biomesMap.put(BiomeDictionary.Type.CONIFEROUS, 285.15);
		biomesMap.put(BiomeDictionary.Type.DEAD, 285.15);
		biomesMap.put(BiomeDictionary.Type.DENSE, 298.15);
		biomesMap.put(BiomeDictionary.Type.DRY, 313.15);
		biomesMap.put(BiomeDictionary.Type.END, 243.15);
		biomesMap.put(BiomeDictionary.Type.FOREST, 298.15);
		biomesMap.put(BiomeDictionary.Type.HILLS, 278.15);
		biomesMap.put(BiomeDictionary.Type.HOT, 313.15);
		biomesMap.put(BiomeDictionary.Type.JUNGLE, 303.15);
		biomesMap.put(BiomeDictionary.Type.LUSH, 298.15);
		biomesMap.put(BiomeDictionary.Type.MAGICAL, 298.15);
		biomesMap.put(BiomeDictionary.Type.MESA, 298.15);
		biomesMap.put(BiomeDictionary.Type.MOUNTAIN, 273.15);
		biomesMap.put(BiomeDictionary.Type.MUSHROOM, 298.15);
		biomesMap.put(BiomeDictionary.Type.NETHER, 673.15);
		biomesMap.put(BiomeDictionary.Type.OCEAN, 298.15);
		biomesMap.put(BiomeDictionary.Type.PLAINS, 298.15);
		biomesMap.put(BiomeDictionary.Type.RIVER, 298.15);
		biomesMap.put(BiomeDictionary.Type.SANDY, 313.15);
		biomesMap.put(BiomeDictionary.Type.SAVANNA, 303.15);
		biomesMap.put(BiomeDictionary.Type.SNOWY, 273.15);
		biomesMap.put(BiomeDictionary.Type.SPARSE, 300.15);
		biomesMap.put(BiomeDictionary.Type.SPOOKY, 283.15);
		biomesMap.put(BiomeDictionary.Type.SWAMP, 303.15);
		biomesMap.put(BiomeDictionary.Type.WASTELAND, 303.15);
		biomesMap.put(BiomeDictionary.Type.WATER, 298.15);
		biomesMap.put(BiomeDictionary.Type.WET, 298.15);
		
		vanillaBiomes.put(BiomeGenBase.beach, 303.5);
		vanillaBiomes.put(BiomeGenBase.birchForest, 298.15);
		vanillaBiomes.put(BiomeGenBase.birchForestHills, 298.15);
		vanillaBiomes.put(BiomeGenBase.coldBeach, 278.15);
		vanillaBiomes.put(BiomeGenBase.coldTaiga, 278.15);
		vanillaBiomes.put(BiomeGenBase.coldTaigaHills, 278.15);
		vanillaBiomes.put(BiomeGenBase.deepOcean, 298.15);
		vanillaBiomes.put(BiomeGenBase.desert, 313.15);
		vanillaBiomes.put(BiomeGenBase.desertHills, 313.15);
		vanillaBiomes.put(BiomeGenBase.extremeHills, 278.15);
		vanillaBiomes.put(BiomeGenBase.forest, 298.15);
		vanillaBiomes.put(BiomeGenBase.extremeHillsEdge, 278.15);
		vanillaBiomes.put(BiomeGenBase.extremeHillsPlus, 278.15);
		vanillaBiomes.put(BiomeGenBase.forestHills, 298.15);
		vanillaBiomes.put(BiomeGenBase.frozenOcean, 273.15);
		vanillaBiomes.put(BiomeGenBase.frozenRiver, 273.15);
		vanillaBiomes.put(BiomeGenBase.iceMountains, 273.15);
		vanillaBiomes.put(BiomeGenBase.hell, 673.15);
		vanillaBiomes.put(BiomeGenBase.icePlains, 273.15);
		vanillaBiomes.put(BiomeGenBase.jungle, 303.15);
		vanillaBiomes.put(BiomeGenBase.jungleEdge, 303.15);
		vanillaBiomes.put(BiomeGenBase.jungleHills, 303.15);
		vanillaBiomes.put(BiomeGenBase.megaTaiga, 283.15);
		vanillaBiomes.put(BiomeGenBase.mesa, 298.15);
		vanillaBiomes.put(BiomeGenBase.mesaPlateau, 298.15);
		vanillaBiomes.put(BiomeGenBase.mesaPlateau_F, 298.15);
		vanillaBiomes.put(BiomeGenBase.mushroomIsland, 298.15);
		vanillaBiomes.put(BiomeGenBase.mushroomIslandShore, 298.15);
		vanillaBiomes.put(BiomeGenBase.ocean, 298.15);
		vanillaBiomes.put(BiomeGenBase.river, 298.15);
		vanillaBiomes.put(BiomeGenBase.roofedForest, 298.15);
		vanillaBiomes.put(BiomeGenBase.savanna, 303.15);
		vanillaBiomes.put(BiomeGenBase.savannaPlateau, 303.15);
		vanillaBiomes.put(BiomeGenBase.sky, 243.15);
		vanillaBiomes.put(BiomeGenBase.stoneBeach, 303.5);
		vanillaBiomes.put(BiomeGenBase.swampland, 303.15);
		vanillaBiomes.put(BiomeGenBase.taiga, 283.15);
		vanillaBiomes.put(BiomeGenBase.taigaHills, 283.15);

	}
	
}