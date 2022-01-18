public class Decorator    //делаем кофейню
{
    public static abstract class Beverage {  //абсрактный класс с двумя методами getDescription() и cost()
        String description = "Unknown Beverage";

        public String getDescription() {  // Метод getDescription реализован, cost() необходимо реализовать в субклассах
            return description;
        }

        public abstract double cost();
    }

    //реализуем абстрактный класс для дополнений
    public static abstract class CondimentDecorator extends Beverage {
        @Override
        public String getDescription() {
            return super.getDescription();
        }
    }

    //Переходим к реализации напитков
    public static class Espresso extends Beverage
    {
        public Espresso()   //описание задается в конструкторе класса, description наследуется от Beverage
        {
            description = "Espresso";
        }

        @Override
        public double cost() {
            return 1.99;
        }
    }

    public static class HouseBlend extends Beverage {
        public HouseBlend()
        {
            description = "House Blend Coffee";
        }

        @Override
        public double cost() {
            return .89;
        }
    }

    public static class DarkRoast extends Beverage {
        public DarkRoast()
        {
            description = "Dark Roast Coffee";
        }

        @Override
        public double cost() {
            return .99;
        }
    }

    public static class Decaf extends Beverage {
        public Decaf()
        {
            description = "Decaf Coffee";
        }

        @Override
        public double cost() {
            return 1.05;
        }
    }

    //Реализация конкретных декораторов
    public static class Mocha extends CondimentDecorator  //класс декоратора расширяет CondimentDecorator
    {
        Beverage beverage;    //переменная для хранения ссылки

        public Mocha(Beverage beverage)
        {
            this.beverage = beverage;  //способ присваивания переменной ссылки на объект. Бужем передавать сыылку при вызове констрктора
        }

        public String getDescription() {
            return beverage.getDescription() + ", Mocha";
        }

        @Override
        public double cost() {
            return .2 + beverage.cost();
        }
    }

    public static class Soy extends CondimentDecorator  //класс декоратора расширяет CondimentDecorator
    {
        Beverage beverage;    //переменная для хранения ссылки

        public Soy(Beverage beverage)
        {
            this.beverage = beverage;  //способ присваивания переменной ссылки на объект. Бужем передавать сыылку при вызове констрктора
        }

        public String getDescription() {
            return beverage.getDescription() + ", Soy";
        }

        @Override
        public double cost() {
            return .15 + beverage.cost();
        }
    }

    public static class Whip extends CondimentDecorator  //класс декоратора расширяет CondimentDecorator
    {
        Beverage beverage;    //переменная для хранения ссылки

        public Whip(Beverage beverage)
        {
            this.beverage = beverage;  //способ присваивания переменной ссылки на объект. Бужем передавать сыылку при вызове констрктора
        }

        public String getDescription() {
            return beverage.getDescription() + ", Whip";
        }

        @Override
        public double cost() {
            return .1 + beverage.cost();
        }
    }
}

