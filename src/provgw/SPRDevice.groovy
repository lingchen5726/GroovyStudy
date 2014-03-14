package provgw
import com.hp.snap.lguplus.spr.wsclient.Device

class SPRDevice extends SPRDBModel {

    public SPRDevice(Object name) {
        super('SPRDevice');
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object get(ENTR_NO) {
        return ws.getDeviceById(ENTR_NO, ENTR_NO)
    }

    @Override
    public void set(Object args) {
        // TODO Auto-generated method stub
        
    }

    static main(args) {
        def sprdev = new SPRDevice()
        Device d = sprdev.get('15994092533')
        println d.getExternalId()
    }

}
