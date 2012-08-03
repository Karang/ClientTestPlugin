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
package test.plugins.client.controller.player;

import test.plugins.client.controller.TestControllerTypes;

import org.spout.api.Client;
import org.spout.api.Spout;
import org.spout.api.entity.component.controller.BasicController;
import org.spout.api.entity.component.controller.PlayerController;
import org.spout.api.geo.discrete.Point;
import org.spout.api.player.Player;
import org.spout.api.player.PlayerInputState;
import org.spout.api.plugin.Platform;
import org.spout.api.render.CameraComponent;

public class TestPlayerController extends BasicController implements PlayerController {
	private final CameraComponent camera;
	private PlayerInputState input;
	private Point pos;

	public TestPlayerController() {
		super (TestControllerTypes.TEST_PLAYER);
		this.camera = new CameraComponent();
		if (Spout.getPlatform() == Platform.CLIENT) {
			((Client) Spout.getEngine()).setActiveCamera(camera);
		}
	}

	@Override
	public void onAttached() {
		getParent().setDisplayName("Spouty 2");
		getParent().attachComponent(new CameraComponent());
	}

	@Override
	public void onTick(float dt) {
		input = getParent().input();
		pos = getParent().getTransform().getPosition();

		if (input.getForward()) {
			pos = pos.add(getParent().getTransform().forwardVector());
		}

		if (input.getBackward()) {
			pos = pos.subtract(getParent().getTransform().forwardVector());
		}
	}

	@Override
	public Player getParent() {
		return (super.getParent() instanceof Player) ? (Player) super.getParent() : null;
	}
}
