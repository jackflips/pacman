package pacman.entries;

import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class Anticeptor
{
	//public Anticeptor(int pillValue, int powerPillValue, int ghostValue, int edibleGhostValue)

	public class pathValue
	{
		public int node;
		public int value;
		public PathValue(int _node, int _value)
		{
			node = _node;
			value = _value;
		}
	}
	
	public ArrayList<pathValue> anticept(Game game, int startingNode, MOVE startingDirection, int exploreLength)
	{
		values = new ArrayList<pathValue>();
		anticept_recurse(game, startingNode, startingDirection, exploreLength, 0);
		
		//now, bubblesort.
		for(int i = 1; i < values.length(); i++)
		{
			if(values[i].value > values[i-1].value)
			{
				//value value value valuevaluevaluevaluevlauvluavvaluevalvuavluevaleauvaluelauvelauvalue
				PathValue value = values.remove(i);
				int j = i - 1;
				while (j > 0)
				{
					if(values[j - 1].value > value.value)
						break;
					j--;
				}
				values.add(j, value);
			}
		}
	}
	
	private int pillWeight = 2;
	private int powerPillWeight = 20;
	//private int edibleGhostWeight = 200;
	//private int nonedibleGhostWeight = -10000;
	private ArrayList<pathValue> values;
	protected void anticept_recurse(Game game, int node, MOVE direction, int exploreLength, int weight)
	{
		int pillIndex = game.getPillIndex(node)
		if (pillIndex != -1)
		{
			if(game.isPillStillAvailable(pillIndex))
				weight += pillWeight;
		}
		pillIndex = game.getPowerPillIndex(node)
		if (pillIndex != -1)
		{
			if(game.isPowerPillStillAvailable(pillIndex))
				weight += powerPillWeight;
		}
		
		if (exploreLength == 0)
		{
			PathValue value = new PathValue(node, weight)
			values.add(value);
			return;
		}
		
		MOVE[] possibleMoves = game.getPossibleMoves(node, direction);
		for( MOVE move : possibleMoves)
		{
			anticept_recurse(game, game.getNeighbour(node, move), move, exploreLength - 1, weight);
		}
	}
}