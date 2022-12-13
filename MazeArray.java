//Team 5 - Aaron Bisel, Alex Hobson, Chris Wilcox

package mazearray;

import java.util.Scanner;

public class MazeArray {

    public static void main(String[] args) {
        Maze maze = new Maze(5);
        maze.generateMaze();
        maze.printMaze();
        Scanner scan = new Scanner(System.in);
        int input = 0;
        
        do{
        System.out.println("1 = up, 2 = down, 3 = right, 4 = left");
        System.out.println("5 = up/left, 6 = up/right, 7 = down/left, 8 = down/right");
        input = scan.nextInt();
        switch(input){
            case 1: maze.up();
                    break;
            case 2: maze.down();
                    break;
            case 3: maze.right();
                    break;
            case 4: maze.left();
                    break;
            case 5: maze.upLeft();
                    break;
            case 6: maze.upRight();
                    break;
            case 7: maze.downLeft();
                    break;
            case 8: maze.downRight();
                    break;
        }
        maze.printMaze();
        } while (!maze.endGame());
    }
    
}
