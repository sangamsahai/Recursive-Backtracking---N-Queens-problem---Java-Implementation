import java.util.Arrays;


public class NQueens {

	/**
	 * @param args
	 */


	//This array will hold the column value of placed Queens where the index 
	//of the cell will indicate the row value.
	static int[] positionInRow;

	//this method places the queens starting from k(th) row and n is the Grid Size
	public static boolean  placeTheQueen(int k , int n)
	{
		for(int i=0;i<n;i++)
		{
			if(place(k,i)==true)
			{
				positionInRow[k]=i;
				if(place(k+1,i)==true)return true;
				else positionInRow[k]=-100;

			}//end of if
		}//end of for
		return false;
	}//end of function placeTheQueen


	//This is a helper function and returns true if the Queen can be placed, 
	//in k(th) row and i(th) column
	public static boolean place(int k,int i)
	{
		int gridSize=positionInRow.length;

		//checking for clashes due to same row
		if(positionInRow[k] != -100)
		{
			return false;
		}
		//checking for clashes due to same column
		for(int j=0;j<gridSize;j++)
		{
			if(positionInRow[j]==i) return false;
		}
		//checking for clashes due to diagonal
		for(int j=0;j<gridSize;j++)
		{
			if( Math.abs(j-positionInRow[j]) == Math.abs (k-i))
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int gridSize=4;//I am using size 4. You can enter any grid size.
		positionInRow=new int[gridSize];
		Arrays.fill(positionInRow, -100);//initially this array will hold -100 for all cells.
		//-100 indicates that the cell is empty and no queen has been placed there
		placeTheQueen(0,gridSize);
		for(int j=0;j<gridSize;j++)
		{
			System.out.println("\n");
			System.out.println(j+1 + "," + positionInRow[j]+1 );
		}
	}//end of main

}
