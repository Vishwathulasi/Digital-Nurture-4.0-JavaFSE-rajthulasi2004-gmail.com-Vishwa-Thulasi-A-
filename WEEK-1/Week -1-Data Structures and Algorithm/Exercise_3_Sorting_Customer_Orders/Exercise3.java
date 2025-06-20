package Exercise_3_Sorting_Customer_Orders;
class Order{
    public int orderId;
    public String customerName;
    public int totalPrice;
    Order(int orderId,String customerName,int totalPrice)
    {
        this.orderId=orderId;
        this.customerName=customerName;
        this.totalPrice=totalPrice;
    }
    public String toString()
    {
        return "OrderId: "+this.orderId+" CustomerName: "+this.customerName+" totalPrice: "+this.totalPrice;
    }
}
public class Exercise3 {
    public static void bubbleSort(Order[] arr)
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j].totalPrice>arr[j+1].totalPrice)
                {
                    Order temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void quickSort(Order[] arr,int low,int high)
    {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private static int partition(Order[] arr, int low, int high) {
        int pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice > pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public static void printOrders(Order[] arr)
    {
        for(Order o:arr)
        {
            System.out.println(o);
        }
    }
    public static void main(String[] args)
    {
        Order[] orderList=new Order[3];
        Order o1=new Order(1,"vishwa",400);
        Order o2=new Order(2,"nawin",300);
        Order o3=new Order(3,"raja",500);
        orderList[0]=o1;
        orderList[1]=o2;
        orderList[2]=o3;
        bubbleSort(orderList);
        System.out.println("Bubble Sort:");
        printOrders(orderList);
        System.out.println("Quick Sort");
        quickSort(orderList, 0, orderList.length-1);
        printOrders(orderList);
    }

}
