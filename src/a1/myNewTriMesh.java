package a1;

import java.nio.*;

import sage.scene.TriMesh;

public class myNewTriMesh extends TriMesh{
	
	private float[] vrts = new float[]  {0,-1,0,1,1,-1,-1,-1,1,1,0,0,-2,-2, 0}; // create new verticies keep on messing around with this
//	private int[] tri = new int[] {0,1,2,0,2,3,0,3,4,0,4,1,1,4,2,4,3,2};
	private int[] tri = new int[] {0,1,2,1,1,1,0,1,1,0,1,1,1,1,2,1,1,1};
	
	public myNewTriMesh()
	{
		FloatBuffer vertBuf = com.jogamp.common.nio.Buffers.newDirectFloatBuffer(vrts);
		IntBuffer triBuf = com.jogamp.common.nio.Buffers.newDirectIntBuffer(tri);
	
		this.setVertexBuffer(vertBuf);
		this.setIndexBuffer(triBuf);
		
	}
}
