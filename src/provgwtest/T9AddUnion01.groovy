package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPSubscription
import org.junit.Test;
import provgw.Dev
import provgw.Event
import provgw.SPRSubscription
import provgw.Sub
import provgw.Union

class T9AddUnion01 {

    //pending for IC4 patch
    @Test 
    public void test() {
        def dev = new Dev()
        dev.add(TestConstants.fatherEntrNo, TestConstants.fatherMsisdn, TestConstants.fatherImsi)
        sleep(TestConstants.sleepCount)
        def sub = new Sub()
        sub.add(TestConstants.fatherEntrNo, TestConstants.fatherSpId);
        sleep(TestConstants.sleepCount)
        
        /*def union = new Union()
        union.add(TestConstants.childEntrNo, TestConstants.fatherEntrNo, 'Y');
        sleep(TestConstants.sleepCount)
        
        def sprsp = new SPRSubscription()
        List<LGUPSubscription> spsChild = sprsp.get(TestConstants.childEntrNo)
        LGUPSubscription spChild = spsChild.get(0)
        List<LGUPSubscription> spsFather = sprsp.get(TestConstants.fatherEntrNo)
        LGUPSubscription spFather = spsFather.get(0)

        assertEquals(TestConstants.fatherEntrNo, spChild.getRelatedDeviceId())
        assertEquals(spFather.getId(), spChild.getRelatedSubscriptionId())
        
        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'ADDUNION'))
        */
    }

}

