package a1;
import sage.app.BaseGame;
import sage.camera.*;
import sage.display.*;
import sage.event.IEventManager;
import sage.input.*;
import sage.input.action.*;
import sage.scene.*;
import sage.scene.shape.*;
import graphicslib3D.Matrix3D;
import graphicslib3D.Point3D;

import java.awt.event.*;
import java.util.Random;
import java.awt.Color;
import java.nio.*;
import java.text.DecimalFormat;

import net.java.games.input.Event;


public class treasurehunt2015 extends BaseGame {
	// what type of objects are in the game
	// world
	// player
	// treasures
	// treasure chest
	IDisplaySystem display;
	ICamera camera;
	IInputManager im;
	IEventManager em;
	myNewTriMesh aPyr;
	Rectangle rect;
	private int score = 0;
	private float time = 0;
	private HUDString scoreD;
	private HUDString timeD;
	
		public void initGame()
		{	
			IInputManager im = getInputManager();
			// initialize Managers
			System.out.println("initGame call");
			initGameObjects();	
			
			//
		}
			
		public void initGameObjects()
		{
			display = getDisplaySystem();
			display.setTitle("hey");
			
			// score
			timeD = new HUDString("Time: " + time);
			addGameWorldObject(timeD);
			scoreD = new HUDString("Score: " + time);
			addGameWorldObject(scoreD);
			
			// 	
			Rectangle rect1 = new Rectangle();
			addGameWorldObject(rect1);
		}
		public void update(float ElapsedTimeMS)
		{
			// overwritten
			super.update(ElapsedTimeMS);
			// move camera
			
		}
		
		// add controller get
	}
