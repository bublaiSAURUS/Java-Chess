package chess;

public class Queen extends Piece{

	public Queen(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			super.setSymbol("♕");
			super.colour=PieceColour.WHITE;
		}
		else if (pc.equals(PieceColour.BLACK)){
			super.setSymbol("♛");
			super.colour=PieceColour.BLACK;
		}
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		int i; int p = 0;
		if(i0==i1 && j0==j1)
		return false;
		if(Board.hasPiece(i1, j1))
		{
			if(Board.getPiece(i0, j0).getColour()==PieceColour.BLACK && Board.getPiece(i1, j1).getColour()==PieceColour.BLACK)
			return false;
		else if (Board.getPiece(i0, j0).getColour()==PieceColour.WHITE && Board.getPiece(i1, j1).getColour()==PieceColour.WHITE)
			return false;
		else 
			p = 1;
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
		else if(i0==i1)
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
		return (Board.hasPiece(i1, j1)==false || p==1);
	}
}
