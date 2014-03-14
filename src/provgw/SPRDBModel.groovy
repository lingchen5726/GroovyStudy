package provgw
import com.hp.snap.lguplus.spr.wsclient.SPRExternalWebServicePortType

abstract class SPRDBModel {
    
    protected String name
    protected static SPRExternalWebServicePortType ws

    SPRDBModel (name) {
        this.name = name
        this.ws = ProvGWExtWS.getWS()
    }
    
    abstract get(args)
    abstract void set(args)

}
