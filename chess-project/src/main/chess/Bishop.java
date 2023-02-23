package chess;



public class Bishop extends Piece{

	public Bishop(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			super.setSymbol("♗");
			super.colour=PieceColour.WHITE;
		}
		else if (pc.equals(PieceColour.BLACK)){
			super.setSymbol("♝");
			super.colour=PieceColour.BLACK;
		}
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
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
