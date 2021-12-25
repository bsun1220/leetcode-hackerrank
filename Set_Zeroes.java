import java.util.*;

public class Set_Zeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        for(int i = 0; i < matrix.length; i++)
        {
            for(int k = 0; k < matrix[i].length; k++)
            {
                if(matrix[i][k] == 0)
                {
                    rows.add(i);
                    cols.add(k);
                }
            }
        }
        for(int i = 0; i < matrix.length; i++)
        {
            if(rows.contains(i))
            {
                Arrays.fill(matrix[i], 0);
                continue;
            }
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(cols.contains(j))
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
