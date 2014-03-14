package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import org.junit.Test;
import provgw.Agnt
import provgw.Event
import provgw.SPRDevice

class T8AddAgnt01 {

    @Test
    public void test() {
        def agnt = new Agnt()
        agnt.add(TestConstants.childEntrNo, TestConstants.fatherMsisdn);
        
        sleep(TestConstants.sleepCount)
        
        def sprdev = new SPRDevice()
        LGUPDevice d = sprdev.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        assertEquals('DSA', d.getLguAGNTKDCode())
        assertEquals(Long.valueOf(TestConstants.fatherMsisdn), d.getLguAGNTCustomerNo())
        assertTrue(TestUtils.isTimeCorrect('2011-05-09 00:00:00', d.getLguAGNTValidStartDate()))
        assertTrue(TestUtils.isTimeCorrect('9999-12-31 00:00:00', d.getLguAGNTValidEndDate()))
        assertEquals('Y', d.getLguAGNTFlag())
        assertTrue(TestUtils.isTimeCorrect(new Date(), d.getLastSyncedTime()))
        
        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'ADDAGNT'))

    }

}
