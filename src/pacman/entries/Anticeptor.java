package pacman.entries;

import pacman.game.Constants.MOVE;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

import java.util.ArrayList;

public class Anticeptor
{

	int pillWeight, edibleGhostWeight, nonEdibleGhostWeight, pacmanWeight, sameDirectionBonusWeight;
	double powerPillWeight;

	public Anticeptor() {
		pillWeight = 10;
		powerPillWeight = 20;
		edibleGhostWeight = 200;
		nonEdibleGhostWeight = -10000;
		pacmanWeight = 0;
		sameDirectionBonusWeight = 5;
	}

	public Anticeptor(int _pillWeight, int _powerPillWeight, int _edibleGhostWeight, int _nonEdibleGhostWeight, int _pacmanWeight, int _sameDirectionBonusWeight) {
		pillWeight = _pillWeight;
		powerPillWeight = _powerPillWeight;
		edibleGhostWeight = _edibleGhostWeight;
		nonEdibleGhostWeight = _nonEdibleGhostWeight;
		pacmanWeight = _pacmanWeight;
		sameDirectionBonusWeight = _sameDirectionBonusWeight;
	}

	public class PathValue
	{
		public MOVE move;
		public int value;
		public int node;
		public PathValue(MOVE _move, int _value, int _node)
		{
			move = _move;
			value = _value;
			node = _node;
		}
	}

	public void adjustPowerpillWeight(double _powerPillWeight) {
		powerPillWeight = _powerPillWeight;
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
		for (GHOST ghost : GHOST.values()) {
			if (game.getGhostCurrentNodeIndex(ghost) == node) {
				if (game.isGhostEdible(ghost)) {
					weight += edibleGhostWeight;
				} else {
					weight += nonEdibleGhostWeight;
				}
			}
		}
		
		if (exploreLength == 0)
		{
			PathValue value = new PathValue(firstMove, weight, node);
			values.add(value);
			return;
		}
		
		MOVE[] possibleMoves = game.getPossibleMoves(node, direction);
		for( MOVE move : possibleMoves)
		{
			if (first) {
				firstMove = move;
				if (move == game.getPacmanLastMoveMade()) {
					weight += 5;
				}
			}
			anticept_recurse(game, game.getNeighbour(node, move), move, exploreLength - 1, weight, false, firstMove);
			if (first) {
				if (move == game.getPacmanLastMoveMade()) {
					weight -= 5;
				}
			}
		}
	}
}