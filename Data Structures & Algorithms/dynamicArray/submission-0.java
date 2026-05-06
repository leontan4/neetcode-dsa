class DynamicArray {
    int capacity;
    int pos;
    int[] arr;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.pos = 0;
        this.arr = new int[this.capacity];
    }

    public int get(int i) {
        // get the element at position i
        return arr[i];
    }

    public void set(int i, int n) {
        if(i < pos){
            arr[i] = n; 
            return;
        }
        return;
    }

    public void pushback(int n) {
        if(pos == capacity){
            this.resize();
        }
        arr[pos] = n;
        pos++;
    }

    public int popback() {
        if(pos > 0){
            pos--;
            
        }
        return arr[pos];
    }

    private void resize() {
        capacity = capacity * 2;
        int[] newArr = new int[capacity];

        for(int i=0; i<pos; i++){
            newArr[i] = arr[i];
        }
        
        arr = newArr;
    }

    public int getSize() {
        return pos;
    }

    public int getCapacity() {
        return capacity;
    }
}
