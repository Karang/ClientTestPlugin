/*
 * This file is part of ClientTestPlugin.
 *
 * Copyright (c) 2012, SpoutDev <http://www.spout.org/>
 * ClientTestPlugin is licensed under the SpoutDev License Version 1.
 *
 * ClientTestPlugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * ClientTestPlugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package test.plugins.client;

import test.plugins.client.world.generator.FlatGenerator;

import org.spout.api.Engine;
import org.spout.api.geo.World;
import org.spout.api.geo.discrete.Point;
import org.spout.api.geo.discrete.Transform;
import org.spout.api.math.Quaternion;
import org.spout.api.math.Vector3;
import org.spout.api.plugin.CommonPlugin;

public class ClientTestPlugin extends CommonPlugin {
	private Engine engine;

	@Override
	public void onLoad() {
		engine = getEngine();
	}

	@Override
	public void onEnable() {
		//Load our test world
		World test = engine.loadWorld("test_world", new FlatGenerator(8));
		if (test.getAge() <= 0) {
			test.setSpawnPoint(new Transform(new Point(test, 1, 9, 1), Quaternion.IDENTITY, Vector3.ONE));
		}
		getLogger().info("enabled.");
	}

	@Override
	public void onDisable() {
		getLogger().info("disabled.");
	}
}
