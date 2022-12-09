package cinema;
import java.util.Scanner;
import java.util.Arrays;

public class Cinema {

    static void showSeats (int seats, char[][] seating) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seats; i++)
            System.out.print(i + " ");

        System.out.println();

        for (int i = 0; i < seating.length; i++) {

            int currentRow = i + 1;
            System.out.print(currentRow + " ");
            for (int j = 0; j < seating[i].length; j++) {
                System.out.print(seating[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int buyTicket (int rows, int seats, char[][] seating) {
        Scanner scan = new Scanner(System.in);

        boolean available = true;
        int chooseRow = 0;
        int chooseSeat;
        while (available) {
            System.out.println();
            System.out.println("Enter a row number:");
            chooseRow = scan.nextInt();
            System.out.println("Enter a seat number in that row:");
            chooseSeat = scan.nextInt();
            System.out.println();

            if (chooseRow < 0 || chooseRow > seating.length ||
                    chooseSeat < 0 || chooseSeat > seating[0].length){
                System.out.println("Wrong input!");
            }
            else if(seating[chooseRow-1][chooseSeat-1] == 'S'){
                seating[chooseRow-1][chooseSeat-1] = 'B';
                available = false;
            }
            else {
                System.out.println("That ticket has already been purchased!");
            }
        }

        int ticketPrice;

        if (rows * seats <= 60) {
            ticketPrice = 10;
        } else if (chooseRow <= rows / 2) {
            ticketPrice = 10;
        } else {
            ticketPrice = 8;
        }

        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println();

        return ticketPrice;
    }

    static void statistics(int ticketsSold, int currentIncome, int rows, int seats){


        System.out.println("Number of purchased tickets: " + ticketsSold);
        double totalSeats = (double)rows * (double)seats;
        double per = ticketsSold / totalSeats * 100;
        System.out.println("Percentage: " + String.format("%.2f", per) + "%");
        System.out.println("Current income: $" + currentIncome);

        int totalIncome;
        if(rows*seats <= 60){
            totalIncome = rows*seats*10;
        }
        else {
            totalIncome = (rows/2)*seats*10;
            totalIncome += ((rows)-(rows/2))*seats*8;
        }
        System.out.println("Total income: $" + totalIncome);
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scan.nextInt();
        System.out.println();

        char[][] seating = new char[rows][seats];
        for (char[] place: seating)
            Arrays.fill(place, 'S');

        int ticketsSold = 0;
        int currentIncome = 0;
        int selection = 1;

        while (selection != 0) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            selection = scan.nextInt();
            System.out.println();

            switch(selection) {
                case 1:
                    showSeats(seats, seating);
                    break;

                case 2:
                    currentIncome += buyTicket(rows, seats, seating);
                    ticketsSold++;
                    break;

                case 3:
                    statistics(ticketsSold, currentIncome, rows, seats);

                case 0:
                    break;
            }
        }
    }
}