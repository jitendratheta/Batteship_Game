import javafx.geometry.Pos;

import java.util.Random;

/**
 * Util class to keep the common data and functions.
 */
public class Util {


    /**
     * Get valid strip int array.
     *
     * @param length the length
     * @param board  the board
     * @return the int array.
     * @throws Exception the exception
     */
    public static int[] getValidStrip(int length, final Board board) throws Exception {
        Random random = new Random(System.currentTimeMillis());
        while(true) {
            int vertical = random.nextInt(2);
            boolean valid  = true;
            if (vertical == 1) {
                int start = random.nextInt(Constants.BOARD_LENGTH - length + 1);
                int column = random.nextInt(Constants.BOARD_BREADTH);
                for (int j = start; j < start + length; j++) {
                    if(!board.isEmpty(new Position(j, column))) {
                        valid = false;
                        continue;
                    }
                }
                if(valid) {
                    return new int[]{start, column, start + length - 1, column};
                }

            } else {
                int start = random.nextInt(Constants.BOARD_BREADTH - length + 1);
                int row = random.nextInt(Constants.BOARD_LENGTH);
                for (int j = start; j < start + length; j++) {
                    if(!board.isEmpty(new Position(row, j))) {
                        valid = false;
                        break;
                    }
                }
                if(valid) {
                    return new int[]{row, start, row, start + length - 1};
                }

            }
        }
    }

    /**
     * Gets {@link Position}.
     *
     * @param input the input string
     * @return the {@link Position} by transating the input string
     */
    public static Position getPosition(String input) {
        return new Position(input.charAt(0) - 'A', input.charAt(1) - '0');
    }

    /**
     * Gets position string.
     *
     * @param position the position
     * @return the position string
     */
    public static String getPositionString(Position position) {
        return ((char)('A'+ position.getX())) + "" + (position.getY());
    }


}
