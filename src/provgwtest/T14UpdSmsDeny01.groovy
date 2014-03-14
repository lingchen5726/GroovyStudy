package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import org.junit.Test;
import provgw.Event
import provgw.SPRDevice
import provgw.SmsDeny

class T14UpdSmsDeny01 {

    @Test
    public void test() {
        def smsdeny = new SmsDeny()
        smsdeny.update(TestConstants.childEntrNo, '2011-05-09 00:00:00', '2014-08-31 23:59:59', 'DL_SERVICE_CODE_UPD');
        
        sleep(TestConstants.sleepCount)
        
        def sprdev = new SPRDevice()
        LGUPDevice d = sprdev.get(TestConstants.childEntrNo)

        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        //assertTrue(TestUtils.isTimeCorrect('2011-05-09 00:00:00', d.getLguSMSDenyStartDate()))
        //assertTrue(TestUtils.isTimeCorrect('2014-08-31 23:59:59', d.getLguSMSDenyEndDate()))
        //assertEquals('DL_SERVICE_CODE_UPD', d.getLguSMSDenyDLSVCCode())
        assertTrue(TestUtils.isTimeCorrect(new Date(), d.getLastSyncedTime()))

        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'UPDSMS'))
    }

}
