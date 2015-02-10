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
		Vector3D newLocVector = new Vector3D();
		Vector3D viewDir = camera.getViewDirection().normalize();
		Vector3D curLocVector = new Vector3D(camera.getLocation());
		// need to find out what direction to go
		
		if (e.getValue() < -0.2)
		{
			newLocVector = curLocVector.add(viewDir.mult(speed*timeElapsed));
		}
		else if (e.getValue() > 0.2)
		{
			newLocVector = curLocVector.add(viewDir.mult(speed*timeElapsed));
		}
		else { newLocVector = curLocVector; }
		
		
		// need to get old position
		// add 1 to new vector
	
		double newX = newLocVector.getX();
		double newY = newLocVector.getY();
		double newZ = newLocVector.getZ();
		Point3D newLoc = new Point3D(newX, newY, newZ);
		camera.setLocation(newLoc);
	}
}
