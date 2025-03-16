package code_package;

public class Stack {
    private Book[] books;
    private int top;
    private int capacity;

    public Stack() {
        this.capacity = 50;
        this.top = -1;
        this.books = new Book[capacity];
    }

    // Push at the end (normal stack behavior)
    public void push(Book book) {
        if (top == capacity - 1) {
            throw new IllegalStateException("Stack Overflow! Cannot push.");
        }
        for (int i = 0; i <= top; i++) {
            if (books[i].bookTitle.equals(book.bookTitle) && books[i].bookEdition == book.bookEdition) {
                books[i].noOfCopies += book.noOfCopies;
                return;
            }
        }
        books[++top] = book;
    }

    // Push at the front
    public void pushAtFront(Book book) {
        if (top == capacity - 1) {
            throw new IllegalStateException("Stack Overflow! Cannot push.");
        }
        for (int i = 0; i <= top; i++) {
            if (books[i].bookTitle.equals(book.bookTitle) && books[i].bookEdition == book.bookEdition) {
                books[i].noOfCopies += book.noOfCopies;
                return;
            }
        }
        for (int i = top; i >= 0; i--) {
            books[i + 1] = books[i];
        }
        books[0] = book;
        top++;
    }

    // Pop from the end (normal stack behavior)
    public Book pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow! Cannot pop.");
        }
        Book poppedBook = books[top];
        if (poppedBook.noOfCopies > 1) {
            poppedBook.noOfCopies--;
            return poppedBook;
        }
        return books[top--];
    }

    // Pop from the front
    public Book popFromFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow! Cannot pop.");
        }
        Book removedBook = books[0];
        if (removedBook.noOfCopies > 1) {
            removedBook.noOfCopies--;
            return removedBook;
        }
        for (int i = 0; i < top; i++) {
            books[i] = books[i + 1];
        }
        books[top--] = null;
        return removedBook;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void clear() {
        top = -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(books[i].toString());
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
