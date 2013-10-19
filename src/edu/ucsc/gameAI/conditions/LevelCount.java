package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class LevelCount implements ICondition {
	
	int levelNum;
	public LevelCount(int level)
	{
		levelNum=level;
	}
	
	public boolean test(Game game) 
	{
		return game.getCurrentLevel() == levelNum;
	}
}
