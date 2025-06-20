import java.util.*;
class Product1
{
    private int productId;
    public String productName;
    public String category;
    public int getProductId()
    {
        return this.productId;
    }
    public void setProductId(int id)
    {
        this.productId=id;
    }
    Product1(String productName,String category)
    {
        this.productName=productName;
        this.category=category;
    }
    public String toString()
    {
        return "Product Id: "+this.productId+" Product Name: "+this.productName+" Category: "+this.category;
    }
}
public class Exercise2
{
    public static Product1 linearSearch(List<Product1> productList,int id)
    {
        for(Product1 p:productList)
        {
            if(p.getProductId()==id)
            {
                return p;
            }
        }
        return null;
    }
    public static Product1 binarySearch(List<Product1> productList,int id)
    {
        int i=0;
        int j=productList.size()-1;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            int midid=productList.get(mid).getProductId();
            if(midid==id)
                return productList.get(mid);
            else if(midid<id)
                i=mid+1;
            else
                j=mid-1;
        }
        return null;
    }
    public static void main(String[] args)
    {
        Scanner vis=new Scanner(System.in);
        List<Product1> productList=new ArrayList<>();
        Product1 p=new Product1("medimix","Soap");
        p.setProductId(1);
        productList.add(p);
        Product1 p1=new Product1("Dove","Soap");
        p1.setProductId(2);
        productList.add(p1);
        Product1 p2=new Product1("Mysore sandal","Soap");
        p2.setProductId(3);
        productList.add(p2);
        System.out.println(productList);
        System.out.println("Enter the id to be searched: ");
        int id=vis.nextInt();
        Product1 res1=linearSearch(productList,id);
        System.out.println("Linear search result: ");
        if(res1!=null)
        {
            System.out.println(res1);
        }
        else{
            System.out.println("Product not found");
        }
        Product1 res2=binarySearch(productList,id);
        System.out.println("Binary search result: ");
        if(res2!=null)
        {
            System.out.println(res2);
        }
        else{
            System.out.println("Product not found");
        }
        vis.close();
    }
}