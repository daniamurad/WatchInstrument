package Util.Sound;
import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;
import kuusisto.tinysound.internal.StreamSound;

public class btAudioPlayer{
	
	private ArrayList<Sound> players;
	int index = 0,count;
	double volume=5,panning=0;
	String path;
	
	public btAudioPlayer(String path, int count){
		TinySound.init();
		this.path = path;
		assert(count>0);
		this.count = count;
	}
	
	public void play(int volume,int panning){		
		/*
		 * index = (index+1)%count;
		players.get(index).play(volume,panning);	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		*/
		new Thread(new Runnable(){
            public void run(){
            	Sound player = TinySound.loadSound(path);
            	player.play(volume,panning);
            	try {
        			Thread.sleep(1000);
        		} catch (InterruptedException e) {}
            }
        }).start();
	}
		
		public void play(){		
			/*
			 * index = (index+1)%count;
			players.get(index).play(volume,panning);	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			*/
			new Thread(new Runnable(){
	            public void run(){
	            	Sound player = TinySound.loadSound(path);
	            	player.play(volume,panning);
	            	try {
	        			Thread.sleep(1000);
	        		} catch (InterruptedException e) {}
	            }
	        }).start();
}

	
	public void terminate(){
		TinySound.shutdown();		
	} 
}
