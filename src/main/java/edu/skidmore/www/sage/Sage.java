package edu.skidmore.www.sage;

import java.io.PrintWriter;

/**
 * Just a test class for now.
 *
 */
public class Sage 
{
    public static void main( String[] args )
    {
        System.setProperty("line.separator", "xxx");
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("foo");
        pw.println("bar");
        pw.flush();
    }
}
