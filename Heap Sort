public class Employee {
    public String id;
    public String name;
    public double salary;
    public String department;
    public String position;
    public int years_of_service;

    public Employee(String id, String name, double salary, String department, String position, int years_of_service){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.years_of_service = years_of_service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getYears_of_service() {
        return years_of_service;
    }

    public void setYears_of_service(int years_of_service) {
        this.years_of_service = years_of_service;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public int compareTo(Employee e){
        return this.years_of_service - e.years_of_service;
    }

}

import java.util.ArrayList;
public class Heap<E extends Comparable<E>> {
    private ArrayList<E> list = new ArrayList<>();

    public Heap(){};

    public Heap(E[] objects){
        for(int i = 0; i < objects.length; i++){
            add(objects[i]);
        }
    }

    public void add(E newObject){
        list.add(newObject);
        int currentIndex = list.size() - 1;

        while(currentIndex > 0){
            int parentIndex = (currentIndex - 1)/2;

            if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            }
            else
                break;
            currentIndex = parentIndex;
        }
    }

    public E remove(){
        if(list.size() == 0) {
            return null;
        }
        E removeObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while(currentIndex < list.size()){
            int leftChildIndex = 2 * currentIndex +1;
            int rightChildIndex = 2 * currentIndex +2;

            if(leftChildIndex >= list.size()){
                break;
            }
            int maxIndex = leftChildIndex;
            if(rightChildIndex < list.size()){
                if(list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0){
                    maxIndex = rightChildIndex;
                }
            }

            if(list.get(currentIndex).compareTo(list.get(maxIndex)) < 0){
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            }
            else
                break;
        }
        return  removeObject;
    }

    public int getSize(){
        return list.size();
    }

    public void print(){
        for(int i = 0; i<=getSize()-1; i++){
            System.out.print("Index: "+i+" Data:"+list.get(i));
            System.out.println();
        }
    }
}

public class HeapSort {
    public static void main(String[] args){
//        File unsorted = new File("C:\\Users\\MJ970828\\Desktop\\Employee.txt");
//        Employee[] a = new Employee[5];
//        for(int i=0; i<=a.length - 1; i++){
//            a[i] = new Employee();
//        }
        Integer[] a = {23, 42, 17, 93, 88, 12, 57, 90};
        Integer[] b = {48, 59, 11, 89, 12, 91, 64, 34};
        heapSort(a);
        heapSort(b);
        for(int i = 0; i< a.length; i++){
            System.out.print( a[i] + " ");
        }
        System.out.println();
        for(int j = 0; j< b.length; j++){
            System.out.print( b[j] + " ");
        }
    }

    public static void heapSort(Integer[] a){
        Heap<Integer> heap = new Heap<>();
        for(int i = 0; i < a.length; i++){
            heap.add(a[i]);
        }
        for(int i = a.length - 1; i >= 0; i--){
            a[i] = heap.remove();
        }
    }
}

public class Pairing {
    public static void main(String[] args) {
        Integer[] a = {23, 42, 17, 93, 88, 12, 57, 90};
        Integer[] b = {48, 59, 11, 89, 12, 91, 64, 34};
        heapSort(a);
        heapSort(b);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int j = 0; j < b.length; j++) {
            System.out.print(b[j] + " ");
        }
    }
    public static void heapSort(Integer[] a){
        Heap<Integer> heap = new Heap<>();
        for(int i = 0; i < a.length; i++){
            heap.add(a[i]);
        }
        for(int i = a.length - 1; i >= 0; i--){
            a[i] = heap.remove();
        }
    }
}
