package p1;
 
import java.util.Arrays;
 
public class List1<A> 
{
    //Size of list
    private int size = 0;
     
    //Default capacity of list is 10
    private static final int buffer = 10;
     
    //This array will store all elements added to list
    private Object elements[];
 
    //Default constructor
    public List1() {
        elements = new Object[buffer];
    }
 
    //Add method
    public void add(A e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }
     
    //Get method
  
    public A get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (A) elements[i];
    }
     
    //Remove method
    public A remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = elements[i];
        int numElts = elements.length - ( i + 1 ) ;
        System.arraycopy( elements, i + 1, elements, i, numElts ) ;
        size--;
        return (A) item;
    }
     
    //Get Size of list
    public int size() {
        return size;
    }
     
    //Print method
    @Override
    public String toString() 
    {
         StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < size ;i++) {
             sb.append(elements[i].toString());
             if(i<size-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         return sb.toString();
    }
     
    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}


