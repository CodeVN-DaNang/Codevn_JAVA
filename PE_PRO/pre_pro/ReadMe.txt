Khi đã có valid thì mọi người sử dụng ở các hàm add, (edit, delete, search nếu có) để kiểm tra giá trị nhập vào.
Cách sử dụng:
---------------------------------------------------------------
String productId = "";
while(!Validator.checkValid(Validator.patternId, productId)){
    System.out.println("Input id like: 'DE170123' ");
    productId = sc.nextLine();
}
---------------------------------------------------------------
Còn nếu ở trong các hàm đọc file ghi file thì mọi ngừoi cần làm như sau:
---------------------------------------------------------------
String productId = arr[0];
if(!Validator.checkValid(Validator.patternId, productId)){
    return;
}
---------------------------------------------------------------
Anh chỉ làm ví dụ trường hợp là Id mọi ngừoi tương tự làm theo với các thuộc tính còn lại của class

Phần abstract Menu cũng đã có trong folder

Phần Class student là 1 ví dụ về sử dụng comparableTo 

Phần validator a chuẩn bị một số cái cơ bản dễ ra 