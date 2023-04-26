import java.util.Random;

public class Ds01
{
    public static void HeapSort(int[] arr)
    {
        int arrLen = arr.length;

        for (int i = arrLen / 2 - 1; i >= 0; i--)
        {
            heapify(arr, arrLen, i);
        }
        for (int i = arrLen - 1; i >= 0; i--)
        {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    public static void swap(int[] arr, int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void heapify(int arr[], int heapLen, int i)
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapLen && arr[left] > arr[largest]) largest = left;
            if (right < heapLen && arr[right] > arr[largest]) largest = right;
                if (largest != i)
                {
                    swap(arr, i, largest);
                    heapify(arr, heapLen, largest);
                } 
    }

    private static String arrToString(int[] arr)
    {
        StringBuilder res = new StringBuilder();
        res.append("[ ");
        for (int i = 0; i < arr.length; ++i)
        {
            res.append(String.format("%s", arr[i]));
            if (i != arr.length - 1)
            {
                res.append(String.format(", "));
            }
        }
        res.append(" ]");

        return res.toString();
    }

    public static void main(String[] args)
    {
        Random random = new Random();
        int[] arr = random.ints(20, 1, 100).toArray();
        System.out.println("Изначальный массив: " + arrToString(arr));
        HeapSort(arr);
        System.out.println("Отсортированный массив: " + arrToString(arr));
    }
}