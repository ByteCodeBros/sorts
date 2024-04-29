package entities;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericArray<E extends Comparable<E>> {
    private final Object[] objectArray;   //object array
    public final int length;

    // class constructor
    public GenericArray(int len)    {
        //new object array
        objectArray = new Object[len];
        this.length = len;
    }
    // get new object array(obj_array[i])
    public E get(int j) {
        @SuppressWarnings("unchecked")
        final E e = (E)objectArray[j];
        return e;
    }

    public Object[] getObjectArray() {
        return objectArray;
    }

    // set e at new object array(obj_array[i])
    public void set(int j, E e) {
        objectArray[j] = e;
    }

    @Override
    public String toString() {
        return Arrays.toString(objectArray);
    }
}