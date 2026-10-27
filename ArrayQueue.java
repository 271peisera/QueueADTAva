public class ArrayQueue<T> implements QueueInterface<T>{
    // returns the logical size of the queue
    private T[] queue;
    private int size;
    private int headInd;
    private int tailInd;

    public ArrayQueue(){
        this.queue = (T[]) new Object[4];
        size = 0;
        headInd = 0;
        tailInd = 0;
    }

    public int size(){
        return size;
    }   
    
    // tests if this queue is empty
    public boolean empty(){
        return(size == 0);
    }

    public boolean isFull(){
        return (size == queue.length);
    }
    
    // adds an item onto the rear of this queue
    public T add(T item){
        if(isFull()){
                doubleLength();
                size++;
                queue[size] = item;
                tailInd++;
            }
        else if (tailInd == size - 1){
            
                tailInd = 0;
                queue[tailInd] = item;
                size++;
            }
            else if(tailInd < headInd){
                queue[tailInd + 1] = item;
                tailInd++;
        }
        return item;
        

    }
        
    // looks at the object at the front of this queue
    // without removing it from the queue
    public T peek() throws QueueUnderflowException{
        if(empty()){
            throw new QueueUnderflowException("No elements in the queue");
        }
        else
        return queue[headInd];

    }
    
    // removes the object at the front of this queue 
    // and returns that object as the value of this function
    public T remove() throws QueueUnderflowException{
         if(empty()){
            throw new QueueUnderflowException("No elements in the queue");
        }
        else{
            if(size  <= queue.length/4){
                T current = (queue[headInd]);
                queue[headInd] = null;
                headInd++;
                return current;
            }
            
        }
            
    }
    
    // removes all of the elements from this stack
    public void clear(){

    }
    
    public void doubleLength(){
        int length = queue.length;
        T[] newQueue = (T[]) new Object[length * 2];
        if(tailInd > headInd){
            for(int i = 0; i < length; i++){
                newQueue[i] = queue[i];
        }
            queue = newQueue;
        }
        else{
           for(int i = headInd; i < queue.length; i++){
                newQueue[i - headInd] = queue[i];
           }
           for(int i = 0; i < headInd; i++){
                newQueue[i + headInd] = queue[i];
           }
           queue = newQueue;
        }
        headInd = 0;
        tailInd = size - 1;
        
    }

    public void halfLength(){
        int length = queue.length;
        T[] newQueue = (T[]) new Object[length / 2];
        for(int i = 0; i < length / 2; i++){
            newQueue[i] = queue[i];
        }
        queue = newQueue;
    }
}
