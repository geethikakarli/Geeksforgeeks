import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n%2==0) {
            System.out.print("Friend");
        } else {
            System.out.print("You");
        }

        // code here
        

        sc.close();
    }
}