package chess;

public class CheckInput {
	
	public static boolean checkCoordinateValidity(String input){
		if(input.length()!=2)
		return false;
		else
		{
			String row ="abcdefgh" ;
			String col ="12345678" ;
			char i_value = input.charAt(0);
			char j_value = input.charAt(1);
			if(row.indexOf(j_value)==-1)
			return false;
			if(col.indexOf(i_value)==-1)
			return false;
		}
		return true;
	}
}
