import { useState } from "react";
import CartService from "../../Services/Cart/CartService";

const DeleteMobileFromCartDTO = () => {

    const [DTO, setDTO] = useState(
        {
            "customerId": "",
            "mobileId": ""
        }
    );

    // const [isEdit, setIsEdit] = useState(false);
    const [msg, setMsg] = useState(undefined);
    const [errorMsg, setErrorMsg] = useState(undefined);

    const handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setDTO((preDTO) => ({ ...preDTO, [name]: value }))
    };
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(DTO);
        CartService.deleteCart(DTO)
            .then((response) => {
                console.log(response.data)
                setMsg("Mobiles deleted from Cart successfully !");
                setErrorMsg(undefined);
            })
            .catch((error) => {
                console.log(error)
                setErrorMsg("Failed to delete Mobiles !");
                setMsg(undefined);
            })
    }
    return (
        <>
            <div className="Cart">
                <h3>Delete Mobiles to Cart:</h3>
                {msg && <h5 className="alert alert-success">{msg}</h5>}
                {errorMsg && <h5 className="alert alert-danger">{errorMsg}</h5>}
                <form onSubmit={handleSubmit}>
                    Customer Id:
                    <input type="text" name="customerId" value={DTO.customerId} onChange={handleChange} /><br />
                    Mobile Id:
                    <input type="text" name="mobileId" value={DTO.mobileId} onChange={handleChange} /><br />
                    <input type="submit" />
                </form>
            </div>
        </>
    );
};

export default DeleteMobileFromCartDTO;