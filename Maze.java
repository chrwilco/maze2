//Team 5 - Aaron Bisel, Alex Hobson, Chris Wilcox
//Chris Wilcox
package mazearray;

import java.util.Random;

public class Maze {
    String[][] maze;
    int row;
    int column;
    int currentRow;
    int currentColumn;
    boolean found = false;
    
    Random rand = new Random();
    
    public Maze(){
        row = 0;
        column = 0;
    }
    
    public Maze(int size){
        if (size < 5){
            size = 5;
        }
        maze = new String[size][size];
        row = size;
        column = size;
    }
    
    public void generateMaze(){
        float wall;
        int endRow = 0;
        int endColumn = 0;
        int startRow = 0;
        int startColumn = 0;
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                wall = rand.nextFloat();
                if (wall < .5){
                    maze[i][j] = "#";
                } else {
                    maze[i][j] = " ";
                }
            }    
        }
        
        do {
            endRow = rand.nextInt(row);
            endColumn = rand.nextInt(column);
        } while(maze[endRow][endColumn].equals("#"));
        maze[endRow][endColumn] = "*";
        
        do {
            startRow = rand.nextInt(row);
            startColumn = rand.nextInt(column);
        } while(maze[startRow][startColumn].equals("#"));
        maze[startRow][startColumn] = "W";
        currentRow = startRow;
        currentColumn = startColumn;
    }
    
    public void printMaze(){
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                System.out.printf("%s", maze[i][j]);
            }
            System.out.println();
        }
    }
    
    public void left(){
        if (maze[currentRow][currentColumn - 1].equals("#")){
            System.out.println("Can't move that direction.");
        } else if (maze[currentRow][currentColumn - 1].equals("*")){
            System.out.println("You found the target!");
            found = true;
        } else {
            maze[currentRow][currentColumn] = " ";
            currentColumn--;
            maze[currentRow][currentColumn] = "W";
        }
    }
    
    public void right(){
        if (maze[currentRow][currentColumn+1].equals("#")){
            System.out.println("Can't move that direction.");
        } else if (maze[currentRow][currentColumn + 1].equals("*")){
            System.out.println("You found the target!");
            found = true;
        } else {
            maze[currentRow][currentColumn] = " ";
            currentColumn++;
            maze[currentRow][currentColumn] = "W";
        }
    }
    
    public void down(){
        if (maze[currentRow+1][currentColumn].equals("#")){
            System.out.println("Can't move that direction.");
        } else if (maze[currentRow+1][currentColumn].equals("*")){
            System.out.println("You found the target!");
            found = true;
        } else {
            maze[currentRow][currentColumn] = " ";
            currentRow++;
            maze[currentRow][currentColumn] = "W";
        }
    }
    
    public void up(){
        if (maze[currentRow-1][currentColumn].equals("#")){
            System.out.println("Can't move that direction.");
        } else if (maze[currentRow-1][currentColumn].equals("*")){
            System.out.println("You found the target!");
            found = true;
        }else {
            maze[currentRow][currentColumn] = " ";
            currentRow--;
            maze[currentRow][currentColumn] = "W";
        }
    }
    
    public void upLeft(){
        if (maze[currentRow-1][currentColumn-1].equals("#")){
            System.out.println("Can't move that direction.");
        } else if (maze[currentRow-1][currentColumn-1].equals("*")){
            System.out.println("You found the target!");
            found = true;
        }else {
            maze[currentRow][currentColumn] = " ";
            currentRow--;
            currentColumn--;
            maze[currentRow][currentColumn] = "W";
        }
    }

    public void upRight(){
        if (maze[currentRow-1][currentColumn+1].equals("#")){
            System.out.println("Can't move that direction.");
        } else if (maze[currentRow-1][currentColumn+1].equals("*")){
            System.out.println("You found the target!");
            found = true;
        }else {
            maze[currentRow][currentColumn] = " ";
            currentRow--;
            currentColumn++;
            maze[currentRow][currentColumn] = "W";
        }
    }

    public void downLeft(){
        if (maze[currentRow+1][currentColumn-1].equals("#")){
            System.out.println("Can't move that direction.");
        } else if (maze[currentRow+1][currentColumn-1].equals("*")){
            System.out.println("You found the target!");
            found = true;
        }else {
            maze[currentRow][currentColumn] = " ";
            currentRow--;
            currentColumn--;
            maze[currentRow][currentColumn] = "W";
        }
    }

    public void downRight(){
        if (maze[currentRow+1][currentColumn+1].equals("#")){
            System.out.println("Can't move that direction.");
        } else if (maze[currentRow+1][currentColumn+1].equals("*")){
            System.out.println("You found the target!");
            found = true;
        }else {
            maze[currentRow][currentColumn] = " ";
            currentRow--;
            currentColumn++;
            maze[currentRow][currentColumn] = "W";
        }
    }
    
    public boolean endGame(){
        return found;
    }
}
