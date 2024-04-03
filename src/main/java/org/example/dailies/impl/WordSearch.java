package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

public class WordSearch extends DailyProblemBase {
    @Override
    public void start() {
        char[][][] data = {
                {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}
        };
        String[] data1 = {"ABCCED", "SEE", "ABCB"};
        boolean[] expected = {true, true, false};
        System.out.print("\nDay 10 Number 79 - Word Search\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %b\t Result received: %b\n", i, expected[i], exist(data[i], data1[i]));
        }
    }

    private boolean exist(char[][] board, String word) {
        char firstLetter = word.charAt(0);
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board[j].length; i++) {
                if (board[j][i] == firstLetter) {
                    if (isWordPresent(board, visited, word, 1, i, j)) {
                        return true;
                    } else {
                        visited[j][i] = false;
                    }
                }
            }
        }
        return false;
    }

    private boolean isWordPresent(char[][] board, boolean[][] visited, String word, int wordIndex, int x, int y) {
        if (wordIndex == word.length()) {
            return true;
        }

        char letterToFind = word.charAt(wordIndex);
        visited[y][x] = true;

        if (isCoordValid(board, x, y + 1) && !visited[y + 1][x] && board[y + 1][x] == letterToFind) {
            if (isWordPresent(board, visited, word, wordIndex + 1, x, y + 1)) {
                return true;
            } else {
                visited[y + 1][x] = false;
            }
        }

        if (isCoordValid(board, x + 1, y) && !visited[y][x + 1] && board[y][x + 1] == letterToFind) {
            if (isWordPresent(board, visited, word, wordIndex + 1, x + 1, y)) {
                return true;
            } else {
                visited[y][x + 1] = false;
            }
        }

        if (isCoordValid(board, x, y - 1) && !visited[y - 1][x] && board[y - 1][x] == letterToFind) {
            if (isWordPresent(board, visited, word, wordIndex + 1, x, y - 1)) {
                return true;
            } else {
                visited[y - 1][x] = false;
            }
        }

        if (isCoordValid(board, x - 1, y) && !visited[y][x - 1] && board[y][x - 1] == letterToFind) {
            if (isWordPresent(board, visited, word, wordIndex + 1, x - 1, y)) {
                return true;
            } else {
                visited[y][x - 1] = false;
            }
        }

        return false;
    }

    private boolean isCoordValid(char[][] board, int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }

        return y < board.length && x < board[y].length;
    }
}
