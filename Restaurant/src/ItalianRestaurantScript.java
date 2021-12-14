public class ItalianRestaurantScript {

    public static class ItaloRestaurant {
        String type;
        String menu_1;
        String menu_2;
        String menu_3;
        String menu_4;
        String menu_5;
        String menu_6;
        public ItaloRestaurant(String food_type) {
            //constuctor method is defined without "void"
            type = food_type;
            menu_1 =  type +" degli Pomodori";
            menu_2 = type +" del formagio";
            menu_3 = type +" speciale tutti";
            menu_4 = "Tiramisu";
            menu_5 = "Agua Naturale";
            menu_6 = "Vino Rosso";
        }
        public void show_menu() {
            System.out.println("Menu:");
            String[] entire_menu = {menu_1,menu_2,menu_3,menu_4,
            menu_5,menu_6};
            for (String element :entire_menu) {
                System.out.println(element+ " 5.00 Eur");
            }
        }
    }
    public static void main(String[] args) {
        ItaloRestaurant Pizzeria = new ItaloRestaurant("Pasta");
        Pizzeria.show_menu();
    }
}