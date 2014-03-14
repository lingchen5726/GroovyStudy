package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import org.junit.Test;
import provgw.Event
import provgw.SPRDevice
import provgw.SmsNotc

class T16UpdSmsNotc01 {

    @Test
    public void test() {
        def smsNotc = new SmsNotc()
        smsNotc.update(TestConstants.childEntrNo, TestConstants.motherMsisdn, '2014-03-01 00:00:00', '2014-08-31 23:59:59');
        
        sleep(TestConstants.sleepCount)
        
        def sprdev = new SPRDevice()
        LGUPDevice d = sprdev.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        assertEquals(TestConstants.motherMsisdn, d.getLguSMSNOTCReceiver())
        //assertTrue(TestUtils.isTimeCorrect('2014-03-01 00:00:00', d.getLguSMSNOTCStartDate()))
        //Original legacy table TB_SB_LTE_RMND_SMS_NOTC hasn't field end 
        //assertEquals('root', d.getLguSMSNOTCEndDate())
        assertTrue(TestUtils.isTimeCorrect(new Date(), d.getLastSyncedTime()))
        
        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'UPDSMSNOTIC'))
    }

}
