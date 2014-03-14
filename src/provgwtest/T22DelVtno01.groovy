package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.DeviceIdentifier
import org.junit.Test;
import provgw.Event
import provgw.SPRDeviceIdentifier
import provgw.VtNo

class T22DelVtno01 {

    @Test
    public void test() {
        def vtNo = new VtNo()
        vtNo.delete(TestConstants.childEntrNo)
        
        sleep(TestConstants.sleepCount)
        
        def sprdi = new SPRDeviceIdentifier()
        DeviceIdentifier di0 = sprdi.get(TestConstants.childUpdMsisdn, 0)
        assertEquals(0, di0.getIdentifierType())
        assertEquals(TestConstants.childUpdMsisdn, di0.getIdentifier())
        DeviceIdentifier di1 = sprdi.get(TestConstants.childUpdImsi, 1)
        assertEquals(1, di1.getIdentifierType())
        assertEquals(TestConstants.childUpdImsi, di1.getIdentifier())
        DeviceIdentifier di99 = sprdi.get(TestConstants.childUpdRoamImsi, 99)
        assertEquals(99, di99.getIdentifierType())
        assertEquals(TestConstants.childUpdRoamImsi, di99.getIdentifier())
        List<DeviceIdentifier> dis = sprdi.get(TestConstants.childEntrNo)
        assertEquals(4, dis.size())

        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'DELVTNO'))
    }

}
