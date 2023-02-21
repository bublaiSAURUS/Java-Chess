package chess;

import javax.lang.model.util.ElementScanner14;

class Bishop extends Piece{
	private PieceColour colour;
	private String symbol;

	Bishop(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♗";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♝";
		}
	}

	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}

	@Override
	boolean isLegitMove(int i0, int j0, int i1, int j1) {
		if(Board.hasPiece(i1, j1))
				{
					if(Board.getPiece(i1,j1).getColour()==PieceColour.WHITE && Board.getPiece(i0, j0).getColour()==PieceColour.WHITE)
					return false;
					else if(Board.getPiece(i1, j1).getColour()==PieceColour.BLACK && Board.getPiece(i0, j0).getColour()==PieceColour.BLACK)
					return false;
				}
		if((int)Math.abs(i1-i0)==(int)Math.abs(j1-j0))
		{
			int update_col = (i1-i0)/(int)Math.abs(i1-i0);
			int update_row = (j1-j0)/(int)Math.abs(j1-j0);
			int start_row = j0+update_row; int start_col = i0+update_col; 
			while(start_row!=j1 && start_col!=i1)
			{
				if(Board.hasPiece(start_col, start_row))
				{
					break;
				}
					start_row = start_row+update_row;	
					start_col = start_col+update_col;
			}
			if(start_row==j1 && start_col==i1)
			return true;
			else
			return false;
		}
		if((int)Math.abs(i1-i0)!=(int)Math.abs(j1-j0))
		return false;
		return true;
	}
}
