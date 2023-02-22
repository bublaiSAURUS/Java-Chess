package chess;


class Pawn extends Piece{
	private PieceColour colour;
	private String symbol;

	public Pawn(PieceColour pc){
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
	public boolean isLegitMove(int i0, int j0, int i1, int j1) 
	{
		int update_col=0;
		if(Board.getPiece(i0, j0).getColour()==PieceColour.BLACK)
		{update_col = 1;}
		else
		{update_col = -1;}
		if(j0==j1)
		{	if(i0!=6 && i0!=1)
			{
				if(i0+update_col==i1 && Board.hasPiece(i1, j1)==false)
				return true;
				else
				return false;
			}
			if(i0==6 || i0==1)
			{
				if(i0==6 && i1==4 && Board.hasPiece(i1, j1)==false)
				return true;
				else if(i0==1 && i1==3 && Board.hasPiece(i1, j1)==false)
				return true;
				else if (i0+update_col==i1 && Board.hasPiece(i1, j1)==false)
				return true;
				else
				return false;

			}
		}
		else if ((int)Math.abs(j0-j1)==1 && i0+update_col==i1 && Board.hasPiece(i1, j1)==true)
		{
			if(Board.getPiece(i0, j0).getColour()==PieceColour.BLACK && Board.getPiece(i1, j1).getColour()==PieceColour.BLACK)
				return false;
			else if (Board.getPiece(i0, j0).getColour()==PieceColour.WHITE && Board.getPiece(i1, j1).getColour()==PieceColour.WHITE)
				return false;
			else
				return true;
		}
		return false;
	}
}
