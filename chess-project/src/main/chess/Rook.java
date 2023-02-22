package chess;

class Rook extends Piece{
	private PieceColour colour;
	private String symbol;

	public Rook(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♖";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♜";
		}
	}

	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}

	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		int i;
		if(i0==i1 && j0==j1)
		return false;
		if(i0==i1)
		{
			int dx = (j0<j1)?1:-1;
			for(i= j0+dx;i!=j1;i+=dx)
			{
				if(Board.hasPiece(i0, i))
				return false;
			}
		}
		else if(j0==j1)
		{
			int dy = (i0<i1)?1:-1;
			for(i = i0+dy; i!=i1 ; i+=dy)
			{
				if(Board.hasPiece(i, j0))
				return false;
			}
		}
		else
		return false;
		return Board.hasPiece(i1, j1)==false;
	}
}
