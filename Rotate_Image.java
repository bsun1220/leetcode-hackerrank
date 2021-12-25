public class Rotate_Image {
    public void rotate(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++)
        {
            for(int k = i; k < matrix.length; k++)
            {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[k][i];
                matrix[k][i] = temp;
            }
        }
        for(int i = 0; i < matrix.length; i++)
        {
            for(int k = 0; k < matrix.length/2; k++)
            {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][matrix.length - k - 1];
                matrix[i][matrix.length - k - 1] = temp;
            }
        }
    }
}
