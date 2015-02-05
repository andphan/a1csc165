package a1;

import java.nio.*;

import sage.scene.TriMesh;

public class myNewTriMesh extends TriMesh{
	private float[] vrts = new float[] {};
	private float[] cl = new float[] {};
	private int[] tri = new int[] {};
	
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
