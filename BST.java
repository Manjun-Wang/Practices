public class Animal implements Comparable<Animal>{
    private int id;
    private String name;
    public Animal(int id, String name){
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int compareTo(Animal a){
        return this.id - a.id;
    }

    public String toString(){
        return "Animal: " + id +" - "+ "Name: " + name;
    }
}

public class BST {
    public BSTnode root;

    public BST(){};

    public BST (BSTnode root){
        this.root = null;
    }

    public boolean search(Animal a){
        BSTnode current = root;
        while(current != null){
            if(current.getElement().getId() < a.getId()){
                current = current.getRight();
            }
            else if(current.getElement().getId() > a.getId()){
                current = current.getLeft();
            }
            else{
                return true;                                  // return和break作用???????
            }
        }
        return false;                                         //为什么不写在上一层
    }

    public boolean insert(Animal a){
        BSTnode current = root;
        BSTnode parrent = null;
        if(current == null){
            root = new BSTnode(a);
        }
        else {
            while (current != null) {
                if (current.getElement().getId() < a.getId()) {
                    parrent = current;
                    current = current.getRight();
                }
                else if (current.getElement().getId() > a.getId()) {
                    parrent = current;
                    current = current.getLeft();
                }
                else{
                    return false;
                }
            }
            if(parrent.getElement().getId() > a.getId()){
               parrent.setLeft(new BSTnode(a));
               System.out.println(parrent);
            }
            else{
               parrent.setRight(new BSTnode(a));
               System.out.println(parrent);
            }
        }
       return true;
    }

    public boolean delete(Animal a){
        BSTnode current = root;
        BSTnode parrent = null;
        while(current != null){
            if (current.getElement().getId() < a.getId()) {
                parrent = current;
                current = current.getRight();
            }
            else if (current.getElement().getId() > a.getId()) {
                parrent = current;
                current = current.getLeft();
            }
            else{
                break;
            }
        }
        if(current.getLeft() == null){
            return false;
        }
        if(current.getLeft() == null){
            if(parrent == null){
                root = current.getRight();
            }
            else{
                if(a.getId() < parrent.getElement().getId()){
                    parrent.setLeft(current.getRight());
                }
                else{
                    parrent.setRight(current.getRight());        //旁边还有其他node???
                }
            }
        }
        else{
            BSTnode parentOfRightMost = current;
            BSTnode rightMost = current.getLeft();
            while(rightMost.getRight() != null){
                parentOfRightMost = rightMost;
                rightMost = rightMost.getRight();
            }
            current.setElement(rightMost.getElement());
            if(parentOfRightMost.getRight() == rightMost){
                parentOfRightMost.setRight(rightMost.getLeft());
            }
            else{
                parentOfRightMost.setLeft(rightMost.getLeft());
            }
        }
        return true;
    }

    public void postorder(BSTnode root){                     //图？
        System.out.println(root);

        if(root == null){
            return;
        } else {
            System.out.println("!" + root.getElement() + "," + root.getLeft() + "," + root.getRight());
        }


        postorder(root.getLeft());
        postorder(root.getRight());
        System.out.print(root.getElement() + " ");
    }

}

public class BSTnode {
    private BSTnode left;
    private BSTnode right;
    private Animal element;

    public BSTnode(Animal element){
        this.left = null;
        this.right = null;
        this.element = element;
    }

    public BSTnode getLeft() {
        return left;
    }

    public void setLeft(BSTnode left) {
        this.left = left;
    }

    public BSTnode getRight() {
        return right;
    }

    public void setRight(BSTnode right) {
        this.right = right;
    }

    public Animal getElement() {
        return element;
    }

    public void setElement(Animal element) {
        this.element = element;
    }

    public String toString(){
        return "Animal: " + element;
    }


}

public class BSTTest {
    public static void main(String[] args){
        Animal kitten = new Animal(1,"kitten");
        Animal doggy = new Animal(2,"doggy");
        Animal piggy = new Animal(3,"piggy");
        Animal bird = new Animal(4,"bird");
        Animal aligator = new Animal(5,"aligator");
        BSTnode Kitten = new BSTnode(kitten);
        BSTnode Doggy = new BSTnode(doggy);
        BSTnode Piggy = new BSTnode(piggy);
        BSTnode Bird = new BSTnode(bird);
        BSTnode Aligator = new BSTnode(aligator);
        BST tree = new BST(Kitten);
//        System.out.println(tree.insert(kitten));
        System.out.println(tree.insert(doggy));
        System.out.println(tree.insert(piggy));
        System.out.println(tree.insert(bird));
        System.out.println(tree.search(aligator));
        System.out.println(tree.insert(aligator));
        System.out.println(tree.search(aligator));
        tree.postorder(Kitten);   //????应该填什么呢？？？？
    }
}
