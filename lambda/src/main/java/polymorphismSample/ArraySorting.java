package polymorphismSample;

public class ArraySorting {
    public static void main(String[] args) {

        ArraySorting as= new ArraySorting();

        Sorting bs=new BubbleSort();
        sort(bs);
        Sorting qs=new QuickSort();
        sort(qs);

        Sorting quickSort= ()-> System.out.println("Quick Sorting");
        as.sort(quickSort);

        Sorting bubbleSort= ()-> System.out.println("Bubble Sorting");
        as.sort(bubbleSort);


    }

    private static void sort(Sorting sorting) {
        sorting.sort();
    }
}

