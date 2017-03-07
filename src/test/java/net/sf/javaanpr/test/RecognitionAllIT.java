/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.javaanpr.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import net.sf.javaanpr.imageanalysis.CarSnapshot;
import net.sf.javaanpr.intelligence.Intelligence;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Frederik
 */
@RunWith(Parameterized.class)
public class RecognitionAllIT {

    String snapshotDirPath = "src/test/resources/snapshots";
    Intelligence intel = new Intelligence();
    
    String expResult = "";
    String currPlate = "";
    CarSnapshot currCarSnap;
    
    public RecognitionAllIT(String expResult, String currPlate) throws Exception {
        this.expResult = expResult;
        this.currPlate = currPlate;
        File tmp = new File(snapshotDirPath + "\\" + currPlate);
        currCarSnap = new CarSnapshot(new FileInputStream(tmp));

    }

    
    //The parameters consist of 2 objects, a string which is the expected result
    //and another String which is the file name of the given file.
    //i generated these paramters with the psvm at the bottom. this can be used
    //if they decide to add more pictures and more properties in the results file
    //they just need to copy-paste it in.
    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
            {"PP587AO", "test_001.jpg"}, {"RK755AJ", "test_002.jpg"}, {"SI819AK", "test_003.jpg"}, {"RK115AN", "test_004.jpg"}, {"TS260AK", "test_005.jpg"}, {"RK099AN", "test_006.jpg"}, {"RK828AG", "test_007.jpg"}, {"LM298AI", "test_008.jpg"}, {"1T43213", "test_009.jpg"}, {"RK248AH", "test_010.jpg"}, {"RK346AL", "test_011.jpg"}, {"RK291AT", "test_012.jpg"}, {"RK857AI", "test_013.jpg"}, {"RK576AH", "test_014.jpg"}, {"RK019AF", "test_015.jpg"}, {"BB751BH", "test_016.jpg"}, {"RK876AD", "test_017.jpg"}, {"RK884AL", "test_018.jpg"}, {"RK865AC", "test_019.jpg"}, {"RK906AJ", "test_020.jpg"}, {"RK855AP", "test_021.jpg"}, {"RK875AE", "test_022.jpg"}, {"RK612AL", "test_023.jpg"}, {"RK026AJ", "test_024.jpg"}, {"RK896AO", "test_025.jpg"}, {"RK492AU", "test_026.jpg"}, {"RK776AI", "test_027.jpg"}, {"LM633BD", "test_028.jpg"}, {"LM010BE", "test_029.jpg"}, {"RK819AM", "test_030.jpg"}, {"RK619AS", "test_031.jpg"}, {"RK763AS", "test_032.jpg"}, {"RK082AL", "test_033.jpg"}, {"SG47471", "test_034.jpg"}, {"BA738DE", "test_035.jpg"}, {"RK708AI", "test_036.jpg"}, {"RK260AR", "test_037.jpg"}, {"RK340A0", "test_038.jpg"}, {"RK892AE", "test_039.jpg"}, {"RK101AO", "test_040.jpg"}, {"LM025BD", "test_041.jpg"}, {"BA28IM", "test_042.jpg"}, {"DK41AH", "test_043.jpg"}, {"RK878AC", "test_044.jpg"}, {"RK878AC", "test_045.jpg"}, {"RK143AT", "test_046.jpg"}, {"RK161AG", "test_047.jpg"}, {"RK161AG", "test_048.jpg"}, {"KMBORAK", "test_049.jpg"}, {"BB135BO", "test_050.jpg"}, {"RK605AB", "test_051.jpg"}, {"BY649AG", "test_052.jpg"}, {"RK715AA", "test_053.jpg"}, {"RK22AH", "test_054.jpg"}, {"NO450AM", "test_055.jpg"}, {"RK300AG", "test_056.jpg"}, {"RK300AS", "test_057.jpg"}, {"RK485AF", "test_058.jpg"}, {"BA302OZ", "test_059.jpg"}, {"BA302OZ", "test_060.jpg"}, {"MT456BJ", "test_061.jpg"}, {"1B80338", "test_062.jpg"}, {"1B25790", "test_063.jpg"}, {"BZM2227", "test_064.jpg"}, {"4B04979", "test_065.jpg"}, {"BSE5579", "test_066.jpg"}, {"1B70440", "test_067.jpg"}, {"1B19839", "test_068.jpg"}, {"4B40262", "test_069.jpg"}, {"2T40211", "test_070.jpg"}, {"1Z75233", "test_071.jpg"}, {"4B39376", "test_072.jpg"}, {"3B97236", "test_073.jpg"}, {"3B29485", "test_074.jpg"}, {"ZA834CO", "test_075.jpg"}, {"4B21875", "test_076.jpg"}, {"RK735AS", "test_077.jpg"}, {"RK457AS", "test_078.jpg"}, {"RK959AF", "test_079.jpg"}, {"RK003AB", "test_080.jpg"}, {"RK641AL", "test_081.jpg"}, {"RK891AU", "test_082.jpg"}, {"PD935BG", "test_083.jpg"}, {"PD722BF", "test_084.jpg"}, {"RK959AD", "test_085.jpg"}, {"RK376AF", "test_086.jpg"}, {"RK011AM", "test_087.jpg"}, {"LM169AM", "test_088.jpg"}, {"RK565AV", "test_089.jpg"}, {"RK550AO", "test_090.jpg"}, {"RK977AF", "test_091.jpg"}, {"RK373AK", "test_092.jpg"}, {"RK301AH", "test_093.jpg"}, {"RK069AV", "test_094.jpg"}, {"NO626AT", "test_095.jpg"}, {"RK735AS", "test_096.jpg"}, {"RK603AV", "test_097.jpg"}
        });
    }

    @Test
    public void ParamTest() throws Exception {
        //use the intel object to get the actual result
        String numberPlate = intel.recognize(currCarSnap, false);
        
        //then use JUnit's assertTrue to get the test outcome
        //assertTrue(currPlate + "   Expected: " + expResult + "    but got: " + numberPlate, expResult.equals(numberPlate));
        
        //the same thing is achieved with here, but this is with hamcrest instead
        assertThat(numberPlate,is(equalTo(expResult)));
    }

    
    //Used this to generate the parameters
    
//    public static void main(String[] args) throws Exception {
//        String snapshotDirPath = "src/test/resources/snapshots";
//        String resultsPath = "src/test/resources/results.properties";
//        InputStream resultsStream = new FileInputStream(new File(resultsPath));
//        Properties properties = new Properties();
//        properties.load(resultsStream);
//        resultsStream.close();
//
//        File snapshotDir = new File(snapshotDirPath);
//        File[] snapshots = snapshotDir.listFiles();
//        for (File snap : snapshots) {
//            System.out.print("{\"" + properties.get(snap.getName()) + "\",\"" + snap.getName() + "\"},");
//        }
//    }
}
