package com.github.epiicthundercat.snowanimals.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.epiicthundercat.snowanimals.Snowanimals;
import com.github.epiicthundercat.snowanimals.entity.passive.EntityArticFox;
import com.github.epiicthundercat.snowanimals.entity.passive.EntityArticOwl;
import com.github.epiicthundercat.snowanimals.entity.passive.EntityHarpSeal;

import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
	public static void init() {

		// Every entity in our mod has an ID (local to this mod)

		// Harp Seal
		EntityRegistry.registerModEntity(EntityHarpSeal.class, "HarpSeal", 0, Snowanimals.instance, 80, 3, false,
				0xffffff, 0xd9d9d9);
		// Artic Owl
		EntityRegistry.registerModEntity(EntityArticOwl.class, "ArticOwl", 1, Snowanimals.instance, 80, 3, false,
				0xffffff, 0xd9d9d9);
		// Artic Fox
				EntityRegistry.registerModEntity(EntityArticFox.class, "ArticFox", 2, Snowanimals.instance, 80, 3, false,
						0xffffff, 0xd9d9d9);

		/*
		 * We want our mob to spawn in Plains and ice plains biomes. If you
		 * don't add this then it will not spawn automatically but you can of
		 * course still make it spawn manually
		 */

		// Harp Seal
		EntityRegistry.addSpawn(EntityHarpSeal.class, 2, 4, 8, EnumCreatureType.CREATURE, Biomes.FROZEN_OCEAN,
				Biomes.FROZEN_RIVER, Biomes.COLD_BEACH, Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS,
				Biomes.ICE_MOUNTAINS, Biomes.ICE_PLAINS, Biomes.MUTATED_ICE_FLATS, Biomes.STONE_BEACH, Biomes.BEACH);
		// Artic Owl
		EntityRegistry.addSpawn(EntityArticOwl.class, 2, 4, 8, EnumCreatureType.AMBIENT, Biomes.FROZEN_OCEAN,
						Biomes.FROZEN_RIVER, Biomes.COLD_BEACH, Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS,
						Biomes.ICE_MOUNTAINS, Biomes.ICE_PLAINS, Biomes.MUTATED_ICE_FLATS, Biomes.STONE_BEACH, Biomes.BEACH);
		// Artic Fox
		EntityRegistry.addSpawn(EntityArticFox.class, 2, 4, 8, EnumCreatureType.AMBIENT, Biomes.FROZEN_OCEAN,
						Biomes.FROZEN_RIVER, Biomes.COLD_BEACH, Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS,
						Biomes.ICE_MOUNTAINS, Biomes.ICE_PLAINS, Biomes.MUTATED_ICE_FLATS, Biomes.STONE_BEACH, Biomes.BEACH);

		/*
		 * Mob Placement
		 */

		// Harp Seal
		EntitySpawnPlacementRegistry.setPlacementType(EntityHarpSeal.class, SpawnPlacementType.IN_WATER);
		// Artic Owl
		EntitySpawnPlacementRegistry.setPlacementType(EntityArticOwl.class, SpawnPlacementType.IN_AIR);
		// Artic Fox
		EntitySpawnPlacementRegistry.setPlacementType(EntityArticFox.class, SpawnPlacementType.ON_GROUND);

		// Harp Seal
		LootTableList.register(EntityHarpSeal.LOOT_SEAL);
		// Artic Fox
		LootTableList.register(EntityArticFox.LOOT_ARTIC_FOX);
		// Artic Owl
		LootTableList.register(EntityArticOwl.LOOT_ARTIC_OWL);
	}

	private static Biome[] getVillagerBiomeList() {
		List<Biome> biomes = new ArrayList<Biome>();
		Iterator<Biome> biomeList = Biome.REGISTRY.iterator();
		while (biomeList.hasNext()) {
			Biome currentBiome = biomeList.next();
			List<SpawnListEntry> spawnList = currentBiome.getSpawnableList(EnumCreatureType.CREATURE);
			for (SpawnListEntry spawnEntry : spawnList) {
				if (spawnEntry.entityClass == EntityVillager.class) {
					biomes.add(currentBiome);
				}
			}
		}
		return biomes.toArray(new Biome[biomes.size()]);
	}
}