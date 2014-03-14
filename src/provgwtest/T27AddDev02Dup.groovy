package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.DeviceIdentifier
import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import com.hp.snap.lguplus.spr.wsclient.LGUPSubscriber
import org.junit.BeforeClass;
import org.junit.Test;
import provgw.Dev
import provgw.DummyTable
import provgw.DummyWS
import provgw.Event
import provgw.SPRDevice
import provgw.SPRDeviceIdentifier
import provgw.SPRSubscriber

class T27AddDev02Dup {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        def dt = new DummyTable()
        dt.clear(TestConstants.childEntrNo)
        dt.clear(TestConstants.fatherEntrNo)
        dt.clear(TestConstants.motherEntrNo)
        def dws = new DummyWS()
        try {
            dws.clear(TestConstants.childEntrNo)
            dws.clear(TestConstants.fatherEntrNo)
            dws.clear(TestConstants.motherEntrNo) 
        } catch (com.hp.snap.lguplus.spr.wsclient.SPRWSException_Exception e) {
            //e.println()
        }
    }

    @Test
    public void test() {
        def dev = new Dev()
        dev.add(TestConstants.childEntrNo, TestConstants.childMsisdn, TestConstants.childImsi)
        dev.query(TestConstants.childEntrNo)
        sleep(TestConstants.sleepCount)
        //Add duplicate dev
        dev.add(TestConstants.childEntrNo, TestConstants.childMsisdn, TestConstants.childImsi)
        dev.query(TestConstants.childEntrNo)
        sleep(TestConstants.sleepCount)
        
        def sprs = new SPRSubscriber()
        LGUPSubscriber s = sprs.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.expSubStatus, s.getStatus())
        assertEquals(TestConstants.expSubBillDay, s.getBillingDay())
        assertEquals(TestConstants.expSubCountryId, s.getCountryId())
        assertEquals(TestConstants.expSubOpCode, s.getOperatorCode())

        def sprd = new SPRDevice()
        LGUPDevice d = sprd.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        assertTrue(TestUtils.isTimeCorrect('2013-09-03 17:08:04', d.getEffectiveDate()))
        assertTrue(TestUtils.isTimeCorrect('2013-09-03 17:08:04', d.getStartTimestamp()))
        assertTrue(TestUtils.isTimeCorrect('2013-10-01 00:00:00', d.getExpirationDate()))
        assertTrue(TestUtils.isTimeCorrect(new Date(), d.getLastSyncedTime()))
        
        def sprdi = new SPRDeviceIdentifier()
        DeviceIdentifier di0 = sprdi.get(TestConstants.childMsisdn, 0)
        assertEquals(0, di0.getIdentifierType())
        assertEquals(TestConstants.childMsisdn, di0.getIdentifier())
        DeviceIdentifier di1 = sprdi.get(TestConstants.childImsi, 1)
        assertEquals(1, di1.getIdentifierType())
        assertEquals(TestConstants.childImsi, di1.getIdentifier())
        List<DeviceIdentifier> dis = sprdi.get(TestConstants.childEntrNo)
        assertEquals(2, dis.size())
        
        def event = new Event()
        assertEquals('Failed', event.getStatus(TestConstants.childEntrNo, 'ADDDEV'))
    }

}
