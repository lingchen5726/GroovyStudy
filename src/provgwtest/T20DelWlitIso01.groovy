package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import org.junit.Test;
import provgw.Event
import provgw.SPRDevice
import provgw.Wlit

class T20DelWlitIso01 {

    @Test
    public void test() {
        def wlit = new Wlit()
        wlit.delete(TestConstants.childEntrNo)
        sleep(TestConstants.sleepCount)
        
        def sprdev = new SPRDevice()
        LGUPDevice d = sprdev.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        assertEquals(0, d.getLguWLITEndDate())
        assertEquals(0, d.getLguWLITStartDate())
        assertEquals('', d.getLguWLITSMSReceiver())
        //It's still 'Y' 
        //assertEquals('', d.getLguWLITISOLDVCode())
        assertEquals('', d.getLguWLITSMSFlag())
        //assertEquals('', d.getLastSyncedTime())
        
        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'DELWLITISO'))
    }

}
