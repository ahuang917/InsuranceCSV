package availity;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *  Utility class that supports the parsing and creation of CSV insurance enrollees
 * 
 *  @author Alan
 *  @version Sep 26, 2021
 */
public final class CsvInsUtil
{
    /**
     * Returns a new sorted list of enrollees under a specific insurance.
     * @param insurance
     * @param list
     * @return Array list of enrollees
     */
    public static ArrayList<Enrollee> getInsuranceEnrolleeList(String insurance, ArrayList<Enrollee> list){
        ArrayList<Enrollee> newList = new ArrayList<Enrollee>();
        
        for(Enrollee e : list) {
            if (e.getInsurance().equalsIgnoreCase(insurance)) {
                newList.add(e);
            }
        }

        Collections.sort(newList, Comparator.comparing(Enrollee::getLastName)
                                            .thenComparing(Enrollee::getFirstName));
        
        return newList;
    }
    
    /**
     * Creates the files based on the insurance.
     * @param insurance
     * @param list
     * @throws IOException
     */
    public static void createFile(String insurance, ArrayList<Enrollee> list) throws IOException {
        String filename = insurance + ".csv";
        PrintWriter pw = new PrintWriter(new FileWriter(filename));
        
        for (Enrollee e : list) {
            pw.print(e);
        }
        
        pw.close();
        System.out.println(filename + " has been created");
    }
    

    /**
     * Checks if userID is a duplicate with the same insurance.
     * @param list
     * @param enrollee TODO
     * @return true or false
     */
    public static boolean isDuplicateUserId(ArrayList<Enrollee> list, Enrollee enrollee) {
        for(Enrollee e : list) {
            if (e.getUserID().equalsIgnoreCase(enrollee.getUserID()) 
                && e.getInsurance().equalsIgnoreCase(enrollee.getInsurance())) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Updates the enrollee list if duplicate user id and lower version
     * @param list
     * @param enrollee
     * @return
     */
    public static ArrayList <Enrollee> updateEnrolleeList(ArrayList<Enrollee> list, Enrollee enrollee) {
        for(Enrollee e : list) {
            if (e.getUserID().equalsIgnoreCase(enrollee.getUserID()) &&
                e.getVersion() < enrollee.getVersion()) {
                list.set(list.indexOf(e), enrollee);
                return list;
            }
        }
        
        return list;
    }
}
