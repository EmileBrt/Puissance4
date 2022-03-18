package com.example.server;

public class MainServeur {

	public static void main(String[] args) {
		ServeurTCP myServ = new ServeurTCP(new UnContexte() , new ProtocolePuissance4() , 6666 );
		myServ.start();
		
	}
}
