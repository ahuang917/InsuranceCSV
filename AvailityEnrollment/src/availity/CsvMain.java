package availity;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet; 


/**
 *  This class will read in a CSV file containing enrollment information
 *  and seperate enrollees by insurance company in its own file.
 *  Files created will be sorted by last and first name (ascending).
 *  Duplicate user IDs for the same insurance company should only include
 *  the latest version. 
 *  Assumptions are CSV format is User ID, Last Name, First Name, Version, Insurance
 *  and does not contain these as headers.
 *  
 *  @author Alan
 *  @version Sep 26, 2021
 */
public class CsvMain
{

    /**
     * Main class
     * @param args
     */
    public static void main(String[] args)
    {
        final String COMMA_DELIMITER = ",";
        HashSet<String> insuranceList = new HashSet<String>();
        ArrayList<Enrollee> enrolleeList = new ArrayList<Enrollee>();
        
        try {
            FileReader file = new FileReader("test01.csv");
            BufferedReader br = new BufferedReader(file);
            
            String line;
            
            //read file and create enrollee and create insurance list
            while((line = br.readLine()) != null) {
                String[] val = line.split(COMMA_DELIMITER);
                String userId = val[0];
                String lName = val[1];
                String fName = val[2];
                int ver = Integer.parseInt(val[3]);
                String ins = val[4].toUpperCase();
                
                Enrollee enrollee = new Enrollee(userId, lName, fName, ver, ins);
                
                //Check for duplicate userID
                if(CsvInsUtil.isDuplicateUserId(enrolleeList, enrollee)) {
                    enrolleeList = CsvInsUtil.updateEnrolleeList(enrolleeList, enrollee);
                } else {
                    enrolleeList.add(enrollee);
                }

                insuranceList.add(ins);
                
            }
            
            //Create a file for every different insurances parsed.
            for(String insurance: insuranceList) {
                ArrayList<Enrollee> insuranceEnrollee = CsvInsUtil.getInsuranceEnrolleeList(insurance, enrolleeList);
                CsvInsUtil.createFile(insurance, insuranceEnrollee);
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    

    
    
    
}
