public class DynamicStringArray {
    private static final int INITIAL_CAPACITY = 10;
    private String[] data;
    private int size;

    public DynamicStringArray(){
        this.data = new String[INITIAL_CAPACITY];
        this.size = 0;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if (size==0){
            return true;
        }else{
            return false;
        }
    }

    public void add(String value){
        if(size<data.length){
            data[size]=value;
            size++;
        }else{
            String[] newArr = new String[data.length*2];
            System.arraycopy(data,0,newArr,0,data.length);
            data = newArr;
            data[size]=value;
            size++;
        }
    }

    public void add(int index, String value){
        if(index>=0 && index<=size){
            if (size < data.length){
                for (int i = size-1; i >=index; i--) {
                    data[i+1]=data[i];
                }
                data[index]=value;
                size++;
            }else{
                String[] newArr = new String[data.length*2];
                System.arraycopy(data,0,newArr,0,data.length);
                data = newArr;
                for (int i = size-1; i >=index; i--) {
                    data[i+1]=data[i];
                }
                data[index]=value;
                size++;
            }
        }else{
              throw new  IndexOutOfBoundsException("Недопустимый индекс: " + index);
        }
    }
    public String get(int index){
        if(index>=0 && index<=size-1){
            return data[index];
        }else{
            throw new  IndexOutOfBoundsException("Недопустимый индекс: " + index);
        }
    }
    public String set(int index, String value){
        if(index>=0 && index<=size-1){
            String oldValue = data[index];
            data[index]=value;
            return oldValue;
        }else{
            throw new  IndexOutOfBoundsException("Недопустимый индекс: " + index);
        }
    }
    public String remove(int index){
        if(index>=0 && index<=size-1){
            String oldValue = data[index];
            for (int i = index+1; i <=size-1; i++) {
                data[i-1]=data[i];
            }
            data[size-1]=null;
            size--;
            return oldValue;
        }else{
            throw new  IndexOutOfBoundsException("Недопустимый индекс: " + index);
        }
    }
    public boolean remove(String value){
        if (value == null) {
            throw new IllegalArgumentException("Null запрещён как значение!");
        }
        for (int i = 0; i <= size-1; i++) {
            if (value.equals(data[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }
    public void clear(){
        for (int i = 0; i <=size-1; i++) {
            data[i]=null;
        }
        size=0;
    }
    public int indexOf(String value){
        if (value == null) {
            throw new IllegalArgumentException("Null запрещён как значение!");
        }
        for (int i = 0; i <= size-1; i++) {
            if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }
}
