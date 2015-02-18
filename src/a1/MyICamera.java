package a1;

import graphicslib3D.*;

public interface MyICamera {

		public Point3D getLocation();
		public Vector3D getRightAxis();
		public Vector3D getUpAxis();
		public Vector3D getViewDiretion();
		
		public void setLocation(Point3D loc);
		public void setRightAxis(Vector3D right);
		public void setUpAxis(Vector3D up);
		public void setViewDirction(Vector3D viewDir);
		public void setAxes(Vector3D right, Vector3D up, Vector3D viewDir);
		
		public double[] getPerspectiveFrustumSettings();
		public void setPerspectiveFrustum(double fovY, double aspect, double near, double far);
}
