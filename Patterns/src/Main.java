public class Main {
    public static void main(String[] args) {

        //тестовый код для провперки адаптера
        Adapter.MallardDuck duck = new Adapter.MallardDuck();
        Adapter.WildTUrkey turkey = new Adapter.WildTUrkey();
        Adapter.Duck turkeyAdapter = new Adapter.TurkeyAdapter(turkey);
        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        Adapter.testDuck(duck);

        System.out.println("\nThe TurkeyAdapter says...");
        Adapter.testDuck(turkeyAdapter);



    }
}
