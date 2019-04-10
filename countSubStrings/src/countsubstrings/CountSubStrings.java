/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countsubstrings;

/**
 *
 * @author Chris
 */
public class CountSubStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s1 = "Java is a programming language originally developed by James Gosling at Sun Microsystems  and released in 1995 as a core component of Sun Microsystems Java platform. The language derives much of its syntax from C and C++ but has a simpler object model and fewer low-level facilities. Java applications are typically compiled to bytecode (class file) that can run on any Java Virtual Machine (JVM) regardless of computer architecture. Java is a general-purpose, concurrent, class-based, object-oriented language that is specifically designed to have as few implementation dependencies as possible. Java is currently one of the most popular programming languages in use, particularly for client-server web applications, with a reported 10 million users.";
        String s2 = "Java";
        System.out.println(countSubString(s1, s2));
    }
    
    public static int countSubString(String s1, String s2) {
        
        if (s1.indexOf(s2) == -1) {
            return 0;
        } else {
            int start_index = s1.indexOf(s2);
            String string_1 = s1.substring((start_index+s2.length()), s1.length());
            return countSubString(string_1, s2)+1;
        }
    }
}
