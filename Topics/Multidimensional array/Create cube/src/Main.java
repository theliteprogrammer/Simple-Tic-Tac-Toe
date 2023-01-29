class ArrayOperations {
    public static int[][][] createCube() {
        // write your code here
        int[][][] cube = new int[3][3][3];
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    if (j == 0 && i <= cube.length) {
                        cube[i][j][k] = k;
                    } else if (j == 1 && i <= cube.length) {
                        cube[i][j][k] = k + 3;
                    } else if (j == 2 && i <= cube.length) {
                        cube[i][j][k] = k + 6;
                    }
                }
            }
        }
        return cube;
    }
}