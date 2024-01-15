import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SnakeGame extends JFrame {
    private static final int TILE_SIZE = 20;
    private static final int GRID_SIZE = 20;
    private int[][] grid;
    private int snakeLength;
    private int[] snakeX, snakeY;
    private int direction;
    private int foodX, foodY;
    private int score;

    public SnakeGame() {
        grid = new int[GRID_SIZE][GRID_SIZE];
        snakeX = new int[GRID_SIZE * GRID_SIZE];
        snakeY = new int[GRID_SIZE * GRID_SIZE];

        setTitle("Snake Game");
        setSize(GRID_SIZE * TILE_SIZE, GRID_SIZE * TILE_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(new SnakeKeyAdapter());
        setFocusable(true);

        initializeGame();
        new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                move();
                checkCollision();
                checkFood();
                repaint();
            }
        }).start();
    }

    private void initializeGame() {
        snakeLength = 3;
        direction = KeyEvent.VK_RIGHT;
        score = 0;

        for (int i = 0; i < snakeLength; i++) {
            snakeX[i] = GRID_SIZE / 2 - i;
            snakeY[i] = GRID_SIZE / 2;
            grid[snakeY[i]][snakeX[i]] = 1;
        }

        spawnFood();
    }

    private void move() {
        int newX = snakeX[0];
        int newY = snakeY[0];

        switch (direction) {
            case KeyEvent.VK_UP:
                newY--;
                break;
            case KeyEvent.VK_DOWN:
                newY++;
                break;
            case KeyEvent.VK_LEFT:
                newX--;
                break;
            case KeyEvent.VK_RIGHT:
                newX++;
                break;
        }

        if (newX >= 0 && newX < GRID_SIZE && newY >= 0 && newY < GRID_SIZE && grid[newY][newX] != 1) {
            // Move snake
            if (newX != foodX || newY != foodY) {
                int lastX = snakeX[snakeLength - 1];
                int lastY = snakeY[snakeLength - 1];
                grid[lastY][lastX] = 0;
                for (int i = snakeLength - 1; i > 0; i--) {
                    snakeX[i] = snakeX[i - 1];
                    snakeY[i] = snakeY[i - 1];
                }
                snakeX[0] = newX;
                snakeY[0] = newY;
            } else {
                // Eat food
                score++;
                snakeLength++;
                spawnFood();
            }

            // Update grid
            for (int i = 0; i < snakeLength; i++) {
                grid[snakeY[i]][snakeX[i]] = 1;
            }
        } else {
            // Game over
            saveScore();
            JOptionPane.showMessageDialog(this, "Game Over!\nYour score: " + score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            initializeGame();
        }
    }

    private void spawnFood() {
        foodX = (int) (Math.random() * GRID_SIZE);
        foodY = (int) (Math.random() * GRID_SIZE);

        while (grid[foodY][foodX] != 0) {
            foodX = (int) (Math.random() * GRID_SIZE);
            foodY = (int) (Math.random() * GRID_SIZE);
        }
    }

    private void checkFood() {
        if (snakeX[0] == foodX && snakeY[0] == foodY) {
            score++;
            snakeLength++;
            spawnFood();
        }
    }

    private void checkCollision() {
        for (int i = 1; i < snakeLength; i++) {
            if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                saveScore();
                JOptionPane.showMessageDialog(this, "Game Over!\nYour score: " + score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                initializeGame();
            }
        }
    }

    private void saveScore() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("scores.txt", true))) {
            writer.println(score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class SnakeKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (direction != KeyEvent.VK_DOWN)
                        direction = KeyEvent.VK_UP;
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != KeyEvent.VK_UP)
                        direction = KeyEvent.VK_DOWN;
                    break;
                case KeyEvent.VK_LEFT:
                    if (direction != KeyEvent.VK_RIGHT)
                        direction = KeyEvent.VK_LEFT;
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != KeyEvent.VK_LEFT)
                        direction = KeyEvent.VK_RIGHT;
                    break;
            }
        }
    }

    private void paintGrid(Graphics g) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == 1) {
                    g.setColor(Color.GREEN);
                    g.fillRect(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                } else if (i == foodY && j == foodX) {
                    g.setColor(Color.RED);
                    g.fillOval(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        paintGrid(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SnakeGame().setVisible(true));
    }
}
