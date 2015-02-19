package a1;

import graphicslib3D.Point3D;
import graphicslib3D.Vector3D;
import sage.camera.ICamera;
import sage.input.action.AbstractInputAction;

public class ForwardCameraMovement extends AbstractInputAction {

	private ICamera camera;
	private float speed;
	
	public ForwardCameraMovement(ICamera c, float s)
	{
		camera = c;
		speed = s;
	}
	
	public void performAction(float timeElapsed, net.java.games.input.Event e)
	{
		
	}
}
