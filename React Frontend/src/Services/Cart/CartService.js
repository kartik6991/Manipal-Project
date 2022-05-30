import http from '../Cart/http-common';

class CartService{
    getAllCustomers(){
         return http.get("customers");
    }
    getAllMobiles(){
        return http.get("mobiles");
    }
    addToCart(DTO){
        return http.post("cart",DTO);
    }
    deleteCart(DTO){
        return http.post("cartDTO",DTO);
    }
    displayCart(customerId){
        return http.get("cart/"+customerId);
    }
}

export default new CartService();