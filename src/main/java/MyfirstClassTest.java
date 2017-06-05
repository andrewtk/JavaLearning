import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by a.tkachuk on 28.02.2017.
 */
public class MyfirstClassTest {
    @org.junit.Test
    public void binarSearchArray() throws Exception {
        int[] ar1 = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        int[] resultArray = new int[20];

        for(int i=0; i<20; i++){
            resultArray[i] = MyfirstClass.binarSearchArray(ar1,i);
        }
        assertArrayEquals(ar1,resultArray);



    }
    @org.junit.Test
    public void binarSearchArrayNegativeCase() throws Exception {
        int[] ar1 = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        int result=0;


        result = MyfirstClass.binarSearchArray(ar1,-1);
        assertEquals(-1,result);



    }

}