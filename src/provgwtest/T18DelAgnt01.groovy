package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import org.junit.Test;
import provgw.Agnt
import provgw.Event
import provgw.SPRDevice

class T18DelAgnt01 {

    @Test
    public void test() {
        def agnt = new Agnt()
        agnt.delete(TestConstants.childEntrNo)
        
        sleep(TestConstants.sleepCount)
        
        def sprdev = new SPRDevice()
        LGUPDevice d = sprdev.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        assertEquals(null, d.getLguAGNTKDCode())
        assertEquals(0, d.getLguAGNTCustomerNo())
        assertEquals(0, d.getLguAGNTValidStartDate())
        assertEquals(0, d.getLguAGNTValidEndDate())
        assertEquals(null, d.getLguAGNTFlag())
        //assertEquals('', d.getLastSyncedTime())
        
        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'DELAGNT'))
    }

}
