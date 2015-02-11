package a1;

import java.nio.*;

import sage.scene.TriMesh;

public class myNewTriMesh extends TriMesh{
	
	private float[] vrts = new float[] {4,3,1,-4,-4,3,2,-3,4,5,-2, 4,-3,2,1}; // create new verticies
//	private float[] cl = new float[] {1,0,0,1,0,1,0,1,0,0,1,1,1,1,0,1,1,0,1,1};
	private int[] tri = new int[] {0,4,6,0,7,12,0,3,5,0,1,3,3,7,8,3,8, 1};
	
	public myNewTriMesh()
	{
		FloatBuffer vertBuf = com.jogamp.common.nio.Buffers.newDirectFloatBuffer(vrts);
	//	FloatBuffer clBuf = com.jogamp.common.nio.Buffers.newDirectFloatBuffer(cl);
		IntBuffer triBuf = com.jogamp.common.nio.Buffers.newDirectIntBuffer(tri);
	
		this.setVertexBuffer(vertBuf);
	//	this.setColorBuffer(clBuf);
		this.setIndexBuffer(triBuf);
		
	}
}
