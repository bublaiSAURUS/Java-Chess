package chess;

public class King extends Piece{
	

	public King(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			super.setSymbol("♔");
			super.colour = PieceColour.WHITE;
		}
		else if (pc.equals(PieceColour.BLACK)){
			super.setSymbol("♚");
			super.colour=PieceColour.BLACK;

		}
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) 
	{
		if(Board.hasPiece(i1, j1))
		{
			if(Board.getPiece(i0, j0).getColour()==PieceColour.BLACK && Board.getPiece(i1, j1).getColour()==PieceColour.BLACK)
			return false;
		else if (Board.getPiece(i0, j0).getColour()==PieceColour.WHITE && Board.getPiece(i1, j1).getColour()==PieceColour.WHITE)
			return false;
		}
		if(i0==i1 && (int)Math.abs(j0-j1)==1)
		{
			return true;
		}
		else if(j0==j1 && (int)Math.abs(i0-i1)==1)
		{
			return true;
		}
		else if((int)Math.abs(i0-i1)==1 && (int)Math.abs(j0-j1)==1)
		{
			return true;
		}
		else
		return false;
	}

}
