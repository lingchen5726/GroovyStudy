package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import org.junit.Test;
import provgw.Dev
import provgw.Event
import provgw.SPRDevice
import provgw.Sub
import provgw.Wlit

class T15UpdWlitIso01 {

    @Test
    public void test() {
        def dev = new Dev()
        dev.add(TestConstants.motherEntrNo, TestConstants.motherMsisdn, TestConstants.motherImsi)
        sleep(TestConstants.sleepCount)
        def sub = new Sub()
        sub.add(TestConstants.motherEntrNo, TestConstants.motherSpId);
        sleep(TestConstants.sleepCount)
        def wlit = new Wlit()
        wlit.update(TestConstants.childEntrNo, TestConstants.motherMsisdn, 'N', 'N', '1118639901', '2014-03-31 23:59:59');
        sleep(TestConstants.sleepCount)
        
        def sprdev = new SPRDevice()
        LGUPDevice d = sprdev.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        //assertTrue(TestUtils.isTimeCorrect('2014-03-31 23:59:59', d.getLguWLITEndDate()))
        //assertTrue(TestUtils.isTimeCorrect('2011-05-09 00:00:00', d.getLguWLITStartDate()))
        assertEquals(TestConstants.motherMsisdn, d.getLguWLITSMSReceiver())
        assertEquals('N', d.getLguWLITISOLDVCode())
        assertEquals('N', d.getLguWLITSMSFlag())
        assertTrue(TestUtils.isTimeCorrect(new Date(), d.getLastSyncedTime()))
        
        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'UPDWLITISO'))
        
    }

}
