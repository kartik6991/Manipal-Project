import { Outlet, Link } from "react-router-dom";

const Layout= () => {
    return (
        <>

            <nav className="navbar navbar-expand-sm bg-light justify-content-center">
                <ul className="navbar-nav">
                    <li className="nav-item">
                        <Link className="nav-link" to="customers">All Customers</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="mobiles">All Mobiles</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="create">Add Mobiles to Cart</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="delete">Delete Mobiles from Cart</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="display"> Display Cart</Link>
                    </li>
                </ul>
            </nav>
            <Outlet/>
        </>
    );
}

export default Layout;