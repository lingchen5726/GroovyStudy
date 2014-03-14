package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import org.junit.Test;
import provgw.Event
import provgw.SPRDevice
import provgw.Wlit

class T6AddWlitIso01 {

    @Test
    public void test() {
        def wlit = new Wlit()
        wlit.add(TestConstants.childEntrNo, TestConstants.fatherMsisdn);
        
        sleep(TestConstants.sleepCount)
        
        def sprdev = new SPRDevice()
        LGUPDevice d = sprdev.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        assertTrue(TestUtils.isTimeCorrect('9999-12-31 00:00:00', d.getLguWLITEndDate()))
        assertTrue(TestUtils.isTimeCorrect('2011-05-09 00:00:00', d.getLguWLITStartDate()))
        assertEquals(TestConstants.fatherMsisdn, d.getLguWLITSMSReceiver())
        assertEquals('Y', d.getLguWLITISOLDVCode())
        //assertEquals('root', d.getLguWLITPRSSDVCode())
        assertEquals('Y', d.getLguWLITSMSFlag())
        assertTrue(TestUtils.isTimeCorrect(new Date(), d.getLastSyncedTime()))
        
        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'ADDWLITISO'))

    }

}
