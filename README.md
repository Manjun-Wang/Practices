# Practices
some basic practices
public class Link<E> {
    private Link<E> pre;
    private Link<E> next;
    private E data;

    public Link(E data) {
        this.data = data;
        this.pre = null;
        this.next = null;
    }

    public Link<E> getPre() {
        return pre;
    }

    public void setPre(Link<E> pre) {
        this.pre = pre;
    }

    public Link<E> getNext() {
        return next;
    }

    public void setNext(Link<E> next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void displayList() {
        System.out.println("" + data + "");
    }
}

public class LinkList<E> {
    private Link<E> first;
    private Link<E> last;

    public LinkList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(E data) {
        Link<E> newNode = new Link<>(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first.setPre(newNode);
            first = newNode;
        }
    }

    public void insertLast(E data) {
        Link<E> newNode = new Link<>(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setPre(last);
            last.setNext(newNode);
            last = newNode;
        }
    }

    public void deleteFirst() {
        if (first.getNext() != null) {
            first = first.getNext();
            first.getNext().setPre(null);
        } else {
            first = first.getNext();
            last = null;
        }

    }

    public Link deleteLast() {
        Link current = last;
        if (first.getNext() != null) {
            last = last.getPre();
            last.getPre().setNext(null);
        } else {
            first = null;
            last = null;
        }
        return current;
    }

    public Link insertAfter(E key, E data) {
        Link<E> newNode = new Link<>(data);
        Link<E> current = first;
        while (current != key) {
            current = current.getNext();
            if (current == null) {
                return null;
            }
        }
        if (current == last) {
            newNode.setPre(current);
            last = newNode;
            current.setNext(newNode);
        } else {
            newNode.setNext(current.getNext());
            newNode.setPre(current);
            current.getNext().setPre(newNode);
            current.setNext(newNode);
        }
        return current;
    }

    public E deleteKey(E key) {
        Link<E> current = first;
        while (current != key) {
            current = current.getNext();
            if (current == null) {
                return null;
            }
        }
        if (current == first) {
            first = first.getNext();
        } else
            current.getPre().setNext(current.getNext());
        if (current == last) {
            last = current.getPre();
        } else
            current.getNext().setPre(current.getPre());
        return key;
    }

    public void displayForward() {
        System.out.println("List(first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayList();
            current = current.getNext();
        }
    }

    public void displayBackward() {
        System.out.println("list(last-->first): ");
        Link current = last;
        while (current != null) {
            current.displayList();
            current = current.getPre();
        }
    }
}

public class ListedListTestApp {
    public static void main(String[] args) {
        LinkList<String> newList = new LinkList<>();
        newList.insertFirst("1");
        newList.insertFirst("2");
        newList.insertFirst("3");
        newList.insertFirst("4");
        newList.displayForward();

        newList.displayBackward();
        newList.insertLast("Jones");
        newList.displayForward();
        newList.deleteKey("3");
        newList.displayForward();
        newList.insertAfter("2", "Katy");
        newList.deleteFirst();
        newList.displayForward();
        newList.deleteLast();
        newList.displayForward();

    }

}
