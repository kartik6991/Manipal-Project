import { useEffect, useState } from "react";
import CartService from "../../Services/Cart/CartService";

function DisplayCustomerMobiles() {

    const [mobiles, setMobiles] = useState([{
        "mobileId": "",
        "mobileName": "",
        "mobileCost": "",
        "quantity": "",
        "mfd": "",
        "modelNumber": "",
        "companyName": "",
        "rating": "",
        "feedback": ""
    }]);

    const [isSubmitted, setIsSubmitted] = useState(false);
    const [msg, setMsg] = useState(undefined);
    const [errorMsg, setErrorMsg] = useState(undefined);

    const [customer, setCustomerId] = useState(
        {
            "customerId": ""
        }
    );

    // const loadMobiles = () => {
    //     CartService.displayCart(customer)
    //         .then((response) => {
    //             setCustomerId(response.data);
    //             // setMobiles(response.data);
    //         })
    //         .catch((error) => {
    //             console.log(error);
    //         }
    //         )
    // };

    // useEffect(() => {
    //     loadMobiles();
    // }, []);

    const handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setCustomerId((preCustomer) => ({ ...preCustomer, [name]: value }))
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(customer.customerId);
        CartService.displayCart(customer.customerId)
            .then((response) => {
                console.log(response.data);
                setMobiles(response.data)
                console.log(mobiles)
                setMsg("Successfully fetched the cart details")
                setIsSubmitted(true)
            })
            .catch((error) => {
                console.log(error)
                setErrorMsg("Failed to fetch the cart details")
                setIsSubmitted(false)
            })
    };

    const customerId = (
        <>
            <h3>Display Customer Mobile list</h3><br></br>

            <form onSubmit={handleSubmit}>
                Customer Id:
                <input type="text" name="customerId" value={customer.customerId} onChange={handleChange}></input>
                <input type="submit" />
            </form>
        </>
    );

    const displayMobiles = (
        <>
            <h2>Mobiles</h2>
            {msg && <h3 className="alert alert-success">{msg}</h3>}
            {errorMsg && <h3 className="alert alert-danger">{errorMsg}</h3>}
            <table className="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Mobile Id</th>
                        <th>Mobile Name</th>
                        <th>Mobile Cost</th>
                        <th>Mobile Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        mobiles.map(
                            (mobile) =>
                                <tr key={mobile.mobileId}>
                                    <td>{mobile.mobileId}</td>
                                    <td>{mobile.mobileName}</td>
                                    <td>{mobile.mobileCost}</td>
                                    <td>{mobile.quantity}</td>
                                </tr>
                        )
                    }
                </tbody>
            </table>
        </>

    );
    return isSubmitted ? displayMobiles : customerId
    // return customerId;
}

export default DisplayCustomerMobiles;