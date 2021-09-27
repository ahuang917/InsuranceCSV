package availity;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 *  Unit tests of the methods found in CsvInsUtil
 * 
 *  @author Alan
 *  @version Sep 26, 2021
 */
class CsvUtilTest
{

    ArrayList<Enrollee> enrolleeList = new ArrayList<Enrollee>();
    Enrollee ahuang = new Enrollee("ahuang", "Alan", "Huang", 1, "UHC");
    Enrollee aanderson = new Enrollee("aanderson", "Aaron", "Anderson", 1, "Cigna");
    Enrollee aaaron = new Enrollee("aaaron", "Aaron", "Aaron", 2, "Aetna");
    
        
    @Test
    void testIsDuplicateUserId()
    {
        enrolleeList.add(ahuang);
        Enrollee ahuangNew = new Enrollee("ahuang", "Alan", "Huang", 2, "UHC");
        
        assertTrue(CsvInsUtil.isDuplicateUserId(enrolleeList, ahuangNew));
    }
    
    @Test
    void testGetInsuranceEnrolleeList() {
        enrolleeList.add(ahuang);
        enrolleeList.add(aanderson);
        enrolleeList.add(aaaron);
        ArrayList<Enrollee> uhcList = new ArrayList<Enrollee>();
        ArrayList<Enrollee> cignaList = new ArrayList<Enrollee>();
        ArrayList<Enrollee> aetnaList = new ArrayList<Enrollee>();
        
        uhcList = CsvInsUtil.getInsuranceEnrolleeList("UHC", enrolleeList);
        cignaList = CsvInsUtil.getInsuranceEnrolleeList("Cigna", enrolleeList);
        aetnaList = CsvInsUtil.getInsuranceEnrolleeList("Aetna", enrolleeList);
        
        assertTrue(uhcList.contains(ahuang));
        assertTrue(uhcList.size() == 1);
        
        assertTrue(cignaList.contains(aanderson));
        assertTrue(cignaList.size() == 1);
        
        assertTrue(aetnaList.contains(aaaron));
        assertTrue(aetnaList.size() == 1);
        
    }
    
    @Test
    void testUpdateEnrolleeList() {
        enrolleeList.add(ahuang);
        Enrollee ahuangNew = new Enrollee("ahuang", "Alan", "Huang", 2, "UHC");
        
        enrolleeList = CsvInsUtil.updateEnrolleeList(enrolleeList, ahuangNew);
        
        assertTrue(enrolleeList.size() == 1);
        assertEquals(enrolleeList.get(0), ahuangNew);
    }
    
    @Test
    void testSortingOfGetInsuranceEnrolleeList() {
        Enrollee ahuangUHC = new Enrollee("ahuang", "Alan", "Huang", 1, "UHC");
        Enrollee aandersonUHC = new Enrollee("aanderson", "Aaron", "Anderson", 1, "UHC");
        Enrollee baaronUHC = new Enrollee("baaron", "Beth", "Aaron", 2, "UHC");
        Enrollee aaaronUHC = new Enrollee("aaaron", "Aaron", "Aaron", 2, "UHC");
        
        enrolleeList.add(ahuangUHC);
        enrolleeList.add(aandersonUHC);
        enrolleeList.add(baaronUHC);
        enrolleeList.add(aaaronUHC);
        
        enrolleeList = CsvInsUtil.getInsuranceEnrolleeList("UHC", enrolleeList);
        
        assertTrue(enrolleeList.size() == 4);
        assertEquals(enrolleeList.get(0), aaaronUHC);
        assertEquals(enrolleeList.get(1), baaronUHC);
        assertEquals(enrolleeList.get(2), aandersonUHC);
        assertEquals(enrolleeList.get(3), ahuangUHC);
        
    }
}
