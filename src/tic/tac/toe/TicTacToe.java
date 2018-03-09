/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

/**
 *
 * @author Risad
 */
import java.util.Scanner;

public class TicTacToe {

    public static Scanner scan = new Scanner(System.in);
    public static char[][] board;
    public static char turn = 'X';
    public static int row,column;
    public static int[][] validity;
    
    
    public static void main(String[] args) {
        
        board=new char[3][3];
        validity=new int[3][3];
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                board[i][j]='_';
                validity[i][j]=0;
            }
        }
        play();
    }
    
    
    public static void printboard()
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(j==0)System.out.print("| ");
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }
    
    public static void play()
    {
        boolean playing=true;
        printboard();
        while(playing)
        {
            row=scan.nextInt()-1;
            column=scan.nextInt()-1;
            if(validity[row][column]==1)
            {
                System.out.println("Wrong Move");
            }
            else
            {
                validity[row][column]=1;
                board[row][column]=turn;
                printboard();
                if(gameover(row,column))
                {
                    playing=false;
                    System.out.println("Game Over");
                    System.out.println(turn + " Wins");
                }
                if(turn=='X')turn='O';
                else turn='X';
            }
        }
    }
    
    public static boolean gameover(int rmove, int cmove)
    {
        if((board[0][cmove]==board[1][cmove]) && (board[0][cmove]==board[2][cmove]) && board[0][cmove]!='_')return true;
        if((board[rmove][0]==board[rmove][1]) && (board[rmove][0]==board[rmove][2]) && board[rmove][0]!='_')return true;
        if((board[0][0]==board[1][1]) && (board[0][0]==board[2][2]) && board[0][0]!='_')return true;
        if((board[0][2]==board[1][1]) && (board[0][2]==board[2][0]) && board[0][2]!='_')return true;
        else return false;
    }
}
