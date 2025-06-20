import java.util.*;
class Product
{
    private int productId;
    public String productName;
    public int quantity;
    public int price;
    public int getProductId()
    {
        return this.productId;
    }
    public void setProductId(int i)
    {
        this.productId=i;
    }
    Product(String productName,int quantity,int price)
    {
        this.productName=productName;
        this.quantity=quantity;
        this.price=price;
    }
}
class ProductManager
{
    List<Product> productList=new ArrayList<>();
    ProductManager(List<Product> productList)
    {
        this.productList=productList;
    }
    public void addProduct(Scanner sc)
    {
        System.out.println("Enter the product name to be added:");
        String productName=sc.nextLine();
        System.out.println("Enter the product quantity: ");
        int quantity=sc.nextInt();
        System.out.println("Enter the price of the product: ");
        int price=sc.nextInt();
        Product p=new Product(productName,quantity,price);
        p.setProductId(productList.size()+1);
        productList.add(p);
        System.out.println("Product added successfully");
    }
    public void viewProduct()
    {
        for(Product p:productList)
        {
            System.out.println("Product id: "+p.getProductId());
            System.out.println("Product Name: "+p.productName);
            System.out.println("Product Quantity: "+p.quantity);
            System.out.println("Product Price: "+p.price);
            System.out.println("==========================================================================");
        }
    }
    public void updateProduct(Scanner sc)
    {
        viewProduct();
        System.out.println("Enter the id of the product to be updated: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Do you want to update product name? either give the product name or NIL");
        String productName=sc.nextLine();
        System.out.println("Do you want to update product quantity? either give the product quantity or value of Integer.MIN_VALUE");
        int quantity=sc.nextInt();
        System.out.println("Do you want to update product price? either give the product price or value of Integer.MIN_VALUE");
        int price=sc.nextInt();
        for(Product p:productList)
        {
            if(p.getProductId()==id)
            {
                if(!productName.equals("NIL"))
                {
                    p.productName=productName;
                }
                if(quantity!=Integer.MIN_VALUE)
                {
                    p.quantity=quantity;
                }
                if(price!=Integer.MIN_VALUE)
                {
                    p.price=price;
                }
                System.out.println("Successfully updated");
                return;
            }
        }
        System.out.println("Product not found");
    }
    public void deleteProduct(Scanner sc)
    {
        viewProduct();
        System.out.println("Enter the id of the product to be deleted");
        int n=sc.nextInt();
         for(Product p:productList)
        {
            if(p.getProductId()==n)
            {
                productList.remove(p);
                System.out.println("Product deleted successfully");
                return;
            }
        }
        System.out.println("Product not found");
    }
}
class Exercise1
{
    public static void main(String[] args)
    {
        Scanner vis=new Scanner(System.in);
        List<Product> productList=new ArrayList<>();
        ProductManager pm=new ProductManager(productList);
        while(true)
        {
            System.out.println("1.Add Items\n2.Update Item details\n3.Delete Item\n4.View Item details\n5.exit");
            System.out.println("Enter the number to perform the corresponding operation: ");
            int n=vis.nextInt();
            vis.nextLine();
            if(n==1)
            {
                pm.addProduct(vis);
            }
            else if(n==2)
            {
                pm.updateProduct(vis);
            }
            else if(n==3)
            {
                pm.deleteProduct(vis);
            }
            else if(n==4)
            {
                pm.viewProduct();
            }
            else if(n==5)
            {
                break;
            }
        }
    }
}