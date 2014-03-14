package study

class FooGroovy implements IFoo {

    @Override
    public Object run(Object foo) {
        // TODO Auto-generated method stub
        println 'Hello from FooGroovy';
        
        Foo2 f2 = new Foo2();
        def str = f2.run(2);
        println str;
        
        return foo*10;
    }

    static main(args) {
        FooGroovy f = new FooGroovy();
        f.run(3);
    }

}
