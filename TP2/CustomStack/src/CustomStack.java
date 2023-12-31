
public class CustomStack {
    private int capacity;
    private int[] stackArray;
    private int top;
    private int size;

    public CustomStack(int ChosenCapacity) {
        capacity=ChosenCapacity;
        stackArray=new int[ChosenCapacity];
        top=-1;
        this.size=0;
    }
    public void AddElement(int element) {
        if (StackIsFull()){
            System.out.println("Stack is full, can't add more elements");
        } else {
            int[] newStack= new int [capacity];
            newStack[0]=element;
            top=element;
            for (int i=0;i<this.size;i++) {
                newStack[i+1]=stackArray[i];
            }
            stackArray=newStack;
            this.size++;
        }
    }
    public void RemoveElement() {
        if (StackIsEmpty()) {
            System.out.println("Stack is empty, can't delete an element");
        } else if (this.size==1) {
            top=-1;
            this.size=0;
            stackArray[0]=-1;
        } else {
            top=stackArray[1];
            int[] newStack= new int [capacity];
            for (int i=0;i<this.size-1;i++) {
                newStack[i]=stackArray[i+1];
            }
            stackArray=newStack;
            this.size--;
        }
    }
    public void DisplayStack() {
        for (int i=0;i<this.size;i++) {
            System.out.println("element "+i+": "+ stackArray[i]);
        }
    }
    public boolean StackIsEmpty() {
        return top == - 1;    }
    public boolean StackIsFull() {
        return this.size == capacity;    }
    public static void main(String[] args) throws Exception {
        CustomStack A = new CustomStack(3);
        A.AddElement(2);
        A.AddElement(5);
        A.AddElement(8);
        A.AddElement(4);
        System.out.println("Full Stack(me)");
        A.DisplayStack();
        A.RemoveElement();
        System.out.println("Post removal");
        A.DisplayStack();
    }
}

