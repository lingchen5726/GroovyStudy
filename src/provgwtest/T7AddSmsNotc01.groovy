package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import org.junit.Test;
import provgw.Event
import provgw.SPRDevice
import provgw.SmsNotc

class T7AddSmsNotc01 {

    @Test
    public void test() {
        def smsNotc = new SmsNotc()
        smsNotc.add(TestConstants.childEntrNo, TestConstants.fatherMsisdn);
        
        sleep(TestConstants.sleepCount)
        
        def sprdev = new SPRDevice()
        LGUPDevice d = sprdev.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        assertEquals(TestConstants.fatherMsisdn, d.getLguSMSNOTCReceiver())
        assertTrue(TestUtils.isTimeCorrect('2011-05-09 00:00:00', d.getLguSMSNOTCStartDate()))
        //Original legacy table TB_SB_LTE_RMND_SMS_NOTC hasn't field end 
        //assertEquals('', d.getLguSMSNOTCEndDate())
        assertTrue(TestUtils.isTimeCorrect(new Date(), d.getLastSyncedTime()))
        
        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'ADDSMSNOTIC'))

    }

}
