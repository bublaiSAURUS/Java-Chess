package chess;

class Pawn extends Piece{
	private PieceColour colour;
	private String symbol;

	Pawn(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♙";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♟";
		}
	}

	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}

	@Override
	boolean isLegitMove(int i0, int j0, int i1, int j1) 
	{
		if(Board.getPiece(i0, j0).getColour()==PieceColour.BLACK && Board.getPiece(i1, j1).getColour()==PieceColour.BLACK)
			return false;
		else if (Board.getPiece(i0, j0).getColour()==PieceColour.WHITE && Board.getPiece(i1, j1).getColour()==PieceColour.WHITE)
			return false;
		if(i0==i1 && j0==j1)
		return false;
		if(Board.getPiece(i0, j0).getColour()==PieceColour.BLACK)
		{
			if(i1<i0)
			return false;
		}
		else if(Board.getPiece(i0, j0).getColour()==PieceColour.WHITE)
		{
			if(i1>i0)
			return false;
		}
		if(j0==j1)
		{
			if(Math.max(i0,i1)-Math.min(i0,i1)==1)
			{
				if(Board.hasPiece(i1,j1))
				return false;
			}
			else if(Math.max(i0,i1)-Math.min(i0,i1)==2)
			{
				if(i0 != 6 && i0 != 1)
				return false;
				else if (i0==6 || i0==1)
				{
					if(Board.hasPiece(i1, j1))
					return false;
				}
			}
			else if(Math.max(i0,i1)-Math.min(i0,i1)>2)
			return false;
		}
		else if(Math.max(i0,i1)-Math.min(i0,i1)==1 && Math.max(j0,j1)-Math.min(j0,j1)==1 )
		{
			if(Board.hasPiece(i1, j1))
			{
				if(Board.getPiece(i0, j0).getColour()==PieceColour.BLACK && Board.getPiece(i1, j1).getColour()==PieceColour.BLACK)
				return false;
				else if (Board.getPiece(i0, j0).getColour()==PieceColour.WHITE && Board.getPiece(i1, j1).getColour()==PieceColour.WHITE)
				return false;
			}
			else
			return false;
		}
		else if(Math.max(i0,i1)-Math.min(i0,i1)>1 && Math.max(j0,j1)-Math.min(j0,j1)>1)
		return false;
		else if(Math.max(j0,j1)-Math.min(j0,j1)>=1 && Math.max(i0,i1)-Math.min(i0,i1)!=1)
		return false;
		return true;
	}
}
