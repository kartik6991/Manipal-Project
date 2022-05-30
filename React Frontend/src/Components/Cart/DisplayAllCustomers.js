import { useEffect, useState } from "react";
import CartService from "../../Services/Cart/CartService";

function DisplayAllCustomers() {

    const [customers, setCustomers] = useState([
        {
            "customerId": "",
            "customerName": "",
            "emailId": "",
            "mobileNumber": "",
            "orders": [
                {
                    "orderId": "",
                    "orderDate": "",
                    "dispatchDate": "",
                    "totalCost": "",
                    "status": "",
                    "payment": {
                        "paymentId": "",
                        "paymentType": "",
                        "paymentStatus": "",
                        "card": {
                            "cardNumber": "",
                            "validDateFrom": "",
                            "validDatethrough": ""
                        }
                    }
                }
            ],
            "cart": {
                "mobiles": [
                    {
                        "mobileId": "",
                        "mobileName": "",
                        "mobileCost": "",
                        "quantity": "",
                        "mfd": "",
                        "modelNumber": "",
                        "companyName": "",
                        "rating": {
                            "ratingID": "",
                            "ratingFeedback": "​​​"
                        },
                        "feedback": {
                            "feedbackId": "",
                            "form": "",
                            "dateTime": ""
                        }
                    }
                ]
            },
            "address": {
                "add_Id": "",
                "city": "",
                "district": "",
                "state": ""
            }
        }
    ]);

    useEffect(() => {
        loadAllCustomers();
    }, []);

    const loadAllCustomers = () => {
        CartService.getAllCustomers()
            .then((response) => {
                console.log(response.data);

                setCustomers(response.data);
            })
            .catch((error) => { console.log(error) })
    };
    const [msg, setMsg] = useState(undefined);
    const [errorMsg, setErrorMsg] = useState(undefined);
    const customersTableElement = (
        <>
            <h3>Display All Customers:</h3>
            {msg && <h5 className="alert alert-success">{msg}</h5>}
            {errorMsg && <h5 className="alert alert-danger">{errorMsg}</h5>}
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Customer Id</th>
                        <th>Customer Name</th>
                        <th>Customer emailId</th>
                        <th>Customer mobileNumber</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        customers.map((customer) => (
                            <tr key={customer.customerId}>
                                <td>{customer.customerId}</td>
                                <td>{customer.customerName}</td>
                                <td>{customer.emailId}</td>
                                <td>{customer.mobileNumber}</td>
                            </tr>
                        )
                        )
                    }
                </tbody>
            </table><br />
        </>

    );
    return (
        <>
            {customersTableElement}
        </>
    );
}
export default DisplayAllCustomers;