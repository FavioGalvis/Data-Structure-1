/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.structure.pkg1;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author 201521268405
 */
public class Linked_Lists_A {
    public static void main(String[] args){
        
        Scanner read = new Scanner ( System.in );
        String i = null,Data = null;
        boolean Flag=false;
        int Index=0;
        LinkedList<String> List = new LinkedList<String>();
        
        List.add("Favio");
        List.add("Mike");
        List.add("Jhonny");
        
        ListIterator<String> Pointer = List.listIterator();
        Data = read.nextLine();
        
        while(Pointer.hasNext()){
            i = Pointer.next();
            if(Data.equals(i)){
                Index=Pointer.previousIndex();
                Flag=true;
            }
        }
        if (Flag){
            System.out.println("Found!"+List.get(Index));
        } else {
            System.out.println("Not Found");
        }
        
    
    }
}
