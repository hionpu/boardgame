public class boardgame {
    public static Integer boardGame(int[][] board, String operation) {
        // TODO:
        //시작 위치 점수 획득(0점)
        int score = board[0][0];
        score = operator(0,0,board,operation,score);
        return score;

    }
    public static Integer operator(int row, int col, int[][] board, String operation, Integer score) {
        //operation의 길이만큼 재귀, score가 null이면 즉시 반환
        System.out.printf("Current location : [%d],[%d]%n", row, col);
        System.out.println("Score : "+ score);
        System.out.print("Operation length : " + operation.length()+"  /  ");
        if ( operation.length() == 0 || score == null) {
            System.out.println("returning score : " + score );
            return score;
        }
        System.out.println("Operation : "+operation.charAt(0));
        int newrow = 0; int newcol = 0;
        switch (operation.charAt(0)) {
            //U: 행번호 < 0 => out
            //   아니면 row-1
            case 'U':
                System.out.println("case U");
                if (row == 0) {
                    System.out.println("Out of boundary");
                    score = null;
                    return operator(newrow, newcol, board, operation.substring(1), score);

                }
                else {
                    newrow = row - 1;

                    newcol = col;
                    score += board[newrow][newcol];
                    return operator(newrow, newcol, board, operation.substring(1), score);

                }


            //D: 행번호 > board.length => out
            //   아니면 row+1
            case 'D':
                System.out.println("case D");
                if (row == board.length-1) {
                    System.out.println("Out of boundary");
                    score = null;
                    return operator(newrow, newcol, board, operation.substring(1), score);
                }
                else {
                    newrow = row + 1;
                    newcol = col;
                    score += board[newrow][newcol];
                    return operator(newrow, newcol, board, operation.substring(1), score);
                }

            //L: 열번호 < 0 => out
            //   아니면 col-1

            case 'L':
                System.out.println("case L");
                if (col == 0) {
                    System.out.println("Out of boundary");
                score = null;
                    return operator(newrow, newcol, board, operation.substring(1), score);
            }
            else {
                newrow = row;
                newcol = col - 1;
                score += board[newrow][newcol];
                return operator(newrow, newcol, board, operation.substring(1), score);
            }


            //R: 열번호 > board[].length => out
            //   아니면 col+1
            case 'R':
                System.out.println("case R");
                if (col == board[0].length-1) {
                    System.out.println("Out of boundary");
                score = null;
                    return operator(newrow, newcol, board, operation.substring(1), score);
            }
            else {
                newrow = row;
                newcol = col + 1;
                score += board[newrow][newcol];
                    return operator(newrow, newcol, board, operation.substring(1), score);
            }
        }
        return score;
    }
    public static void main(String[] args) {
        int[][] board1 = {
            {0, 0, 0, 3},
            {3, 3, 3, 0},
            {3, 3, 0, 0},
            {0, 0, 0, 0}
        };
        System.out.println(" result = " + boardgame.boardGame(board1, "RRDLLD"));
    }
}
