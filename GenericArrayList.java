/*
Chao Lin
linc0@sewanee.edu
Project 2
CS 257
*/

public class GenericArrayList<T> implements Cloneable {

    private static final int INIT_CAPACITY = 10;
    private static final int NOT_FOUND = -1;
    
    private int count;
    private T[] theItems;

    /**
     * StringArrayList Construct an empty ArrayList.
     */
    public GenericArrayList() {
        clear();
    }

    /**
     *  clear - change the size of this collection to zero
     *  @postcondition size is zero and theItems is reset to minimum capacity, all nulls 
     */
    public void clear( )
    {
        count = 0;
        theItems = (T[]) new Object[ INIT_CAPACITY ];
    }
    
    /**
     * size - Returns the number of items in this collection.
     * @postcondition the number of items in this collection.
     */
    public int size() {
        return count;
    }
    
    /**
     * get - Returns the item at position idx.
     * @param idx the index to search in.
     * @precondition 0 <= idx < count
     * @postcondition returns the item at the specified position
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public T get(int idx) {
        if (idx < 0 || idx >= count)
           throw new ArrayIndexOutOfBoundsException("Index " + idx + "; size " + size());
        return theItems[idx]; 
    }
        
    /**
     * set - Changes the item at position idx.
     * @param idx the index to change.
     * @param newVal the new value.
     * @precondition 0 <= idx < count
     * @postcondition theItems[idx] <= newVal, returns the old value
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public T set(int idx, T newVal) {
        if (idx < 0 || idx >= size())
           throw new ArrayIndexOutOfBoundsException("Index " + idx + "; size " + size());
        T old = theItems[idx];   
        theItems[idx] = newVal;
        
        return old;    
    }
    
    /** 
     *  ensureCapacity - checks if room to add new item, "grows" the array if necessary
     *  @precondition
     *  @postcondition array has enough room to add new item
     */
    private void ensureCapacity() {
        if (theItems.length == count) {
            T[] temp = (T[])new Object[theItems.length + (theItems.length / 2) + 1];  // the +1 is a hedge against length of 0;
            //System.out.printf("DBG: EnsureCapacity: %d\n", theItems.length + (theItems.length / 2) + 1);
            System.arraycopy(theItems, 0, temp, 0, count);
            theItems = temp;
            }
        }

    /**
     * add - Adds an item to this collection, at the end.
     * @param x any object.
     * @postcondition x is added at end of ArrayList; returns true (as per java.util.ArrayList)
     */
    public boolean add(T x) {
        ensureCapacity();
        theItems[count]=x;
        count += 1; 
        return true;            
    }
    
    /**
     * Removes an item from this collection.
     * @param idx the index of the object.
     * @precondition 0 <= idx < count
     * @postcondition the item is removed from the collection
     * @throws ArrayIndexOutOfBoundsException if index is out of range
     */
    public T remove(int idx) {
        if (idx < 0 || idx >= size())
           throw new ArrayIndexOutOfBoundsException("Index " + idx + "; size " + size());

        T removedItem = theItems[idx]; 
        for(int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        count--;    
        
        return removedItem;
    }

    /**
     * Construct a shallow copy of the collection.  The contents array theItems
     * is copied, but individual elements are shared between arraylists.
     *
     * @precondition 
     * @postcondition returns a copy of the vector, using same objects
     */
    public GenericArrayList<T> clone() {
        GenericArrayList<T> copy = null;
        try {
            copy = (GenericArrayList<T>) super.clone();
        } catch (java.lang.CloneNotSupportedException e) { 
            throw new RuntimeException("StringArrayList cannot be cloned");
        }
        copy.theItems = theItems.clone();

        return copy;
    }

    /**
    * check if the array contains the item that is being searched
    * @param item is the item we are looking for
    * @precondition theItems!= null;
    * @return the index where the item is located in the array, -1 if item not found
    **/
    public int contains(T item){
        for(int i=0; i<size(); i++) {
            if(theItems[i].equals(item)) {
                return i;
            } 
        }
        return -1;
    }
}
