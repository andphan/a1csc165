package a1;

import java.nio.*;

import sage.scene.TriMesh;

public class myNewTriMesh extends TriMesh{
	private float[] vrts = new float[] {0,1,0,-1,-1,1,1,-1,1,1,-1,-1,-1,-1,-1};
	private float[] cl = new float[] {1,0,0,1,0,1,0,1,0,0,1,1,1,1,0,1,1,0,1,1};
	private int[] tri = new int[] {0,1,2,0,2,3,0,3,4,0,4,1,1,4,2,4,3,2};
	
	public myNewTriMesh()
	{
		FloatBuffer vertBuf = com.jogamp.common.nio.Buffers.newDirectFloatBuffer(vrts);
		FloatBuffer clBuf = com.jogamp.common.nio.Buffers.newDirectFloatBuffer(cl);
		IntBuffer triBuf = com.jogamp.common.nio.Buffers.newDirectIntBuffer(tri);
	
		this.setVertexBuffer(vertBuf);
		this.setColorBuffer(clBuf);
		this.setIndexBuffer(triBuf);
		
	}
}