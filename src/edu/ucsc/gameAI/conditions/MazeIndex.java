package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class MazeIndex implements ICondition {
	
	int mazeNum;
	public MazeIndex(int index)
	{
		mazeNum=index;
	}
	
	public boolean test(Game game) 
	{
		return game.getMazeIndex() == mazeNum;
	}
}
