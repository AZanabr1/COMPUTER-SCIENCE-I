import java.util.Scanner; 

public class MovieDriver {

	public static void main(String[] args) {
		 
		Scanner scan = new Scanner(System.in);
		Movie myMovie = new Movie();
		String choices; 
	
		do {
			System.out.println("Enter the name of a movie");
			String title = scan.nextLine();
			myMovie.setTitle(title);
					
			System.out.println("Enter the rating of the movie");
			String rating = scan.nextLine();
			myMovie.setRating(rating);
					
			System.out.println("Enter the number of tickets sold for this movie");
			int tickets = scan.nextInt();
			myMovie.setSoldTickets(tickets);
					
			System.out.println(myMovie.toString());
			scan.nextLine(); 
			
			System.out.println("Do you want to enter another? (y/n): ");
			choices = scan.nextLine(); 
		}while(choices.equalsIgnoreCase("y"));
		
		System.out.println("Goodbye");
		scan.close(); 
		
	}

}
