package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import org.junit.Test;
import provgw.Event
import provgw.SPRDevice
import provgw.SmsNotc

class T19DelSmsNotc01 {

    @Test
    public void test() {
        def smsNotc = new SmsNotc()
        smsNotc.delete(TestConstants.childEntrNo)
        
        sleep(TestConstants.sleepCount)
        
        def sprdev = new SPRDevice()
        LGUPDevice d = sprdev.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        assertEquals(null, d.getLguSMSNOTCReceiver())
        assertEquals(0, d.getLguSMSNOTCStartDate())
        //Original legacy table TB_SB_LTE_RMND_SMS_NOTC hasn't field end 
        //assertEquals('root', d.getLguSMSNOTCEndDate())
        //assertEquals('', d.getLastSyncedTime())
        
        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'DELSMSNOTIC'))
    }

}
