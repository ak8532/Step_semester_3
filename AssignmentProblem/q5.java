public class q5 {

    static class Cart {
        private double[] prices;
        private final String id;

        Cart(String id, int size) {
            this.id = id;
            prices = new double[size];
        }

        void addItem(double price) {
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] == 0) {
                    prices[i] = price;
                    return;
                }
            }
        }

        double getTotal() {
            double total = 0;

            for (int i = 0; i < prices.length; i++)
                total += prices[i];

            return total;
        }

        int getItemCount() {
            int count = 0;

            for (int i = 0; i < prices.length; i++) {
                if (prices[i] != 0)
                    count++;
            }

            return count;
        }
    }

    public static void main(String[] args) {

        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Count: " + cart.getItemCount());
    }
}