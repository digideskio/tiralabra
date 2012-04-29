package joosakur.regexptulkki;

import java.util.Scanner;
import joosakur.regexptulkki.regexp.MyRegExpMatcher;

class App 
{
    private Scanner scanner;
    private MyRegExpMatcher matcher;
    
    public void run() {
        scanner = new Scanner(System.in);
        matcher = new MyRegExpMatcher();
        
        while(true){
            String regexp = "";
            while(regexp.length()==0){
                regexp = getRegexp();
            }
            
            String input = "";
            while(input.length()==0){
                input = getInput();
            }
            
            
            getAndShowResults(regexp, input);
            
            if(!getContinue()) break;
        }
        
        System.out.println("Ohjelman suoritus päättynyt.");
    }
    
    private String getRegexp(){
        System.out.println("Syötä säännöllinen lauseke:");
        try {
            String regexp = scanner.nextLine();
            if(regexp.contains(".")) throw new Exception();
            else return regexp;
        } catch (Exception e) {
            System.out.println("Virheellinen lauseke.");
            return "";
        }
    }
    
    private String getInput(){
        System.out.println("Syötä merkkijono:");
        String input = scanner.nextLine();
        
        if(input.contains(".")){
            System.out.println("Piste ei ole sallittu syötteessä");
            return "";
        }
        
        return input;
    }
    
    private boolean getContinue(){
        while(true){
            System.out.println("Haluatko jatkaa? (y/n)");
            String input = scanner.nextLine();
            if(input.length() != 1) continue;
            if(input.toLowerCase().charAt(0) == 'y') return true;
            if(input.toLowerCase().charAt(0) == 'n') return false;
        }
        
    }

    private void getAndShowResults(String regexp, String input){
        try {
            boolean match = matcher.matches(regexp, input);
            if(match) {
                System.out.println("Merkkijono on lausekkeen mukainen");
            }
            else System.out.println("Merkkijono ei ole lausekkeen mukainen");
        } catch (Exception e) {
            System.out.println("Virhe: Tulosta ei pystytty laskemaan.");
        }
    }
    
}
