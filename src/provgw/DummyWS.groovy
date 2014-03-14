package provgw

class DummyWS extends SPRDBModel {

    public DummyWS(Object name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    public clear(entr_no) {
        ws.removeSubscriberWithAllInfos(entr_no)
    }
    
    @Override
    public Object get(Object args) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void set(Object args) {
        // TODO Auto-generated method stub
        
    }

    static main(args) {
        def dws = new DummyWS()
        dws.clear(this)
    }

}
