package es.ieslavereda.exercises;

public class E4 {

    public static void main(String[] args) {

        int[][] array = {{1, 4},
                {1, 4},
                {2, 4},
                {1, 4},
                {1, 7},
                {9, 4},
                {3, 3},
                {0, 4},
                {1, 4}};

        System.out.println("Array without repetitions:");
        show(withoutRepetitions(array));
    }

    private static int[] withoutRepetitions(int[][] array) {
        int[] positions = new int[0];
        for (int[] row : array)
            for (int num : row)
                if (!contains(positions, num))
                    positions = add(positions, num);

        return positions;
    }

    private static boolean contains(int[] result, int data) {
        boolean found = false;

        int i = 0;
        while (i < result.length && !found)
            if (result[i++] == data)
                found = true;

        return found;
    }

    private static int[] add(int[] result, int data) {
        int[] aux = new int[result.length + 1];
        for (int i = 0; i < result.length; i++)
            aux[i] = result[i];

        aux[aux.length - 1] = data;

        return aux;
    }

    // Only for testing
    private static void show(int[] result) {
        for (int i : result)
            System.out.print(i + " ");
        System.out.println();
    }

}
