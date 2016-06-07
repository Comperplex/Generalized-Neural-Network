package io;

import tictactoe.GameBoard;
import tictactoe.GameObject;
import tictactoe.TicTacToe;

public class Main {
	public static void main(String[] args){
		TicTacToe toe = new TicTacToe();
		GameBoard board = toe.getBoard();
		toe.start();
		board.placePieceAtLocation(0, 0, GameObject.O);
		board.placePieceAtLocation(0, 0, GameObject.X);
		board.placePieceAtLocation(1, 0, GameObject.X);
		board.placePieceAtLocation(2, 0, GameObject.X);
		board.placePieceAtLocation(0, 1, GameObject.X); 
		board.placePieceAtLocation(1, 1, GameObject.O); 
		board.placePieceAtLocation(2, 1, GameObject.X); 
		board.placePieceAtLocation(0, 2, GameObject.X); 
		board.placePieceAtLocation(1, 2, GameObject.X); 
		board.placePieceAtLocation(2, 2, GameObject.O); 
		
		board.detectWinAt(1, 1, -1, -1);
		board.getGameState();
		
		//board.placePieceAtLocation(1, 1, GameObject.BLANK);
		//board.placePieceAtLocation(1, 1, GameObject.X);
		board.detectWinAt(1, 1, 1, 0);
		board.detectWinAt(1, 1, 0, 1);
	}
}
