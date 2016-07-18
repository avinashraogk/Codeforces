/*
 * Copyright (c) Rakuten, Inc. All Rights Reserved.
 * 
 * This program is the information assets which are handled
 * as "Strictly Confidential".
 * Permission of Use is only admitted in Rakuten Inc.
 * Development Department.
 * If you don't have permission , MUST not be published,
 * broadcast, rewritten for broadcast or publication
 * or redistributed directly or indirectly in any medium.
 * 
 * $Id$
 * Created on May 29, 2016
 * Updated on $Date$
 */
package com.problems.codeforces;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author avinash.rao
 *
 */
public class Maze676D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Maze maze = new Maze(n, m);
        maze.initialize(sc);
    }
}

class Maze {

    Room[][] labyrinth;
    int n, m, mx, my;
    static volatile boolean found;

    Maze(int n, int m) {
        labyrinth = new Room[n][m];
        this.n = n;
        this.m = m;
    }

    void initialize(Scanner sc) {
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                Room room = new Room();
                room.x = i;
                room.y = j;
                room.shape = Shape.getShape(row.charAt(j));
                labyrinth[i][j] = room;
            }
        }
        int tx = sc.nextInt();
        int ty = sc.nextInt();
        tx--;
        ty--;
        labyrinth[tx][ty].isTheseusPresent = true;
        mx = sc.nextInt();
        my = sc.nextInt();
        mx--;
        my--;
        labyrinth[mx][my].isMinotaurPresent = true;
        if (tx == mx && ty == my) {
            found = true;
            printResult();
        }
        // printMaze();
        if (!found) {
            labyrinth[tx][ty].visited = true;
            searchForMinotaur(tx, ty);
        }
    }

    private void printMaze() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(labyrinth[i][j]);
            }
        }
    }

    private void searchForMinotaur(int tx, int ty) {
        if (!labyrinth[tx][ty].isMinotaurPresent && !found) {
            if (leftAvailable(ty)) {
                if (Moves.canMoveLeft(labyrinth[tx][ty], labyrinth[tx][ty - 1])) {
                    Moves.makeMove(labyrinth[tx][ty], labyrinth[tx][ty - 1]);
                    // if (minotaurFound(tx, ty - 1)) {
                    // printResult();
                    // return;
                    // } else {
                    searchForMinotaur(tx, ty - 1);
                    // }
                }
            }
            if (rightAvailable(ty)) {
                if (Moves.canMoveRight(labyrinth[tx][ty], labyrinth[tx][ty + 1])) {
                    Moves.makeMove(labyrinth[tx][ty], labyrinth[tx][ty + 1]);
                    // if (minotaurFound(tx, ty + 1)) {
                    // printResult();
                    // return;
                    // } else {
                    searchForMinotaur(tx, ty + 1);
                    // }
                }
            }
            if (topAvailable(tx)) {
                if (Moves.canMoveUp(labyrinth[tx][ty], labyrinth[tx - 1][ty])) {
                    Moves.makeMove(labyrinth[tx][ty], labyrinth[tx - 1][ty]);
                    // if (minotaurFound(tx - 1, ty)) {
                    // printResult();
                    // return;
                    // } else {
                    searchForMinotaur(tx - 1, ty);
                    // }
                }
            }
            if (downAvailable(tx)) {
                if (Moves.canMoveDown(labyrinth[tx][ty], labyrinth[tx + 1][ty])) {
                    Moves.makeMove(labyrinth[tx][ty], labyrinth[tx + 1][ty]);
                    // if (minotaurFound(tx + 1, ty)) {
                    // printResult();
                    // return;
                    // } else {
                    searchForMinotaur(tx + 1, ty);
                    // }
                }
            }
            transform(tx, ty);
            labyrinth[tx][ty].moves++;
            // printMaze();
            searchForMinotaur(tx, ty);
        } else {
            found = true;
            System.out.println(labyrinth[mx][my].moves);
            return;
        }
    }

    private void transform(int x, int y) {
        System.out.println("####");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                labyrinth[i][j].shape = labyrinth[i][j].shape.getTransformedShape();
            }
        }
    }

    private boolean minotaurFound(int tx, int ty) {
        return found = tx == mx && ty == my;
    }

    private boolean leftAvailable(int ty) {
        return ty != 0;
    }

    private boolean rightAvailable(int ty) {
        return ty != m - 1;
    }

    private boolean topAvailable(int tx) {
        return tx != 0;
    }

    private boolean downAvailable(int tx) {
        return tx != n - 1;
    }

    void printResult() {
        if (found) {
            System.out.println(labyrinth[mx][my].moves);
        }
    }
}

class Moves {
    static boolean canMoveLeft(Room from, Room to) {
        print(from, to, '<');
        if (from.shape.getOpenSides().contains(Side.LEFT)
                && to.shape.getOpenSides().contains(Side.RIGHT) && (!to.visited || from.moves + 1 < to.moves))
            return true;
        return false;
    }

    private static void print(Room from, Room to, char ch) {
        for (int i = 0; i < 20; i++)
            System.out.print(ch);
        System.out.println();

        System.out.println("From :" + from);
        System.out.println("To :" + to);

        for (int i = 0; i < 20; i++)
            System.out.print(ch);
        System.out.println();
    }

    public static void makeMove(Room from, Room to) {
        to.visited = true;
        to.isTheseusPresent = true;
        to.moves = from.moves + 1;
        System.out.println("=================");
    }

    static boolean canMoveRight(Room from, Room to) {
        print(from, to, '>');
        if (from.shape.getOpenSides().contains(Side.RIGHT)
                && to.shape.getOpenSides().contains(Side.LEFT)
                && (!to.visited || from.moves + 1 < to.moves))
            return true;
        return false;
    }

    static boolean canMoveUp(Room from, Room to) {
        print(from, to, '^');
        if (from.shape.getOpenSides().contains(Side.TOP)
                && to.shape.getOpenSides().contains(Side.BOTTOM) && (!to.visited || from.moves + 1 < to.moves))
            return true;
        return false;
    }

    static boolean canMoveDown(Room from, Room to) {
        print(from, to, 'V');
        if (from.shape.getOpenSides().contains(Side.BOTTOM)
                && to.shape.getOpenSides().contains(Side.TOP) && (!to.visited || from.moves + 1 < to.moves))
            return true;
        return false;
    }

}

class Room {
    Shape shape;
    int x, y, moves;
    boolean isTheseusPresent, isMinotaurPresent, visited;

    @Override
    public String toString() {
        return "Shape: " + shape + " x: " + x + " y: " + y + " moves: " + moves + " isTheseus?: " + isTheseusPresent
                + " isMinotus? " + isMinotaurPresent + " isVisited: " + visited;

    }
}

enum Side {
    LEFT, RIGHT, TOP, BOTTOM
};

enum Shape {

    CLOSED('*', 0),
    UP('^', 1, Side.TOP),
    DOWN('v', 1, Side.BOTTOM),
    LEFT('<', 1, Side.LEFT),
    RIGHT('>', 1, Side.RIGHT),
    UP_DOWN('|', 2, Side.TOP, Side.BOTTOM),
    LEFT_RIGHT('-', 2, Side.LEFT, Side.RIGHT),
    UP_DOWN_LEFT('R', 3, Side.TOP, Side.BOTTOM, Side.LEFT),
    UP_DOWN_RIGHT('L', 3, Side.TOP, Side.BOTTOM, Side.RIGHT),
    LEFT_RIGHT_UP('D', 3, Side.LEFT, Side.RIGHT, Side.TOP),
    LEFT_RIGHT_DOWN('U', 3, Side.LEFT, Side.RIGHT, Side.BOTTOM),
    OPEN('+', 4, Side.LEFT, Side.RIGHT, Side.TOP, Side.BOTTOM);

    private static Map<Shape, Shape> transformedShapes = new TreeMap<>();
    char symbol;
    int doors;
    List<Side> openSides;
    static {
        transformedShapes.put(CLOSED, CLOSED);
        transformedShapes.put(UP, RIGHT);
        transformedShapes.put(RIGHT, DOWN);
        transformedShapes.put(DOWN, LEFT);
        transformedShapes.put(LEFT, UP);
        transformedShapes.put(UP_DOWN, LEFT_RIGHT);
        transformedShapes.put(LEFT_RIGHT, UP_DOWN);
        transformedShapes.put(UP_DOWN_LEFT, LEFT_RIGHT_UP);
        transformedShapes.put(LEFT_RIGHT_UP, UP_DOWN_RIGHT);
        transformedShapes.put(UP_DOWN_RIGHT, LEFT_RIGHT_DOWN);
        transformedShapes.put(LEFT_RIGHT_DOWN, UP_DOWN_LEFT);
        transformedShapes.put(OPEN, OPEN);
        // System.out.println(transformedShapes);
    }

    Shape(char symbol, int doors, Side... sides) {
        this.symbol = symbol;
        this.doors = doors;
        openSides = Arrays.asList(sides);
    }

    public char getSymbol() {
        return symbol;
    }

    public int getDoors() {
        return doors;
    }

    public Shape getTransformedShape() {
        return transformedShapes.get(this);
    }

    public List<Side> getOpenSides() {
        return openSides;
    }

    static Shape getShape(char c) {
        for (Shape s : Shape.values()) {
            if (s.getSymbol() == c)
                return s;
        }
        return CLOSED;
    }

    @Override
    public String toString() {
        return "symbol: " + symbol + " doors: " + doors + " openSides: " + openSides + " transFormedShape: "
                + getTransformedShape().symbol + "\n";
    }
}
