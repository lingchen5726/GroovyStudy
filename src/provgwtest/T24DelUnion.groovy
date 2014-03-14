package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPSubscription
import org.junit.Test;
import provgw.Event
import provgw.SPRSubscription
import provgw.Union

class T24DelUnion {

    //@Test pending for IC4 patch
    public void test() {
        def union = new Union()
        union.delete(TestConstants.childEntrNo)
        sleep(TestConstants.sleepCount)
        
        def sprsp = new SPRSubscription()
        List<LGUPSubscription> spsChild = sprsp.get(TestConstants.childEntrNo)
        LGUPSubscription spChild = spsChild.get(0)
        //List<LGUPSubscription> spsFather = sprsp.get('500089381788')
        //LGUPSubscription spFather = spsFather.get(0)

        assertEquals(0, spChild.getRelatedDeviceId())
        assertEquals(0, spChild.getRelatedSubscriptionId())

        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'DELUNION'))
    }

}
