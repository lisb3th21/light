package com.lisbeth.lightoutgame;

public class GameModel {
    private boolean[][] board;

    public GameModel(int width, int height) {
        this.board = new boolean[width][height];

    }

    public void changeLight(int row, int col) {
        int rows = board.length;
        int cols = board[0].length;

        // Cambia el estado de la celda presionada
        board[row][col] = !board[row][col];

        // Cambia el estado de las celdas adyacentes
        if (row > 0) {
            board[row - 1][col] = !board[row - 1][col];
        }
        if (row < rows - 1) {
            board[row + 1][col] = !board[row + 1][col];
        }
        if (col > 0) {
            board[row][col - 1] = !board[row][col - 1];
        }
        if (col < cols - 1) {
            board[row][col + 1] = !board[row][col + 1];
        }
    }

    public void randomBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Math.random() < 0.5;
            }
        }
    }

    public void print() {
        // ! por eliminar - para pruebas
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }
    public boolean[][] getBoard() {
        return board;
    }

    public void setBoard(boolean[][] board) {
        this.board = board;
    }
    public static void main(String[] args) {
        GameModel model = new GameModel(3, 4);
        model.print();
        model.randomBoard();
        model.print();
        model.changeLight(model.getBoard().length-1, model.getBoard()[0].length - 1);
        model.print();
      
    }

    
}
