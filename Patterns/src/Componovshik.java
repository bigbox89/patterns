import java.util.ArrayList;
import java.util.Iterator;

public class Componovshik
{
    //Реализация по умолчанию для всех методов
    public static abstract class MenuComponent {
    //Одни методы имеют смысл только для MenuItem, другие для Menu, реализация по умолчанию инициализирует UnsupportedOperationException
        public void add(MenuComponent menuComponent)
        { throw new UnsupportedOperationException();}
        public void remove(MenuComponent menuComponent)
        { throw new UnsupportedOperationException();}
        public MenuComponent getChild(int i)
        { throw new UnsupportedOperationException();}
        public String getName()
        { throw new UnsupportedOperationException();}
        public String getDescription()
        { throw new UnsupportedOperationException();}
        public double getPrice()
        { throw new UnsupportedOperationException();}
        public boolean isVegeterian()
        { throw new UnsupportedOperationException();}
        public void print()
        { throw new UnsupportedOperationException();}
    }

    //реализация MenuItem (это класс листового узла на диаграмме классов паттерна Компоновзик и он реализует поведение элементов комбинации
    public static class MenuItem extends MenuComponent {  //класс расширяет интерейс MenuComponent
        String name;
        String description;
        boolean vegetarian;
        double price;

        public MenuItem(String name, String description, boolean vegeterian, double price) {
            this.name = name;
            this.description = description;
            this.vegetarian = vegeterian;
            this.price = price;
        }

        public String getName()
        {
            return name;
        }

        @Override
        public String getDescription() {
            return description;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }

        @Override
        public double getPrice() {
            return price;
        }

       public void print() {
           System.out.print(" "+getName());
           if (isVegetarian()) {
               System.out.print("(v)");
           }
           System.out.println(", "+getPrice());
           System.out.println("      -- "+getDescription());
       }
    }

    //класс комбинированного узла. Класс комбинации может содержать элементы MenuItem или другие Menu. getPrice isVegetarian не имеют смысла
    public static class Menu extends MenuComponent {
        ArrayList menuComponents = new ArrayList();
        String name;
        String description;

        public Menu(String name, String description)
        {
            this.name = name;
            this.description = description;
        }

        public void add(MenuComponent menuComponent)
        {
            menuComponents.add(menuComponent);
        }

        public void remove(MenuComponent menuComponent)
        {
            menuComponents.remove(menuComponent);
        }

        public MenuComponent getChild(int i)
        {
            return (MenuComponent) menuComponents.get(i);
        }

        public String getName() {return name;}
        public String getDescription() {return description;}

        public void print()
        {
            System.out.print("\n"+getName());
            System.out.println(", "+getDescription());
            System.out.println("----------------");

            //Итертаор для перебора всех компонентов объекта Menu.... Это Menu или MenuItem.
            Iterator iterator = menuComponents.iterator();
            while (iterator.hasNext())
            {
                MenuComponent menuComponent = (MenuComponent) iterator.next();
                menuComponent.print();
            }
        }
    }

    //создаем класс официанта
    public static class Waitress {
        MenuComponent allMenus;

        public Waitress(MenuComponent allMenus)
        {
            this.allMenus = allMenus;
        }

        public void printMenu() {
            allMenus.print();
        }
    }

}
