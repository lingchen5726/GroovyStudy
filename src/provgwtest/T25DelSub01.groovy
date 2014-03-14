package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPSubscription
import org.junit.Test;
import provgw.Event
import provgw.SPRSubscription
import provgw.Sub

class T25DelSub01 {

    @Test
    public void test() {
        def sub = new Sub()
        sub.delete(TestConstants.childEntrNo)
        sleep(TestConstants.sleepCount)
        sub.delete(TestConstants.fatherEntrNo)
        sleep(TestConstants.sleepCount)
        sub.delete(TestConstants.motherEntrNo)
        sleep(TestConstants.sleepCount)

        def sprsp = new SPRSubscription()
        List<LGUPSubscription> spsChild = sprsp.get(TestConstants.childEntrNo)
        assertEquals(null, spsChild)
        List<LGUPSubscription> spsFather = sprsp.get(TestConstants.fatherEntrNo)
        assertEquals(null, spsFather)
        List<LGUPSubscription> spsMother = sprsp.get(TestConstants.motherEntrNo)
        assertEquals(null, spsMother)

        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'DELSUB'))
        assertEquals('Done', event.getStatus(TestConstants.fatherEntrNo, 'DELSUB'))
        assertEquals('Done', event.getStatus(TestConstants.motherEntrNo, 'DELSUB'))
    }

}
