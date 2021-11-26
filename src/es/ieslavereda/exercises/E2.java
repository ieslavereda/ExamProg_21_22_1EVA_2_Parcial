package es.ieslavereda.exercises;

public class E2 {

	public static void main(String[] args) {

		String[][] matrix = { { "1", "3", "0" }, { "5", "3", "5" }, { "4", "2", "6" }, { "8", "7", "4" } };
		int[][] positions;

		show(matrix);

		System.out.println("The count of all even elements is: " + countOddElements(matrix));

		positions = getOddPosition(matrix);		
		
		for(int[] position : positions)
			System.out.println("There even number " + matrix[position[0]][position[1]] + " is in the row " + position[0] + " col " + position[1]);

	}

	private static int[][] getOddPosition(String[][] matrix) {
		int size = countOddElements(matrix);
		int[][] positions = new int[size][2];

		int i = 0;// Index used to store a position in the positions array
		for (int row = 0; row < matrix.length; row++)
			for (int col = 0; col < matrix[0].length; col++)
				if (Integer.parseInt(matrix[row][col]) % 2 == 0)
					positions[i++] = new int[] { row, col };

		return positions;
	}

	private static int countOddElements(String[][] matrix) {

		int count = 0;

		for (String[] row : matrix)
			for (int col = 0; col < matrix[0].length; col++)
				if (Integer.parseInt(row[col]) % 2 == 0)
					count++;

		return count;
	}

	private static void show(String[][] matrix) {

		for (String[] row : matrix) {
			for (String cel : row)
				System.out.print(cel + " ");
			System.out.println();
		}
		System.out.println();
	}


}
