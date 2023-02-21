package chess;

class Rook extends Piece{
	private PieceColour colour;
	private String symbol;

	Rook(PieceColour pc){
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

	boolean isLegitMove(int i0, int j0, int i1, int j1) {
		if(i0==i1 && j0==j1)
		return false;
		int f1 = 0;
		int a = 0; int b = 0;
		if((i0 != i1) && (j0 != j1))
		{
			return false;
		}
		else
		{
			if(i0 == i1)
			{
				int start = Math.min(j0,j1);
				int end = Math.max(j0,j1);
				for(int i = start; i<=end ;i++)
				{
					if(Board.hasPiece(i0, i))
					{
						f1++; 
						a = i0;
						b = i;
					}
				}
			}
			else if (j0 == j1)
			{
				int start = Math.min(i0,i1);
				int end = Math.max(i0,i1);
				for(int i = start; i<=end ;i++)
				{
					if(Board.hasPiece(i, j0))
					{
						f1++; 
						a = i;
						b = j0;
					}
				}
			}
			if(f1 > 1)
			return false;
			else if(f1 == 1 && (a != i1 && b != j1))
			{
				return false;
			}
			else if (f1 == 1 && (a == i1 && b == j1))
			{
				if(Board.getPiece(i0, j0).getColour()==PieceColour.BLACK && Board.getPiece(i1, j1).getColour()==PieceColour.BLACK)
				return false;
				else if (Board.getPiece(i0, j0).getColour()==PieceColour.WHITE && Board.getPiece(i1, j1).getColour()==PieceColour.WHITE)
				return false;
			}
		}
		return true;
	}
}
