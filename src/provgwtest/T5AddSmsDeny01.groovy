package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import org.junit.Test;
import provgw.Event
import provgw.SPRDevice
import provgw.SmsDeny

class T5AddSmsDeny01 {

    @Test
    public void test() {
        def smsdeny = new SmsDeny()
        smsdeny.add(TestConstants.childEntrNo);
        
        sleep(TestConstants.sleepCount)
        
        def sprdev = new SPRDevice()
        LGUPDevice d = sprdev.get(TestConstants.childEntrNo)

        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        assertTrue(TestUtils.isTimeCorrect('2011-05-09 00:00:00', d.getLguSMSDenyStartDate()))
        assertTrue(TestUtils.isTimeCorrect('9999-12-31 00:00:00', d.getLguSMSDenyEndDate()))
        //assertEquals('DL_SERVICE_CODE', d.getLguSMSDenyDLSVCCode())
        //assertEquals(1111, d.getLguSMSDenyDLUpdateStamp())
        assertTrue(TestUtils.isTimeCorrect(new Date(), d.getLastSyncedTime()))

        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'ADDSMS'))

    }

}
