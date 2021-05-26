import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class LinkedList implements LinkedListInterface {
	protected coupon start;
	//linkedList l = new linkedList();
	double[] finalprice= new double[50];
	int k = 0, counnt =0;
	public int size;

	public LinkedList() {
		start = null;
		size = 0;
	}

	/* Function to check if list is empty */
	public boolean isEmpty() {
		return start == null;
	}

	/* Function to check size of list */
	public int getSize() {
		return size;
	}

	/* Function to insert an element */
	public void insert(double price,
			double discount_rate, double expiration_period, double Coupon_ID, double Discounted_price) {
		coupon nptr, ptr, tmp = null;
		nptr = new coupon(price, discount_rate, expiration_period, Coupon_ID, Discounted_price, null);
		boolean ins = false;
		if (start == null)
			start = nptr;
		else if (Coupon_ID <= start.getCoupon_ID()) {
			nptr.setLink(start);
			start = nptr;
		} 
		else {
			tmp = start;
			ptr = start.getLink();
			while (ptr != null) {
				if (Coupon_ID >= tmp.getCoupon_ID() && Coupon_ID <= ptr.getCoupon_ID()) {
					tmp.setLink(nptr);
					nptr.setLink(ptr);
					ins = true;
					break;
				} else {
					tmp = ptr;
					ptr = ptr.getLink();
				}
			}
			if (ins == false) {
				tmp.setLink(nptr);
			}
		}
		size++;
	}
  /* Function to delete an element at position */
	public void delete(double pos)
	{
		int ct=0;
		coupon ptr1=start;
		while (ptr1!= null)
		{
			    
				ct++;
				if(ptr1.getCoupon_ID()== pos)
				{
					break;
				}
				;
				
			    
				ptr1= ptr1.getLink();
		}

		if (ct == 1) 
		{
			start = start.getLink();
			size--;
			return;
		}
		if (ct == size)
		{
			coupon ptr = start;
			for (int i = 1; i < size - 1; i++)
				ptr = ptr.getLink();
			ptr.setLink(null);
			size--;
			return;
		}
		coupon ptr = start;
		ct = ct - 1;
		for (int i = 1; i < size - 1; i++)
		{
			if (i == ct)
			{
				coupon tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
		size--;
	}
  /* Function to display elements */
	public void display()
	{
		
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		coupon ptr = start;
		while (ptr.getLink() != null) {
			System.out.print(ptr.getCoupon_ID() + "\t" + ptr.getPrice() + "\t" + ptr.getDiscount_rate() + "\t"
					+ ptr.getExpiration_period() +"\t" + ptr.getDiscounted_price() + "\t"  +"\n");
			ptr = ptr.getLink();
		}

		System.out.print(ptr.getCoupon_ID() + "\t" + ptr.getPrice() + "\t" + ptr.getDiscount_rate() + "\t"
				+ ptr.getExpiration_period() +"\t" + ptr.getDiscounted_price() + "\t"  +"\n");
    /*sort coupons according to expiration period*/
    public void lowtohigh_expiration()
	{
		double arr[]= new double[30];
		int i=0;
		coupon ptr=new coupon();
		ptr.setLink(this.start);
		while (ptr!= null)
			{
				arr[i]= ptr.getExpiration_period();
				ptr= ptr.getLink();
				i++;
	
				
			}
		double temp;

			for (int z = 1; z<i; z++) {
	            for (int j = 1; j < (i-z); j++) {
	            
	                if (arr[j] > arr[j+1])
	                {
	                	temp = arr[j];
	                	arr[j] = arr[j+1];
	                	arr[j+1] = temp;
	                	
	                }
	            }
	            
	            
	          }
			System.out.println();
			
			coupon ptr1=new coupon();
			
			int j=1;
			System.out.println("Coupon details sorted in accordance to Expiration Period:");
			System.out.println();
			do
			{
			ptr1=start;
			while (ptr1!= null)
			{
				    
	
					if(arr[j]==ptr1.getExpiration_period())
					{
						System.out.println(ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
						break;
					}
					
					
				    
					ptr1= ptr1.getLink();
			}
			++j;
			}while(j<11);
			}
	}
}
