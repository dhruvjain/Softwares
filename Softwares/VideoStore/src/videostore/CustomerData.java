/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videostore;

import java.io.File;

/**
 *
 * @author DHRUV
 */
public class CustomerData {
    private static String path = System.getProperty("user.home") + "/Project5Files";
     public static boolean checkLogin(String custno)throws Exception
    {
        File f = new File(path + "/" + custno + ".ser");
        if(!f.exists())
            return false;
        else
            return true;
    }
    
}
