public interface LinkedListInterface {

	boolean isEmpty();
	// Returns true if the linkedlist is empty, else returns False
	
	int getSize();
	//Returns the size of the linkedlist. return type is an integer
	
	void insert(double price,
			double discount_rate, double expiration_period, double Coupon_ID, double Discounted_price);
    // Adds a new object to the linkedlist, an object that has parameters like price,
	//dicount rate, expiration_period, Coupon_ID, Discounted_price
	
	void delete(double pos);
	// Deletes a node at a given position
	
	void display();
  void lowtohigh_expiration();
	// Sorts and displays the entire data on the basis of ascending order of expiration period
}
