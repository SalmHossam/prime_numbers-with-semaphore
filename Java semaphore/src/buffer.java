
import java.util.LinkedList;
import java.util.Queue;
public class buffer {
	 Queue<String> str_queue = new LinkedList<>();
        private int size_q;
        Semaphore elements = new Semaphore(0);
        Semaphore spaces = new Semaphore(size_q);
        int element = 0;
        Boolean check = false;
        String item = " ";
        int pro_con=0;
        public buffer(int max_size)
        {
        	size_q=max_size;
            spaces = new Semaphore(size_q);
        	
        }
        
        public void check(Boolean c)
        {
           this.check=c;
        }
        public void producer(Object item)
        {
         
              while(str_queue.size()==size_q)
              {
                  try {
                      
                     spaces.P();//wait();
                } catch (InterruptedException e)
                {
                  e.printStackTrace();
                }
              }
              
              
              this.str_queue.add((String) item);
              element++;
              elements.V();//notify();
          
          
        }
        
        public  Object consumer()
        {
        	Object iteam;
             
             while(str_queue.isEmpty()) {
                 try {
                   elements.P();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             
             iteam = str_queue.remove();
             element--;
             spaces.V();
             return iteam;
}
        
        

    void large(int large_prime) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	public void add(String string) {
		// TODO Auto-generated method stub
		
	}
        

   

}
