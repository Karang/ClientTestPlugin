package test.plugins.client.entities;

import net.royawesome.jlibnoise.MathHelper;

import org.spout.api.entity.component.Controller;
import org.spout.api.entity.component.controller.PlayerController;
import org.spout.api.entity.component.controller.type.ControllerType;
import org.spout.api.geo.discrete.Point;
import org.spout.api.player.Player;
import org.spout.api.player.PlayerInputState;

public class TestPlayer extends Controller implements PlayerController {

	protected TestPlayer(ControllerType type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onAttached() {
		// TODO Auto-generated method stub
		
	}
	
	public void onTick(float dt){
		PlayerInputState input = getPlayer().input();
		
		Point pos = getParent().getTransform().getPosition();
		
		
		if(input.getForward()) {
			pos = pos.add(getParent().getTransform().forwardVector());
		}
		if(input.getBackward()) {
			pos = pos.subtract(getParent().getTransform().forwardVector());
		}
		
	}

}
