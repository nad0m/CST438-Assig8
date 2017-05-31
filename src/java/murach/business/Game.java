package murach.business;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import murach.data.*;
/**
 * Game contains logic to play hangman game.
 * Includes code to generate new words,
 * process user guess, determine win or lose.
 * @author Huy
 * @version 1.0
 */
public class Game {
 
    private Random generator;  
    private int state;  
	           //  1 means no incorrect guesses, or start of game
                   //  2 means 1 incorrect guess.
                   //  3 means 2 incorrect guesses.
                   //  4 means 3 incorrect guesses.
                   //  5 means 4 incorrect guesses.
                   //  6 means 5 incorrect guesses.
	           //  7 means 6 incorrect guesses, user has lost game
    
    public String word;   // the word to be guessed 
    private StringBuffer displayWord; // part of the word (if any) to show user
    private ArrayList<String> wordlist;  // list of words
    private List<Character> letterList = new ArrayList<Character>();
    
    public Game() {
        generator = new Random();
        wordlist=null;
        randomWord();
        createDisplayWord();
        state=1;       
        letterList.clear();
        
    }
    
    public int getState(){
        return state;
    }
    
    public String getWord(){
        return word;
    }
    
    public List<Character> getLetterList(){
        System.out.println(letterList);
        return letterList;
    }
    
    public String getDisplayWord(){
        return displayWord.toString();
    }
    
    public void startNewGame() {
        state = 1;
        randomWord(); // modification 1
        createDisplayWord();
        letterList.clear();
    }
    
    /*
     * process a user guess return page saying game over user win or lost, or
     * return page with updated game display
     * return 0 = continue game, good guess
     *        1 = good guess.  Win game. 
     *        2 = bad guess.  continue game
     *        3 = bad guess.  Lost game.
     *        4 = bad input. Redo.
     */
    public int playGame(char guess) {
            System.out.println(isValidInput(guess));
            
            guess = Character.toLowerCase(guess);
            
            if(!isValidInput(guess) || isUsed(guess)) // modification 2 - test for input
            {
              return 4;   // bad input, continue with same state
            }
            
            letterList.add(guess);
            
            boolean correctGuess = updateDisplayWord(guess);
            
            if (correctGuess==false) { 
                state++;
                if (state==7) {
                    // user has lost game
                    return 3;
                } else {
                    return 2; // bad guess, continue
                }
            } else if ( displayWord.indexOf("_") >= 0) {
               return 0; // continue game, with good guess
            } else {
               return 1; // all characters has been guessed, user has won game.
            }
    }
    
    
    public boolean isValidInput(char guess)
    {
        return Character.isLetter(guess); //returns false if guess is not a letter
    }
    
    public boolean isUsed(char guess)
    {
        return letterList.indexOf(guess) > -1; //returns true if guess is in letterList
    }
    
    
    /**
     * update display word to show any occurrences of guess
     * There is a space character between each letter, and 
     * any letters remaining to be guessed are displayed as underscore
     * @param guess
     * @return true if at least one match, false if guess is incorrect
     */
    private boolean updateDisplayWord(char guess){
        boolean correctGuess = false;
        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i)==guess){
                    displayWord.replace(2*i, 2*i+1, Character.toString(guess)); 
                    correctGuess=true;
                }
        }
        return correctGuess;
        
    }
    /**
     * Create the display version of word with letters replaced by
     * underscore for letter remaining to be guessed
     * @param word
     * @return 
     */
    private void createDisplayWord(){
        displayWord = new StringBuffer("_");
        for (int i=1; i<word.length(); i++) {
            displayWord.append(" _");
        }
   
    }
    
       /**
     * generate random word.
     * 
     * @return a word from the list
     */
    public String randomWord() {
        
        word = wordDB.selectWord(55);
        System.out.println(word);
        System.out.println("hello world");
        return word;
	
    }
}
