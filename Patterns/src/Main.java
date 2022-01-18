public class Main {
    public static void main(String[] args) {

        /*
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

        //Заказываем кофе и наблюдаем за гибкой архитектурой, построенной на основе паттерна Декоратор.
         */

        /*
        Decorator.Beverage beverage = new Decorator.Espresso(); //эспрессо без дополнений, выводим описание и стоимость
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Decorator.Beverage beverage2 = new Decorator.DarkRoast();
        beverage2 = new Decorator.Mocha(beverage2);  //завораичваем в объект Mocha
        beverage2 = new Decorator.Mocha(beverage2); //второй раз
        beverage2 = new Decorator.Whip(beverage2);  //заворачиваем в Whip
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Decorator.Beverage beverage3 = new Decorator.HouseBlend(); //домашняя смесь с соей, шоколадом и взитыми сливками
        beverage3 = new Decorator.Soy(beverage3);
        beverage3 = new Decorator.Mocha(beverage3);
        beverage3 = new Decorator.Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
        */
    }
}
