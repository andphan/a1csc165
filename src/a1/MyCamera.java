package a1;

import graphicslib3D.Point3D;
import graphicslib3D.Vector3D;

public class MyCamera implements MyICamera{

	// initialize variables
	private Point3D cameraLoc;
	private Vector3D rightAxis;
	private Vector3D upAxis;
	private Vector3D viewDirection;
	private double fieldOfViewY;
	private double aspectRatio;
	private double nearDistance;
	private double farDistance;

	public Point3D getLocation() {
	
		return cameraLoc; 
	}


	public Vector3D getRightAxis() { 
		
		return rightAxis; // u 
	}


	public Vector3D getUpAxis() {

		return upAxis; // V
	}


	public Vector3D getViewDiretion() {

		return viewDirection; // N
	}


	public void setLocation(Point3D loc) {

		this.cameraLoc = loc;
	}

	
	public void setRightAxis(Vector3D right) {

		this.rightAxis = right;
	}

	
	public void setUpAxis(Vector3D up) {

		this.upAxis = up;
	}

	
	public void setViewDirction(Vector3D viewDir) {

		this.viewDirection = viewDir;
	}

	
	public void setAxes(Vector3D right, Vector3D up, Vector3D viewDir) {

		this.rightAxis = right;
		this.upAxis = up;
		this.viewDirection = viewDir;
		
	}

	
	public double[] getPerspectiveFrustumSettings() {
		
		double [] arr;
		
		arr = new double[4];
		
		arr[0] = this.fieldOfViewY;
		arr[1] = this.aspectRatio;
		arr[2] = this.nearDistance;
		arr[3] = this.farDistance;
		
		return arr;
		
	}

	
	public void setPerspectiveFrustum(double fovY, double aspect, double near,
			double far) {
		
		this.fieldOfViewY = fovY;
		this.aspectRatio = aspect;
		this.nearDistance = near;
		this.farDistance = far;
	}
	

}
