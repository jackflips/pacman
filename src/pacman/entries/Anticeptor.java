package pacman.entries;

import pacman.game.Constants.MOVE;
import pacman.game.Game;

import java.util.ArrayList;

public class Anticeptor
{
	//public Anticeptor(int pillValue, int powerPillValue, int ghostValue, int edibleGhostValue)

	public class PathValue
	{
		public MOVE move;
		public int value;
		public PathValue(MOVE _move, int _value)
		{
			move = _move;
			value = _value;
		}
	}
	
	public ArrayList<PathValue> anticept(Game game, int startingNode, MOVE startingDirection, int exploreLength)
	{
		values = new ArrayList<PathValue>();
		anticept_recurse(game, startingNode, startingDirection, exploreLength, 0, true, MOVE.NEUTRAL);
		
		//now, bubblesort.
		for(int i = 1; i < values.size(); i++)
		{
			if(values.get(i).value > values.get(i-1).value)
			{
				//value value value valuevaluevaluevaluevlauvluavvaluevalvuavluevaleauvaluelauvelauvalue
				PathValue value = values.remove(i);
				int j = i - 1;
				while (j > 0)
				{
					if(values.get(j - 1).value > value.value)
						break;
					j--;
				}
				values.add(j, value);
			}
		}
		
		return values;
	}
	
	private int pillWeight = 10;
	private int powerPillWeight = 20;
	private int edibleGhostWeight = 200;
	//private int nonedibleGhostWeight = -10000;
	private ArrayList<PathValue> values;
	protected void anticept_recurse(Game game, int node, MOVE direction, int exploreLength, int weight, boolean first, MOVE firstMove)
	{
		int pillIndex = game.getPillIndex(node);
		if (pillIndex != -1)
		{
			if(game.isPillStillAvailable(pillIndex))
				weight += pillWeight;
		}
		pillIndex = game.getPowerPillIndex(node);
		if (pillIndex != -1)
		{
			if(game.isPowerPillStillAvailable(pillIndex))
				weight += powerPillWeight;
		}
		
		if (exploreLength == 0)
		{
			PathValue value = new PathValue(firstMove, weight);
			values.add(value);
			return;
		}
		
		MOVE[] possibleMoves = game.getPossibleMoves(node, direction);
		for( MOVE move : possibleMoves)
		{
			if (first)
				firstMove = move;
			anticept_recurse(game, game.getNeighbour(node, move), move, exploreLength - 1, weight, false, firstMove);
		}
	}
}