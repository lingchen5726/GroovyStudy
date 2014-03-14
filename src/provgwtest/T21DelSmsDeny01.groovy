package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import org.junit.Test;
import provgw.Event
import provgw.SPRDevice
import provgw.SmsDeny

class T21DelSmsDeny01 {

    @Test
    public void test() {
        def smsdeny = new SmsDeny()
        smsdeny.delete(TestConstants.childEntrNo)
        
        sleep(TestConstants.sleepCount)
        
        def sprdev = new SPRDevice()
        LGUPDevice d = sprdev.get(TestConstants.childEntrNo)

        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        assertEquals(0, d.getLguSMSDenyStartDate())
        assertEquals(0, d.getLguSMSDenyEndDate())
        assertEquals(null, d.getLguSMSDenyDLSVCCode())
        //assertEquals('', d.getLastSyncedTime())

        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'DELSMS'))
    }

}
