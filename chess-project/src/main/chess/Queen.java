package chess;

class Queen extends Piece{
	private PieceColour colour;
	private String symbol;

	Queen(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♕";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♛";
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
			if(Board.getPiece(i0, j0).getColour()==PieceColour.BLACK && Board.getPiece(i1, j1).getColour()==PieceColour.BLACK)
			return false;
		else if (Board.getPiece(i0, j0).getColour()==PieceColour.WHITE && Board.getPiece(i1, j1).getColour()==PieceColour.WHITE)
			return false;
		}
		if((int)Math.abs(i0-i1)==(int)Math.abs(j0-j1))
		{
			int update_col = (i1-i0)/(int)(Math.abs(i1-i0));
			int update_row = (j1-j0)/(int)(Math.abs(j1-j0));
			int start_col = i0;
			int end_col = i1;
			int start_row = j0;
			int end_row = j1;
			int count = 0; int a = 0; int b = 0;
			while(start_col!=end_col && start_row!=end_row)
			{
				if(Board.hasPiece(start_col,start_row))
				{
					a = start_col;
					b = start_row;
					count++;
				}
				start_col = start_col+update_col;
				start_row = start_row+update_row;
					
			}
			if(count>2)
			return false;
			else if(count == 2)
			{
				if(a!=i1 && b!=j1)
				return false;
			}
		}
		else if(i0 == i1)
		{
			int update_row = (j1-j0)/(int)(Math.abs(j1-j0));
			int start_row = j0;
			int end_row = j1;
			int count = 0; int b = 0;
			while(start_row!=end_row)
			{
				if(Board.hasPiece(i0,start_row))
				{
					b = start_row;
					count++;
				}
				start_row = start_row+update_row;		
			}
			if(count>2)
			return false;
			else if(count == 2)
			{
				if(b!=j1)
				return false;
			}
		}
		else if( j0 == j1)
		{
			int update_col = (i1-i0)/(int)(Math.abs(i1-i0));
			int start_col = i0;
			int end_col = i1;
			int count = 0; int a = 0;
			while(start_col!=end_col)
			{
				if(Board.hasPiece(j0,start_col))
				{
					a = start_col;
					count++;
				}
				start_col = start_col+update_col;		
			}
			if(count>2)
			return false;
			else if(count == 2)
			{
				if(a!=i1)
				return false;
			}
		}
		else if((int)Math.abs(i0-i1)!=(int)Math.abs(j0-j1) && (j0 != j1) && (i0!=i1))
		return false;
		return true;
	}
}
