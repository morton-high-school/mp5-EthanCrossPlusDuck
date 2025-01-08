public class BetterArray{
    public int[] array;
    private int numElements = 0;

    public BetterArray(){
        array = new int[0];
    }

    public BetterArray(int len){
        array = new int[len];
    }

    public int size(){
        return numElements;
    }

    public boolean add(int item){
        if(numElements==array.length){
            handleNewLength();
        }
        array[numElements] = item;
        numElements++;
        return true;
    }

    public void add(int index, int item){
        if(numElements==array.length){
            handleNewLength();
        }
        int curr = item;
        numElements++;
        for(int i=index;i<numElements;i++){
            int temp = array[i];
            array[i] = curr;
            curr = temp;
        }

    }

    public int get(int index){
        return array[index];
    }

    public int set(int index, int item){
        int temp = array[index];
        array[index] = item;
        return temp;
    }

    public int remove(int index){
        int temp = array[index];
        for(int i=index;i<numElements;i++){
            array[i] = array[i+1];
        }
        numElements--;
        return temp;
    }

    private void handleNewLength(){
        if(array.length == 0){
            array = new int[1];
        }else{
            int[] newarray = new int[array.length * 2];
            for(int i=0;i<array.length;i++){
                newarray[i] = array[i];
            }
            array = newarray;
        }
    }
}