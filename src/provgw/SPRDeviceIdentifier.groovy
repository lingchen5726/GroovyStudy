package provgw
import com.hp.snap.lguplus.spr.wsclient.DeviceIdentifier
import com.hp.snap.lguplus.spr.wsclient.ArrayOfDeviceIdentifier
import provgwtest.TestConstants

class SPRDeviceIdentifier extends SPRDBModel {

    public SPRDeviceIdentifier(Object name) {
        super('SPRDeviceIdentifier');
    }

    @Override
    public Object get(ENTR_NO) {
        try {
            ArrayOfDeviceIdentifier dis = ws.getDeviceIdentifierByDeviceId(ENTR_NO, ENTR_NO) 
            if (null!=dis) {
                return dis.getDeviceIdentifier()
            } else {
                return null
            }
        } catch (com.hp.snap.lguplus.spr.wsclient.SPRWSException_Exception e) {
            return null
        }
    }

    @Override
    public Object get(identifier, identifierType) {
        DeviceIdentifier di = ws.getDeviceIdentifierByIdentifier(identifier, identifierType)
        return di
    }

    @Override
    public void set(Object args) {
        // TODO Auto-generated method stub
        
    }

    public static test1() {
        def sprdi = new SPRDeviceIdentifier()
        List<DeviceIdentifier> dis = sprdi.get('010089381739', '0')
        dis.each {
            println ('type is '+it.getIdentifierType()+', id is '+it.getIdentifier())
        }
        List<DeviceIdentifier> dis2 = sprdi.get('15994092533')
        dis2.each {
            println ('type is '+it.getIdentifierType()+', id is '+it.getIdentifier())
        }

    }
    
    public static test2() {
        def sprdi = new SPRDeviceIdentifier()
        DeviceIdentifier di0 = sprdi.get(TestConstants.childMsisdn, 0)
        println di0.getIdentifier()
        DeviceIdentifier di1 = sprdi.get(TestConstants.childImsi, 1)
        println di1.getIdentifier()
        List<DeviceIdentifier> dis = sprdi.get(TestConstants.childEntrNo)
        println dis.size()
    }
    
    static main(args) {
        test2()
    }

}
