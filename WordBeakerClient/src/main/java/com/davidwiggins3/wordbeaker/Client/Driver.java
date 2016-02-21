package com.davidwiggins3.wordbeaker.Client;

import com.davidwiggins3.wordbeaker.DocReader.WordDocxReader;
import com.davidwiggins3.wordbeaker.ProjectReader.ReaderException;

public class Driver 
{
    public static void main( String[] args ) throws ReaderException
    {
        WordDocxReader reader = new WordDocxReader();
        
        String fileLoc = "C:\\Users\\burnthq\\Documents\\Sync\\Writing\\The Elementalist.docx";
        int wordCount = reader.readWordCount(fileLoc);
        
        System.out.println( "Word Count = " + wordCount );
        
    }
}
